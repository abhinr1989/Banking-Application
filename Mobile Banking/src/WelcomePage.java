import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class WelcomePage
{
	private JFrame frmMobileBanking;
	int flag = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					WelcomePage window = new WelcomePage();
					window.frmMobileBanking.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomePage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmMobileBanking = new JFrame();
		frmMobileBanking.setTitle("Mobile Banking");
		frmMobileBanking.setBounds(100, 100, 1187, 698);
		frmMobileBanking.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMobileBanking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMobileBanking.getContentPane().setLayout(null);
		
		JLabel lblWelcomeImage = new JLabel("");
		lblWelcomeImage.setBounds(20, 11, 1166, 682);
		Image img = new ImageIcon(this.getClass().getResource("/MainScreen.jpg")).getImage();
		lblWelcomeImage.setIcon(new ImageIcon(img));
		frmMobileBanking.getContentPane().add(lblWelcomeImage);
		
		JButton btnClickHereTo = new JButton("Click Here To Proceed Next");
		btnClickHereTo.setBounds(1140, 600, 222, 30);
		//btnClickHereTo.setBackground(Color.getHSBColor(202, 92, 75));
		btnClickHereTo.setBackground(Color.BLUE);
		btnClickHereTo.setForeground(Color.white);
		frmMobileBanking.getContentPane().add(btnClickHereTo);
		
		btnClickHereTo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{
				if(flag == 1)
				{
					Image img = new ImageIcon(this.getClass().getResource("/phone.jpg")).getImage();
					lblWelcomeImage.setIcon(new ImageIcon(img));
					flag = 2;
				}
				
				else if(flag == 2)
				{
					frmMobileBanking.dispose();
					LoginPage loginPage = new LoginPage();
					JFrame LoginPageframe = loginPage.getLoginFrame();
					LoginPageframe.setVisible(true);
					LoginPageframe.setLocation(300, 150);
				}
			}
		});
	}
}
