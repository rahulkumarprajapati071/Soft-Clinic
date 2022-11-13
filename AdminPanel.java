package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminPanel {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1338, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JButton BACKbTN = new JButton("LOGOUT");
		BACKbTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin frame = new AdminLogin();
				frame.setVisible(true);
			}
		});
		
		JButton docDetaButton = new JButton("Doctor Details");
		docDetaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ADoctorDetails window = new ADoctorDetails();
				window.frame.setVisible(true);
			}
		});
		
		JButton staffdetBtn = new JButton("Lower Staff Details");
		staffdetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AStaffDetails window = new AStaffDetails();
				window.frame.setVisible(true);
			}
		});
		staffdetBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		staffdetBtn.setBounds(579, 352, 170, 37);
		frame.getContentPane().add(staffdetBtn);
		
		JLabel staffdetailsLbl = new JLabel("");
		staffdetailsLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\EMPLOYEESDETAILS.png"));
		staffdetailsLbl.setBounds(590, 194, 150, 159);
		frame.getContentPane().add(staffdetailsLbl);
		
		JLabel whitebacklbl_2_1_1 = new JLabel("");
		whitebacklbl_2_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_2_1_1.setBackground(Color.GREEN);
		whitebacklbl_2_1_1.setBounds(559, 194, 208, 206);
		frame.getContentPane().add(whitebacklbl_2_1_1);
		docDetaButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		docDetaButton.setBounds(318, 352, 148, 37);
		frame.getContentPane().add(docDetaButton);
		BACKbTN.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\LOGOUT (2).png"));
		BACKbTN.setFont(new Font("Segoe UI Light", Font.BOLD, 16));
		BACKbTN.setBounds(56, 101, 132, 30);
		frame.getContentPane().add(BACKbTN);
		
		JLabel dockImageLbl = new JLabel("New label");
		dockImageLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\DOCTORDETAILS (2).png"));
		dockImageLbl.setBounds(319, 194, 147, 159);
		frame.getContentPane().add(dockImageLbl);
		
		JLabel whitebacklbl_3 = new JLabel("");
		whitebacklbl_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_3.setBackground(Color.GREEN);
		whitebacklbl_3.setBounds(44, 94, 155, 42);
		frame.getContentPane().add(whitebacklbl_3);
		
		JButton DepBTN = new JButton("Department Details");
		DepBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ADepartmentDetails window = new ADepartmentDetails();
				window.frame.setVisible(true);
			}
		});
		DepBTN.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		DepBTN.setBounds(838, 596, 183, 37);
		frame.getContentPane().add(DepBTN);
		
		JLabel DepartDetLbl = new JLabel("");
		DepartDetLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\department.png"));
		DepartDetLbl.setBounds(852, 441, 155, 150);
		frame.getContentPane().add(DepartDetLbl);
		
		JButton bedBtn = new JButton("Bed Availibility");
		bedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ABedDetails window = new ABedDetails();
				window.frame.setVisible(true);
			}
		});
		bedBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		bedBtn.setBounds(590, 596, 148, 37);
		frame.getContentPane().add(bedBtn);
		
		JLabel BedLbl = new JLabel("");
		BedLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\BEDDETAILS.png"));
		BedLbl.setBounds(590, 447, 150, 150);
		frame.getContentPane().add(BedLbl);
		
		JLabel whitebacklbl_1_3 = new JLabel("");
		whitebacklbl_1_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_1_3.setBackground(Color.GREEN);
		whitebacklbl_1_3.setBounds(825, 438, 208, 206);
		frame.getContentPane().add(whitebacklbl_1_3);
		
		JLabel whitebacklbl_2_1 = new JLabel("");
		whitebacklbl_2_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_2_1.setBackground(Color.GREEN);
		whitebacklbl_2_1.setBounds(291, 194, 208, 206);
		frame.getContentPane().add(whitebacklbl_2_1);
		
		JLabel whitebacklbl_1_2 = new JLabel("");
		whitebacklbl_1_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_1_2.setBackground(Color.GREEN);
		whitebacklbl_1_2.setBounds(559, 438, 208, 206);
		frame.getContentPane().add(whitebacklbl_1_2);
		
		JButton ptttbtn = new JButton("Patient Details");
		ptttbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				APatientDetails window = new APatientDetails();
				window.frame.setVisible(true);
			}
		});
		ptttbtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		ptttbtn.setBounds(318, 596, 148, 37);
		frame.getContentPane().add(ptttbtn);
		
		JLabel paitiDetaiLbl = new JLabel("");
		paitiDetaiLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\patientdetals.png"));
		paitiDetaiLbl.setBounds(318, 447, 170, 150);
		frame.getContentPane().add(paitiDetaiLbl);
		
		JLabel whitebacklbl_2 = new JLabel("");
		whitebacklbl_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_2.setBackground(Color.GREEN);
		whitebacklbl_2.setBounds(291, 438, 208, 206);
		frame.getContentPane().add(whitebacklbl_2);
		
		JButton btnReceptionistDetails = new JButton("Receptionist Details");
		btnReceptionistDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AReceptionistDetails window = new AReceptionistDetails();
				window.frame.setVisible(true);
			}
		});
		btnReceptionistDetails.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnReceptionistDetails.setBounds(842, 352, 176, 37);
		frame.getContentPane().add(btnReceptionistDetails);
		
		JLabel RecepDetailLbl = new JLabel("");
		RecepDetailLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\RECETIONISTDETAILS.png"));
		RecepDetailLbl.setBounds(852, 194, 150, 159);
		frame.getContentPane().add(RecepDetailLbl);
		
		JLabel whitebacklbl_1_1 = new JLabel("");
		whitebacklbl_1_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl_1_1.setBackground(Color.GREEN);
		whitebacklbl_1_1.setBounds(825, 194, 208, 206);
		frame.getContentPane().add(whitebacklbl_1_1);
		
		JLabel doctorDetailsLbl = new JLabel("");
		doctorDetailsLbl.setIcon(new ImageIcon("E:\\Hospital ka saaman\\Hospital Management System\\src\\DOCTORDETAILS (2).png"));
		doctorDetailsLbl.setBounds(322, 194, 150, 159);
		frame.getContentPane().add(doctorDetailsLbl);
		
		JLabel backgrounLbl = new JLabel("");
		backgrounLbl.setBackground(Color.RED);
		backgrounLbl.setForeground(new Color(0, 0, 0));
		backgrounLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\adminpanel.png"));
		backgrounLbl.setBounds(0, 0, 1333, 728);
		frame.getContentPane().add(backgrounLbl);
		
		JLabel label = new JLabel("New label");
		label.setBounds(73, 113, 45, 13);
		frame.getContentPane().add(label);
		
		JLabel whitebacklbl = new JLabel("");
		whitebacklbl.setBackground(new Color(0, 255, 0));
		whitebacklbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\white.jpg"));
		whitebacklbl.setBounds(291, 194, 208, 206);
		frame.getContentPane().add(whitebacklbl);
	}
}
