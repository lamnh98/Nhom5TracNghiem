package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Grammarguidelinecontentforward")
public class Grammarguidelinecontentforward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Grammarguidelinecontentforward() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	 {
		String grammarguidelineid=request.getParameter("id");
		request.setAttribute("grammarguidelineid",grammarguidelineid);
		RequestDispatcher rd= request.getRequestDispatcher("View/Admin/Insertgrammarguidelinecontent.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
