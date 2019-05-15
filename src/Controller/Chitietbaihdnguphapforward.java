package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.BaihdnguphapDAO;
import DB.DBConnection;

/**
 * Servlet implementation class Chitietbaihdnguphapforward
 */
@WebServlet("/Chitietbaihdnguphapforward")
public class Chitietbaihdnguphapforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chitietbaihdnguphapforward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		Connection conn=DBConnection.CreateConnection();
		String mabaihdnguphapstr=request.getParameter("mabaihdnguphap");
		int mabaihdnguphap=Integer.parseInt(mabaihdnguphapstr);
		String content = BaihdnguphapDAO.Displaygrammarcontent(conn, mabaihdnguphap);
		
		request.setAttribute("mabaihdnguphap", mabaihdnguphap);
		request.setAttribute("gammarcontent", content);
		request.setAttribute("kitutrongdatabase1", "\n");
		request.setAttribute("kitutronghtml1", "</br>");
		
		RequestDispatcher rd= request.getRequestDispatcher("View/Chitietbaihdnguphap.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
