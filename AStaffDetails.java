package softclinic;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.MouseAdapter;

public class AStaffDetails {

	public JFrame frame;
	private JTextField stafIDTF;
	private JTextField firsNmaTF;
	private JTextField ageTF;
	private JTextField addressTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton malebtn;
	private JTextField cityTF;
	private JTextField phoNoTF;
	private JTextField LstNameTF;
	private JComboBox<?> staffTypeTF;
	private JTable tblData;
	private JLabel imageLbl;
	private File file;
	private DefaultTableModel model1;
	private String[] colName;
	private JTextField aadharNumTF;
	private String pathString;
	private JMenuItem browBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AStaffDetails window = new AStaffDetails();
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
	public AStaffDetails() {
		initialize();
	}
	private void clear()
	{
		stafIDTF.setText(null);
		firsNmaTF.setText(null);
		ageTF.setText(null);
		addressTF.setText(null);
		aadharNumTF.setText(null);
		LstNameTF.setText(null);
		phoNoTF.setText(null);
		cityTF.setText(null);
		staffTypeTF.setSelectedIndex(0);
		malebtn.setSelected(true);
		imageLbl.setIcon(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(212, 68, 1248, 56);
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
		
		JLabel lblNewLabel = new JLabel("Lower Staff Details");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(20, 14, 370, 31);
		panel.add(lblNewLabel);
		
		JLabel DoctorIDLbl = new JLabel("STAFF ID");
		DoctorIDLbl.setForeground(new Color(0, 0, 255));
		DoctorIDLbl.setFont(new Font("Segoe UI", Font.BOLD, 26));
		DoctorIDLbl.setBounds(214, 150, 130, 28);
		frame.getContentPane().add(DoctorIDLbl);
		
		stafIDTF = new JTextField();
		stafIDTF.setBounds(354, 150, 179, 28);
		frame.getContentPane().add(stafIDTF);
		
		JLabel firsNamLbl = new JLabel("First Name");
		firsNamLbl.setForeground(Color.BLUE);
		firsNamLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		firsNamLbl.setBounds(35, 196, 130, 28);
		frame.getContentPane().add(firsNamLbl);
		
		firsNmaTF = new JTextField();
		firsNmaTF.setColumns(10);
		firsNmaTF.setBounds(191, 202, 179, 28);
		frame.getContentPane().add(firsNmaTF);
		
		JLabel AgeLbl = new JLabel("Age");
		AgeLbl.setForeground(Color.BLUE);
		AgeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		AgeLbl.setBounds(35, 257, 152, 28);
		frame.getContentPane().add(AgeLbl);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(191, 257, 179, 28);
		frame.getContentPane().add(ageTF);
		
		JLabel gendLbll = new JLabel("Gender");
		gendLbll.setForeground(Color.BLUE);
		gendLbll.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gendLbll.setBounds(452, 257, 130, 28);
		frame.getContentPane().add(gendLbll);
		
		malebtn = new JRadioButton("Male");
		buttonGroup.add(malebtn);
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		malebtn.setBounds(618, 261, 69, 26);
		malebtn.setSelected(true);
		frame.getContentPane().add(malebtn);
		
		JRadioButton fembtn = new JRadioButton("Female");
		buttonGroup.add(fembtn);
		fembtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fembtn.setBounds(689, 260, 108, 28);
		frame.getContentPane().add(fembtn);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setForeground(Color.BLUE);
		addressLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addressLbl.setBounds(35, 322, 130, 28);
		frame.getContentPane().add(addressLbl);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(191, 322, 606, 28);
		frame.getContentPane().add(addressTF);
		
		JLabel lstNmaeLbl = new JLabel("Last Name");
		lstNmaeLbl.setForeground(Color.BLUE);
		lstNmaeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lstNmaeLbl.setBounds(452, 196, 130, 28);
		frame.getContentPane().add(lstNmaeLbl);
		
		LstNameTF = new JTextField();
		LstNameTF.setColumns(10);
		LstNameTF.setBounds(618, 196, 179, 28);
		frame.getContentPane().add(LstNameTF);
		
		JLabel PhoNoLbl = new JLabel("Phone No.");
		PhoNoLbl.setForeground(Color.BLUE);
		PhoNoLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		PhoNoLbl.setBounds(452, 442, 130, 28);
		frame.getContentPane().add(PhoNoLbl);
		
		phoNoTF = new JTextField();
		phoNoTF.setColumns(10);
		phoNoTF.setBounds(618, 442, 179, 28);
		frame.getContentPane().add(phoNoTF);
		
		JLabel CityLbl = new JLabel("City");
		CityLbl.setForeground(Color.BLUE);
		CityLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		CityLbl.setBounds(35, 442, 130, 28);
		frame.getContentPane().add(CityLbl);
		
		cityTF = new JTextField();
		cityTF.setColumns(10);
		cityTF.setBounds(191, 442, 179, 28);
		frame.getContentPane().add(cityTF);
		
		JLabel dockImageLbl = new JLabel("");
		dockImageLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\RECETIONISTDETAILS.png"));
		dockImageLbl.setBounds(35, 16, 167, 170);
		frame.getContentPane().add(dockImageLbl);
		
		JLabel DeprtmLbl = new JLabel("Staff Type");
		DeprtmLbl.setForeground(Color.BLUE);
		DeprtmLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		DeprtmLbl.setBounds(35, 383, 130, 28);
		frame.getContentPane().add(DeprtmLbl);
		
		
		String staff[] = new String[] {"select","Orthopedics","Pediatrics","Cardiology","Ophthalmology",
				 "Obstetrics and gynaecology","Radiology","Psychiatry","Surgery","Gastroenterology","Neurology",
				 "Otorhinolaryngology","Nephrology","General medicine","Urology","Pharmacy","Anesthesiology",
				 "Pathology"};
		staffTypeTF = new JComboBox<Object>(staff);
		staffTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		staffTypeTF.setBounds(191, 384, 179, 30);
		frame.getContentPane().add(staffTypeTF);
		
		JLabel aadharNumLbl = new JLabel("Aadhar Number");
		aadharNumLbl.setForeground(Color.BLUE);
		aadharNumLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		aadharNumLbl.setBounds(452, 383, 167, 28);
		frame.getContentPane().add(aadharNumLbl);
		
		
		aadharNumTF = new JTextField();
		aadharNumTF.setColumns(10);
		aadharNumTF.setBounds(618, 383, 179, 28);
		frame.getContentPane().add(aadharNumTF);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(861, 222,230, 201);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		imageLbl = new JLabel("");
		imageLbl.setBounds(0, 0, 230, 201);
		panel_2.add(imageLbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(1150, 251, 255, 40);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ADD EMPLOYEE");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffIDString = stafIDTF.getText();
				String firstName = firsNmaTF.getText();
				String lastName = LstNameTF.getText();
				String ageString = ageTF.getText();
				String genderString;
				if(malebtn.isSelected())
				{
					genderString = malebtn.getText();
				}
				else {
					genderString = fembtn.getText();
				}
				String addressString = addressTF.getText();
				String staffTypeString = (String)staffTypeTF.getSelectedItem();
				String aadharString = aadharNumTF.getText();
				String cityString = cityTF.getText();
				String phoneString = phoNoTF.getText();
				String browString = file.getAbsolutePath();
				browString = browString.replace("\\", "\\\\");
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("insert into staffdetails(StaffID,FirstName,LastName,Age,Gender,Address,StaffType,AadharNum,City"
									+ ",PhoneNum,browse) values(?,?,?,?,?,?,?,?,?,?,?)");
					statement.setString(1, staffIDString);
					statement.setString(2,firstName);
					statement.setString(3,lastName);
					statement.setString(4,ageString);
					statement.setString(5,genderString);
					statement.setString(6,addressString);
					statement.setString(7,staffTypeString);
					statement.setString(8,aadharString);
					statement.setString(9,cityString);
					statement.setString(10,phoneString);
					statement.setString(11,browString);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Employee Added Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					viewDetails();
				} catch (Exception en) {
					JOptionPane.showMessageDialog(frame,"Employee Addition Failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\adduser.png"));
		mntmNewMenuItem_1.setForeground(new Color(0, 128, 255));
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mntmNewMenuItem_1.setBounds(1, 1, 253, 38);
		panel_1.add(mntmNewMenuItem_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(1150, 335, 255, 40);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("DELETE EMPLOYEE");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String staffString = stafIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("delete from staffdetails where StaffID = ?");
					statement.setString(1, staffString);
					int count = statement.executeUpdate();
					System.out.println("rahl");
					if(count > 0)
					{
						JOptionPane.showMessageDialog(frame,"Deletion Succesful","success",JOptionPane.INFORMATION_MESSAGE);
						
						
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Deletion not Possible","erorr",JOptionPane.ERROR_MESSAGE);
					}
					clear();
					viewDetails();
					statement.close();
					adminLoginConnection.close();
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame,"Unable to delete Employee","erorr",JOptionPane.ERROR_MESSAGE);
				}
				browBtn.setEnabled(true);
			}
		});
		mntmNewMenuItem_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DELETESMALL.png"));
		mntmNewMenuItem_1_1.setForeground(new Color(0, 128, 255));
		mntmNewMenuItem_1_1.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_1_1.setBounds(1, 1, 253, 38);
		panel_1_1.add(mntmNewMenuItem_1_1);
		mntmNewMenuItem_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBounds(1150, 419, 255, 40);
		frame.getContentPane().add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("UPDATE EMPLOYEE");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffIDString = stafIDTF.getText();
				String firstName = firsNmaTF.getText();
				String lastName = LstNameTF.getText();
				String ageString = ageTF.getText();
				String genderString;
				if(malebtn.isSelected())
				{
					genderString = malebtn.getText();
				}
				else {
					genderString = fembtn.getText();
				}
				String addressString = addressTF.getText();
				String staffTypeString = (String)staffTypeTF.getSelectedItem();
				String aadharString = aadharNumTF.getText();
				String cityString = cityTF.getText();
				String phoneString = phoNoTF.getText();
				String browString = pathString;
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update staffdetails set FirstName = ?,LastName = ?,Age = ?,Gender = ?,Address = ?,StaffType = ?,AadharNum = ?,"
									+ "City = ?, PhoneNum = ?,browse = ? where StaffID = ?");
					statement.setString(1,firstName);
					statement.setString(2,lastName);
					statement.setString(3,ageString);
					statement.setString(4,genderString);
					statement.setString(5,addressString);
					statement.setString(6,staffTypeString);
					statement.setString(7,aadharString);
					statement.setString(8,cityString);
					statement.setString(9,phoneString);
					statement.setString(10,browString);
					statement.setString(11, staffIDString);
					int rSet = statement.executeUpdate();
					if(rSet > 0)
						JOptionPane.showMessageDialog(frame,"Employee Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					viewDetails();
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Employee Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
				browBtn.setEnabled(true);
			}
		});
		mntmNewMenuItem_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\UPDATESMALL.png"));
		mntmNewMenuItem_1_2.setForeground(new Color(0, 128, 255));
		mntmNewMenuItem_1_2.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mntmNewMenuItem_1_2.setBounds(1, 1, 253, 38);
		panel_1_2.add(mntmNewMenuItem_1_2);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				browBtn.setEnabled(false);
				
				String staffString = stafIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("select * from staffdetails where StaffID = ?");
					statement.setString(1, staffString);
					ResultSet resultSet = statement.executeQuery();
					System.out.println("rahl");
					if(resultSet.next())
					{
						
						stafIDTF.setText(resultSet.getString(1));
						firsNmaTF.setText(resultSet.getString(2));
						LstNameTF.setText(resultSet.getString(3));
						ageTF.setText(resultSet.getString(4));
						System.out.println(resultSet.getString(5));
						if(resultSet.getString(5) == "Male")
						{
							malebtn.setSelected(true);
						}
						else {
							fembtn.setSelected(true);
						}
						addressTF.setText(resultSet.getString(6));
						staffTypeTF.setSelectedItem(resultSet.getString(7));
						aadharNumTF.setText(resultSet.getString(8));
						cityTF.setText(resultSet.getString(9));
						phoNoTF.setText(resultSet.getString(10));
						pathString = resultSet.getString(11);
						ImageIcon icon = new ImageIcon(pathString);
						Image image = icon.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH);
						imageLbl.setIcon(new ImageIcon(image));
						panel_2.add(imageLbl);
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Staff ID not found","erorr",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Unable to Display staff","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblSearch.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\SEARCHRECORD.png"));
		lblSearch.setForeground(Color.BLUE);
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSearch.setBounds(580, 152, 130, 28);
		frame.getContentPane().add(lblSearch);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_3.setBounds(898, 442, 152, 40);
		frame.getContentPane().add(panel_1_3);
		panel_1_3.setLayout(null);
		
		browBtn = new JMenuItem("    BROWSE");
		browBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fetch system file and folder
				System.out.println("files");
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("IMAGES", "png","jpg","jpeg");
				chooser.addChoosableFileFilter(fileNameExtensionFilter);
				int response = chooser.showOpenDialog(null);
				
				if(response == JFileChooser.APPROVE_OPTION)
				{
					file = chooser.getSelectedFile();
					String string = file.getAbsolutePath();
					ImageIcon icon = new ImageIcon(string);
					Image image = icon.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH);
					imageLbl.setIcon(new ImageIcon(image));
					panel_2.add(imageLbl);
					
				}
				
			}
		});
		browBtn.setForeground(new Color(0, 128, 192));
		browBtn.setHorizontalAlignment(SwingConstants.CENTER);
		browBtn.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		browBtn.setBackground(new Color(255, 255, 255));
		browBtn.setBounds(1, 1, 150, 38);
		panel_1_3.add(browBtn);
		
		viewDetails();
	
	}
	public void viewDetails()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 499, 1423, 293);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select * from staffdetails");
			
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
			
			String staffID;
			String firstName;
			String lastName;
			String ageString;
			String gender;
			String address;
			String staffType1;
			String aadharString;
			String city;
			String phonenoString;
			String browseString;
			
			while(resultSet.next())
			{
				staffID = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				ageString = resultSet.getString(4);
				gender = resultSet.getString(5);
				address = resultSet.getString(6);
				staffType1 = resultSet.getString(7);
				aadharString = resultSet.getString(8);
				city = resultSet.getString(9);
				phonenoString = resultSet.getString(10);
				browseString = resultSet.getString(11);
				String[] rowStrings = {staffID,firstName,lastName,ageString,gender,address,staffType1,
						aadharString,city,phonenoString,browseString
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
