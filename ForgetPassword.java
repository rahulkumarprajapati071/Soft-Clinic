package softclinic;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassword {

	public JFrame frame;
	private JTextField userTF;
	private JPasswordField passwordField;
	private JTextField andTF;
	private JTextField sqTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPassword window = new ForgetPassword();
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
	public ForgetPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(202, 255, 255));
		frame.setBounds(100, 100, 1056, 576);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setForeground(Color.BLUE);
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewPassword.setBounds(215, 337, 253, 37);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel userLbl = new JLabel("Username");
		userLbl.setForeground(Color.BLUE);
		userLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		userLbl.setBounds(215, 139, 154, 37);
		frame.getContentPane().add(userLbl);
		
		userTF = new JTextField();
		userTF.setColumns(10);
		userTF.setBounds(529, 140, 320, 36);
		frame.getContentPane().add(userTF);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(529, 338, 320, 36);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Security Question");
		lblUsername.setForeground(Color.BLUE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(215, 204, 270, 37);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblAddress = new JLabel("Answer");
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAddress.setBounds(215, 276, 114, 37);
		frame.getContentPane().add(lblAddress);
		
		andTF = new JTextField();
		andTF.setColumns(10);
		andTF.setBounds(529, 277, 320, 36);
		frame.getContentPane().add(andTF);
		
		JLabel lblCreateNewPassword = new JLabel("Create New Password");
		lblCreateNewPassword.setForeground(new Color(255, 0, 0));
		lblCreateNewPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCreateNewPassword.setBounds(362, 42, 360, 37);
		frame.getContentPane().add(lblCreateNewPassword);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();

				try {
					PreparedStatement statement = adminLoginConnection.prepareStatement("select * from registration where username = ? and answer = ?");
					statement.setString(1, userTF.getText());
					statement.setString(2, andTF.getText());
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						statement = adminLoginConnection.prepareStatement("update registration set password = ? where username = ? and answer = ?");
						statement.setString(1,passwordField.getText());
						statement.setString(2,userTF.getText());
						statement.setString(3,andTF.getText());
						statement.executeUpdate();
						JOptionPane.showMessageDialog(frame, "Password Reset Successfully");
						frame.dispose();
						AdminLogin frame = new AdminLogin();
						frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Somthing wend wrong","error",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.setBounds(409, 430, 114, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnCancel.setBounds(557, 430, 99, 31);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Check");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection adminLoginConnection = AdminLoginDBConnection.connectAdminLoginDB();

				try {
					PreparedStatement statement = adminLoginConnection.prepareStatement("select question from registration where username = ?");
					statement.setString(1, userTF.getText());
					ResultSet resultSet = statement.executeQuery();
					if(resultSet.next())
					{
						sqTF.setText(resultSet.getString(1));
					}
					else {
						JOptionPane.showMessageDialog(frame,"username not found","error",JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
		lblNewLabel.setBounds(859, 148, 82, 25);
		frame.getContentPane().add(lblNewLabel);
		
		sqTF = new JTextField();
		sqTF.setColumns(10);
		sqTF.setBounds(529, 205, 320, 36);
		frame.getContentPane().add(sqTF);
	}
}
