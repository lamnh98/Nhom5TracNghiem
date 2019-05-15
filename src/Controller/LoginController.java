package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Member;
import DAO.LoginDAO;
import DB.DBConnection;

import java.sql.*;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		RequestDispatcher rd= request.getRequestDispatcher("/View/Login.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Connection conn= DBConnection.CreateConnection();
		String nembername=request.getParameter("nembername");
		String nemberpass=request.getParameter("nemberpass");
		Member mb=new Member();
		mb.setNembername(nembername);
		mb.setNemberpass(nemberpass);
		
		String fullname=LoginDAO.Exportnamemember(request, conn, mb);
		
		String authentication=LoginDAO.Authenticationmember(request, conn, mb);
		if(authentication.equals("success"))
		{
			int authorization=LoginDAO.Authorizationmember(request, conn, mb);
			if(authorization==1)
			{
				HttpSession session= request.getSession(true);
				session.setAttribute("sessionuser", fullname);
				RequestDispatcher rd= request.getRequestDispatcher("HomeForward");
				rd.forward(request, response);
			}
			else 	
			{
				if(authorization==2)
				{
					HttpSession session= request.getSession(true);
					session.setAttribute("sessionadmin", fullname);
					RequestDispatcher rd= request.getRequestDispatcher("AdminForward");
					rd.forward(request, response);
				}
			}
		}
		else
		{
			if(authentication.equals("fail"))
			{
				request.setAttribute("msgLogin", "Tên hoặc mật khẩu sai.");
				RequestDispatcher rd= request.getRequestDispatcher("View/Login.jsp");
				rd.forward(request, response);
			}
		}
	}


}
