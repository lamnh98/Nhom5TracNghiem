package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Grammarguideline;



public class BaihdnguphapDAO 
{

	public static List<Grammarguideline> DisplayEmp(int start, int count, Connection conn)
	{
		List<Grammarguideline> list=new ArrayList<Grammarguideline>();
		String sql="Select* from grammarguideline limit "+(start-1)+","+count+"";
		
		try
		{

			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			
			
			
			while(rs.next())
			{
				Grammarguideline gmgl= new Grammarguideline();
				
				int grammarguidelineid=rs.getInt("grammarguidelineid");
				String grammarname=rs.getString("grammarname");
				String grammarimage=rs.getString("grammarimage");
				
				gmgl.setGrammarguidelineid(grammarguidelineid);
				gmgl.setGrammarname(grammarname);
				gmgl.setGrammarimage(grammarimage);
				
				list.add(gmgl);
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static int Countrow(Connection conn)
	{
		int count=0;
		String sql="select count(*) from grammarguideline";
		
		try
		{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			
			rs.next();
			count=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static String Displaygrammarcontent(Connection conn,int mabaihdnguphap)
	{
		String content="";
		String sql="Select* from grammarguideline where grammarguidelineid= "+ mabaihdnguphap;
		
		try
		{

			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			
			
			
			while(rs.next())
			{
				content = rs.getString("content");
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return content;
	}
}
