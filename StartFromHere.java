package softclinic;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;

public class StartFromHere extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		StartFromHere loadingPage = new StartFromHere();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loadingPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		try {
			
			for(int i = 0; i <= 100; i++)
			{
				Thread.sleep(50);
				loadingPage.LoadingValue.setText(i + "%");
				
				if(i == 10)
				{
					loadingPage.LoadingText.setText("Loading...");
				}
				if(i == 50)
				{
					loadingPage.LoadingText.setText("Connecting to Database.....");
				}
				if(i == 70)
				{
					loadingPage.LoadingText.setText("Connection Successfull");
				}
				if(i == 80)
				{
					loadingPage.LoadingText.setText("Launching Application");
				}
				loadingPage.progressBar.setValue(i);
				if(i == 100)
				{
					loadingPage.dispose();
					Front window = new Front();
					window.setVisible(true);
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	private JPanel panel = new JPanel();
	private JProgressBar progressBar = new JProgressBar();
	private JLabel LoadingText = new JLabel("Loading...");
	private JLabel LoadingValue = new JLabel("0 %");
	private JLabel BackGrounImage = new JLabel("");
	public StartFromHere() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1341, 568);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(0, 0, 1365, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		progressBar.setForeground(Color.CYAN);
		
		progressBar.setBounds(302, 507, 748, 22);
		panel.add(progressBar);
		
		LoadingValue.setForeground(Color.BLACK);
		LoadingValue.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		LoadingValue.setBackground(Color.LIGHT_GRAY);
		LoadingValue.setBounds(1019, 486, 45, 13);
		panel.add(LoadingValue);
		
		LoadingText.setBackground(Color.BLACK);
		LoadingText.setForeground(Color.BLACK);
		LoadingText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		LoadingText.setBounds(302, 479, 260, 27);
		panel.add(LoadingText);
		
		BackGrounImage.setBackground(Color.LIGHT_GRAY);
		BackGrounImage.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		BackGrounImage.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\loadingimage.jpg"));
		BackGrounImage.setBounds(0, -29, 1355, 568);
		panel.add(BackGrounImage);
	}
}
