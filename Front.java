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

public class Front extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front window = new Front();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 1313, 754);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1432, 845);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblReceptionist = new JLabel("");
		lblReceptionist.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\receptionist.png"));
		lblReceptionist.setBounds(581, 323, 127, 138);
		panel.add(lblReceptionist);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(1171, 667, 88, 25);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("About Us");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CreditEnd window = new CreditEnd();
				window.setVisible(true);
			}
		});
		lblNewLabel_2.setBounds(0, 0, 88, 25);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		
		JLabel lblAdmin = new JLabel("");
		lblAdmin.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\admin.png"));
		lblAdmin.setBounds(339, 323, 133, 147);
		panel.add(lblAdmin);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin aLogin = new AdminLogin();
				aLogin.setVisible(true);
				dispose();
			}
		});
		btnAdmin.setForeground(new Color(51, 51, 255));
		btnAdmin.setBackground(new Color(204, 255, 255));
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdmin.setBounds(308, 474, 175, 39);
		panel.add(btnAdmin);
		
		JButton btnReception = new JButton("RECEPTIONIST");
		btnReception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReceptionistLogin window = new ReceptionistLogin();
				window.frame.setVisible(true);
			}
		});
		btnReception.setForeground(new Color(51, 51, 255));
		btnReception.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnReception.setBackground(new Color(204, 255, 255));
		btnReception.setBounds(527, 474, 232, 39);
		panel.add(btnReception);
		
		JLabel lblDoctor = new JLabel("");
		lblDoctor.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\doctor (4).png"));
		lblDoctor.setBounds(831, 323, 127, 138);
		panel.add(lblDoctor);
		
		JButton btnDoctor = new JButton("DOCTOR");
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorLogin window = new DoctorLogin();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnDoctor.setForeground(new Color(51, 51, 255));
		btnDoctor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDoctor.setBackground(new Color(204, 255, 255));
		btnDoctor.setBounds(803, 474, 175, 39);
		panel.add(btnDoctor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(153, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\hmbackground.png"));
		lblNewLabel.setBounds(0, 0, 1309, 725);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(169, 425, 45, 13);
		panel.add(lblNewLabel_1);
	}
}
