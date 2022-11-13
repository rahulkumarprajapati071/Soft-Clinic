package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class RDoctorDetails {

	public JFrame frame;
	private Connection adminLoginConnection;
	private JTable tblData;
	private String[] colName;
	private String[] rowStrings;
	private JTextField seTF;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RDoctorDetails window = new RDoctorDetails();
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
	public RDoctorDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1288, 754);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 31, 1274, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOCTOR DETAILS");
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
		
		JLabel lblNewLabel_1 = new JLabel("SEARCH DOCTOR");
		lblNewLabel_1.setBounds(322, 304, 292, 41);
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
		seTF.setBounds(624, 304, 352, 41);
		frame.getContentPane().add(seTF);
		seTF.setColumns(10);
		
		viewDetails();
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\d3.jpg"));
		lblNewLabel.setBounds(0, 0, 1274, 717);
		frame.getContentPane().add(lblNewLabel);
	}
	public void viewDetails()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 365, 1254, 303);
		frame.getContentPane().add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try 
		{
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("select DoctorID,FirstName,LastName,Age,BloodGroup,Gender,Department,Address,DOB,PhoneNum,MarredeStatus,City,AadharNum,JoinDate,VisitTime,LeavingDate from doctordetails");
			
			ResultSet resultSet = statement.executeQuery();
			//take all meta data of resutlSet...or our database tabel..
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			model = (DefaultTableModel) tblData.getModel();
			
			int cols = resultSetMetaData.getColumnCount();
			colName = new String[cols];
			for(int i = 0; i < cols; i++)
			{
				colName[i] = resultSetMetaData.getColumnName(i+1);
			}
			model.setColumnIdentifiers(colName);
			
			String doctoIdString;
			String firString;
			String laString;
			String ageString;
			String bloodString;
			String genderString;
			String departString;
			String addressString;
			String dobString;
			String phoneString;
			String marredString;
			String cityString;
			String aadharString;
			String joinString;
			String visiString;
			String leavString;
			
			while(resultSet.next())
			{
				doctoIdString = resultSet.getString(1);
				firString = resultSet.getString(2);
				laString = resultSet.getString(3);
				ageString = resultSet.getString(4);
				bloodString = resultSet.getString(5);
				genderString = resultSet.getString(6);
				departString = resultSet.getString(7);
				addressString = resultSet.getString(8);
				dobString = resultSet.getString(9);
				phoneString = resultSet.getString(10);
				marredString = resultSet.getString(11);
				cityString = resultSet.getString(12);
				aadharString = resultSet.getString(13);
				joinString = resultSet.getString(14);
				visiString = resultSet.getString(15);
				leavString = resultSet.getString(16);
				
				rowStrings = new String[]{doctoIdString,firString,laString,ageString,bloodString,genderString,departString,addressString,dobString,phoneString,marredString,cityString,aadharString,joinString,visiString,leavString
				};
				model.addRow(rowStrings);
			}
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
