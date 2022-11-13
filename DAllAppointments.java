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

public class DAllAppointments {

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
					DAllAppointments window = new DAllAppointments();
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
	public DAllAppointments() {
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
		
		JLabel lblNewLabel = new JLabel("View Appointments");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setBounds(478, 14, 370, 31);
		panel.add(lblNewLabel);
		
		JButton homeBtn = new JButton("");
		homeBtn.setBounds(27, 14, 51, 34);
		panel.add(homeBtn);
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();DoctorPanel window = new DoctorPanel();
				window.frame.setVisible(true);
			}
		});
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\home.png"));
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR NAME");
		lblNewLabel_1.setBounds(338, 304, 292, 41);
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
		seTF.setBounds(612, 304, 352, 41);
		frame.getContentPane().add(seTF);
		seTF.setColumns(10);
		
		viewDetails();
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\appointment.jpg"));
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
					adminLoginConnection.prepareStatement("select * from appointmentdetails");
			
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
			
			String drnameString;
			String firString;
			String laString;
			String dateString;
			String timeString;
			
			while(resultSet.next())
			{
				drnameString = resultSet.getString(1);
				firString = resultSet.getString(2);
				laString = resultSet.getString(3);
				dateString = resultSet.getString(4);
				timeString = resultSet.getString(5);
				
				rowStrings = new String[]{drnameString,firString,laString,dateString,timeString
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
