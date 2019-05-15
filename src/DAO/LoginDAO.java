package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import BEAN.Member;

public class LoginDAO
{
	public static String Authenticationmember(HttpServletRequest request,Connection conn, Member mb)
	{
		PreparedStatement ptmt=null;
		
		String flag="fail";
		
		String sql="select nembername,nemberpass from nember";
//		String sql="select *  from nember";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				String nembername=rs.getString("nembername");
				String nemberpass=rs.getString("nemberpass");
				
				if(mb.getNembername().equals(nembername) && mb.getNemberpass().equals(nemberpass))
				{
					flag="success";
				}
			}
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			//e.printStackTrace();
			request.setAttribute("msgLogin",e.getMessage());
		}
		
		return flag;
		
	}
	
	public static int Authorizationmember(HttpServletRequest request,Connection conn, Member mb)
	{
		PreparedStatement ptmt=null;
		
		String sql="select categorymemberid	 from nember where nembername='"+mb.getNembername()+"'AND nemberpass="+mb.getNemberpass();
		int categorymemberid=0;
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				categorymemberid=rs.getInt("categorymemberid");
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			//e.printStackTrace();
			request.setAttribute("msgLogin",e.getMessage());
		}
		
		return categorymemberid;
	}
	
	public static String Exportnamemember(HttpServletRequest request, Connection conn, Member mb)
	{
		PreparedStatement ptmt=null;
		
		String sql="select fullname	 from nember where nembername='"+mb.getNembername()+"'AND nemberpass="+mb.getNemberpass();
		String fullname="";
		try
		{
			ptmt = conn.prepareStatement(sql); 
			
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				fullname=rs.getString("fullname");
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			//e.printStackTrace();
			request.setAttribute("msgLogin",e.getMessage());
		}
		
		return fullname;
	}
}
