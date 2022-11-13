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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class DAddPatient {

	public JFrame frame;
	private JTextField pIDTF;
	private JTextField fNamTF;
	private JTextField adhTF;
	private JTextField BedNoTF;
	private JDateChooser daTF;
	private SimpleDateFormat sdf;
	private JTextField lstNTF;
	private JTextField addrTF;
	private JTextField phonTF;
	private JComboBox<?> mtrlTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton malebtn;
	private JTextField ageTF;
	private JRadioButton fembtn;
	private JComboBox<?> ptTypeTF;
	private JTextField disTF;
	private JTextField rxNumTF;
	private JTextField dlydosTF;
	private JTextField doseTF;
	private JTextField possSTF;
	private JTextField comTF;
	private JTextArea desDeTF;
	private JComboBox<?> namOfTabTF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DAddPatient window = new DAddPatient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void clear()
	{
		pIDTF.setText(null);
		fNamTF.setText(null);
		lstNTF.setText(null);
		ageTF.setText(null);
		mtrlTF.setSelectedIndex(0);
		malebtn.setSelected(true);
		daTF.setDate(null);
		addrTF.setText(null);
		adhTF.setText(null);
		phonTF.setText(null);
		ptTypeTF.setSelectedIndex(0);
		BedNoTF.setText(null);
		disTF.setText(null);
		desDeTF.setText(null);
		namOfTabTF.setSelectedIndex(0);
		rxNumTF.setText(null);
		doseTF.setText(null);
		dlydosTF.setText(null);
		comTF.setText(null);
		possSTF.setText(null);
		
	}
	/**
	 * Create the application.
	 */
	public DAddPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1448, 839);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		
		fembtn = new JRadioButton("Female");
		buttonGroup.add(fembtn);
		fembtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fembtn.setBounds(263, 464, 84, 26);
		frame.getContentPane().add(fembtn);
		
		malebtn = new JRadioButton("Male");
		buttonGroup.add(malebtn);
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		malebtn.setBounds(181, 464, 69, 26);
		malebtn.setSelected(true);
		frame.getContentPane().add(malebtn);
		
		JLabel gendLbll = new JLabel("Gender");
		gendLbll.setForeground(Color.BLUE);
		gendLbll.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gendLbll.setBounds(29, 460, 130, 28);
		frame.getContentPane().add(gendLbll);
		
		String patTypeString[] = new String[] {"select","Indoor","Outdoor"};
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(1075, 650, 158, 50);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Update");
		lblNewLabel_4_1.setBounds(6, 6, 155, 38);
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String patID = pIDTF.getText();
				String firstName = fNamTF.getText();
				String lastName = lstNTF.getText();
				String ageString = ageTF.getText();
				String mtrString = (String)mtrlTF.getSelectedItem();
				String genderString;
				if(malebtn.isSelected())
				{
					genderString = malebtn.getText();
				}
				else {
					genderString = fembtn.getText();
				}
				String presDatString = sdf.format(daTF.getDate());
				String address = addrTF.getText();
				String aadharString = adhTF.getText();
				String phonenoString = phonTF.getText();
				String ptnType = (String)ptTypeTF.getSelectedItem();
				String bedNo = BedNoTF.getText();
				String diString = disTF.getText();
				String deString = desDeTF.getText();
				String namOfTString = (String)namOfTabTF.getSelectedItem();
				String dlyDoseString = dlydosTF.getText();
				String comString = comTF.getText();
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update patientdetails set FirstName = ?,LastName = ?,Age = ?,MaritialSts = ?,Gender = ?,PresentDate = ?"
									+ ",Address = ?,AadharNum = ?,PhoneNum = ?,PatientType = ?,BedNo = ?,Disease = ?,Description = ?,NameOfTablet = ?,DailyDose = ?,Company = ?  where PatientID = ?");
					statement.setString(1,firstName);
					statement.setString(2,lastName);
					statement.setString(3, ageString);
					statement.setString(4, mtrString);
					statement.setString(5, genderString);
					statement.setString(6, presDatString);
					statement.setString(7, address);
					statement.setString(8, aadharString);
					statement.setString(9, phonenoString);
					statement.setString(10, ptnType);
					statement.setString(11, bedNo);
					statement.setString(12, diString);
					statement.setString(13, deString);
					statement.setString(14, namOfTString);
					statement.setString(15, dlyDoseString);
					statement.setString(16, comString);
					statement.setString(17,patID);
					int rSet = statement.executeUpdate();
					if(rSet > 0)
						JOptionPane.showMessageDialog(frame,"Patient Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Patient Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\UPDATESMALL.png"));
		lblNewLabel_4_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		
		ptTypeTF = new JComboBox<Object>(patTypeString);
		ptTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ptTypeTF.setBounds(181, 716, 187, 28);
		frame.getContentPane().add(ptTypeTF);
		
		JLabel lblNewLabel_3_3_1_2 = new JLabel("Patient Type");
		lblNewLabel_3_3_1_2.setForeground(Color.BLUE);
		lblNewLabel_3_3_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1_2.setBounds(29, 714, 139, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1_2);
		
		JLabel lblNewLabel_3_3_2_2 = new JLabel("SEARCH");
		lblNewLabel_3_3_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String patID = pIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("select * from patientdetails where PatientID = ?");
					statement.setString(1, patID);
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						pIDTF.setText(resultSet.getString(1));
						fNamTF.setText(resultSet.getString(2));
						lstNTF.setText(resultSet.getString(3));
						ageTF.setText(resultSet.getString(4));
						mtrlTF.setSelectedItem(resultSet.getString(5));
						String genderString = resultSet.getString(6);
						if(genderString.equals("Male"))
						{
							malebtn.setSelected(true);
						}
						else {
							fembtn.setSelected(true);
						}
						daTF.setDate(resultSet.getDate(7));
						addrTF.setText(resultSet.getString(8));
						adhTF.setText(resultSet.getString(9));
						phonTF.setText(resultSet.getString(10));
						ptTypeTF.setSelectedItem(resultSet.getString(11));
						BedNoTF.setText(resultSet.getString(12));
						disTF.setText(resultSet.getString(13));
						desDeTF.setText(resultSet.getString(14));
						namOfTabTF.setSelectedItem(resultSet.getString(15));
						
					} 
					else 
					{
						JOptionPane.showMessageDialog(frame,"Patient ID not found","erorr",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch (Exception en) 
				{
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Unable to Display Patient","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_3_3_2_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\SEARCHRECORD.png"));
		lblNewLabel_3_3_2_2.setForeground(new Color(64, 0, 128));
		lblNewLabel_3_3_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_3_3_2_2.setBounds(856, 109, 152, 39);
		frame.getContentPane().add(lblNewLabel_3_3_2_2);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("Age");
		lblNewLabel_3_3_2.setForeground(Color.BLUE);
		lblNewLabel_3_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_2.setBounds(29, 329, 118, 33);
		frame.getContentPane().add(lblNewLabel_3_3_2);
		
		phonTF = new JTextField();
		phonTF.setColumns(10);
		phonTF.setBounds(636, 191, 187, 27);
		frame.getContentPane().add(phonTF);
		
		addrTF = new JTextField();
		addrTF.setColumns(10);
		addrTF.setBounds(181, 588, 187, 27);
		frame.getContentPane().add(addrTF);
		
		lstNTF = new JTextField();
		lstNTF.setColumns(10);
		lstNTF.setBounds(181, 262, 187, 27);
		frame.getContentPane().add(lstNTF);
		
		JLabel lblNewLabel_3_3_1_1_1 = new JLabel("Phone No.");
		lblNewLabel_3_3_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1_1_1.setBounds(493, 191, 130, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1_1_1);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Address");
		lblNewLabel_3_3_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1_1.setBounds(29, 588, 152, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Maritial Status");
		lblNewLabel_3_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1.setBounds(29, 401, 152, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1);
		
		String marStatuString[] = new String[] {"select","Married","Widowed","Separated","Divorced","Single"};
		mtrlTF = new JComboBox<Object>(marStatuString);
		mtrlTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mtrlTF.setBounds(181, 403, 187, 28);
		frame.getContentPane().add(mtrlTF);
		
		JLabel lblNewLabel_3_3 = new JLabel("Last Name");
		lblNewLabel_3_3.setForeground(Color.BLUE);
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3.setBounds(29, 262, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		daTF = new JDateChooser();
		daTF.setBounds(181, 522, 187, 28);
		daTF.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(daTF);
		
		BedNoTF = new JTextField();
		BedNoTF.setColumns(10);
		BedNoTF.setBounds(636, 255, 187, 27);
		frame.getContentPane().add(BedNoTF);
		
		adhTF = new JTextField();
		adhTF.setColumns(10);
		adhTF.setBounds(181, 650, 187, 27);
		frame.getContentPane().add(adhTF);
		
		fNamTF = new JTextField();
		fNamTF.setColumns(10);
		fNamTF.setBounds(181, 196, 187, 27);
		frame.getContentPane().add(fNamTF);
		
		pIDTF = new JTextField();
		pIDTF.setBounds(362, 116, 461, 37);
		frame.getContentPane().add(pIDTF);
		pIDTF.setColumns(10);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Bed No.");
		lblNewLabel_3_2_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1.setBounds(492, 257, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Aadhar Num.");
		lblNewLabel_3_2.setForeground(Color.BLUE);
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2.setBounds(29, 650, 139, 27);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date");
		lblNewLabel_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_1.setBounds(29, 523, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(29, 191, 118, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setBounds(200, 112, 152, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(200, 23, 1302, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT DETAILS");
		lblNewLabel.setBounds(478, 14, 370, 31);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		panel.add(lblNewLabel);
		
		JButton homeBtn = new JButton("");
		homeBtn.setBounds(1124, 10, 62, 38);
		panel.add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DPatientDetails window = new DPatientDetails();
				window.frame.setVisible(true);
			}
		});
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back (2).png"));
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(181, 335, 187, 27);
		frame.getContentPane().add(ageTF);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\patientdetals.png"));
		lblNewLabel_1.setBounds(19, 10, 158, 143);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Disease");
		lblNewLabel_3_2_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1.setBounds(493, 332, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_2_1_1);
		
		disTF = new JTextField();
		disTF.setColumns(10);
		disTF.setBounds(636, 329, 187, 27);
		frame.getContentPane().add(disTF);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Description & Details");
		lblNewLabel_3_2_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_1.setBounds(492, 401, 234, 27);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(493, 450, 330, 294);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		desDeTF = new JTextArea();
		desDeTF.setBackground(new Color(255, 255, 255));
		desDeTF.setWrapStyleWord(true);
		desDeTF.setLineWrap(true);
		desDeTF.setBounds(1, 1, 328, 292);
		panel_1.add(desDeTF);
		
		JLabel lblNewLabel_3_2_1_1_2 = new JLabel("MEDICINE PRESCRIPTION");
		lblNewLabel_3_2_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_2_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_3_2_1_1_2.setBounds(989, 175, 366, 41);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_2);
		
		JLabel lblNewLabel_3_2_1_1_3 = new JLabel("Name of Tablet");
		lblNewLabel_3_2_1_1_3.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_3.setBounds(945, 255, 153, 30);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_3);
		
		JLabel lblNewLabel_3_2_1_1_3_1 = new JLabel("Ref#");
		lblNewLabel_3_2_1_1_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_3_1.setBounds(945, 322, 153, 30);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_3_1);
		
		JLabel lblNewLabel_3_2_1_1_3_1_1 = new JLabel("Daily Dose");
		lblNewLabel_3_2_1_1_3_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_3_1_1.setBounds(945, 387, 175, 30);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_3_1_1);
		
		JLabel lblNewLabel_3_2_1_1_3_1_1_1 = new JLabel("Dose(mg)");
		lblNewLabel_3_2_1_1_3_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_3_1_1_1.setBounds(945, 450, 175, 30);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_3_1_1_1);
		
		JLabel lblNewLabel_3_2_1_1_3_1_1_1_1 = new JLabel("Possible SideEffects");
		lblNewLabel_3_2_1_1_3_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_3_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_3_1_1_1_1.setBounds(945, 508, 216, 30);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_3_1_1_1_1);
		
		JLabel lblNewLabel_3_2_1_1_3_1_1_1_1_1 = new JLabel("Company");
		lblNewLabel_3_2_1_1_3_1_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1_1_3_1_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1_1_3_1_1_1_1_1.setBounds(945, 569, 140, 30);
		frame.getContentPane().add(lblNewLabel_3_2_1_1_3_1_1_1_1_1);
		
		String nameOfM[] = new String[] {"select","ACICLOVIR","NOVIDE","Brindso","ARIPHILA","PERISINS","SONOFIO","AVIOLIN-XX","AROPALN","CLOROFINS","PERACITAMOL"};

		namOfTabTF = new JComboBox<Object>(nameOfM);
		namOfTabTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selecNameOfTabString = (String) namOfTabTF.getSelectedItem();
				Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = connection.prepareStatement("select RxNumber,DailyDose,Dose,PossibleSideEffects,Company from medicinedetails where NameOfMedicine = ?");
					statement.setString(1,selecNameOfTabString);
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						rxNumTF.setText(resultSet.getString(1));
						dlydosTF.setText(resultSet.getString(2));
						doseTF.setText(resultSet.getString(3));
						possSTF.setText(resultSet.getString(4));
						comTF.setText(resultSet.getString(5));
					}
					else {
						JOptionPane.showMessageDialog(frame,"no any medicine found");
					}
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		namOfTabTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namOfTabTF.setBounds(1200, 258, 193, 28);
		frame.getContentPane().add(namOfTabTF);
		
		rxNumTF = new JTextField();
		rxNumTF.setColumns(10);
		rxNumTF.setEditable(false);
		rxNumTF.setBounds(1200, 325, 193, 27);
		frame.getContentPane().add(rxNumTF);
		
		dlydosTF = new JTextField();
		dlydosTF.setColumns(10);
		dlydosTF.setBounds(1200, 390, 193, 27);
		frame.getContentPane().add(dlydosTF);
		
		doseTF = new JTextField();
		doseTF.setColumns(10);
		doseTF.setEditable(false);
		doseTF.setBounds(1200, 453, 193, 27);
		frame.getContentPane().add(doseTF);
		
		possSTF = new JTextField();
		possSTF.setColumns(10);
		possSTF.setEditable(false);
		possSTF.setBounds(1200, 511, 193, 27);
		frame.getContentPane().add(possSTF);
		
		comTF = new JTextField();
		comTF.setEditable(false);
		comTF.setColumns(10);
		comTF.setBounds(1200, 572, 193, 27);
		frame.getContentPane().add(comTF);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
	}
}
