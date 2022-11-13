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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ADepartmentDetails {

	public JFrame frame;
	private Connection adminLoginConnection;
	private String[] rowStrings;
	private JTextField depNumTF;
	private JTextField depNameTF;
	private JTextField deptDesTF;
	private JTextField searcTF;
	private JTable table;
    private DefaultTableModel model;
    final Object[] rowObjects = new Object[3];
	private DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADepartmentDetails window = new ADepartmentDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void clear()
	{
		depNameTF.setText(null);
		deptDesTF.setText(null);
		depNumTF.setText(null);
		searcTF.setText(null);
	}
//	public void autoID()
//	{
//		Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
//		try {
//			PreparedStatement statement = connection.prepareStatement("select Max(DepartmentID) from departmentdetails");
//			
//			ResultSet rSet = statement.executeQuery();
//			rSet.next();
//			rSet.getString("Max(DepartmentID)");
//			if(rSet.getString("Max(DepartmentID)")==null)
//			{
//				int depID = 1;
//				String invoicNumString = "DI"+"OO"+depID;
//				depNumTF.setText(invoicNumString);
//			}
//			else {
//				Long depID = Long.parseLong(rSet.getString("Max(DepartmentID)").substring(2));
//				depID++;
//				String invoicNumString = "DI"+"00 "+depID;//DR23101
//				depNumTF.setText(invoicNumString);
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	/**
	 * Create the application.
	 */
	public ADepartmentDetails() {
		initialize();
//		autoID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 1338, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(214, 62, 1100, 56);
		panel.setBackground(new Color(30, 144, 255));
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
		homeBtn.setBounds(1031, 11, 51, 34);
		panel.add(homeBtn);
		
		JLabel lblNewLabel = new JLabel("DEPARTMENT DETAILS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(20, 14, 453, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(26, 10, 159, 162);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\department.png"));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Department Number");
		lblNewLabel_2.setBounds(66, 444, 262, 39);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Department Name");
		lblNewLabel_2_1.setBounds(66, 493, 262, 39);
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Department Description");
		lblNewLabel_2_2.setBounds(66, 546, 292, 39);
		lblNewLabel_2_2.setForeground(Color.BLUE);
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("SEARCH");
//		lblNewLabel_2_3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				String depIDString = searcTF.getText();
//				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
//				try 
//				{
//					PreparedStatement statement = (PreparedStatement)
//							adminLoginConnection.prepareStatement("select * from departmentdetails where DepartmentID = ?");
//					statement.setString(1, depIDString);
//					ResultSet resultSet = statement.executeQuery();
//					if(resultSet.next())
//					{
//						
//						depNumTF.setText(resultSet.getString(1));
//						depNameTF.setText(resultSet.getString(2));
//						deptDesTF.setText(resultSet.getString(3));
//					} 
//					else 
//					{
//						JOptionPane.showMessageDialog(frame,"Departement ID not found","erorr",JOptionPane.ERROR_MESSAGE);
//					}
//					
//				}
//				catch (Exception en) 
//				{
//					// TODO: handle exception
//					en.printStackTrace();
//					JOptionPane.showMessageDialog(frame,"Unable to Display Department","erorr",JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
		lblNewLabel_2_3.setBounds(887, 632, 128, 39);
		lblNewLabel_2_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\SEARCHRECORD.png"));
		lblNewLabel_2_3.setForeground(Color.BLUE);
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_2_3);
		
		depNumTF = new JTextField();
		depNumTF.setBounds(377, 444, 262, 35);
		frame.getContentPane().add(depNumTF);
		depNumTF.setColumns(10);
		
		depNameTF = new JTextField();
		depNameTF.setBounds(377, 497, 262, 35);
		depNameTF.setColumns(10);
		frame.getContentPane().add(depNameTF);
		
		deptDesTF = new JTextField();
		deptDesTF.setBounds(377, 554, 435, 35);
		deptDesTF.setColumns(10);
		frame.getContentPane().add(deptDesTF);
		
		searcTF = new JTextField();
		searcTF.setBounds(66, 636, 746, 35);
		searcTF.setColumns(10);
		frame.getContentPane().add(searcTF);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBounds(887, 444, 283, 46);
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Delete Department");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DELETESMALL.png"));
		lblNewLabel_3.setForeground(new Color(0, 0, 160));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(1, 1, 281, 44);
		panel1.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
				String depaIDString = depNumTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("delete from departmentdetails where DepartmentID = ?");
					statement.setString(1, depaIDString);
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
//					viewDetails();
//					autoID();
					statement.close();
					adminLoginConnection.close();
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame,"Unable to delete Employee","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setBounds(887, 511, 283, 46);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Update Department");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String depIDString = depNumTF.getText();
				String depNameString = depNameTF.getText();
				String depDeString = deptDesTF.getText();
				int i = table.getSelectedRow();
				model.removeRow(i);
				
				rowObjects[0] = depIDString;
				rowObjects[1] = depNameString;
				rowObjects[2] = depDeString;
				
				model1.addRow(rowObjects);
				
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update departmentdetails set DepartmentName = ?,DepartmentDesc = ? where DepartmentID = ?");
					statement.setString(1,depNameString);
					statement.setString(2,depDeString);
					statement.setString(3,depIDString);
					int rSet = statement.executeUpdate();
					if(rSet > 0)
						JOptionPane.showMessageDialog(frame,"Department Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Department Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\UPDATESMALL.png"));
		lblNewLabel_3_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_1.setBounds(0, 0, 283, 44);
		panel2.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setBackground(new Color(255, 255, 255));
//		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				String depNumString = depNumTF.getText();
//				String depNamString = depNameTF.getText();
//				String depDeString = deptDesTF.getText();
//				//connection from db for fill doctor details....
//				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
//				try {
//					PreparedStatement statement = (PreparedStatement)
//							adminLoginConnection.prepareStatement("update departmentdetails set DepartmentName = ?,DepartmentDesc = ? where DepartmentID = ?");
//					statement.setString(1,depNamString);
//					statement.setString(2,depDeString);
//					statement.setString(3,depNumString);
//					int rSet = statement.executeUpdate();
//					if(rSet > 0)
//						JOptionPane.showMessageDialog(frame,"Department Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
//					clear();
//					autoID();
////					viewDetails();
//				} catch (Exception en) {
//					// TODO: handle exception
//					en.printStackTrace();
//					JOptionPane.showMessageDialog(frame,"Department Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
//				}
//			}
//			
//		});   
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel3.setBounds(887, 576, 283, 46);
		frame.getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 206, 1196, 183);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				depNumTF.setText(model.getValueAt(i, 0).toString());
				depNameTF.setText(model.getValueAt(i, 1).toString());
				deptDesTF.setText(model.getValueAt(i, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] columnObjects = {"DepartmentID","DepartmentName","DepartmentDesc"};
		model.setColumnIdentifiers(columnObjects);
		table.setModel(model);
		
		model1 = (DefaultTableModel) table.getModel();
		adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select DepartmentID,DepartmentName,DepartmentDesc from departmentdetails");
			
			ResultSet resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel..
			
			String depNumString;
			String depNaString;
			String dedeString;
			
			while(resultSet.next())
			{
				depNumString = resultSet.getString(1);
				depNaString = resultSet.getString(2);
				dedeString = resultSet.getString(3);
				rowStrings = new String[]{depNumString,depNaString,dedeString};
				
				model1.addRow(rowStrings);
			}
		} catch (Exception en) {
			// TODO: handle exception
			en.printStackTrace();
			JOptionPane.showMessageDialog(frame,"somthing problem","erorr",JOptionPane.ERROR_MESSAGE);
		}
		
		JLabel lblNewLabel_3_11 =  new JLabel("Add Deparment");
		lblNewLabel_3_11.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\adduser.png"));
		lblNewLabel_3_11.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_11.setBounds(0, 0, 283, 44);
		panel3.add(lblNewLabel_3_11);
		lblNewLabel_3_11.setBackground(new Color(255, 255, 255));
		lblNewLabel_3_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String depIDString = depNumTF.getText();
				rowObjects[0] = depNumTF.getText();
				String depNameString = depNameTF.getText();
				rowObjects[1] = depNameTF.getText();
				String depDeString = deptDesTF.getText();
				rowObjects[2] = deptDesTF.getText();
				model.addRow(rowObjects);
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("insert into departmentdetails(DepartmentID,DepartmentName,DepartmentDesc) values(?,?,?)");
					statement.setString(1, depIDString);
					statement.setString(2,depNameString);
					statement.setString(3,depDeString);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"department Added Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
//					autoID();
//					viewDetails();
				} catch (Exception en) {
					JOptionPane.showMessageDialog(frame,"department Addition Failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		lblNewLabel_3_11.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		
		
//		viewDetails();
	}
}
