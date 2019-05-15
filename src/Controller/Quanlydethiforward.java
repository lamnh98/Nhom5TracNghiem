package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Examination;
import DAO.QuanlydethiDAO;
import DB.DBConnection;

/**
 * Servlet implementation class Quanlydethiforward
 */
@WebServlet("/Quanlydethiforward")
public class Quanlydethiforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Quanlydethiforward() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try 
		{
			Connection conn = DBConnection.CreateConnection();
			List<Examination> list=QuanlydethiDAO.DisplayExamination(request, conn);
			
			request.setAttribute("msglistexam", list);
			
			
			conn.close();	
		} 
		catch (SQLException e) 
		{
			request.setAttribute("msglistexam", e.getMessage());
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("View/Admin/Quanlydethi.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
