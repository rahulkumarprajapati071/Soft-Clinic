package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class AReceptionistDetails {

	public JFrame frame;
	private JTextField receptIDTF;
	private JTextField firsNmaTF;
	private JTextField ageTF;
	private JFileChooser chooser;
	private FileNameExtensionFilter fileNameExtensionFilter;
	private JTextField addressTF;
	private ImageIcon icon;
	private Image image;
	private TableModel model;
	private String genderString;
	private int i;
	private String[] rowStrings;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton fembtn;
	private JRadioButton malebtn;
	private JTextField cityTF;
	private JTextField phoNoTF;
	private JTextField LstNameTF;
	private JComboBox<?> mrdStTF;
	private JTable tblData;
	private JLabel imageLbl;
	private File file;
	private DefaultTableModel model1;
	private String[] colName;
	private JTextField aadharNumTF;
	private String pathString;
	private JMenuItem browBtn;
	private JPanel panel_2;
	private ResultSetMetaData resultSetMetaData;
	private ResultSet resultSet;
//	private PreparedStatement statement;
	private Connection adminLoginConnection;
	private JTextField userTF;
	private JPasswordField passTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AReceptionistDetails window = new AReceptionistDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void clear()
	{
		receptIDTF.setText(null);
		firsNmaTF.setText(null);
		ageTF.setText(null);
		addressTF.setText(null);
		aadharNumTF.setText(null);
		LstNameTF.setText(null);
		phoNoTF.setText(null);
		cityTF.setText(null);
		mrdStTF.setSelectedIndex(0);
		malebtn.setSelected(true);
		imageLbl.setIcon(null);
		userTF.setText(null);
		passTF.setText(null);
	}
	public void autoID()
	{
		Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
		try {
			PreparedStatement statement = connection.prepareStatement("select Max(ReceptionID) from receptiondetails");
			
			ResultSet rSet = statement.executeQuery();
			rSet.next();
			rSet.getString("Max(ReceptionID)");
			if(rSet.getString("Max(ReceptionID)")==null)
			{
				int RSID = 1;
				String invoicNumString = "RS"+new SimpleDateFormat("ddMM").format(new Date())+RSID;
				receptIDTF.setText(invoicNumString);
			}
			else {
				Long RSID = Long.parseLong(rSet.getString("Max(ReceptionID)").substring(5));
				RSID++;
				String invoicNumString = "RS"+new SimpleDateFormat("ddMM").format(new Date())+RSID;//DR23101
				receptIDTF.setText(invoicNumString);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AReceptionistDetails() {
		initialize();
		autoID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(212, 43, 1248, 56);
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
		
		JLabel lblNewLabel = new JLabel("RECEPTIONIST DETAILS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(20, 14, 453, 31);
		panel.add(lblNewLabel);
		
		JLabel DoctorIDLbl = new JLabel("RECEPTIONIST ID");
		DoctorIDLbl.setForeground(new Color(0, 0, 255));
		DoctorIDLbl.setFont(new Font("Segoe UI", Font.BOLD, 26));
		DoctorIDLbl.setBounds(45, 194, 228, 28);
		frame.getContentPane().add(DoctorIDLbl);
		
		receptIDTF = new JTextField();
		receptIDTF.setBounds(283, 194, 336, 28);
		frame.getContentPane().add(receptIDTF);
		
		JLabel firsNamLbl = new JLabel("First Name");
		firsNamLbl.setForeground(Color.BLUE);
		firsNamLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		firsNamLbl.setBounds(35, 257, 130, 28);
		frame.getContentPane().add(firsNamLbl);
		
		firsNmaTF = new JTextField();
		firsNmaTF.setColumns(10);
		firsNmaTF.setBounds(191, 257, 179, 28);
		frame.getContentPane().add(firsNmaTF);
		
		JLabel AgeLbl = new JLabel("Age");
		AgeLbl.setForeground(Color.BLUE);
		AgeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		AgeLbl.setBounds(35, 307, 152, 28);
		frame.getContentPane().add(AgeLbl);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(191, 313, 179, 28);
		frame.getContentPane().add(ageTF);
		
		JLabel gendLbll = new JLabel("Gender");
		gendLbll.setForeground(Color.BLUE);
		gendLbll.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gendLbll.setBounds(452, 307, 130, 28);
		frame.getContentPane().add(gendLbll);
		
		malebtn = new JRadioButton("Male");
		buttonGroup.add(malebtn);
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		malebtn.setBounds(618, 311, 69, 26);
		malebtn.setSelected(true);
		frame.getContentPane().add(malebtn);
		
		fembtn = new JRadioButton("Female");
		buttonGroup.add(fembtn);
		fembtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fembtn.setBounds(689, 310, 108, 28);
		frame.getContentPane().add(fembtn);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setForeground(Color.BLUE);
		addressLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		addressLbl.setBounds(35, 366, 130, 28);
		frame.getContentPane().add(addressLbl);
		
		addressTF = new JTextField();
		addressTF.setColumns(10);
		addressTF.setBounds(191, 366, 606, 28);
		frame.getContentPane().add(addressTF);
		
		JLabel lstNmaeLbl = new JLabel("Last Name");
		lstNmaeLbl.setForeground(Color.BLUE);
		lstNmaeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lstNmaeLbl.setBounds(452, 257, 130, 28);
		frame.getContentPane().add(lstNmaeLbl);
		
		LstNameTF = new JTextField();
		LstNameTF.setColumns(10);
		LstNameTF.setBounds(618, 257, 179, 28);
		frame.getContentPane().add(LstNameTF);
		
		JLabel PhoNoLbl = new JLabel("Phone No.");
		PhoNoLbl.setForeground(Color.BLUE);
		PhoNoLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		PhoNoLbl.setBounds(452, 473, 130, 28);
		frame.getContentPane().add(PhoNoLbl);
		
		phoNoTF = new JTextField();
		phoNoTF.setColumns(10);
		phoNoTF.setBounds(618, 473, 179, 28);
		frame.getContentPane().add(phoNoTF);
		
		JLabel CityLbl = new JLabel("City");
		CityLbl.setForeground(Color.BLUE);
		CityLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		CityLbl.setBounds(35, 473, 130, 28);
		frame.getContentPane().add(CityLbl);
		
		cityTF = new JTextField();
		cityTF.setColumns(10);
		cityTF.setBounds(191, 473, 179, 28);
		frame.getContentPane().add(cityTF);
		
		JLabel dockImageLbl = new JLabel("");
		dockImageLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\RECETIONISTDETAILS.png"));
		dockImageLbl.setBounds(35, 16, 167, 170);
		frame.getContentPane().add(dockImageLbl);
		
		JLabel DeprtmLbl = new JLabel("Marred Status");
		DeprtmLbl.setForeground(Color.BLUE);
		DeprtmLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		DeprtmLbl.setBounds(35, 415, 130, 28);
		frame.getContentPane().add(DeprtmLbl);
		
		String staff[] = new String[] {"select","Married","Widowed","Separated","Divorced","Single"};
		mrdStTF = new JComboBox<Object>(staff);
		mrdStTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mrdStTF.setBounds(191, 416, 179, 30);
		frame.getContentPane().add(mrdStTF);
		
		JLabel aadharNumLbl = new JLabel("Aadhar Number");
		aadharNumLbl.setForeground(Color.BLUE);
		aadharNumLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		aadharNumLbl.setBounds(452, 421, 167, 28);
		frame.getContentPane().add(aadharNumLbl);
		
		
		aadharNumTF = new JTextField();
		aadharNumTF.setColumns(10);
		aadharNumTF.setBounds(618, 421, 179, 28);
		frame.getContentPane().add(aadharNumTF);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(870, 134,221, 201);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		imageLbl = new JLabel("");
		imageLbl.setBounds(0, 0, 221, 201);
		panel_2.add(imageLbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(1150, 251, 255, 40);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		userTF = new JTextField();
		userTF.setColumns(10);
		userTF.setBounds(942, 421, 179, 28);
		frame.getContentPane().add(userTF);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblUsername.setBounds(833, 421, 167, 28);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPassword.setBounds(833, 473, 95, 28);
		frame.getContentPane().add(lblPassword);JMenuItem mntmNewMenuItem_1 = new JMenuItem("ADD RECEPT");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String receptString = receptIDTF.getText();
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
				String marredStsString = (String)mrdStTF.getSelectedItem();
				String aadharString = aadharNumTF.getText();
				String cityString = cityTF.getText();
				String phoneString = phoNoTF.getText();
				String userString = userTF.getText();
				String passString = new String(passTF.getPassword());
				String browString = file.getAbsolutePath();
				browString = browString.replace("\\", "\\\\");
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("insert into receptiondetails(ReceptionID,FirstName,LastName,Age,Gender,Address,MarredStatus,AadharNum,City"
									+ ",PhoneNum,Username,Password,browse) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					statement.setString(1, receptString);
					statement.setString(2,firstName);
					statement.setString(3,lastName);
					statement.setString(4,ageString);
					statement.setString(5,genderString);
					statement.setString(6,addressString);
					statement.setString(7,marredStsString);
					statement.setString(8,aadharString);
					statement.setString(9,cityString);
					statement.setString(10,phoneString);
					statement.setString(11,userString);
					statement.setString(12,passString);
					statement.setString(13,browString);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Recept Added Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					autoID();
					viewDetails();
				} catch (Exception en) {
					JOptionPane.showMessageDialog(frame,"Recept Addition Failed","erorr",JOptionPane.ERROR_MESSAGE);
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
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("REMOVE RECEPT");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String receptString = receptIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("delete from receptiondetails where ReceptionID = ?");
					statement.setString(1,receptString);
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
		
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("UPDATE RECEPT");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String receptString = receptIDTF.getText();
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
				String marredstsString = (String)mrdStTF.getSelectedItem();
				String aadharString = aadharNumTF.getText();
				String cityString = cityTF.getText();
				String phoneString = phoNoTF.getText();
				String userString = userTF.getText();
				String passString = new String(passTF.getPassword());
				String browString = pathString;
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update receptiondetails set FirstName = ?,LastName = ?,Age = ?,Gender = ?,Address = ?,MarredStatus = ?,AadharNum = ?,"
									+ "City = ?, PhoneNum = ?,Username = ?,Password = ?,browse = ? where ReceptionID = ?");
					statement.setString(1,firstName);
					statement.setString(2,lastName);
					statement.setString(3,ageString);
					statement.setString(4,genderString);
					statement.setString(5,addressString);
					statement.setString(6,marredstsString);
					statement.setString(7,aadharString);
					statement.setString(8,cityString);
					statement.setString(9,phoneString);
					statement.setString(10,userString);
					statement.setString(11,passString);
					statement.setString(12,browString);
					statement.setString(13,receptString);
					int rSet = statement.executeUpdate();
					if(rSet > 0)
						JOptionPane.showMessageDialog(frame,"Recept Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					autoID();
					viewDetails();
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Recept Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
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
				
				String receptString = receptIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("select * from receptiondetails where ReceptionID = ?");
					statement.setString(1, receptString);
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						
						receptIDTF.setText(resultSet.getString(1));
						firsNmaTF.setText(resultSet.getString(2));
						LstNameTF.setText(resultSet.getString(3));
						ageTF.setText(resultSet.getString(4));
						String genderString = resultSet.getString(5);
						if(genderString.equals("Male"))
						{
							malebtn.setSelected(true);
						}
						else {
							fembtn.setSelected(true);
						}
						addressTF.setText(resultSet.getString(6));
						mrdStTF.setSelectedItem(resultSet.getString(7));
						aadharNumTF.setText(resultSet.getString(8));
						cityTF.setText(resultSet.getString(9));
						phoNoTF.setText(resultSet.getString(10));
						userTF.setText(resultSet.getString(11));
						passTF.setText(resultSet.getString(12));
						pathString = resultSet.getString(13);
						icon = new ImageIcon(pathString);
						image = icon.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH);
						imageLbl.setIcon(new ImageIcon(image));
						panel_2.add(imageLbl);
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Recept ID not found","erorr",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Unable to Display Recept","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblSearch.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\SEARCHRECORD.png"));
		lblSearch.setForeground(Color.BLUE);
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSearch.setBounds(667, 194, 130, 28);
		frame.getContentPane().add(lblSearch);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_3.setBounds(902, 354, 152, 40);
		frame.getContentPane().add(panel_1_3);
		panel_1_3.setLayout(null);
		
		browBtn = new JMenuItem("    BROWSE");
		browBtn.setBounds(1, 1, 150, 38);
		panel_1_3.add(browBtn);
		browBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//fetch  file and folder
				chooser = new JFileChooser();
				fileNameExtensionFilter = new FileNameExtensionFilter("IMAGES", "png","jpg","jpeg");
				chooser.addChoosableFileFilter(fileNameExtensionFilter);
				int response = chooser.showOpenDialog(null);
				
				if(response == JFileChooser.APPROVE_OPTION)
				{
					file = chooser.getSelectedFile();
					String string = file.getAbsolutePath();
					icon = new ImageIcon(string);
					image = icon.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH);
					imageLbl.setIcon(new ImageIcon(image));
					panel_2.add(imageLbl);
					
				}
				
			}
		});
		browBtn.setForeground(new Color(0, 128, 192));
		browBtn.setHorizontalAlignment(SwingConstants.CENTER);
		browBtn.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		browBtn.setBackground(new Color(255, 255, 255));
		
		viewDetails();
	
	}
	public void viewDetails()
	{
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 522, 1423, 220);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		tblData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i = tblData.getSelectedRow();
				model = tblData.getModel();
				receptIDTF.setText(model.getValueAt(i, 0).toString());
				firsNmaTF.setText(model.getValueAt(i, 1).toString());
				LstNameTF.setText(model.getValueAt(i, 2).toString());
				ageTF.setText(model.getValueAt(i, 3).toString());
				genderString = model.getValueAt(i, 4).toString();
				if(genderString.equals("Male"))
					malebtn.setSelected(true);
				else {
					fembtn.setSelected(true);
				}
				addressTF.setText(model.getValueAt(i, 5).toString());
				mrdStTF.setSelectedItem(model.getValueAt(i, 6).toString());
				aadharNumTF.setText(model.getValueAt(i, 7).toString());
				cityTF.setText(model.getValueAt(i, 8).toString());
				phoNoTF.setText(model.getValueAt(i, 9).toString());
				userTF.setText(model.getValueAt(i, 10).toString());
				passTF.setText(model.getValueAt(i, 11).toString());
				pathString = model.getValueAt(i, 12).toString();
				icon = new ImageIcon(pathString);
				image = icon.getImage().getScaledInstance(imageLbl.getWidth(), imageLbl.getHeight(), Image.SCALE_SMOOTH);
				imageLbl.setIcon(new ImageIcon(image));
				panel_2.add(imageLbl);
			}
		});
		scrollPane.setViewportView(tblData);
		
		passTF = new JPasswordField();
		passTF.setBounds(942, 473, 179, 28);
		frame.getContentPane().add(passTF);
		
		adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select * from receptiondetails");
			
			resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel..
			resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			model1 = (DefaultTableModel) tblData.getModel();
			
			int cols = resultSetMetaData.getColumnCount();
			colName = new String[cols];
			for(int i = 0; i < cols; i++)
			{
				colName[i] = resultSetMetaData.getColumnName(i+1);
			}
			model1.setColumnIdentifiers(colName);
			
			String receptID;
			String firstName;
			String lastName;
			String ageString;
			String gender;
			String address;
			String marredSts;
			String aadharString;
			String city;
			String phonenoString;
			String userString;
			String passString;
			String browseString;
			
			while(resultSet.next())
			{
				receptID = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				ageString = resultSet.getString(4);
				gender = resultSet.getString(5);
				address = resultSet.getString(6);
				marredSts = resultSet.getString(7);
				aadharString = resultSet.getString(8);
				city = resultSet.getString(9);
				phonenoString = resultSet.getString(10);
				userString = resultSet.getString(11);
				passString = resultSet.getString(12);
				browseString = resultSet.getString(13);
				rowStrings = new String[]{receptID,firstName,lastName,ageString,gender,address,marredSts,
						aadharString,city,phonenoString,userString,passString,browseString
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
