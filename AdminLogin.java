package softclinic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userTF;
	private JPasswordField passwTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
		  		} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1272, 754);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1258, 764);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userNameLabel = new JLabel("UserName");
		userNameLabel.setForeground(Color.BLUE);
		userNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		userNameLabel.setBounds(780, 399, 128, 45);
		panel.add(userNameLabel);
		
		JLabel LoginTextMessageLable = new JLabel("Login Here");
		LoginTextMessageLable.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		LoginTextMessageLable.setBounds(870, 325, 180, 45);
		panel.add(LoginTextMessageLable);
		
		JLabel PasswordLable = new JLabel("Password");
		PasswordLable.setForeground(Color.BLUE);
		PasswordLable.setBackground(Color.WHITE);
		PasswordLable.setFont(new Font("Segoe UI", Font.BOLD, 25));
		PasswordLable.setBounds(780, 470, 128, 45);
		panel.add(PasswordLable);
		
		userTF = new JTextField();
		userTF.setBounds(926, 399, 226, 38);
		panel.add(userTF);
		userTF.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userNameString = userTF.getText();
				String passwordString = passwTF.getText().toString();
				if(userNameString.isEmpty())
				{
					JOptionPane pane = new JOptionPane();
					pane.showMessageDialog(contentPane, "Username or Password missing", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//start the login process....
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		loginButton.setBounds(813, 561, 118, 38);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		registerButton.setBounds(977, 561, 146, 38);
		panel.add(registerButton);
		
		JButton backButton = new JButton("");
		backButton.setHorizontalAlignment(SwingConstants.TRAILING);
		backButton.setBackground(Color.WHITE);
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setIcon(new ImageIcon("E:\\Hospital ka saaman\\Hospital Management System\\src\\back (2).png"));
		backButton.setBounds(43, 185, 68, 52);
		panel.add(backButton);
		
		passwTF = new JPasswordField();
		passwTF.setBounds(926, 470, 226, 38);
		panel.add(passwTF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Pictures\\ADMINLOGIN (1).jpg"));
		panel.add(lblNewLabel);
		
		setResizable(false);
	}
}
