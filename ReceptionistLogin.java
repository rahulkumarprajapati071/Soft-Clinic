package softclinic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ReceptionistLogin {

	public JFrame frame;
	private JTextField userTF;
	private JPasswordField passTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistLogin window = new ReceptionistLogin();
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
	public ReceptionistLogin() {
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
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Front window = new Front();
				window.setVisible(true);
			}
		});
		cancelBtn.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		cancelBtn.setBounds(648, 493, 125, 40);
		frame.getContentPane().add(cancelBtn);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userNameString = userTF.getText();
				String passwordString = new String(passTF.getPassword());
				if(userNameString.isEmpty() || passwordString.isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Username or Password missing", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//start the login process....
					Connection connection = AdminLoginDBConnection.connectAdminLoginDB();
					try {
						PreparedStatement statement = connection.prepareStatement("select * from receptiondetails where Username = ? and Password = ?");
						statement.setString(1, userNameString);
						statement.setString(2, passwordString);
						
						ResultSet resultSet = statement.executeQuery();
						if(resultSet.next())
						{
							
							JOptionPane.showMessageDialog(frame, "Login Succesfull", "success", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							ReceptionistPanel window = new ReceptionistPanel();
							window.frame.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(frame,"Username or password wrong","erorr",JOptionPane.ERROR_MESSAGE);
							userTF.setText(null);
							passTF.setText(null);
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		loginBtn.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		loginBtn.setBounds(493, 493, 125, 40);
		frame.getContentPane().add(loginBtn);
		
		userTF = new JTextField();
		userTF.setBackground(new Color(192, 192, 192));
		userTF.setBounds(569, 325, 216, 31);
		frame.getContentPane().add(userTF);
		userTF.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\PASSWORD.png"));
		lblNewLabel_2_1.setBounds(481, 376, 53, 60);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\LOGIN.png"));
		lblNewLabel_2.setBounds(481, 309, 53, 60);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("RECEPTIONIST LOGIN PANEL");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(405, 221, 628, 54);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(364, 167, 578, 396);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		passTF = new JPasswordField();
		passTF.setBackground(new Color(192, 192, 192));
		passTF.setBounds(205, 226, 218, 32);
		panel.add(passTF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\hmbackground.png"));
		lblNewLabel.setBounds(0, 0, 1274, 717);
		frame.getContentPane().add(lblNewLabel);
	}
}
