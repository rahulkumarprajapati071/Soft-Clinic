package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JDateChooser;

public class RPAppointment {

	public JFrame frame;
	private Connection adminLoginConnection;
	private JTable tblData;
	private String[] colName;
	private String[] rowStrings;
	private String firsName;
	private String lasName;
	private JTextField seTF;
	private DefaultTableModel model;
	private JDateChooser daTF;
	private JComboBox<?> timTF;
	private SimpleDateFormat sdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPAppointment window = new RPAppointment(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void clear()
	{
		daTF.setDate(null);
		timTF.setSelectedIndex(0);
		
	}
	/**
	 * Create the application.
	 */
	public RPAppointment(String docString) {
		initialize(docString);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String docString) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1288, 754);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("NEXT");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
				try {
					PreparedStatement statement = connection.prepareStatement("insert into appointmentdetails values(?,?,?,?,?)");
					String dateString = sdf.format(daTF.getDate());
					String timeString = (String) timTF.getSelectedItem();
					statement.setString(1, docString);
					statement.setString(2, firsName);
					statement.setString(3, lasName);
					statement.setString(4, dateString);
					statement.setString(5, timeString);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Patient "+firsName+" "+lasName+" Appointmented with Doctor "+docString+" on Date "+sdf.format(daTF.getDate())+" at time "+timTF.getSelectedItem(),"success",JOptionPane.INFORMATION_MESSAGE);
					clear();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame," failed to create Appointment","erorr",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		String marStatuString[] = new String[] {"select","9:00 AM","10:00 AM","11:00 AM","12:00 PM","1:00 PM","2:00 PM",
				"3:00 PM","4:00 PM","5:00 PM","6:00 PM","7:00 PM","8:00 PM","9:00 PM","10:00 PM","11:00 PM","12:00 AM","1:00 AM"};
		timTF = new JComboBox<Object>(marStatuString);
		timTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		timTF.setBounds(382, 586, 187, 28);
		frame.getContentPane().add(timTF);
		
		daTF = new JDateChooser();
		daTF.setDateFormatString("dd-MM-yyyy");
		daTF.setBounds(382, 532, 187, 28);
		frame.getContentPane().add(daTF);
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Timming");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBackground(new Color(245, 245, 245));
		lblNewLabel_1_1_1.setBounds(210, 577, 144, 41);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DATE");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1_1.setBackground(new Color(245, 245, 245));
		lblNewLabel_1_1.setBounds(210, 526, 108, 41);
		frame.getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(857, 577, 166, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(857, 566, 166, 50);
		frame.getContentPane().add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 31, 1274, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Set Appointment");
		lblNewLabel.setBounds(509, 2, 370, 46);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		panel.add(lblNewLabel);
		
		JButton homeBtn = new JButton("");
		homeBtn.setBounds(25, 6, 68, 42);
		panel.add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RDAppointment window = new RDAppointment();
				window.frame.setVisible(true);
			}
		});
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back (2).png"));
		
		JLabel lblNewLabel_1 = new JLabel("SEARCH PATIENT");
		lblNewLabel_1.setBounds(317, 179, 292, 41);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(245, 245, 245));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		
		seTF = new JTextField();
		seTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = seTF.getText();
				search(searchString);			
			}
		});
		seTF.setBounds(606, 186, 352, 28);
		frame.getContentPane().add(seTF);
		seTF.setColumns(10);
		
		viewDetails();
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back1.jpg"));
		lblNewLabel.setBounds(0, 0, 1274, 717);
		frame.getContentPane().add(lblNewLabel);
	}
	public void viewDetails()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 266, 1194, 220);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		tblData.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblData.getSelectedRow();
				firsName = model.getValueAt(i, 1).toString();
				lasName = model.getValueAt(i,2).toString();
			}
		});
		scrollPane.setViewportView(tblData);
		
		adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select PatientID,FirstName,LastName,Age,MaritialSts,Gender,PresentDate,Address,AadharNum,PhoneNum,PatientType,BedNo from patientdetails");
			
			ResultSet resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel...
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			model = (DefaultTableModel) tblData.getModel();
			
			int cols = resultSetMetaData.getColumnCount();
			colName = new String[cols];
			for(int i = 0; i < cols; i++)
			{
				colName[i] = resultSetMetaData.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			String patIDString;
			String firString;
			String laString;
			String ageString;
			String marredString;
			String genderString;
			String prestDaString;
			String addressString;
			String aadharString;
			String phoneString;
			String ptntypString;
			String bedNoString;
			
			while(resultSet.next())
			{
				patIDString = resultSet.getString(1);
				firString = resultSet.getString(2);
				laString = resultSet.getString(3);
				ageString = resultSet.getString(4);
				marredString = resultSet.getString(5);
				genderString = resultSet.getString(6);
				prestDaString = resultSet.getString(7);
				addressString = resultSet.getString(8);
				aadharString = resultSet.getString(9);
				phoneString = resultSet.getString(10);
				ptntypString = resultSet.getString(11);
				bedNoString = resultSet.getString(12);
				
				rowStrings = new String[]{patIDString,firString,laString,ageString,
						marredString,genderString,prestDaString,addressString,aadharString,phoneString,ptntypString,bedNoString
				};
				model.addRow(rowStrings);
			}
			statement.close();
			adminLoginConnection.close();
		} catch (Exception en) {
			// TODO: handle exception
			en.printStackTrace();
			JOptionPane.showMessageDialog(frame,"somthing problem","erorr",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void search(String searString)
	{
		model = (DefaultTableModel) tblData.getModel();
		TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
		tblData.setRowSorter(tableRowSorter);
		tableRowSorter.setRowFilter(RowFilter.regexFilter(searString));
	}
}
