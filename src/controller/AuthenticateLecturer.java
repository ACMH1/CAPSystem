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

import model.LecturerDTO;
import service.LecturerManager;



/**
 * Servlet implementation class AuthenticateLecturer
 */
@WebServlet("/AuthenticateLecturer")
public class AuthenticateLecturer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateLecturer() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		String path;
		try{
		Integer u = Integer.parseInt(request.getParameter("lecturerid"));
		String p = request.getParameter("password");
		LecturerDTO s = new LecturerDTO();
		s.setLecturerID(u);;
		s.setPassword(p);
		LecturerManager service;
		boolean result = false;

		 	 service = new LecturerManager();
	    	 result = service.authenticate(u,p,request);
	    	 
	    	 HttpSession session = request.getSession();
	    	 session.setAttribute("role", "lecturer");
	    	 session.setAttribute("lecturerid", u);
			
		if (result)
		{
			path = "/Success.jsp";		
			request.getSession().setAttribute("status", " ");
	
		}
		else
		{
			path = "/lecturer_login.jsp";
			request.getSession().setAttribute("status", "Wrong Password");
		}
		
		}catch (NumberFormatException e)
		{
			path = "/lecturer_login.jsp";
			request.getSession().setAttribute("status", "Invalid Login ID/ Password");

		}catch (Exception e) {
			path = "/lecturer_login.jsp";
			request.getSession().setAttribute("status", "Unknown Error: Contact Admin");
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	
		
	
		
	}

}
