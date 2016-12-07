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
import model.LecturerDTO;
import services.coursemanager;

/**
 * Servlet implementation class FindCourseForGrade
 */
@WebServlet("/FindCourseForGrade")
public class FindCourseForGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCourseForGrade() {
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
		coursemanager cmgr = new coursemanager();
		LecturerDTO lecturer=new LecturerDTO();
		lecturer.setLecturerID(2006);
			try {
				
				ArrayList<CourseDTO> mlist = cmgr.findCourseByLecturer(lecturer);
				HttpSession session=request.getSession();
        		session.setAttribute("mlist", mlist);
				RequestDispatcher rd = request.getRequestDispatcher("/button3.jsp");
				rd.forward(request, response);
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
