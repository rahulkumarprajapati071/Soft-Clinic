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

public class DoctorLogin {

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
					DoctorLogin window = new DoctorLogin();
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
	public DoctorLogin() {
		// TODO Auto-generated constructor stub
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(364, 193, 578, 399);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		passTF = new JPasswordField();
		passTF.setBackground(new Color(192, 192, 192));
		passTF.setBounds(203, 201, 218, 32);
		panel.add(passTF);
		
		JLabel lblNewLabel_1 = new JLabel("DOCTOR LOGIN PANEL");
		lblNewLabel_1.setBounds(96, 28, 398, 43);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 34));
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(313, 292, 125, 40);
		panel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Front window = new Front();
				window.setVisible(true);
			}
		});
		cancelBtn.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.setBounds(143, 292, 125, 40);
		panel.add(loginBtn);
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
						PreparedStatement statement = connection.prepareStatement("select * from doctordetails where Username = ? and Password = ?");
						statement.setString(1, userNameString);
						statement.setString(2, passwordString);
						
						ResultSet resultSet = statement.executeQuery();
						if(resultSet.next())
						{
							
							JOptionPane.showMessageDialog(frame, "Login Succesfull", "Welcome Dr."+resultSet.getString(2), JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							DoctorPanel window = new DoctorPanel();
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\D3 (2).png"));
		lblNewLabel.setBounds(0, 0, 1274, 717);
		frame.getContentPane().add(lblNewLabel);
	}

}
