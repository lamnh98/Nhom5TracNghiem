package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Slidebanner;


public class HomeDAO
{
	public static List<Slidebanner> DisplaySlidebanner(Connection conn)
	{
		PreparedStatement ptmt=null;
		List<Slidebanner> list=new ArrayList<Slidebanner>();
		String sql="Select* from slidebanner";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			
			
			
			while(rs.next())
			{
				Slidebanner slide= new Slidebanner();
				String slidename=rs.getString("slidename");
				String slidecontent=rs.getString("slidecontent");
				String slideimage=rs.getString("slideimage");
				slide.setSlidename(slidename);
				slide.setSlidecontent(slidecontent);
				slide.setSlideimage(slideimage);
				list.add(slide);
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
}
