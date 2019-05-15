package DB;

import java.sql.*;

public class DBConnection 
{
	public static Connection CreateConnection()
	{
		Connection conn=null;
		String url="jdbc:mysql://aa11nws2ui2zlga.cmuawpxdv6pg.us-east-2.rds.amazonaws.com:3306/webtoeic?useUnicode=true&amp;characterEncoding=utf8;";
		String Username="root";
		String Password="nhom5tracnghiem";
		
		try 
		{
			//Load driver
			Class.forName("com.mysql.jdbc.Driver");
			//Create connection
			conn = DriverManager.getConnection(url, Username, Password);
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
