import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewUserPage
{

	private JFrame frmUserRegistration;
	private JTextField txtName;
	private JTextField txtAccountNo;
	private JLabel lblAccountNumber;
	private JLabel lblMobileNumber;
	private JTextField txtMobileNo;
	private JLabel lblNewLabel;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel lblAccountNoError;

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
					NewUserPage window = new NewUserPage();
					window.frmUserRegistration.setVisible(true);
					window.frmUserRegistration.setLocation(300, 150);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getMainFrame()
	{
		return frmUserRegistration;
	}

	/**
	 * Create the application.
	 */
	public NewUserPage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmUserRegistration = new JFrame();
		frmUserRegistration.setTitle("User Registration");
		frmUserRegistration.setBounds(100, 100, 697, 364);
		frmUserRegistration.setResizable(false);
		frmUserRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserRegistration.getContentPane().setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(417, 20, 251, 140);
		panelLogin.setBorder(new TitledBorder(null, "Login Credentials", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Tahoma", Font.PLAIN, 20)), (new Color(0,191,255))));
		frmUserRegistration.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 46, 70, 14);
		panelLogin.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(90, 43, 151, 20);
		txtUsername.setColumns(10);
		panelLogin.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 85, 70, 14);
		panelLogin.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(90, 82, 151, 20);
		txtPassword.setColumns(10);
		panelLogin.add(txtPassword);
		
		JPanel panelAccount = new JPanel();
		panelAccount.setBounds(10, 20, 397, 294);
		panelAccount.setBorder(new TitledBorder(null, "Account Information", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Tahoma", Font.PLAIN, 20)), (new Color(0,191,255))));
		frmUserRegistration.getContentPane().add(panelAccount);
		panelAccount.setLayout(null);
		
		lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setBounds(10, 89, 100, 14);
		panelAccount.add(lblAccountNumber);
		
		txtAccountNo = new JTextField();
		txtAccountNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
			    if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
			    {
			    	txtAccountNo.setEditable(true);
			    	lblAccountNoError.setText("");
			    }
			    else 
			    {
			    	txtAccountNo.setEditable(false);
			    	lblAccountNoError.setText("* Enter only numbers(0-9)");
			    }	
			}
		});
		txtAccountNo.setBounds(153, 86, 143, 20);
		panelAccount.add(txtAccountNo);
		txtAccountNo.setColumns(10);
		
		JLabel lblName = new JLabel("Account Holder Name");
		lblName.setBounds(10, 35, 132, 14);
		panelAccount.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(153, 32, 184, 20);
		panelAccount.add(txtName);
		txtName.setColumns(10);
		
		lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setBounds(10, 146, 100, 14);
		panelAccount.add(lblMobileNumber);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(153, 143, 143, 20);
		panelAccount.add(txtMobileNo);
		txtMobileNo.setColumns(10);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(10, 200, 46, 14);
		panelAccount.add(lblPhoto);
		
		lblAccountNoError = new JLabel("");
		lblAccountNoError.setBounds(153, 117, 234, 14);
		panelAccount.add(lblAccountNoError);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btnReset)
				{
					txtName.setText(null);
					txtAccountNo.setText(null);
					txtMobileNo.setText(null);
					txtUsername.setText(null);
					txtPassword.setText(null);
				}
			}
		});
		btnReset.setBounds(417, 268, 89, 23);
		frmUserRegistration.getContentPane().add(btnReset);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(510, 268, 89, 23);
		frmUserRegistration.getContentPane().add(btnRegister);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btnClose)
				{
					frmUserRegistration.dispose();
					LoginPage loginPage = new LoginPage();
					JFrame LoginPageframe = loginPage.getLoginFrame();
					LoginPageframe.setVisible(true);
					LoginPageframe.setLocation(300, 150);
				}
			}
		});
		btnClose.setBounds(602, 268, 66, 23);
		frmUserRegistration.getContentPane().add(btnClose);
	}
}
