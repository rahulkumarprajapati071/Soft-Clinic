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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class DPHistory {

	public JFrame frame;
	private JTextField pITf;
	private JLabel headNameLbl;
	private JLabel lblHistory;
	private JLabel nicheStarLbl;
	private JLabel uparLIneLbl;
	private JLabel datLbl;
	private JLabel datLbl_1;
	private JLabel ptiNLbl;
	private JLabel PtiAgeLbl;
	private JLabel GenLbl;
	private JLabel aadhLbl;
	private JLabel PatTLbl;
	private JLabel DisLbl;
	private JLabel DesLbl;
	private JLabel MedRecLbl;
	private JLabel DalDoLbl;
	private JLabel comLbl;
	private JLabel namLbl;
	private JLabel agLbl;
	private JLabel genLbl;
	private JLabel aaaaLbl;
	private JLabel ptpLbl;
	private JLabel diseLbl;
	private JLabel descLbl;
	private JLabel medrLbl;
	private JLabel ddLbl;
	private JLabel coLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DPHistory window = new DPHistory();
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
	public DPHistory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1289, 783);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
				String pIDString = pITf.getText();
				uparLIneLbl.setText("*********************************************");
				lblHistory.setText("HISTORY");
				nicheStarLbl.setText("*********************************************");
				datLbl.setText("Date:");
				ptiNLbl.setText("Patient Name:");
				PtiAgeLbl.setText("Patient Age:");
				GenLbl.setText("Gender:");
				aadhLbl.setText("Aadhar Num:");
				PatTLbl.setText("Patient Type:");
				DisLbl.setText("Disease:");
				DesLbl.setText("Description:");
				MedRecLbl.setText("Medicine Recomended:");
				DalDoLbl.setText("Daily Dose:");
				comLbl.setText("Company");
				
				try {
					PreparedStatement statement = connection.prepareStatement("select FirstName,LastName,Age,Gender,PresentDate,AadharNum,PatientType,Disease,Description,NameOfTablet,DailyDose,Company from patientdetails where PatientId = ?");
					statement.setString(1, pIDString);
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						
						String headNameString = resultSet.getString(1);
						String headSurString = resultSet.getString(2);
						headNameLbl.setText(headNameString +"  "+headSurString);
						datLbl_1.setText(resultSet.getString(5));
						namLbl.setText(resultSet.getString(1)+" "+resultSet.getString(2));
						agLbl.setText(resultSet.getString(3));
						genLbl.setText(resultSet.getString(4));
						aaaaLbl.setText(resultSet.getString(6));
						ptpLbl.setText(resultSet.getString(7));
						diseLbl.setText(resultSet.getString(8));
						descLbl.setText(resultSet.getString(9));
						medrLbl.setText(resultSet.getString(10));
						ddLbl.setText(resultSet.getString(11));
						coLbl.setText(resultSet.getString(12));
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		lblSearch.setForeground(new Color(0, 128, 255));
		lblSearch.setBounds(910, 113, 80, 34);
		frame.getContentPane().add(lblSearch);
		lblSearch.setFont(new Font("Segoe UI", Font.BOLD, 21));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(890, 113, 117, 34);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 20, 1324, 56);
		frame.getContentPane().add(panel);
		
		JButton homeBtn = new JButton("");
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DPatientDetails window = new DPatientDetails();
				window.frame.setVisible(true);
			}
		});
		homeBtn.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back (2).png"));
		homeBtn.setBounds(25, 6, 68, 42);
		panel.add(homeBtn);
		
		JLabel lblCheckPatientHistory = new JLabel("CHECK PATIENT HISTORY");
		lblCheckPatientHistory.setForeground(new Color(240, 255, 240));
		lblCheckPatientHistory.setFont(new Font("Verdana", Font.BOLD, 35));
		lblCheckPatientHistory.setBounds(407, 6, 510, 44);
		panel.add(lblCheckPatientHistory);
		
		pITf = new JTextField();
		pITf.setBounds(405, 113, 450, 34);
		frame.getContentPane().add(pITf);
		pITf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(225, 106, 154, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(114, 178, 1058, 558);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		uparLIneLbl = new JLabel("");
		uparLIneLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		uparLIneLbl.setForeground(new Color(0, 0, 255));
		uparLIneLbl.setBounds(349, 10, 381, 13);
		panel_2.add(uparLIneLbl);
		
		nicheStarLbl = new JLabel("");
		nicheStarLbl.setForeground(Color.BLUE);
		nicheStarLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		nicheStarLbl.setBounds(349, 66, 381, 13);
		panel_2.add(nicheStarLbl);
		
		headNameLbl = new JLabel("");
		headNameLbl.setForeground(new Color(0, 0, 255));
		headNameLbl.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		headNameLbl.setBounds(376, 29, 183, 27);
		panel_2.add(headNameLbl);
		
		lblHistory = new JLabel("");
		lblHistory.setForeground(new Color(0, 0, 255));
		lblHistory.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblHistory.setBounds(569, 29, 175, 27);
		panel_2.add(lblHistory);
		
		datLbl = new JLabel("");
		datLbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		datLbl.setForeground(new Color(0, 0, 255));
		datLbl.setBounds(803, 29, 46, 27);
		panel_2.add(datLbl);
		
		datLbl_1 = new JLabel("");
		datLbl_1.setForeground(Color.BLUE);
		datLbl_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		datLbl_1.setBounds(859, 29, 135, 27);
		panel_2.add(datLbl_1);
		
		ptiNLbl = new JLabel("");
		ptiNLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		ptiNLbl.setForeground(new Color(0, 0, 255));
		ptiNLbl.setBounds(31, 117, 139, 30);
		panel_2.add(ptiNLbl);
		
		PtiAgeLbl = new JLabel("");
		PtiAgeLbl.setForeground(Color.BLUE);
		PtiAgeLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		PtiAgeLbl.setBounds(31, 157, 139, 30);
		panel_2.add(PtiAgeLbl);
		
		GenLbl = new JLabel("");
		GenLbl.setForeground(Color.BLUE);
		GenLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		GenLbl.setBounds(31, 197, 139, 30);
		panel_2.add(GenLbl);
		
		aadhLbl = new JLabel("");
		aadhLbl.setForeground(Color.BLUE);
		aadhLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		aadhLbl.setBounds(31, 237, 139, 30);
		panel_2.add(aadhLbl);
		
		PatTLbl = new JLabel("");
		PatTLbl.setForeground(Color.BLUE);
		PatTLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		PatTLbl.setBounds(31, 277, 139, 30);
		panel_2.add(PatTLbl);
		
		DisLbl = new JLabel("");
		DisLbl.setForeground(Color.BLUE);
		DisLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		DisLbl.setBounds(31, 317, 139, 30);
		panel_2.add(DisLbl);
		
		DesLbl = new JLabel("");
		DesLbl.setForeground(Color.BLUE);
		DesLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		DesLbl.setBounds(31, 357, 139, 30);
		panel_2.add(DesLbl);
		
		MedRecLbl = new JLabel("");
		MedRecLbl.setForeground(Color.BLUE);
		MedRecLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		MedRecLbl.setBounds(31, 397, 233, 30);
		panel_2.add(MedRecLbl);
		
		DalDoLbl = new JLabel("");
		DalDoLbl.setForeground(Color.BLUE);
		DalDoLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		DalDoLbl.setBounds(31, 437, 139, 30);
		panel_2.add(DalDoLbl);
		
		comLbl = new JLabel("");
		comLbl.setForeground(Color.BLUE);
		comLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		comLbl.setBounds(31, 477, 139, 30);
		panel_2.add(comLbl);
		
		namLbl = new JLabel("");
		namLbl.setForeground(Color.BLUE);
		namLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		namLbl.setBounds(389, 117, 617, 30);
		panel_2.add(namLbl);
		
		agLbl = new JLabel("");
		agLbl.setForeground(Color.BLUE);
		agLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		agLbl.setBounds(389, 157, 617, 30);
		panel_2.add(agLbl);
		
		genLbl = new JLabel("");
		genLbl.setForeground(Color.BLUE);
		genLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		genLbl.setBounds(389, 197, 617, 30);
		panel_2.add(genLbl);
		
		aaaaLbl = new JLabel("");
		aaaaLbl.setForeground(Color.BLUE);
		aaaaLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		aaaaLbl.setBounds(389, 237, 617, 30);
		panel_2.add(aaaaLbl);
		
		ptpLbl = new JLabel("");
		ptpLbl.setForeground(Color.BLUE);
		ptpLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		ptpLbl.setBounds(389, 277, 617, 30);
		panel_2.add(ptpLbl);
		
		diseLbl = new JLabel("");
		diseLbl.setForeground(Color.BLUE);
		diseLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		diseLbl.setBounds(389, 317, 617, 30);
		panel_2.add(diseLbl);
		
		descLbl = new JLabel("");
		descLbl.setForeground(Color.BLUE);
		descLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		descLbl.setBounds(389, 357, 628, 30);
		panel_2.add(descLbl);
		
		medrLbl = new JLabel("");
		medrLbl.setForeground(Color.BLUE);
		medrLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		medrLbl.setBounds(389, 397, 617, 30);
		panel_2.add(medrLbl);
		
		ddLbl = new JLabel("");
		ddLbl.setForeground(Color.BLUE);
		ddLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		ddLbl.setBounds(389, 437, 617, 30);
		panel_2.add(ddLbl);
		
		coLbl = new JLabel("");
		coLbl.setForeground(Color.BLUE);
		coLbl.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		coLbl.setBounds(389, 477, 617, 30);
		panel_2.add(coLbl);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\historypic.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1334, 785);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
