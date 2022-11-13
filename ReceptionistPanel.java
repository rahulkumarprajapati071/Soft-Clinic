package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ReceptionistPanel {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistPanel window = new ReceptionistPanel();
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
	public ReceptionistPanel() {
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
		
		JLabel lblNewLabel_1_3 = new JLabel("LOGOUT");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				ReceptionistLogin window = new ReceptionistLogin();
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_3.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(264, 472, 109, 28);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("PATIENT DETAILS");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				RPatientDetails window = new RPatientDetails();
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(173, 404, 291, 57);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("DOCTOR DETAILS");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				RDoctorDetails window = new RDoctorDetails();
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(173, 337, 291, 57);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("CREATE APPOINTMENT");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				RDAppointment window = new RDAppointment();
				window.frame.setVisible(true);
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(173, 270, 291, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(260, 472, 118, 28);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(178, 404, 286, 52);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(178, 337, 286, 52);
		frame.getContentPane().add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(178, 275, 286, 52);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\recback.jpg"));
		lblNewLabel.setBounds(0, 0, 1274, 717);
		frame.getContentPane().add(lblNewLabel);
	}

}
