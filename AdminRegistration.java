package softclinic;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminRegistration {

	public JFrame frame;
	private JTextField nameTF;
	private JTextField LastNameTF;
	private JTextField userTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passTF;

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
		
		JLabel adminRegistPanelLbl = new JLabel("Admin Registration Panel");
		adminRegistPanelLbl.setBackground(SystemColor.activeCaptionBorder);
		adminRegistPanelLbl.setForeground(new Color(0, 128, 128));
		adminRegistPanelLbl.setFont(new Font("Tahoma", Font.BOLD, 40));
		adminRegistPanelLbl.setBounds(383, 54, 540, 56);
		frame.getContentPane().add(adminRegistPanelLbl);
		
		JLabel FnameLbl = new JLabel("First Name");
		FnameLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		FnameLbl.setForeground(new Color(0, 0, 0));
		FnameLbl.setBounds(181, 175, 181, 86);
		frame.getContentPane().add(FnameLbl);
		
		nameTF = new JTextField();
		nameTF.setBounds(383, 200, 204, 36);
		frame.getContentPane().add(nameTF);
		nameTF.setColumns(10);
		
		JLabel LnameLbl = new JLabel("Last Name");
		LnameLbl.setForeground(Color.BLACK);
		LnameLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		LnameLbl.setBounds(685, 175, 181, 86);
		frame.getContentPane().add(LnameLbl);
		
		
		LastNameTF = new JTextField();
		LastNameTF.setColumns(10);
		LastNameTF.setBounds(875, 200, 204, 36);
		frame.getContentPane().add(LastNameTF);
		
		JLabel lblAge = new JLabel("Gender");
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAge.setBounds(181, 294, 181, 86);
		frame.getContentPane().add(lblAge);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAddress.setBounds(685, 294, 181, 86);
		frame.getContentPane().add(lblAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(875, 319, 204, 102);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);

		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(181, 440, 181, 86);
		frame.getContentPane().add(lblUsername);
		
		userTF = new JTextField();
		userTF.setColumns(10);
		userTF.setBounds(383, 466, 204, 36);
		frame.getContentPane().add(userTF);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(685, 440, 181, 86);
		frame.getContentPane().add(lblPassword);
		
		
		JRadioButton maleRadioBtn = new JRadioButton("Male");
		buttonGroup.add(maleRadioBtn);
		maleRadioBtn.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
		maleRadioBtn.setBounds(383, 317, 100, 36);
		maleRadioBtn.setEnabled(true);
		maleRadioBtn.setSelected(true);
		frame.getContentPane().add(maleRadioBtn);
		
		JRadioButton femalebtn = new JRadioButton("Female");
		buttonGroup.add(femalebtn);
		femalebtn.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
		femalebtn.setBounds(498, 319, 100, 34);
		frame.getContentPane().add(femalebtn);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = nameTF.getText();
				String lastName = LastNameTF.getText();
				String genderString;
				if(maleRadioBtn.isSelected())
				{
					genderString = maleRadioBtn.getText();
				}
				else {
					genderString = femalebtn.getText();
				}
				String addressString = textArea.getText();
				String usernameString = userTF.getText();
				String passString = String.valueOf(passTF.getPassword());
				
				if(firstName.isEmpty() || lastName.isEmpty() || addressString.isEmpty() || usernameString.isEmpty() || passString.isEmpty())
				{
					JOptionPane.showMessageDialog(frame,"Enter all details","Erorr",JOptionPane.ERROR_MESSAGE);
				}
				else {
					//connection from db for registration....
					Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();
					try {
						PreparedStatement statement = (PreparedStatement)
								adminLoginConnection.prepareStatement("insert into registration(firstname,lastname,gender,address,username,password) values(?,?,?,?,?,?)");
						statement.setString(1,firstName);
						statement.setString(2,lastName);
						statement.setString(3,genderString);
						statement.setString(4,addressString);
						statement.setString(5,usernameString);
						statement.setString(6,passString);
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
		btnSubmit.setBounds(447, 583, 141, 43);
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
		canclebtn.setBounds(706, 583, 141, 43);
		frame.getContentPane().add(canclebtn);
		
		passTF = new JPasswordField();
		passTF.setBounds(875, 466, 204, 36);
		frame.getContentPane().add(passTF);
		
		JLabel backgrounLbl = new JLabel("");
		backgrounLbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
		backgrounLbl.setBackground(SystemColor.text);
		backgrounLbl.setIcon(new ImageIcon("E:\\Hospital ka saaman\\Hospital Management System\\src\\back1.jpg"));
		backgrounLbl.setBounds(0, 0,1253, 712);
		frame.getContentPane().add(backgrounLbl);
		frame.setLocationRelativeTo(null);
		
		frame.setResizable(false);
	}
}
