package softclinic;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminRegistration {

	public JFrame frame;
	private JTextField userTF;
	private JTextField LastNameTF;
	private JTextField ansTF;
	private JPasswordField passTF;
	private JTextField mobTF;
	private JTextField emailTF;
	private JComboBox<Object> queTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistration window = new AdminRegistration();
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
	public AdminRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1267, 749);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(634, 389, 320, 36);
		frame.getContentPane().add(emailTF);
		
		mobTF = new JTextField();
		mobTF.setColumns(10);
		mobTF.setBounds(634, 267, 320, 36);
		frame.getContentPane().add(mobTF);
		
		JLabel adminRegistPanelLbl = new JLabel("Admin Registration Panel");
		adminRegistPanelLbl.setBackground(SystemColor.activeCaptionBorder);
		adminRegistPanelLbl.setForeground(new Color(255, 0, 0));
		adminRegistPanelLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		adminRegistPanelLbl.setBounds(383, 54, 540, 56);
		frame.getContentPane().add(adminRegistPanelLbl);
		
		JLabel userLbl = new JLabel("Username");
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		userLbl.setForeground(new Color(0, 0, 255));
		userLbl.setBounds(320, 143, 154, 37);
		frame.getContentPane().add(userLbl);
		
		userTF = new JTextField();
		userTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();

				try {
					PreparedStatement statement = adminLoginConnection.prepareStatement("select username from registration where username = ?");
					statement.setString(1, userTF.getText());
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						userTF.setForeground(Color.RED);
					}
					else {
						
						userTF.setForeground(Color.GREEN);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		userTF.setBounds(634, 144, 320, 36);
		frame.getContentPane().add(userTF);
		userTF.setColumns(10);
		
		JLabel LnameLbl = new JLabel("Name");
		LnameLbl.setForeground(new Color(0, 0, 255));
		LnameLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		LnameLbl.setBounds(320, 204, 89, 37);
		frame.getContentPane().add(LnameLbl);
		
		
		LastNameTF = new JTextField();
		LastNameTF.setColumns(10);
		LastNameTF.setBounds(634, 205, 320, 36);
		frame.getContentPane().add(LastNameTF);
		
		JLabel lblAge = new JLabel("Mobile");
		lblAge.setForeground(new Color(0, 0, 255));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAge.setBounds(320, 266, 101, 37);
		frame.getContentPane().add(lblAge);
		
		JLabel lblAddress = new JLabel("Answer");
		lblAddress.setForeground(new Color(0, 0, 255));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAddress.setBounds(320, 506, 114, 37);
		frame.getContentPane().add(lblAddress);

		
		JLabel lblUsername = new JLabel("Security Question");
		lblUsername.setForeground(new Color(0, 0, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(320, 447, 270, 37);
		frame.getContentPane().add(lblUsername);
		
		ansTF = new JTextField();
		ansTF.setColumns(10);
		ansTF.setBounds(634, 507, 320, 36);
		frame.getContentPane().add(ansTF);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(320, 327, 148, 37);
		frame.getContentPane().add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userString = userTF.getText();
				String nameString = LastNameTF.getText();
				String mobString = mobTF.getText();
				String passString = String.valueOf(passTF.getPassword());
				String emaiString = emailTF.getText();
				String queString = queTF.getSelectedItem().toString();
				String ansString = ansTF.getText();
				if(userString.isEmpty() || nameString.isEmpty() || mobString.isEmpty() || passString.isEmpty() || emaiString.isEmpty() || queString.isEmpty() || ansString.isEmpty())
				{
					JOptionPane.showMessageDialog(frame,"Enter all details","Erorr",JOptionPane.ERROR_MESSAGE);
				}
				else {
					//connection from db for registration....
					Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
					try {
						PreparedStatement statement = (PreparedStatement)
								adminLoginConnection.prepareStatement("insert into registration(username,name,mobileNum,email,password,question,answer) values(?,?,?,?,?,?,?)");
						statement.setString(1,userString);
						statement.setString(2,nameString);
						statement.setString(3,mobString);
						statement.setString(4,emaiString);
						statement.setString(5,passString);
						statement.setString(6,queString);
						statement.setString(7,ansString);
						
						statement.close();
						adminLoginConnection.close();
						JOptionPane.showMessageDialog(frame,"Registration Successfull","successfull",JOptionPane.INFORMATION_MESSAGE);
						AdminLogin adminLogin = new AdminLogin();
						frame.dispose();
						adminLogin.setVisible(true);
					} catch (Exception en) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(frame,"Registration Failed","erorr",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnSubmit.setBounds(442, 624, 141, 43);
		frame.getContentPane().add(btnSubmit);
		
		JButton canclebtn = new JButton("Cancel");
		canclebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.setVisible(true);
			}
		});
		canclebtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		canclebtn.setBounds(654, 624, 141, 43);
		frame.getContentPane().add(canclebtn);
		
		passTF = new JPasswordField();
		passTF.setEchoChar('*');
		passTF.setBounds(634, 327, 320, 36);
		frame.getContentPane().add(passTF);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255,255,125));
		panel.setBounds(243, 44, 790, 545);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(77, 340, 83, 37);
		panel.add(lblEmail);
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		String queString[] = new String[] {"What is your favorite color?","What is your eldest cousin's name?",
				"In what city or town was your mother born?","who is your favorite cricket player","who is your favorite Indian singer",
				"who is your favorite motivator","what is your first school name?"};
		queTF = new JComboBox<Object>(queString);
		queTF.setBounds(391, 404, 318, 37);
		panel.add(queTF);
		
		JLabel lblNewLabel = new JLabel("Show");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			int count = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				count++;
				if(count % 2 == 0)
				{
					passTF.setEchoChar('*');
				}
				else {
					passTF.setEchoChar((char)0);
				}
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(723, 295, 45, 13);
		panel.add(lblNewLabel);
		
		
		JLabel backgrounLbl = new JLabel("");
		backgrounLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
		backgrounLbl.setBackground(SystemColor.text);
		backgrounLbl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Documents\\src\\back1.jpg"));
		backgrounLbl.setBounds(0, 0,1253, 712);
		frame.getContentPane().add(backgrounLbl);
		
		JLabel lblAge_1 = new JLabel("Mobile");
		lblAge_1.setForeground(Color.BLUE);
		lblAge_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAge_1.setBounds(181, 376, 181, 86);
		frame.getContentPane().add(lblAge_1);
		frame.setLocationRelativeTo(null);
		
		frame.setResizable(false);
	}
}
