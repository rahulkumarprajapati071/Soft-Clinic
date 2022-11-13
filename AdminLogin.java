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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	AdminLoginDBConnection conn;
	AdminRegistration adminRegistration = new AdminRegistration();
	private void adminLogin(String username,String password)
	{
		Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
		try {
			PreparedStatement statement = (PreparedStatement)
					adminLoginConnection.prepareStatement("Select * from registration WHERE username = ? AND password = ?");
			statement.setString(1,username);
			statement.setString(2,password);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
			{
				//display dashboard or Admin Panel.
				JOptionPane.showMessageDialog(contentPane,"Login Successfull","success",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				AdminPanel window = new AdminPanel();
				window.frame.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(contentPane,"Username / Password not found.","erorr",JOptionPane.ERROR_MESSAGE);
			}
			statement.close();
			adminLoginConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
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
		JLabel lblNewLabel_1 = new JLabel("Show");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			int count = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
				if(count % 2 == 0)
				{
					passwTF.setEchoChar('*');
				}
				else {
					passwTF.setEchoChar((char)0);
				}
				
			}
		});
		
		JButton btnForgotPassword = new JButton("Forgot password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ForgetPassword window = new ForgetPassword();
				window.frame.setVisible(true);
			}
		});
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnForgotPassword.setBounds(1000, 511, 152, 25);
		panel.add(btnForgotPassword);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_1.setBounds(1162, 477, 58, 33);
		panel.add(lblNewLabel_1);
		
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
				String passwordString = String.valueOf(passwTF.getPassword());
				if(userNameString.isEmpty() || passwordString.isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Username or Password missing", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//start the login process....
					adminLogin(userNameString,passwordString);
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		loginButton.setBounds(813, 561, 118, 38);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminRegistration adminRegistration = new AdminRegistration();
				adminRegistration.frame.setVisible(true);
			}
		});
		
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		registerButton.setBounds(977, 561, 146, 38);
		panel.add(registerButton);
		
		JButton backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Front window = new Front();
				window.setVisible(true);
			}
		});
		backButton.setHorizontalAlignment(SwingConstants.TRAILING);
		backButton.setBackground(Color.WHITE);
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back (2).png"));
		backButton.setBounds(43, 185, 68, 52);
		panel.add(backButton);
		
		passwTF = new JPasswordField();
		passwTF.setEchoChar('*');
		passwTF.setBounds(926, 470, 226, 38);
		panel.add(passwTF);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\ADMINLOGIN (1).png"));
		panel.add(lblNewLabel);
		
		setResizable(false);
		
		//connectivity portion
		conn = new AdminLoginDBConnection();
		if(conn == null)
		{
			JOptionPane.showMessageDialog(contentPane, "DataBase Connection not availabel","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
