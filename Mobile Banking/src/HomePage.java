import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class HomePage {

	private JFrame HomePageframe;
	JLabel lblAccountHolderName;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					HomePage window = new HomePage();
					window.HomePageframe.setVisible(true);
					window.HomePageframe.setLocation(300, 150);
					//window.HomePageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getMainFrame()
	{
		return HomePageframe;
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	public HomePage(Customer newCustomer) 
	{
		initialize();
		lblAccountHolderName.setText(newCustomer.getName());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		HomePageframe = new JFrame();
		HomePageframe.setResizable(false);
		HomePageframe.setTitle("Mobile Banking");
		//HomePageframe.setBounds(100, 100, 1160, 504);
		//HomePageframe.setSize(720, 493);
		HomePageframe.setBounds(100, 100, 861, 425);
		HomePageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomePageframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 153);
		HomePageframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(161, 22, 73, 27);
		panel.add(lblNewLabel);
		
		lblAccountHolderName = new JLabel("Account Holder Name");
		lblAccountHolderName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAccountHolderName.setBounds(244, 22, 288, 27);
		panel.add(lblAccountHolderName);
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAccountNo.setBounds(244, 64, 156, 27);
		panel.add(lblAccountNo);
		
		JButton btnCustomer = new JButton();
		btnCustomer.setBounds(10, 11, 117, 135);
		panel.add(btnCustomer);
		Image imgCustomer = new ImageIcon(this.getClass().getResource("/User.jpg")).getImage();
		btnCustomer.setIcon(new ImageIcon(imgCustomer));
	}
}
