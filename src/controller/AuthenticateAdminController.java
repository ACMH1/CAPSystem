package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDTO;
import service.AdminManager;


/**
 * Servlet implementation class AuthenticateAdmin
 */
@WebServlet("/AuthenticateAdmin")
public class AuthenticateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		String path;
		try{
		Integer u = Integer.parseInt(request.getParameter("adminID"));
		String p = request.getParameter("password");
		AdminDTO s = new AdminDTO();
		s.setAdminID(u);;
		s.setPassword(p);
		AdminManager service;
		boolean result = false;

		 	 service = new AdminManager();
	    	 result = service.authenticate(u,p,request);
	    	 
	    	 HttpSession session = request.getSession();
	    	 
			
		if (result)
		{
			path = "/adminstudent";		
			request.getSession().setAttribute("status", " ");
			session.setAttribute("role", "admin");
	    	session.setAttribute("adminID", u);
		}
		else
		{
			path = "/admin_login.jsp";
			request.getSession().setAttribute("status", "Wrong Password");
		}
		
		}catch (NumberFormatException e)
		{
			path = "/admin_login.jsp";
			request.getSession().setAttribute("status", "Invalid Login ID/ Password");

		}catch (Exception e) {
			path = "/admin_login.jsp";
			request.getSession().setAttribute("status", "Unknown Error: Contact Admin");
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	
		
	
		
	}

}
