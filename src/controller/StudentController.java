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

import model.CompletedDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;
import service.StudentManager;

/**
 * Servlet implementation class StudentController
 */
//{"/StudentController","/courseEnroll","/insertEnrol","/CourseGradeController"}
@WebServlet({"/StudentController","/courseEnroll","/insertEnrol", "/CourseGradeController"})
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int studentId=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getRequestURI().substring(request.getContextPath().length());
		getStudentId(request,response);
		switch(path){
		case "/StudentController":
			viewCourses(request,response);
			break;
		case "/courseEnroll":
			enrolCourseList(request,response);
			break;
		case "/insertEnrol" :
			insertEnrol(request,response);
			break;	
		case "/CourseGradeController":
		     displayCourseGrade(request,response);
		    break;
		
		}
		
	}

	@SuppressWarnings("unused")
	private int getStudentId(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();       
		if(session.getAttribute("studentID") != null)
		{
			studentId =Integer.parseInt(session.getAttribute("studentID").toString());
		}
	 return studentId;
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		doGet(request, response);
	}
	private void viewCourses(HttpServletRequest request, HttpServletResponse response) {
		StudentManager cm= new StudentManager();
		ArrayList<EnrolmentDTO> data=cm.getEnrollCourseListByStudentId(studentId);
		request.setAttribute("courseList", data);
		RequestDispatcher rd = request.getRequestDispatcher("viewcourses.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void  enrolCourseList(HttpServletRequest request, HttpServletResponse response) {
		StudentManager cm= new StudentManager();		
		StudentDTO student= new StudentDTO();
		student.setStudentID(studentId);
	
		ArrayList<CourseDTO> data=cm.findAvailableCourses(student);
		request.setAttribute("courseEnrollList", data);
		RequestDispatcher rd = request.getRequestDispatcher("course_enroll.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	private void insertEnrol(HttpServletRequest request, HttpServletResponse response) {
			
		if(request.getParameter("courseID") != null)
		{
			int courseId =Integer.parseInt(request.getParameter("courseID"));        
			StudentDTO student=new StudentDTO();
			student.setStudentID(studentId);
			if(courseId != 0 )
			{
				StudentManager stu= new StudentManager();
				stu.insertEnrolment(studentId, courseId);				
				enrolCourseList(request,response);
			}
			
			
		}
        	
	}
	private void displayCourseGrade(HttpServletRequest request, HttpServletResponse response)
	{
		StudentManager studentManager= new StudentManager();	
		String strDouble=null;
		StudentDTO student = new StudentDTO();	
		student.setStudentID(studentId);
		ArrayList<CompletedDTO> elist = studentManager.allStudentsCourses(student);
		RequestDispatcher rd=null;

			double gpa=studentManager.CalculateGPA(student);
			if(Double.isNaN(gpa))
			{
				strDouble="null";
			}
			else
			{
				strDouble = String.format("%.2f", gpa);
				System.out.println(gpa);
			}
		   
			request.setAttribute("gpa",strDouble);
			//System.out.println("list"+elist.get(0).getCourse().getCourseID());
			request.setAttribute("courseGradeList", elist);
			 rd = request.getRequestDispatcher("Grades_GPA.jsp");
		
		
			
		
		
		
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
