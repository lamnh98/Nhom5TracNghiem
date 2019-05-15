package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;


public class RegisterDAO 
{
	public static boolean InsertAccount(HttpServletRequest request,Connection conn, Member mb)
	{
		PreparedStatement ptmt=null;
		
		String sql="insert into nember(nembername,nemberpass,categorymemberid,fullname,nemberimage) value(?,?,?,?,?)";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			String fullname=mb.getFullname();
			String username=mb.getNembername();
			String password=mb.getNemberpass();
			int categorymemberid=1;
			String nemberimage=null;
			
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			ptmt.setInt(3,categorymemberid);
			ptmt.setString(4,fullname);
			ptmt.setString(5,nemberimage);
			int kq= ptmt.executeUpdate();
			
			if(kq!=0)
			{
				return true;
			}
			
			ptmt.close();
		} catch (SQLException e) 
		{
			//e.printStackTrace();
			request.setAttribute("msgregister",e.getMessage());
		}
		
		return false;
		
	}
}
