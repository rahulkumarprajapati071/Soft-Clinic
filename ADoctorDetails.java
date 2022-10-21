package softclinic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ADoctorDetails {

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
	private JTextField leaviTF;
	private SimpleDateFormat sdf;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {  
				try {
					ADoctorDetails window = new ADoctorDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	public ADoctorDetails() {
		initialize();
	}
	
	private void clear()
	{
		DorIDTF.setText(null);
		firsNmaTF.setText(null);
		ageTF.setText(null);
		addressTF.setText(null);
		DobTF.setDate(null);
		adharTF.setText(null);
		LstNameTF.setText(null);
		phoNoTF.setText(null);
		cityTF.setText(null);
		JoinDTF.setDate(null);
		leaviTF.setText(null);
		usertF.setText(null);
		passTF.setText(null);
		bldgrpComboBx.setSelectedIndex(0);
		MtrleStatComboBox.setSelectedIndex(0);
		dprtmComboBx.setSelectedIndex(0);
		malebtn.setSelected(true);
		imageLbl.setIcon(null);
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
		
		JLabel lblNewLabel = new JLabel("ADD Doctors");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(20, 14, 270, 31);
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
		
		String marStatuString[] = new String[] {"select gender","Married","Widowed","Separated","Divorced","Single"};
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
		
		//runnable clock time ke liye
		Thread clockThread = new Thread()
		{
			public void run()
			{
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						VistTimiTF.setText(hour+":"+minute+":"+second);
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clockThread.start();
		
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
		userNameLbl.setBounds(1059, 491, 130, 28);
		frame.getContentPane().add(userNameLbl);
		
		JLabel passworLbl = new JLabel("Password");
		passworLbl.setForeground(Color.BLUE);
		passworLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passworLbl.setBounds(1059, 539, 130, 28);
		frame.getContentPane().add(passworLbl);
		
		usertF = new JTextField();
		usertF.setColumns(10);
		usertF.setBounds(1185, 484, 220, 35);
		frame.getContentPane().add(usertF);
		
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		mntmClear.setHorizontalAlignment(SwingConstants.LEFT);
		mntmClear.setBounds(1275, 614, 130, 42);
		frame.getContentPane().add(mntmClear);
		mntmClear.setBackground(new Color(192, 192, 192));
		mntmClear.setForeground(new Color(0, 0, 205));
		mntmClear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JMenuItem menItmeBrowser = new JMenuItem("Browse");
		menItmeBrowser.addActionListener(new ActionListener() {
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
		menItmeBrowser.setHorizontalAlignment(SwingConstants.CENTER);
		menItmeBrowser.setBackground(new Color(192, 192, 192));
		menItmeBrowser.setBounds(1159, 410, 158, 40);
		frame.getContentPane().add(menItmeBrowser);
		menItmeBrowser.setForeground(new Color(0, 0, 205));
		menItmeBrowser.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		DobTF = new JDateChooser();
		DobTF.setBounds(407, 434, 179, 28);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		frame.getContentPane().add(DobTF);
		
		JoinDTF = new JDateChooser();
		JoinDTF.setBounds(848, 559, 179, 28);
		frame.getContentPane().add(JoinDTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(1185, 534, 220, 35);
		frame.getContentPane().add(passTF);
		
		leaviTF = new JTextField();
		leaviTF.setColumns(10);
		leaviTF.setBounds(848, 614, 179, 28);
		frame.getContentPane().add(leaviTF);
		
		JMenuItem minItemAddDoctoe = new JMenuItem("ADD Doctor");
		minItemAddDoctoe.setBounds(1059, 614, 179, 42);
		frame.getContentPane().add(minItemAddDoctoe);
		minItemAddDoctoe.setBackground(new Color(192, 192, 192));
		minItemAddDoctoe.setForeground(new Color(0, 0, 205));
		minItemAddDoctoe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		minItemAddDoctoe.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\adduser.png"));
		
		minItemAddDoctoe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doctorID = DorIDTF.getText();
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
				String dobString = sdf.format(DobTF.getDate());
				String phonenoString = phoNoTF.getText();
				String materialString = (String)MtrleStatComboBox.getSelectedItem();
				String cityString = cityTF.getText();
				String aadharString = adharTF.getText();
				String joininDString = sdf.format(JoinDTF.getDate());
				String visitTimeString = VistTimiTF.getText();
				String leavingString = leaviTF.getText();
				String usernameString = usertF.getText();
				String passString = String.valueOf(passTF.getPassword());
				String browString = file.getAbsolutePath();
				browString = browString.replace("\\", "\\\\");
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("insert into doctordetails(DoctorID,FirstName,LastName,Age,BloodGroup,Gender,Department,Address,DOB,PhoneNum,MarredeStatus"
									+ ",City,AadharNum,JoinDate,VisitTime,LeavingDate,username,password,browse) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					statement.setString(1, doctorID);
					statement.setString(2,firstName);
					statement.setString(3,lastName);
					statement.setString(4,ageString);
					statement.setString(5,bloodgrpString);
					statement.setString(6,genderString);
					statement.setString(7,departmentString);
					statement.setString(8,addressString);
					statement.setString(9,dobString);
					statement.setString(10,phonenoString);
					statement.setString(11,materialString);
					statement.setString(12,cityString);
					statement.setString(13,aadharString);
					statement.setString(14,joininDString);
					statement.setString(15,visitTimeString);
					statement.setString(16,leavingString);
					statement.setString(17,usernameString);
					statement.setString(18,passString);
					statement.setString(19,browString);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Doctor Added Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
				} catch (Exception en) {
					JOptionPane.showMessageDialog(frame,"Doctor Addition Failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
