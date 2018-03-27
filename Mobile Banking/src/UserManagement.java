import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserManagement
{
	public boolean userLogin(String uName, String password)
	{
		Statement st;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Banking Application;user=sa;password=sqlserver;");
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from Login where UserName='"+uName+"' and Password='"+password+"'");
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception ex)
		{
			System.out.println("Inside Catch");
			System.out.println(ex);
		}
		return false;
	}
}
