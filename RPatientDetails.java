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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JDateChooser;

public class RPatientDetails {

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
	private Connection adminLoginConnection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private DefaultTableModel model1;
	private ResultSetMetaData resultSetMetaData;
	private String genderString;
	private JRadioButton fembtn;
	private String[] colName;
	private JTable tblData;
	private String[] rowStrings;
	private JComboBox<?> ptTypeTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPatientDetails window = new RPatientDetails();
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
	}
	public void autoID()
	{
		Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
		try {
			PreparedStatement statement = connection.prepareStatement("select Max(PatientID) from patientdetails");
			
			ResultSet rSet = statement.executeQuery();
			rSet.next();
			rSet.getString("Max(PatientID)");
			if(rSet.getString("Max(PatientID)")==null)
			{
				int depID = 1;
				String invoicNumString = "PI"+new SimpleDateFormat("ddMM").format(new Date())+depID;
				pIDTF.setText(invoicNumString);
			}
			else {
				Long petID = Long.parseLong(rSet.getString("Max(PatientID)").substring(5));
				petID++;
				String invoicNumString = "PI"+"00"+petID;//DR23101
				pIDTF.setText(invoicNumString);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public RPatientDetails() {
		initialize();
		autoID();
	}
	public void viewDetails()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 363, 1254, 273);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		tblData.addMouseListener(new MouseAdapter() {
			private TableModel model;

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblData.getSelectedRow();
				model = tblData.getModel();
				pIDTF.setText(model.getValueAt(i, 0).toString());
				fNamTF.setText(model.getValueAt(i, 1).toString());
				lstNTF.setText(model.getValueAt(i, 2).toString());
				ageTF.setText(model.getValueAt(i, 3).toString());
				mtrlTF.setSelectedItem(model.getValueAt(i, 4).toString());
				genderString = model.getValueAt(i, 5).toString();
				if(genderString.equals("Male"))
					malebtn.setSelected(true);
				else {
					fembtn.setSelected(true);
				}
				String dateString = model.getValueAt(i, 6).toString();
				((JTextField)daTF.getDateEditor().getUiComponent()).setText(dateString);
				
				addrTF.setText(model.getValueAt(i, 7).toString());
				adhTF.setText(model.getValueAt(i, 8).toString());
				phonTF.setText(model.getValueAt(i, 9).toString());
				ptTypeTF.setSelectedItem(model.getValueAt(i, 10).toString());
				BedNoTF.setText(model.getValueAt(i, 11).toString());
			}
		});
		scrollPane.setViewportView(tblData);
		model1 = (DefaultTableModel) tblData.getModel();
		
		adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select PatientID,FirstName,LastName,Age,MaritialSts,Gender,PresentDate,Address,AadharNum,PhoneNum,PatientType,BedNo from patientdetails");
			
			resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel..
			resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			int cols = resultSetMetaData.getColumnCount();
			colName = new String[cols];
			for(int i = 0; i < cols; i++)
			{
				colName[i] = resultSetMetaData.getColumnName(i+1);
			}
			model1.setColumnIdentifiers(colName);
			
			String patID;
			String firstName;
			String lastName;
			String ageString;
			String mtrString;
			String gender;
			String presDatString;
			String address;
			String aadharString;
			String phonenoString;
			String ptnType;
			String bedNo;
			
			while(resultSet.next())
			{
				patID = resultSet.getString(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				ageString = resultSet.getString(4);
				mtrString = resultSet.getString(5);
				gender = resultSet.getString(6);
				presDatString = resultSet.getString(7);
				address = resultSet.getString(8);
				aadharString = resultSet.getString(9);
				phonenoString = resultSet.getString(10);
				ptnType = resultSet.getString(11);
				bedNo = resultSet.getString(12);
				rowStrings = new String[]{patID,firstName,lastName,ageString,mtrString,gender,presDatString
						,address,aadharString,phonenoString,ptnType,bedNo
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1288, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		
		fembtn = new JRadioButton("Female");
		buttonGroup.add(fembtn);
		fembtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fembtn.setBounds(1088, 214, 84, 26);
		frame.getContentPane().add(fembtn);
		
		malebtn = new JRadioButton("Male");
		buttonGroup.add(malebtn);
		malebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		malebtn.setBounds(1004, 214, 69, 26);
		malebtn.setSelected(true);
		frame.getContentPane().add(malebtn);
		
		JLabel gendLbll = new JLabel("Gender");
		gendLbll.setForeground(Color.BLUE);
		gendLbll.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		gendLbll.setBounds(862, 212, 130, 28);
		frame.getContentPane().add(gendLbll);
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(818, 655, 259, 50);
		frame.getContentPane().add(panel_1_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Delete Patient");
		lblNewLabel_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ptIDString = pIDTF.getText();
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try 
				{
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("delete from patientdetails where PatientID = ?");
					statement.setString(1, ptIDString);
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
					viewDetails();
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
		panel_1_1_1.add(lblNewLabel_4_2);
		lblNewLabel_4_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DELETESMALL.png"));
		lblNewLabel_4_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(493, 655, 272, 50);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Update Patient");
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
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("update patientdetails set FirstName = ?,LastName = ?,Age = ?,MaritialSts = ?,Gender = ?,PresentDate = ?"
									+ ",Address = ?,AadharNum = ?,PhoneNum = ?,PatientType = ?,BedNo = ? where PatientID = ?");
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
					statement.setString(12,patID);
					int rSet = statement.executeUpdate();
					if(rSet > 0)
						JOptionPane.showMessageDialog(frame,"Patient Update Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					autoID();
					viewDetails();
				} catch (Exception en) {
					// TODO: handle exception
					en.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Patient Updation failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\UPDATESMALL.png"));
		lblNewLabel_4_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(240, 655, 213, 50);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Add Patient");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
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
				//connection from db for fill doctor details....
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = (PreparedStatement)
							adminLoginConnection.prepareStatement("insert into patientdetails(PatientID,FirstName,LastName,Age,MaritialSts,Gender,PresentDate,Address,AadharNum,PhoneNum,PatientType,BedNo) values(?,?,?,?,?,?,?,?,?,?,?,?)");
					statement.setString(1,patID);
					statement.setString(2,firstName);
					statement.setString(3,lastName);
					statement.setString(4, ageString);
					statement.setString(5, mtrString);
					statement.setString(6, genderString);
					statement.setString(7, presDatString);
					statement.setString(8, address);
					statement.setString(9, aadharString);
					statement.setString(10, phonenoString);
					statement.setString(11, ptnType);
					statement.setString(12, bedNo);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Patient Added Successfuly","success",JOptionPane.INFORMATION_MESSAGE);
					clear();
					autoID();
					viewDetails();
				} catch (Exception en) {
					JOptionPane.showMessageDialog(frame,"Patient Addition Failed","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\adduser.png"));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		
		String patTypeString[] = new String[] {"select","Indoor","Outdoor"};
		ptTypeTF = new JComboBox<Object>(patTypeString);
		ptTypeTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ptTypeTF.setBounds(998, 310, 187, 28);
		frame.getContentPane().add(ptTypeTF);
		
		JLabel lblNewLabel_3_3_1_2 = new JLabel("Patient Type");
		lblNewLabel_3_3_1_2.setForeground(Color.BLUE);
		lblNewLabel_3_3_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1_2.setBounds(862, 311, 139, 27);
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
						if(resultSet.getString(6) == "Male")
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
		lblNewLabel_3_3_2_2.setBounds(998, 114, 152, 39);
		frame.getContentPane().add(lblNewLabel_3_3_2_2);
		
		JLabel lblNewLabel_3_3_2_1 = new JLabel("");
		lblNewLabel_3_3_2_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_2_1.setBounds(799, 218, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_3_2_1);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("Age");
		lblNewLabel_3_3_2.setForeground(Color.BLUE);
		lblNewLabel_3_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_2.setBounds(862, 166, 118, 33);
		frame.getContentPane().add(lblNewLabel_3_3_2);
		
		phonTF = new JTextField();
		phonTF.setColumns(10);
		phonTF.setBounds(634, 313, 187, 27);
		frame.getContentPane().add(phonTF);
		
		addrTF = new JTextField();
		addrTF.setColumns(10);
		addrTF.setBounds(634, 268, 551, 27);
		frame.getContentPane().add(addrTF);
		
		lstNTF = new JTextField();
		lstNTF.setColumns(10);
		lstNTF.setBounds(634, 166, 187, 27);
		frame.getContentPane().add(lstNTF);
		
		JLabel lblNewLabel_3_3_1_1_1 = new JLabel("Phone No.");
		lblNewLabel_3_3_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1_1_1.setBounds(483, 311, 152, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1_1_1);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Address");
		lblNewLabel_3_3_1_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1_1.setBounds(483, 268, 152, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Maritial Status");
		lblNewLabel_3_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3_1.setBounds(483, 218, 152, 27);
		frame.getContentPane().add(lblNewLabel_3_3_1);
		
		String marStatuString[] = new String[] {"select","Married","Widowed","Separated","Divorced","Single"};
		mtrlTF = new JComboBox<Object>(marStatuString);
		mtrlTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mtrlTF.setBounds(634, 216, 187, 28);
		frame.getContentPane().add(mtrlTF);
		
		JLabel lblNewLabel_3_3 = new JLabel("Last Name");
		lblNewLabel_3_3.setForeground(Color.BLUE);
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_3.setBounds(483, 166, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		daTF = new JDateChooser();
		daTF.setBounds(260, 217, 187, 28);
		daTF.setDateFormatString("yyyy-MM-dd");
		frame.getContentPane().add(daTF);
		
		BedNoTF = new JTextField();
		BedNoTF.setColumns(10);
		BedNoTF.setBounds(260, 311, 187, 27);
		frame.getContentPane().add(BedNoTF);
		
		adhTF = new JTextField();
		adhTF.setColumns(10);
		adhTF.setBounds(260, 266, 187, 27);
		frame.getContentPane().add(adhTF);
		
		fNamTF = new JTextField();
		fNamTF.setColumns(10);
		fNamTF.setBounds(260, 169, 187, 27);
		frame.getContentPane().add(fNamTF);
		
		pIDTF = new JTextField();
		pIDTF.setBounds(261, 116, 709, 37);
		frame.getContentPane().add(pIDTF);
		pIDTF.setColumns(10);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Bed No.");
		lblNewLabel_3_2_1.setForeground(Color.BLUE);
		lblNewLabel_3_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2_1.setBounds(100, 310, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Aadhar Num.");
		lblNewLabel_3_2.setForeground(Color.BLUE);
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_2.setBounds(100, 266, 175, 27);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date");
		lblNewLabel_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3_1.setBounds(100, 220, 118, 27);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(100, 169, 118, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_2.setBounds(100, 116, 205, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 31, 1274, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT DETAILS");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(478, 14, 370, 31);
		panel.add(lblNewLabel);
		
		JButton homeBtn = new JButton("");
		homeBtn.setBounds(27, 14, 51, 34);
		panel.add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReceptionistPanel window = new ReceptionistPanel();
				window.frame.setVisible(true);
			}
		});
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\home.png"));
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(996, 166, 187, 27);
		frame.getContentPane().add(ageTF);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		viewDetails();
	}
}
