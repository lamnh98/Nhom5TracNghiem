package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
 * Servlet implementation class Themtendethi
 */
@WebServlet("/Themtendethi")
public class Themtendethi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Themtendethi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		if(request.getCharacterEncoding()==null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		String examinationname=request.getParameter("examinationname");
		
		Examination ex=new Examination();
		
		ex.setExeminationname(examinationname);
		
		Connection conn=DBConnection.CreateConnection();
		try 
		{
			boolean kt=QuanlydethiDAO.ThemTenDeThi(request, conn, ex);
			
			if(kt)
			{
				int examinationid=QuanlydethiDAO.Xuatmadethi(request, conn, ex);
				request.setAttribute("exeminationid", examinationid);
				RequestDispatcher rd= request.getRequestDispatcher("View/Admin/Themhinhdethi.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msgquanlydethi","Thêm không thành công!!!");
				RequestDispatcher rd= request.getRequestDispatcher("Quanlydethiforward");
				rd.forward(request, response);
			}
			conn.close();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			request.setAttribute("msgquanlydethi", e.getMessage());
		}
	}

}
