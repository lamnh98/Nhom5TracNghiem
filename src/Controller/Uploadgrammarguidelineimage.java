package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GrammarguidelinemanageDAO;
import DB.DBConnection;

@WebServlet("/Uploadgrammarguidelineimage")
public class Uploadgrammarguidelineimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Uploadgrammarguidelineimage() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Connection conn=DBConnection.CreateConnection();
		String grammarguidelineidstr=request.getParameter("grammarguidelineid");
		int grammarguidelineid=Integer.parseInt(grammarguidelineidstr);
		GrammarguidelinemanageDAO.Uploadimagegrammarguideline(conn,request, response,grammarguidelineid);
	}

}
