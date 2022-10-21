package softclinic;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import com.toedter.calendar.JDateChooser;

public class AUpdateDoctor {

	public JFrame frame;
	private JTextField DorIDTF;
	private JTextField firsNmaTF;
	private JTextField ageTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField addressTF;
	private JTextField adharTF;
	private JTextField VistTimiTF;
	private JTextField LstNameTF;
	private JTextField phoNoTF;
	private JTextField cityTF;
	private JTextField usertF;
	private JComboBox<?> MtrleStatComboBox;
	private JRadioButton malebtn;
	private JComboBox<?> bldgrpComboBx;
	private JComboBox<?> dprtmComboBx;
	private JDateChooser DobTF;
	private JDateChooser JoinDTF;
	private JLabel imageLbl;
	private JPasswordField passTF;
	private JPanel panel;
	private String pathString;
	private JTextField levDTF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AUpdateDoctor window = new AUpdateDoctor();
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
	public AUpdateDoctor() {
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
			}
		});
		UpdaDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		UpdaDoc.setIcon(new ImageIcon("E:\\Hospital ka saaman\\Hospital Management System\\src\\UPDATESMALL.png"));
		UpdaDoc.setForeground(Color.BLACK);
		UpdaDoc.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(UpdaDoc);
		
		JMenu ViewDoc = new JMenu("View Doctors");
		ViewDoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				AViewDoctor window = new AViewDoctor();
				window.frame.setVisible(true);
			}
		});
		ViewDoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		ViewDoc.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\viewuser.png"));
		ViewDoc.setForeground(Color.BLACK);
		ViewDoc.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.add(ViewDoc);
		
		panel = new JPanel();
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
		
		JLabel lblNewLabel = new JLabel("UPDATE DOCTORS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(22, 14, 352, 31);
		panel.add(lblNewLabel);
		
		JLabel dockImageLbl = new JLabel("New label");
		dockImageLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DOCTORDETAILS (2).png"));
		dockImageLbl.setBounds(22, 68, 147, 170);
		frame.getContentPane().add(dockImageLbl);
		
		JLabel DoctorIDLbl = new JLabel("Doctor ID");
		DoctorIDLbl.setForeground(new Color(0, 0, 255));
		DoctorIDLbl.setFont(new Font("Segoe UI", Font.BOLD, 26));
		DoctorIDLbl.setBounds(251, 158, 130, 28);
		frame.getContentPane().add(DoctorIDLbl);
		
		DorIDTF = new JTextField();
		DorIDTF.setBounds(407, 158, 179, 28);
		frame.getContentPane().add(DorIDTF);
		
		JLabel firsNamLbl = new JLabel("First Name");
		firsNamLbl.setForeground(Color.BLUE);
		firsNamLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		firsNamLbl.setBounds(251, 224, 130, 28);
		frame.getContentPane().add(firsNamLbl);
		
		firsNmaTF = new JTextField();
		firsNmaTF.setColumns(10);
		firsNmaTF.setBounds(407, 224, 179, 28);
		frame.getContentPane().add(firsNmaTF);
		
		JLabel AgeLbl = new JLabel("Age");
		AgeLbl.setForeground(Color.BLUE);
		AgeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		AgeLbl.setBounds(251, 277, 130, 28);
		frame.getContentPane().add(AgeLbl);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(407, 277, 179, 28);
		frame.getContentPane().add(ageTF);
		
		JLabel gendLbll = new JLabel("Gender");
		gendLbll.setForeground(Color.BLUE);
		gendLbll.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gendLbll.setBounds(251, 334, 130, 28);
		frame.getContentPane().add(gendLbll);
		
		malebtn = new JRadioButton("Male");
		buttonGroup.add(malebtn);
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		malebtn.setBounds(407, 336, 69, 26);
		malebtn.setSelected(true);
		frame.getContentPane().add(malebtn);
		
		JRadioButton fembtn = new JRadioButton("Female");
		buttonGroup.add(fembtn);
		fembtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fembtn.setBounds(478, 334, 108, 28);
		frame.getContentPane().add(fembtn);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setForeground(Color.BLUE);
		addressLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addressLbl.setBounds(251, 384, 130, 28);
		frame.getContentPane().add(addressLbl);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(407, 384, 620, 28);
		frame.getContentPane().add(addressTF);
		
		JLabel dobLbl = new JLabel("DOB");
		dobLbl.setForeground(Color.BLUE);
		dobLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		dobLbl.setBounds(251, 434, 158, 28);
		frame.getContentPane().add(dobLbl);
		
		JLabel mateStatLbl = new JLabel("Material Status");
		mateStatLbl.setForeground(Color.BLUE);
		mateStatLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mateStatLbl.setBounds(251, 500, 147, 28);
		frame.getContentPane().add(mateStatLbl);
		
		String marStatuString[] = new String[] {"select","Married","Widowed","Separated","Divorced","Single"};
		MtrleStatComboBox = new JComboBox<Object>(marStatuString);
		MtrleStatComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MtrleStatComboBox.setBounds(407, 500, 179, 28);
		frame.getContentPane().add(MtrleStatComboBox);
		
		JLabel adharLbl = new JLabel("Aadhar Number");
		adharLbl.setForeground(Color.BLUE);
		adharLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		adharLbl.setBounds(251, 559, 147, 28);
		frame.getContentPane().add(adharLbl);
		
		adharTF = new JTextField();
		adharTF.setColumns(10);
		adharTF.setBounds(407, 559, 179, 28);
		frame.getContentPane().add(adharTF);
		
		
		JLabel VistimnLbl = new JLabel("Visit Timing");
		VistimnLbl.setForeground(Color.BLUE);
		VistimnLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		VistimnLbl.setBounds(251, 614, 147, 28);
		frame.getContentPane().add(VistimnLbl);
		
		
		VistTimiTF = new JTextField();
		VistTimiTF.setColumns(10);
		VistTimiTF.setBounds(407, 614, 179, 28);
		frame.getContentPane().add(VistTimiTF);

		JLabel lstNmaeLbl = new JLabel("Last Name");
		lstNmaeLbl.setForeground(Color.BLUE);
		lstNmaeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lstNmaeLbl.setBounds(675, 224, 130, 28);
		frame.getContentPane().add(lstNmaeLbl);
		
		LstNameTF = new JTextField();
		LstNameTF.setColumns(10);
		LstNameTF.setBounds(848, 224, 179, 28);
		frame.getContentPane().add(LstNameTF);
		
		JLabel BlodGroLbl = new JLabel("Blood Group");
		BlodGroLbl.setForeground(Color.BLUE);
		BlodGroLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		BlodGroLbl.setBounds(675, 277, 130, 28);
		frame.getContentPane().add(BlodGroLbl);
		
		
		String bloodGrpString[] = new String[] {"select","A+","A-","B+","B-","O+","O-","AB+","AB-"};
		bldgrpComboBx = new JComboBox<Object>(bloodGrpString);
		bldgrpComboBx.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bldgrpComboBx.setBounds(848, 277, 179, 30);
		frame.getContentPane().add(bldgrpComboBx);
		
		JLabel DeprtmLbl = new JLabel("Department");
		DeprtmLbl.setForeground(Color.BLUE);
		DeprtmLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		DeprtmLbl.setBounds(675, 334, 130, 28);
		frame.getContentPane().add(DeprtmLbl);
		
		
		String department[] = new String[] {"select","Orthopedics","Pediatrics","Cardiology","Ophthalmology",
				 "Obstetrics and gynaecology","Radiology","Psychiatry","Surgery","Gastroenterology","Neurology",
				 "Otorhinolaryngology","Nephrology","General medicine","Urology","Pharmacy","Anesthesiology",
				 "Pathology"};
		dprtmComboBx = new JComboBox<Object>(department);
		dprtmComboBx.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dprtmComboBx.setBounds(848, 332, 179, 30);
		frame.getContentPane().add(dprtmComboBx);
		
		JLabel PhoNoLbl = new JLabel("Phone No.");
		PhoNoLbl.setForeground(Color.BLUE);
		PhoNoLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		PhoNoLbl.setBounds(675, 434, 130, 28);
		frame.getContentPane().add(PhoNoLbl);
		
		phoNoTF = new JTextField();
		phoNoTF.setColumns(10);
		phoNoTF.setBounds(848, 434, 179, 28);
		frame.getContentPane().add(phoNoTF);
		
		JLabel CityLbl = new JLabel("City");
		CityLbl.setForeground(Color.BLUE);
		CityLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		CityLbl.setBounds(675, 500, 130, 28);
		frame.getContentPane().add(CityLbl);
		
		cityTF = new JTextField();
		cityTF.setColumns(10);
		cityTF.setBounds(848, 500, 179, 28);
		frame.getContentPane().add(cityTF);
		
		JLabel JoinDatLbl = new JLabel("Joining Date");
		JoinDatLbl.setForeground(Color.BLUE);
		JoinDatLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		JoinDatLbl.setBounds(675, 559, 130, 28);
		frame.getContentPane().add(JoinDatLbl);
		
		JLabel LeavingDLbl = new JLabel("Leaving Date");
		LeavingDLbl.setForeground(Color.BLUE);
		LeavingDLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		LeavingDLbl.setBounds(675, 614, 130, 28);
		frame.getContentPane().add(LeavingDLbl);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(1121, 202,232, 198);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		imageLbl = new JLabel("");
		imageLbl.setBounds(0, 0, 232, 198);
		panel_2.add(imageLbl);
		
		
		JLabel userNameLbl = new JLabel("Username");
		userNameLbl.setForeground(Color.BLUE);
		userNameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		userNameLbl.setBounds(1059, 500, 130, 37);
		frame.getContentPane().add(userNameLbl);
		
		JLabel passworLbl = new JLabel("Password");
		passworLbl.setForeground(Color.BLUE);
		passworLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passworLbl.setBounds(1059, 559, 130, 37);
		frame.getContentPane().add(passworLbl);
		
		usertF = new JTextField();
		usertF.setColumns(10);
		usertF.setBounds(1185, 502, 220, 35);
		frame.getContentPane().add(usertF);
		
		JMenuItem minItemUpdateDoctoe = new JMenuItem("UPDATE");
		
		DobTF = new JDateChooser();
		DobTF.setBounds(407, 434, 179, 28);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		frame.getContentPane().add(DobTF);
		
		JoinDTF = new JDateChooser();
		JoinDTF.setBounds(848, 559, 179, 28);
		frame.getContentPane().add(JoinDTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(1185, 561, 220, 35);
		frame.getContentPane().add(passTF);
		
		minItemUpdateDoctoe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dobString = DorIDTF.getText();
				String firstName = firsNmaTF.getText();
				String lastName = LstNameTF.getText();
				String ageString = ageTF.getText();
				String bloodgrpString = (String)bldgrpComboBx.getSelectedItem();
				String genderString;
				if(malebtn.isSelected())
				{
					genderString = malebtn.getText();
				}
				else {
					genderString = fembtn.getText();
				}
				String departmentString = (String)dprtmComboBx.getSelectedItem();
				String addressString = addressTF.getText();
				String dobString1 = sdf.format(DobTF.getDate());
				System.out.println(dobString);
				String phonenoString = phoNoTF.getText();
				String materialString = (String)MtrleStatComboBox.getSelectedItem();
				String cityString = cityTF.getText();
				String aadharString = adharTF.getText();
				String joininDString = sdf.format(JoinDTF.getDate());
				System.out.println(joininDString);
				String visitTimeString = VistTimiTF.getText();
				String leavingString = levDTF.getText();
				String usernameString = usertF.getText();
				String passString = String.valueOf(passTF.getPassword());	
				String browString = pathString;
				browString = browString.replace("\\", "\\\\");
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update doctordetails set FirstName = ?,LastName = ?,Age = ?,BloodGroup = ?,Gender = ?,Department = "
									+ "?,Address = ?,DOB = ?,PhoneNum = ?,MarredeStatus = ?,City = ?,AadharNum = ?"
									+ ",JoinDate = ?,VisitTime = ?,LeavingDate = ?,username = ?,password = ?,browse = ? where DoctorID = ?");
					statement.setString(1,firstName);
					statement.setString(2,lastName);
					statement.setString(3,ageString);
					statement.setString(4,bloodgrpString);
					statement.setString(5,genderString);
					statement.setString(6,departmentString);
					statement.setString(7,addressString);
					statement.setString(8,dobString1);
					statement.setString(9,phonenoString);
					statement.setString(10,materialString);
					statement.setString(11,cityString);
					statement.setString(12,aadharString);
					statement.setString(13,joininDString);
					statement.setString(14,visitTimeString);
					statement.setString(15,leavingString);
					statement.setString(16,usernameString);
					statement.setString(17,passString);
					statement.setString(18,browString);
					statement.setString(19, dobString);
					int count  = statement.executeUpdate();
					System.out.println("not update");
					if(count > 0)
					{
						JOptionPane.showMessageDialog(frame,"Doctor Updation Succesfull","erorr",JOptionPane.INFORMATION_MESSAGE);
						
					}
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Doctor Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		minItemUpdateDoctoe.setBounds(1172, 144, 130, 42);
		frame.getContentPane().add(minItemUpdateDoctoe);
		minItemUpdateDoctoe.setBackground(new Color(192, 192, 192));
		minItemUpdateDoctoe.setForeground(new Color(0, 0, 205));
		minItemUpdateDoctoe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		minItemUpdateDoctoe.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\UPDATESMALL.png"));
		
		JMenuItem menItmeBrowser = new JMenuItem("Browse");
		menItmeBrowser.setHorizontalAlignment(SwingConstants.CENTER);
		menItmeBrowser.setBackground(new Color(192, 192, 192));
		menItmeBrowser.setBounds(1171, 410, 141, 40);
		menItmeBrowser.setEnabled(false);
		frame.getContentPane().add(menItmeBrowser);
		menItmeBrowser.setForeground(new Color(0, 0, 205));
		menItmeBrowser.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String docID = DorIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("select * from doctordetails where DoctorID = ?");
					statement.setString(1, docID);
					ResultSet resultSet = statement.executeQuery();
					System.out.println("rahl");
					if(resultSet.next())
					{
						
						DorIDTF.setText(resultSet.getString(1));
						firsNmaTF.setText(resultSet.getString(2));
						LstNameTF.setText(resultSet.getString(3));
						ageTF.setText(resultSet.getString(4));
						bldgrpComboBx.setSelectedItem(resultSet.getString(5));
						if(resultSet.getString(6) == "Male")
						{
							malebtn.setSelected(true);
						}
						else {
							fembtn.setSelected(true);
						}
						dprtmComboBx.setSelectedItem(resultSet.getString(7));
						addressTF.setText(resultSet.getString(8));
						DobTF.setDate(resultSet.getDate(9));
						phoNoTF.setText(resultSet.getString(10));
						MtrleStatComboBox.setSelectedItem(resultSet.getString(11));
						cityTF.setText(resultSet.getString(12));
						adharTF.setText(resultSet.getString(13));
						JoinDTF.setDate(resultSet.getDate(14));
						VistTimiTF.setText(resultSet.getString(15));
						levDTF.setText(resultSet.getString(16));
						usertF.setText(resultSet.getString(17));
						passTF.setText(resultSet.getString(18));
						pathString = resultSet.getString(19);
						ImageIcon icon = new ImageIcon(pathString);
						Image image = icon.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH);
						imageLbl.setIcon(new ImageIcon(image));
						panel_2.add(imageLbl);
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
		mntmSearch.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\SEARCHRECORD.png"));
		mntmSearch.setForeground(new Color(0, 0, 205));
		mntmSearch.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		mntmSearch.setBackground(new Color(192, 192, 192));
		mntmSearch.setBounds(675, 151, 147, 37);
		frame.getContentPane().add(mntmSearch);
		
		levDTF = new JTextField();
		levDTF.setColumns(10);
		levDTF.setBounds(848, 614, 179, 28);
		frame.getContentPane().add(levDTF);
	}
	public JPanel getPanel() {
		return panel;
	}
}
