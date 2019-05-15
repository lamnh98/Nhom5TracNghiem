package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import BEAN.Examination;
import BEAN.Examinationquestion;


public class QuanlydethiDAO 
{
	//Thêm tên bài thi hướng dẫn vào CSDL
		public static boolean ThemTenDeThi(HttpServletRequest request,Connection conn, Examination ex)
		{
			PreparedStatement ptmt=null;
			
			String sql="insert into exemination(exeminationname) value(?)";
			
			try
			{
				ptmt = conn.prepareStatement(sql);
				
				String examinationname=ex.getExeminationname();
				
				ptmt.setString(1, examinationname);
				int kq= ptmt.executeUpdate();
				
				if(kq!=0)
				{
					return true;
				}
				
				ptmt.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			return false;
		}
		
		// Xuất ID của bài thi
		
		public static int Xuatmadethi(HttpServletRequest request,Connection conn,Examination ex)
		{
			int examinationid=0;
			PreparedStatement ptmt=null;
			
			String sql="select exeminationid from exemination where exeminationname='"+ex.getExeminationname()+"'";
			
			try
			{
				ptmt = conn.prepareStatement(sql);
				
				ResultSet rs=ptmt.executeQuery();
				while(rs.next())
				{
					examinationid=rs.getInt("exeminationid");
				}
				
				ptmt.close();
				rs.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
				//request.setAttribute("msgGrammarguidelineimage",e.getMessage());
			}
			return examinationid;
		}
		
		// Thêm tên hình cho de thi.
		
		public static void InsertExamImage(HttpServletRequest request,Connection conn,String image,int exeminationid)
		{
			PreparedStatement ptmt=null;
			
			String sql="update exemination set exeminationimage=? where exeminationid="+exeminationid;
			
			try
			{
				ptmt = conn.prepareStatement(sql);
				
				ptmt.setString(1, image);
				ptmt.executeUpdate();
				
				ptmt.close();
			} catch (SQLException e) 
			{
				//request.setAttribute("msgthemhinhdethi", e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		// Hàm thêm file ảnh của bài kiểm tra.
		
		public static void UploadimageExam(Connection conn,HttpServletRequest request,HttpServletResponse response,int exeminationid)
				throws ServletException, IOException 
		{
			ServletContext context=request.getServletContext();
			//final String Address="D:\\";
			response.setContentType("text/html; charset=UTF-8");
			final String Address= context.getRealPath("/ImageExam");
			final int yourMaxMemorySize= 1024*1024*3; //3MB
			final int yourMaxRequestSize= 1024*1024*50; //50MB
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(!isMultipart)
			{
				request.setAttribute("msgGrammarguidelineimage", "not have enctypr: multipart/form-data");
				request.setAttribute("exeminationid", exeminationid);
				 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
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
				    			 request.setAttribute("msgThemhinhdethi","Files exists");
				    			 request.setAttribute("exeminationid", exeminationid);
				    			 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
				    				 rd.forward(request, response);
				    			
				    		 }
				    		 else
				    		 {
				    			 item.write(uploadedFile);
				    			// GrammarguidelinemanageDAO.Insertgrammarimage(request, conn, fileName, exeminationid);
				    			 QuanlydethiDAO.InsertExamImage(request, conn, fileName, exeminationid);
				    			 RequestDispatcher rd= request.getRequestDispatcher("Quanlydethiforward");
				    			 rd.forward(request, response);
				    		 }
				    	 } 
				    	 catch (Exception e) 
				    	 {
							request.setAttribute("msgThemhinhdethi", e.getMessage());
							request.setAttribute("exeminationid", exeminationid);
							 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
								 rd.forward(request, response);
							
				    	 }
				    } else 
				    {
				    	request.setAttribute("msgThemhinhdethi", "Upload File Fail");
				    	request.setAttribute("exeminationid", exeminationid);
						 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
							 rd.forward(request, response);
				    }
				}
			} 
			catch (FileUploadException e) 
			{
				request.setAttribute("msgThemhinhdethi", e.getMessage());
				request.setAttribute("exeminationid", exeminationid);
				RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
				rd.forward(request, response);
			}
			
		}
		
		//Thêm đề thi.
		public static List<Examination> DisplayExamination(HttpServletRequest request,Connection conn)
		{
			PreparedStatement ptmt=null;
			List<Examination> list=new ArrayList<Examination>();
			String sql="Select* from exemination";
			
			try
			{
				ptmt = conn.prepareStatement(sql);
				
				ResultSet rs=ptmt.executeQuery();
				
				if(rs.isBeforeFirst())
				{
					while(rs.next())
					{
						Examination ex= new Examination();
						int exeminationid=rs.getInt("exeminationid");
						String exeminationname=rs.getString("exeminationname");
						String exeminationimage=rs.getString("exeminationimage");
						
						ex.setExeminationid(exeminationid);
						ex.setExeminationname(exeminationname);
						ex.setExeminationimage(exeminationimage);
						
						list.add(ex);
					}	
				}
				else
				{
					request.setAttribute("msglistexam", "Không có bài tập hướng dẫn");
				}
				
			} catch (SQLException e) 
			{
				request.setAttribute("msglistexam", e.getMessage());
			}
			
			return list;
		}
		
		//Mo File Excel
		public static void Themcauhoituexcel(HttpServletRequest request,Connection conn,HttpServletResponse response,String address,int examinationid) throws ServletException, IOException
		{
			FileInputStream inp;
			try 
			{
				inp = new FileInputStream(address);
				HSSFWorkbook wb=new HSSFWorkbook(new POIFSFileSystem(inp));
				Sheet sheet=wb.getSheetAt(0);
				for(int i=1;i<=sheet.getLastRowNum();i++)
				{
					Row row=sheet.getRow(i);
					
					 int num=(int) row.getCell(0).getNumericCellValue();
					 String imagequestion=row.getCell(1).getStringCellValue();
					 String audiogg=row.getCell(2).getStringCellValue();
					 String audiomp3=row.getCell(3).getStringCellValue();
					 String paragraph=row.getCell(4).getStringCellValue();
					 String question=row.getCell(5).getStringCellValue();
					 String option1=row.getCell(6).getStringCellValue();
					 String option2=row.getCell(7).getStringCellValue();
					 String option3=row.getCell(8).getStringCellValue();
					 String option4=row.getCell(9).getStringCellValue();
					 String correctanswer=row.getCell(10).getStringCellValue();
					 
					 Examinationquestion exq=new Examinationquestion();
					 
					 exq.setNum(num);
					 exq.setImagequestion(imagequestion);
					 exq.setAudiogg(audiogg);
					 exq.setAudiomp3(audiomp3);
					 exq.setParagraph(paragraph);
					 exq.setQuestion(question);
					 exq.setOption1(option1);
					 exq.setOption2(option2);
					 exq.setOption3(option3);
					 exq.setOption4(option4);
					 exq.setCorrectanswer(correctanswer);
					 exq.setExaminationid(examinationid);
					 QuanlydethiDAO.Themcauhoivaomysql(request, exq, conn);
				}
				
				wb.close();
			} 
			catch (FileNotFoundException e) 
			{
				//request.setAttribute("message", e.getMessage());
				e.printStackTrace();
			}
			catch (IOException e) 
			{
//				request.setAttribute("message", e.getMessage());
				e.printStackTrace();
			}
	//			RequestDispatcher rd=request.getRequestDispatcher("View/Result.jsp");
	//			rd.forward(request, response);
		}
		
		//Them cau hoi vao mysql
		public static void Themcauhoivaomysql(HttpServletRequest request,Examinationquestion exq,Connection conn)
		{
			String sql="insert into account(num,imagequestion,audiogg,audiomp3,paragraph,question,option1,option2,option3,option4,correctanswer,examinationid) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			try 
			{
				PreparedStatement ptmt= conn.prepareStatement(sql);
				
				ptmt.setInt(1,exq.getNum());
				ptmt.setString(2, exq.getImagequestion());
				ptmt.setString(3, exq.getAudiogg());
				ptmt.setString(4, exq.getAudiomp3());
				ptmt.setString(5, exq.getParagraph());
				ptmt.setString(6, exq.getQuestion());
				ptmt.setString(7, exq.getOption1());
				ptmt.setString(8, exq.getOption2());
				ptmt.setString(9, exq.getOption3());
				ptmt.setString(10, exq.getOption4());
				ptmt.setString(11, exq.getCorrectanswer());
				ptmt.setInt(12,exq.getExaminationid());
				
				int kt=ptmt.executeUpdate();
				if(kt!=0)
				{
					request.setAttribute("message", "Sucess");
				}
				else
				{
					request.setAttribute("message", "Failed");
				}
			} 
			catch (SQLException e)
			{
				request.setAttribute("message", e.getMessage());
			}
		}
		
		//hàm thêm file excel vào thư mục filedethi trong project
		public static void Uploadcauhoidethi(Connection conn,HttpServletRequest request,HttpServletResponse response,int exeminationid)
				throws ServletException, IOException 
		{
			ServletContext context=request.getServletContext();
			//final String Address="D:\\";
			response.setContentType("text/html; charset=UTF-8");
			final String Address= context.getRealPath("/Filedethi");
			final int yourMaxMemorySize= 1024*1024*3; //3MB
			final int yourMaxRequestSize= 1024*1024*50; //50MB
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(!isMultipart)
			{
				request.setAttribute("msgGrammarguidelineimage", "not have enctypr: multipart/form-data");
				request.setAttribute("exeminationid", exeminationid);
				 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
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
				    			 request.setAttribute("msgThemhinhdethi","Files exists");
				    			 request.setAttribute("exeminationid", exeminationid);
				    			 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
				    				 rd.forward(request, response);
				    			
				    		 }
				    		 else
				    		 {
				    			 item.write(uploadedFile);
				    			// GrammarguidelinemanageDAO.Insertgrammarimage(request, conn, fileName, exeminationid);
				    			 QuanlydethiDAO.InsertExamImage(request, conn, fileName, exeminationid);
				    			 RequestDispatcher rd= request.getRequestDispatcher("Quanlydethiforward");
				    			 rd.forward(request, response);
				    		 }
				    	 } 
				    	 catch (Exception e) 
				    	 {
							request.setAttribute("msgThemhinhdethi", e.getMessage());
							request.setAttribute("exeminationid", exeminationid);
							 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
								 rd.forward(request, response);
							
				    	 }
				    } else 
				    {
				    	request.setAttribute("msgThemhinhdethi", "Upload File Fail");
				    	request.setAttribute("exeminationid", exeminationid);
						 RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
							 rd.forward(request, response);
				    }
				}
			} 
			catch (FileUploadException e) 
			{
				request.setAttribute("msgThemhinhdethi", e.getMessage());
				request.setAttribute("exeminationid", exeminationid);
				RequestDispatcher rd= request.getRequestDispatcher("Themhinhdethiforward");
				rd.forward(request, response);
			}
			
		}
}
