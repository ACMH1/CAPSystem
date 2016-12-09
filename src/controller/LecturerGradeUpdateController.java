package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MyDataException;
import model.CompletedDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;
import service.CourseManager;

/**
 * Servlet implementation class DeleteUpdateCompleted
 */
@WebServlet("/DeleteUpdateCompleted")
public class LecturerGradeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerGradeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		int studentId=Integer.parseInt(request.getParameter("studentId"));

		int courseId=Integer.parseInt(request.getParameter("courseId"));
      
	
		int grade=Integer.parseInt(request.getParameter("grade1"));
		
		
		StudentDTO student=new StudentDTO();
		student.setStudentID(studentId);
		
		CourseDTO course=new CourseDTO();
		course.setCourseID(courseId);
		
		CompletedDTO completed=new CompletedDTO();
		completed.setStudent(student);
		completed.setCourse(course);
		completed.setGrade(grade);
		
		EnrolmentDTO enrol=new EnrolmentDTO();
		enrol.setStudent(student);
		enrol.setCourse(course);
		
		CourseManager cmgr = new CourseManager();
	
		
		try {
			cmgr.GradeCourse(completed);
            cmgr.DeleteEnrol(enrol);
        	request.setAttribute("courseid",courseId);	
			RequestDispatcher rd = request.getRequestDispatcher("/GradeCourse");
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
