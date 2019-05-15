package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Member;
import DAO.RegisterDAO;
import DB.DBConnection;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(request.getCharacterEncoding()==null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn=DBConnection.CreateConnection();
		
		String fullname=request.getParameter("fullname");
		String username=request.getParameter("nembername");
		String password=request.getParameter("nemberpass");
		
		Member mb=new Member();
		mb.setFullname(fullname);
		mb.setNembername(username);
		mb.setNemberpass(password);
		boolean test=RegisterDAO.InsertAccount(request, conn, mb);
		
		if(test)
		{
			request.setAttribute("msgregister", "Đăng ký thành công");
			RequestDispatcher rd= request.getRequestDispatcher("RegisterForward");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msgregister", "Đăng ký không thành công");
			RequestDispatcher rd= request.getRequestDispatcher("RegisterForward");
			rd.forward(request, response);
		}
	}

}
