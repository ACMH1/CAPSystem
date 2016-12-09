package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MyDataException;
import model.CourseDTO;
import model.EnrolmentDTO;
import service.CourseManager;

/**
 * Servlet implementation class GradeCourse
 */
@WebServlet("/GradeCourse")
public class LecturerGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerGradeController() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		CourseManager cmgr=new CourseManager();
		CourseDTO course=new CourseDTO();
		int courseID;
	if(request.getAttribute("courseid") != null )
	{
		courseID=Integer.parseInt(request.getAttribute("courseid").toString());
		course.setCourseID(courseID);
	}
	else{
		course.setCourseID(Integer.parseInt(request.getParameter("cid")));		
		}
		try {
			ArrayList<EnrolmentDTO> elist=cmgr.findCourseEnrolment(course);
			request.setAttribute("elist", elist);
			RequestDispatcher rd = request.getRequestDispatcher("/LecturerGradeCourse.jsp");
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
