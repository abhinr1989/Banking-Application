import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.*;

public class LoginPage
{
	private JFrame Loginframe;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private String uName, password;
	private boolean userLogin;
	UserManagement user = new UserManagement();
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
					LoginPage window = new LoginPage();
					window.Loginframe.setVisible(true);
					window.Loginframe.setLocation(300, 150);
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
	public LoginPage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Loginframe = new JFrame();
		Loginframe.setResizable(false);
		Loginframe.getContentPane().setBackground(SystemColor.textHighlight);
		Loginframe.setLocationRelativeTo(null); 
		Loginframe.setBounds(100, 100, 861, 425);
		Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Loginframe.getContentPane().setLayout(null);
		
		JLabel lblLoginImage = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/LoginScreen.jpg")).getImage();
		lblLoginImage.setIcon(new ImageIcon(img));
		lblLoginImage.setBounds(10, 11, 500, 372);
		Loginframe.getContentPane().add(lblLoginImage);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBackground(SystemColor.desktop);
		LoginPanel.setBorder(new TitledBorder(null, "Login Credentials", TitledBorder.LEADING, TitledBorder.TOP, (new Font("Tahoma", Font.PLAIN, 20)), (new Color(0,191,255))));
		LoginPanel.setBounds(520, 11, 325, 374);
		Loginframe.getContentPane().add(LoginPanel);
		LoginPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(0, 191, 255));
		lblUsername.setBackground(SystemColor.text);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(10, 30, 100, 30);
		LoginPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 191, 255));
		lblPassword.setBackground(SystemColor.text);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 90, 89, 25);
		LoginPanel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(120, 30, 195, 30);
		LoginPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 90, 195, 30);
		LoginPanel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{
				uName = txtUsername.getText();
				password = new String(passwordField.getPassword());
				
				Object obj = ae.getSource();
				if(obj == btnLogin)
				{
					JOptionPane.showMessageDialog(null, uName, "Username", JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(null, password, "Password", JOptionPane.ERROR_MESSAGE);
					userLogin = user.userLogin(uName, password);
					if(userLogin == true)
					{
						Loginframe.dispose();
						Customer newCustomer = new Customer();
						newCustomer.setName(uName);
						HomePage homePage = new HomePage(newCustomer);
						JFrame MainPageframe = homePage.getMainFrame();
						MainPageframe.setVisible(true);
						MainPageframe.setLocation(300, 150);
						//JOptionPane.showMessageDialog(null, "Login Successful", "Login Successful", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						
						JOptionPane.showMessageDialog(null, "Enter Valid Login Credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
						txtUsername.setText(null);
						passwordField.setText(null);
						txtUsername.requestFocus();
					}
				}
			}
		});
		btnLogin.setBounds(10, 158, 152, 23);
		LoginPanel.add(btnLogin);
		
		JButton btnClear = new JButton("Reset");
		btnClear.setBounds(172, 158, 143, 23);
		LoginPanel.add(btnClear);
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBounds(10, 214, 152, 23);
		LoginPanel.add(btnForgotPassword);
		
		JButton btnNewUser = new JButton("New User?");
		btnNewUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Object obj = e.getSource();
				if(obj == btnNewUser)
				{
					Loginframe.dispose();
					NewUserPage newUser = new NewUserPage();
					JFrame newUserframe = newUser.getMainFrame();
					newUserframe.setVisible(true);
					newUserframe.setLocation(300, 150);
				}
			}
		});
		btnNewUser.setBounds(172, 214, 143, 23);
		LoginPanel.add(btnNewUser);
	}

	public JFrame getLoginFrame() 
	{
		return Loginframe;
	}
}
