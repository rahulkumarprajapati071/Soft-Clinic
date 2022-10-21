package softclinic;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AViewDoctor {

	public JFrame frame;
	private JTextField textField;
	private JTable tblData;
	private DefaultTableModel model1;
	String[] colName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AViewDoctor window = new AViewDoctor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AViewDoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1500, 45);
		frame.getContentPane().add(menuBar);
		
		JMenu mnAddDock = new JMenu("Add Doctors");
		mnAddDock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ADoctorDetails window = new ADoctorDetails();
				window.frame.setVisible(true);
			}
		});
		mnAddDock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		mnAddDock.setFont(new Font("Verdana", Font.PLAIN, 13));
		mnAddDock.setForeground(new Color(0, 0, 0));
		mnAddDock.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\adduser.png"));
		menuBar.add(mnAddDock);
		
		JMenu mnDeleteDoc = new JMenu("Delete Doctors");
		mnDeleteDoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ADeleteDoctor window = new ADeleteDoctor();
				window.frame.setVisible(true);
			}
		});
		mnDeleteDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		mnDeleteDoc.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DELETESMALL.png"));
		mnDeleteDoc.setFont(new Font("Verdana", Font.PLAIN, 12));
		mnDeleteDoc.setForeground(new Color(0, 0, 0));
		menuBar.add(mnDeleteDoc);
		

		JMenu SearchDoc = new JMenu("Search Doctor");
		SearchDoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ASearchDoctor window = new ASearchDoctor();
				window.frame.setVisible(true);
			}
		});
		SearchDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		SearchDoc.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\searchuser.png"));
		SearchDoc.setForeground(Color.BLACK);
		SearchDoc.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(SearchDoc);
		
		JMenu UpdaDoc = new JMenu("Update Doctors");
		UpdaDoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				AUpdateDoctor window = new AUpdateDoctor();
				window.frame.setVisible(true);
			}
		});
		UpdaDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		UpdaDoc.setIcon(new ImageIcon("E:\\Hospital ka saaman\\Hospital Management System\\src\\UPDATESMALL.png"));
		UpdaDoc.setForeground(Color.BLACK);
		UpdaDoc.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(UpdaDoc);
		
		JMenu ViewDoc = new JMenu("View Doctors");
		ViewDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		ViewDoc.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\viewuser.png"));
		ViewDoc.setForeground(Color.BLACK);
		ViewDoc.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(ViewDoc);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(202, 68, 1248, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminPanel window = new AdminPanel();
				window.frame.setVisible(true);
			}
		});
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\home.png"));
		homeBtn.setBounds(1179, 11, 51, 34);
		panel.add(homeBtn);
		
		JLabel lblNewLabel = new JLabel("VIEW Doctors");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(22, 14, 270, 31);
		panel.add(lblNewLabel);
		
		JLabel dockImageLbl = new JLabel("New label");
		dockImageLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DOCTORDETAILS (2).png"));
		dockImageLbl.setBounds(22, 68, 147, 170);
		frame.getContentPane().add(dockImageLbl);
		
		textField = new JTextField();
		textField.setBounds(589, 202, 393, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 264, 1423, 370);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		JLabel searchLbl = new JLabel("Search");
		searchLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String docID = textField.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("select * from doctordetails where DoctorID = ?");
					statement.setString(1, docID);
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.isBeforeFirst())
					{
						model1.setRowCount(0);
						//take all meta data of resutlSet...or our database tabel..
						ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
						DefaultTableModel model = (DefaultTableModel) tblData.getModel();
						
						int cols = resultSetMetaData.getColumnCount();
						String[] colName = new String[cols];
						for(int i = 0; i < cols; i++)
						{
							colName[i] = resultSetMetaData.getColumnName(i+1);
						}
						model.setColumnIdentifiers(colName);
						
						String doctorID;
						String firstName;
						String lastName;
						String ageString;
						String bloodgrpString;
						String genderString;
						String departmentString;
						String addressString;
						String dobString;
						String phonenoString;
						String materialString;
						String cityString;
						String aadharString;
						String joininDString;
						String visitTimeString;
						String leavingString;
						String usernameString;
						String passString;
						String browseString;
						if(resultSet.next())
						{
							doctorID = resultSet.getString(1);
							firstName = resultSet.getString(2);
							lastName = resultSet.getString(3);
							ageString = resultSet.getString(4);
							bloodgrpString = resultSet.getString(5);
							genderString = resultSet.getString(6);
							departmentString = resultSet.getString(7);
							addressString = resultSet.getString(8);
							dobString = resultSet.getString(9);
							phonenoString = resultSet.getString(10);
							materialString = resultSet.getString(11);
							cityString = resultSet.getString(12);
							aadharString = resultSet.getString(13);
							joininDString = resultSet.getString(14);
							visitTimeString = resultSet.getString(15);
							leavingString = resultSet.getString(16);
							usernameString = resultSet.getString(17);
							passString = resultSet.getString(18);
							browseString = resultSet.getString(19);
							String[] rowStrings = {doctorID,firstName,lastName,ageString,
									bloodgrpString,genderString,departmentString,addressString,dobString,phonenoString,
									materialString,cityString,aadharString,joininDString,visitTimeString,leavingString,
									usernameString,passString,browseString,
							};
							model.addRow(rowStrings);
						}
						statement.close();
						adminLoginConnection.close();
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Doctor ID not found","erorr",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Unable to Display Doctors","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		searchLbl.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		searchLbl.setBounds(471, 202, 108, 36);
		frame.getContentPane().add(searchLbl);
		
		Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select * from doctordetails");
			
			ResultSet resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel..
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			model1 = (DefaultTableModel) tblData.getModel();
			
			int cols = resultSetMetaData.getColumnCount();
			colName = new String[cols];
			for(int i = 0; i < cols; i++)
			{
				colName[i] = resultSetMetaData.getColumnName(i+1);
			}
			model1.setColumnIdentifiers(colName);
			
			String doctorID;
			String firstName;
			String lastName;
			String ageString;
			String bloodgrpString;
			String genderString;
			String departmentString;
			String addressString;
			String dobString;
			String phonenoString;
			String materialString;
			String cityString;
			String aadharString;
			String joininDString;
			String visitTimeString;
			String leavingString;
			String usernameString;
			String passString;
			String browsString;
			while(resultSet.next())
			{
				doctorID = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				ageString = resultSet.getString(4);
				bloodgrpString = resultSet.getString(5);
				genderString = resultSet.getString(6);
				departmentString = resultSet.getString(7);
				addressString = resultSet.getString(8);
				dobString = resultSet.getString(9);
				phonenoString = resultSet.getString(10);
				materialString = resultSet.getString(11);
				cityString = resultSet.getString(12);
				aadharString = resultSet.getString(13);
				joininDString = resultSet.getString(14);
				visitTimeString = resultSet.getString(15);
				leavingString = resultSet.getString(16);
				usernameString = resultSet.getString(17);
				passString = resultSet.getString(18);
				browsString = resultSet.getString(19);
				String[] rowStrings = {doctorID,firstName,lastName,ageString,
						bloodgrpString,genderString,departmentString,addressString,dobString,phonenoString,
						materialString,cityString,aadharString,joininDString,visitTimeString,leavingString,
						usernameString,passString,browsString
				};
				model1.addRow(rowStrings);
			}
			statement.close();
			adminLoginConnection.close();
		} catch (Exception en) {
			// TODO: handle exception
			en.printStackTrace();
			JOptionPane.showMessageDialog(frame,"Unable to Display Doctors","erorr",JOptionPane.ERROR_MESSAGE);
		}
	}
}
