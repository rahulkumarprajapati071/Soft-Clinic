package softclinic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CreditEnd extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer creditTimer = new Timer(1,this);
	String textString;
	int textY = 600;
	
	
	public CreditEnd()
	{
		
		JFrame window = new JFrame();
		window.setSize(919,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.getContentPane().add(this);
		window.setVisible(true);
		this.setBackground(Color.black);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.dispose();
				Front window = new Front();
				window.setVisible(true);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 10, 45, 19);
		add(lblNewLabel);
		
		textString = "         * * *           * * *     * * * * * * *\n"
				   + "*      *      *          *           *\n"
				   + "*        *   *            *          *\n"
				   + "*        *   *                        *\n"
				   + "*      *     *                        *\n"
				   + "* * *       *       * * *         *\n"
				   + "*      *     *       *    *         *\n"
				   + "*        *   *             *         *\n"
				   + "*        *   *             *         *\n"
				   + "*      *      *          *           *\n"
				   + "         * * *           * * *     * * * * * * *\n"
				   + "\n\n"
				   + "WELCOME \n"
				   + "I HOPE YOU ENJOYED WELL THIS PLATFORM"
				   + "\n\n"
				   + "This software is not only a peice of code its startup of my software\n"
				   + "development journy when i developing this project\n"
				   + "i am taking so much intrest to develop this and i was exited\n"
				   + "to how will this look after complete\n"
				   + "but when its complete I was not more happy because I feel that its not\n"
				   + "complete even somthing missing from here!!! every time\n"
				   + "(: may be it's common problem of a developer :)\n\n"
				   + "If some person Ask to me what you learn in period of developing"
				   + "\nthis your first project"
				   + "\n\nthan I want to says him nothig is big or small like you imagine"
				   + "\nif you start when you realize that how many complexity are present"
				   + "\nin the given problem. also I learnt that you are"
				   + "\ncreating this for your customers ,So you have to think about there"
				   + "\nCompatability you have to create userfriendly more "
				   + "\nso that you customer"
				   + "\nnot feel stuck when they use your creation."
				   + "\n\n\n===== SOME QUESTIONS AND ANSWERS ====="
				   + "\n\n-Q- What is the Name of this Software ?"
				   + "\n\n-A- Soft Clinic."
				   + "\n\n-Q- What is the purpose of this Software ?"
				   + "\n\n-A- for Submitting in Minor Project and learning lot's of new."
				   + "\n\n-Q- What is the minimum time to develop this Software ?"
				   + "\n\n-A- Undefined."
				   + "\n\n-Q- What is the maximum size of this Software ?"
				   + "\n\n-A- depends upon this files."
				   + "\n\n-Q- is it include database in this Software ? If yes than which."
				   + "\n\n-A- YES , MySQL."
				   + "\n\n-Q- How many total class in this java Software ?"
				   + "\n\n-A- 29 Only."
				   + "\n\n-Q- It can increase in future ?"
				   + "\n\n-A- YES Off-course on new Update or adding new feature."
				   + "\n\n-Q- How many Database created in for this Software ?"
				   + "\n\n-A- 1 Only."
				   + "\n\n-Q- What is the name of Database ?"
				   + "\n\n-A- Name:- admindatabases."
				   + "\n\n-Q- How many tables created in this Database ?"
				   + "\n\n-A- 9 Only."
				   + "\n\n-Q- is Images used in this Software."
				   + "\n\n-A- YES."
				   + "\n\n-Q- is this Software unique in the world"
				   + "\n\n-A- NO."
				   + "\n\n-Q- is this Software Copeid from Internet or Not ?"
				   + "\n\n-A- YES."
				   + "\n\n-Q- How many Portion Copeid from Internet ?"
				   + "\n\n-A- Only Look and feel."
				   + "\n\n-Q- is this Software Usefull for Industry or Any Place ? If NO Why."
				   + "\n\n-A- NO, Because its not created on demand of any customer"
				   + "\n\n-Q- there are any different or unique feature from other "
				   + "\nSoftwares like this ? If not than Why."
				   + "\n\n-A- YES, Because its more userfriendly."
				   + "\nNO, Because I don't know how exactly work in the Hospital,"
				   + "\nso there for i don't know what requirement or what is enough."
				   + "\n\n-Q- is this run on any Machine like win,linux,mac ?"
				   + "\n\n-A- YES. because its build in Java Language."
				   + "\n\n-Q- is this deployable on another System with database ?"
				   + "\n\n-A- still NO. but may be in future when I learned."
				   + "\n\n-Q- What Happen when this Project Delete from your System ?"
				   + "\n\n-A- I have Save its Backup already."
				   + "\n\n-Q- What happen when its database delete ?"
				   + "\n\n-A- I have no idea."
				   + "\n\n-Q- which class i main Starting Class in this Software ?"
				   + "\n\n-A- StartFromHere.java."
				   + "\n\n-Q- Maximum Line Of Class in this Software ?"
				   + "\n\n-A- AReceptionistDetails.java  by  727 line of Code."
				   + "\n\n-Q- Who is your motivater for this Software ?"
				   + "\n\n-A- HOD of my Department in my College."
				   + "\n\n-Q- is this Software you develped by yourself only ?"
				   + "\n\n-A- NO."
				   + "\n\n-Q- How many Partners you have to develop this Software ?"
				   + "\n\n-A- All my IT Branch helps to me for develop this Software "
				   + "\n directly or indirectly."
				   + "\n\n\n\n\n\n\n\n\n\n\n THANKS YOU";
		
		
		creditTimer.start();
		
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setFont(new Font("Times New Roman",Font.PLAIN,28));
		g2d.setColor(Color.white);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		int y = textY;
		
		for(String line : textString.split("\n"))
		{
			int stringLenght = (int)g2d.getFontMetrics().getStringBounds(line, g2d).getWidth();
			int x = getWidth()/2 - stringLenght/2;
			
			g2d.drawString(line, x, y += 28);
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textY--;
		if(textY < -3970)
		{
			creditTimer.stop();
		}
		repaint();
	}
	
	public static void main(String [] agrs)
	{
		new CreditEnd();
	}
	
}
