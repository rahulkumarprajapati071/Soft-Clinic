package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ABedDetails {

	public JFrame frame;
	private Connection adminLoginConnection;
	private String[] rowStrings;
	private String[] colName;
	private JTable tblData;
	private JTextField bedDTF;
	private JTextField RoomNTF;
	private DefaultTableModel model;
	private JComboBox<?> bedCatTF;
	private JTextField searchTF;
	final Object[] rowObjects = new Object[3];
	private DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABedDetails window = new ABedDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void clear()
	{
		bedDTF.setText(null);
		bedCatTF.setSelectedIndex(0);
		RoomNTF.setText(null);
		searchTF.setText(null);
	}
	public void autoID()
	{
		Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
		try {
			PreparedStatement statement = connection.prepareStatement("select Max(BedID) from beddetails");
			
			ResultSet rSet = statement.executeQuery();
			rSet.next();
			rSet.getString("Max(BedID)");
			if(rSet.getString("Max(BedID)")==null)
			{
				int stID = 1;
				String invoicNumString = "BI"+new SimpleDateFormat("ddMM").format(new Date())+stID;
				bedDTF.setText(invoicNumString);
			}
			else {
				Long stID = Long.parseLong(rSet.getString("Max(BedID)").substring(5));
				stID++;
				String invoicNumString = "BI"+new SimpleDateFormat("ddMM").format(new Date())+stID;//DR23101
				bedDTF.setText(invoicNumString);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public ABedDetails() {
		initialize();
		autoID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(69, 214, 214));
		frame.setBounds(100, 100, 1280, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminPanel window = new AdminPanel();
				window.frame.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("BED DETAILS");
		lblNewLabel_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\BEDDETAILS.png"));
		lblNewLabel_1.setBounds(448, 36, 361, 156);
		frame.getContentPane().add(lblNewLabel_1);
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\home.png"));
		homeBtn.setBounds(17, 13, 51, 34);
		frame.getContentPane().add(homeBtn);
		

		JLabel lblNewLabel = new JLabel("Bed Number");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(739, 225, 145, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBedCategory = new JLabel("Bed Category");
		lblBedCategory.setForeground(Color.BLUE);
		lblBedCategory.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblBedCategory.setBounds(739, 289, 145, 34);
		frame.getContentPane().add(lblBedCategory);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setForeground(Color.BLUE);
		lblRoomNumber.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblRoomNumber.setBounds(739, 357, 145, 34);
		frame.getContentPane().add(lblRoomNumber);
		
		bedDTF = new JTextField();
		bedDTF.setBounds(896, 223, 262, 36);
		frame.getContentPane().add(bedDTF);
		bedDTF.setColumns(10);
		
		RoomNTF = new JTextField();
		RoomNTF.setColumns(10);
		RoomNTF.setBounds(894, 355, 262, 36);
		frame.getContentPane().add(RoomNTF);
		
		String bedCatagry[] = new String[] {"select","ICU","X-RAY","Operation","Cabin","ROOM"};
		bedCatTF = new JComboBox<Object>(bedCatagry);
		bedCatTF.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bedCatTF.setBounds(894, 289, 264, 33);
		frame.getContentPane().add(bedCatTF);
		
		JLabel lblNewLabel_2 = new JLabel("ADD BED");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bedIDString = bedDTF.getText();
				rowObjects[0] = bedIDString;
				String bedCatString = (String) bedCatTF.getSelectedItem();
				rowObjects[1] = bedCatString;
				String roomString = RoomNTF.getText();
				rowObjects[2] = roomString;
				model.addRow(rowObjects);
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("insert into beddetails(BedID,Catagary,RoomNum) values(?,?,?)");
					statement.setString(1, bedIDString);
					statement.setString(2,bedCatString);
					statement.setString(3,roomString);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Bed Added Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					autoID();
				} catch (Exception en) {
					JOptionPane.showMessageDialog(frame,"Bed Addition Failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_2.setBounds(727, 466, 127, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("REMOVE BED");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblData.getSelectedRow();
				model.removeRow(i);
				String bedIDString = bedDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("delete from beddetails where BedID = ?");
					statement.setString(1, bedIDString);
					int count = statement.executeUpdate();
					if(count > 0)
					{
						JOptionPane.showMessageDialog(frame,"Deletion Succesful","success",JOptionPane.INFORMATION_MESSAGE);
						
						
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Deletion not Possible","erorr",JOptionPane.ERROR_MESSAGE);
					}
					clear();
					autoID();
					statement.close();
					adminLoginConnection.close();
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame,"Unable to delete Bed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_2_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(877, 466, 162, 41);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("UPDATE BED");
		lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bedCatString = (String) bedCatTF.getSelectedItem();
				String roomString = RoomNTF.getText();
				String bedIDString = bedDTF.getText();
				int i = tblData.getSelectedRow();
				model.removeRow(i);
				
				rowObjects[0] = bedIDString;
				rowObjects[1] = bedCatString;
				rowObjects[2] = roomString;
				
				model1.addRow(rowObjects);
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update beddetails set Catagary = ?,RoomNum = ? where BedID = ?");
					statement.setString(1,bedCatString);
					statement.setString(2,roomString);
					statement.setString(3,bedIDString);
					int rSet = statement.executeUpdate();
					if(rSet > 0)
						JOptionPane.showMessageDialog(frame,"Bed Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					autoID();
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Bed Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(1075, 466, 159, 41);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(716, 466, 127, 41);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(876, 466, 162, 41);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(1075, 466, 162, 41);
		frame.getContentPane().add(panel_2);
		
		searchTF = new JTextField();
		searchTF.setColumns(10);
		searchTF.setBounds(739, 557, 262, 36);
		frame.getContentPane().add(searchTF);
		
		JLabel lblNewLabel_2_3 = new JLabel("SEARCH");
		lblNewLabel_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String bedIDString = searchTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("select * from beddetails where BedID = ?");
					statement.setString(1, bedIDString);
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						
						bedDTF.setText(resultSet.getString(1));
						bedCatTF.setSelectedItem(resultSet.getString(2));
						RoomNTF.setText(resultSet.getString(3));
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Bed ID not found","erorr",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Unable to Display Bed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel_2_3.setBounds(1033, 559, 127, 34);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		//table area
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 223, 642, 452);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		
		tblData.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblData.getSelectedRow();
				bedDTF.setText(model.getValueAt(i, 0).toString());
				bedCatTF.setSelectedItem(model.getValueAt(i, 1).toString());
				RoomNTF.setText(model.getValueAt(i, 2).toString());
				
			}
		});
		scrollPane.setViewportView(tblData);
		model = new DefaultTableModel();
		Object[] columnObjects = {"BedID","Catagery","Room NO"};
		model.setColumnIdentifiers(columnObjects);
		tblData.setModel(model);
		
		
		model1 = (DefaultTableModel) tblData.getModel();
		
		adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select * from beddetails");
			
			ResultSet resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel..
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			
			int cols = resultSetMetaData.getColumnCount();
			colName = new String[cols];
			for(int i = 0; i < cols; i++)
			{
				colName[i] = resultSetMetaData.getColumnName(i+1);
			}
			model1.setColumnIdentifiers(colName);
			
			String bedIDString;
			String bedCatString;
			String bedroomString;
			
			while(resultSet.next())
			{
				bedIDString = resultSet.getString(1);
				bedCatString = resultSet.getString(2);
				bedroomString = resultSet.getString(3);
				
				rowStrings = new String[]{bedIDString,bedCatString,bedroomString
				};
				model1.addRow(rowStrings);
			}
			statement.close();
			adminLoginConnection.close();
		} catch (Exception en) {
			// TODO: handle exception
			en.printStackTrace();
			JOptionPane.showMessageDialog(frame,"somthing problem","erorr",JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
