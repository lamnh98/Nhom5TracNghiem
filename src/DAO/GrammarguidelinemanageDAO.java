package DAO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BEAN.Grammarguideline;

public class GrammarguidelinemanageDAO 
{
	public static List<Grammarguideline> DisplayGrammarguidelinemanage(HttpServletRequest request,Connection conn)
	{
		PreparedStatement ptmt=null;
		List<Grammarguideline> list=new ArrayList<Grammarguideline>();
		String sql="Select* from grammarguideline";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Grammarguideline gmgl= new Grammarguideline();
					int grammarguidelineid=rs.getInt("grammarguidelineid");
					String grammarname=rs.getString("grammarname");
					String grammarimage=rs.getString("grammarimage");
					String content=rs.getString("content");
					
					gmgl.setGrammarguidelineid(grammarguidelineid);
					gmgl.setGrammarname(grammarname);
					gmgl.setGrammarimage(grammarimage);
					gmgl.setContent(content);
					
					list.add(gmgl);
				}	
			}
			else
			{
				request.setAttribute("msglistgrammarguidelinemanage", "Không có bài tập hướng dẫn");
			}
			
		} catch (SQLException e) 
		{
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
		
		return list;
	}
	
	//Thêm tên bài hướng dẫn vào CSDL
	public static boolean Insertgrammarguidelinename(HttpServletRequest request,Connection conn, Grammarguideline gmgl)
	{
		PreparedStatement ptmt=null;
		
		String sql="insert into grammarguideline(grammarname) value(?)";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			String grammarname=gmgl.getGrammarname();
			
			ptmt.setString(1, grammarname);
			int kq= ptmt.executeUpdate();
			
			if(kq!=0)
			{
				return true;
			}
			
			ptmt.close();
		} catch (SQLException e) 
		{
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
		
		return false;
	}
	
	// Hàm thêm file ảnh của các bài tập trong phần ngữ pháp.
	
	public static void Uploadimagegrammarguideline(Connection conn,HttpServletRequest request,HttpServletResponse response,int grammarguidelineid)
			throws ServletException, IOException 
	{
		ServletContext context=request.getServletContext();
		//final String Address="D:\\";
		response.setContentType("text/html; charset=UTF-8");
		final String Address= context.getRealPath("/ImageUpload");
		final int yourMaxMemorySize= 1024*1024*3; //3MB
		final int yourMaxRequestSize= 1024*1024*50; //50MB
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart)
		{
			request.setAttribute("msgGrammarguidelineimage", "not have enctypr: multipart/form-data");
			request.setAttribute("grammarguidelineid", grammarguidelineid);
			 RequestDispatcher rd= request.getRequestDispatcher("Grammarguidelineimageforward");
				 rd.forward(request, response);
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// Set factory constraints
		factory.setSizeThreshold(yourMaxMemorySize);
		factory.setRepository(new java.io.File(System.getProperty("java.io.tmpdir")));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// Set overall request size constraint
		upload.setSizeMax(yourMaxRequestSize);
		
		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {	
			    FileItem item = iter.next();

			    if (!item.isFormField()) 
			    {
			    	 String fileName = item.getName();
			    	 
			    	 //padthFile: Vị trí chúng ta muốn chuyển phải vào.
			    	 String pathFile = Address + File.separator + fileName;
			    	 File uploadedFile = new File(pathFile);
			    	 
			    	 boolean kt=uploadedFile.exists();
			    	 
			    	 try 
			    	 {
			    		 if(kt==true)
			    		 {
			    			 request.setAttribute("msgGrammarguidelineimage","Files exists");
			    			 request.setAttribute("grammarguidelineid", grammarguidelineid);
			    			 RequestDispatcher rd= request.getRequestDispatcher("Grammarguidelineimageforward");
			    				 rd.forward(request, response);
			    			
			    		 }
			    		 else
			    		 {
			    			 item.write(uploadedFile);
			    			 GrammarguidelinemanageDAO.Insertgrammarimage(request, conn, fileName, grammarguidelineid);
			    			 RequestDispatcher rd= request.getRequestDispatcher("Listgrammarguidelinemanage");
			    			 rd.forward(request, response);
			    		 }
			    	 } 
			    	 catch (Exception e) 
			    	 {
						request.setAttribute("msgGrammarguidelineimage", e.getMessage());
						request.setAttribute("grammarguidelineid", grammarguidelineid);
						 RequestDispatcher rd= request.getRequestDispatcher("Grammarguidelineimageforward");
							 rd.forward(request, response);
						
			    	 }
			    } else 
			    {
			    	request.setAttribute("msgGrammarguidelineimage", "Upload File Fail");
			    	request.setAttribute("grammarguidelineid", grammarguidelineid);
					 RequestDispatcher rd= request.getRequestDispatcher("Grammarguidelineimageforward");
						 rd.forward(request, response);
			    }
			}
		} 
		catch (FileUploadException e) 
		{
			request.setAttribute("msgGrammarguidelineimage", e.getMessage());
			request.setAttribute("grammarguidelineid", grammarguidelineid);
			RequestDispatcher rd= request.getRequestDispatcher("Grammarguidelineimageforward");
			rd.forward(request, response);
		}
		
	}
	
	// Xuất ID của bài hướng dẫn ngữ pháp
	
	public static int Retrieveidgrammarguideline(HttpServletRequest request,Connection conn,Grammarguideline gmgl)
	{
		int grammarguidelineid=0;
		PreparedStatement ptmt=null;
		
		String sql="select grammarguidelineid from grammarguideline where grammarname='"+gmgl.getGrammarname() +"'";
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				grammarguidelineid=rs.getInt("grammarguidelineid");
			}
			
			ptmt.close();
			rs.close();
		} catch (SQLException e) 
		{
			//e.printStackTrace();
			request.setAttribute("msgGrammarguidelineimage",e.getMessage());
		}
		return grammarguidelineid;
	}
	
	// Thêm tên hình cho bài hướng dẫn dựa theo id của bài hướng dẫn.
	
	public static void Insertgrammarimage(HttpServletRequest request,Connection conn,String image,int grammarguidelineid)
	{
		PreparedStatement ptmt=null;
		
		String sql="update grammarguideline set grammarimage=? where grammarguidelineid="+grammarguidelineid;
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, image);
			ptmt.executeUpdate();
			
			ptmt.close();
		} catch (SQLException e) 
		{
			request.setAttribute("msglistgrammarguidelinemanage", e.getMessage());
		}
		
	}
	
	
	// Thêm nội dung vào bài hướng dẫn
	public static boolean Insertgrammarguidelinecontent(HttpServletRequest request,Connection conn, Grammarguideline gmgl,int id)
	{
		PreparedStatement ptmt=null;
		
		String sql="update grammarguideline set content=? where grammarguidelineid="+id;
		
		try
		{
			ptmt = conn.prepareStatement(sql);
			
			String content=gmgl.getContent();
			
			ptmt.setString(1, content);
			int kq= ptmt.executeUpdate();
			
			if(kq!=0)
			{
				return true;
			}
			
			ptmt.close();
		} catch (SQLException e) 
		{
			request.setAttribute("msggrammarguidelinecontent", e.getMessage());
		}
		
		return false;
	}
	
	//Xóa bài hướng dẫn
	public static void Xoabaihdnguphap(Connection conn, int grammarguidelineid)
	{
		String sql="delete from grammarguideline where grammarguidelineid="+grammarguidelineid;
		try 
		{
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
			ptmt.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//Xóa mã bài hướng trong cmt
	public static void Xoabaihdnguphaptrongcmtgrammar(Connection conn, int grammarguidelineid)
	{
		String sql="delete from cmtgrammar where grammarguidelineid="+grammarguidelineid;
		try 
		{
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.executeUpdate();
			ptmt.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
