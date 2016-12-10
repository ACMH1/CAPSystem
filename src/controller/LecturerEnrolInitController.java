package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.MyDataException;
import model.CourseDTO;
import service.CourseManager;

/**
 * Servlet implementation class CourseEnrolInit
 */
@WebServlet("/CourseEnrolInit")
public class LecturerEnrolInitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerEnrolInitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
HttpSession session=request.getSession();
		if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("lecturer"))
		{
		try {
			CourseManager cmgr = new CourseManager();
			ArrayList<CourseDTO> mlist = cmgr.searchAllCourses();
			request.setAttribute("mlist", mlist);
			RequestDispatcher rd = request.getRequestDispatcher("/LecturerViewEnrolInit.jsp");
			rd.forward(request, response);
		} catch (MyDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
		else{
			RequestDispatcher dd = request.getRequestDispatcher("/lecturer_login.jsp");
			dd.forward(request, response);
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
