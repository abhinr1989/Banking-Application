import java.sql.*;

public class DBConnection 
{
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Banking Application;user=sa;password=sqlserver";
	private Connection con;
	
	private void connectDB()
	{
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			con = DriverManager.getConnection(url);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public ResultSet getDataCount()
	{
		connectDB();
		ResultSet rs;
		try
		{
			PreparedStatement stmt = con.prepareStatement("select * from Login orderby UserName");
			rs = stmt.executeQuery();
			return rs;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
