package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.MyDataException;
import model.LecturerDTO;
import model.StudentDTO;
import service.ProfilePassword;

/**
 * Servlet implementation class StudentProfile
 */
@WebServlet("/StudentProfile")
public class StudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doprocess(request,response);
		ProfilePassword pwd=new ProfilePassword();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("student"))
		{
		try {
			int id=(int) session.getAttribute("studentID");
			StudentDTO plist=pwd.findstudpwd(id);
	
			request.setAttribute("plist",plist );
			RequestDispatcher rd = request.getRequestDispatcher("/StudentProfile.jsp");
			rd.forward(request, response);
		} catch (MyDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			RequestDispatcher dd = request.getRequestDispatcher("/student_login.jsp");
			dd.forward(request, response);
		}
	}

	private void doprocess(HttpServletRequest request, HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
