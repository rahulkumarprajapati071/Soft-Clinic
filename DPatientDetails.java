package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class DPatientDetails {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DPatientDetails window = new DPatientDetails();
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
	public DPatientDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1229, 669);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				DAddPatient window = new DAddPatient();
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_2.setBounds(313, 253, 70, 116);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\ADD (6).png"));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CHECK PATIENT HISTORY");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(656, 379, 381, 43);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(773, 233, 139, 147);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				DPHistory window = new DPHistory();
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\HISTORY.png"));
		lblNewLabel_2_1.setBounds(35, 0, 70, 147);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ADD PATIENT DETAILS");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(193, 379, 345, 43);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(281, 233, 139, 147);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 41, 1215, 63);
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DoctorPanel window = new DoctorPanel();
				window.frame.setVisible(true);
			}
		});
		backButton.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back (2).png"));
		backButton.setHorizontalAlignment(SwingConstants.TRAILING);
		backButton.setForeground(Color.WHITE);
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(1119, 10, 72, 43);
		panel.add(backButton);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT'S PORTAL");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_1.setBounds(30, 10, 360, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\pat.jpg"));
		lblNewLabel.setBounds(0, 0, 1215, 638);
		frame.getContentPane().add(lblNewLabel);
	}
}
