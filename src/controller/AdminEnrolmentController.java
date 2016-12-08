
package controller;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;
import service.AdminCourseManager;
import service.AdminEnrolmentManager;
import service.AdminStudentManager;

/**
 * Servlet implementation class admin_manageenrollment
 */
@WebServlet("/admin_manageenrolment")
public class AdminEnrolmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEnrolmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		AdminEnrolmentManager enrolManager=new AdminEnrolmentManager();
		AdminCourseManager courseManager=new AdminCourseManager();
		AdminStudentManager studentManager=new AdminStudentManager();
		String action=request.getParameter("action");
		System.out.println(action);
		String courseID = request.getParameter("CourseID");
		System.out.println(courseID);
		String studentID=request.getParameter("StudentID");
		if(action!=null&&action.equals("view"))
		{
			System.out.println("view");
			
			CourseDTO course=courseManager.findCourse(Integer.parseInt(courseID));
			System.out.println(course);
			ArrayList<EnrolmentDTO> data=enrolManager.findEnrolmentByCourse(course);
			if(data!=null)
			{
				
				enrolManager.findEnrolmentByCourse(course);
				request.setAttribute("enrolment", data);
				request.setAttribute("CourseID", courseID);
			}
			else
			{
				request.setAttribute("noEnrol", "No Enrolment");
			}
			
			
			
			
			System.out.println(data);
			RequestDispatcher rd = request.getRequestDispatcher("/admin_manageenrolment.jsp?action=");
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
		else if(action!=null&&action.equals("addEnrolment"))
		{
			
			String path="";
			 try {
				 int id = Integer.parseInt(request.getParameter("StudentID"));
				 StudentDTO student=studentManager.findStudent(Integer.parseInt(request.getParameter("StudentID")));
					CourseDTO course =courseManager.findCourse(Integer.parseInt(request.getParameter("CourseID")));
					
					if(student!=null)
					{
						if(course !=null)
						{
							ArrayList<EnrolmentDTO> data=enrolManager.findEnrolmentByCourse(course);
							
								if(enrolManager.checkDuplicate(student,course)&&enrolManager.checkSize(course))
								{
									
									EnrolmentDTO enrolment=new EnrolmentDTO(student,course);
									int addEnrol=enrolManager.createEnrolment(enrolment);
									System.out.println(addEnrol);
									request.setAttribute("message", "success");
									path="admin_manageenrolment?action=view";
								}
								else
								{
									path="admin_manageenrolment?action=view&studentError=duplicate enrolment.";
								}

						}
						else
						{
							path="admin_manageenrolment?action=view&studentError=this course is unavailable.";
						}
						
					}
					else
					{
						path="admin_manageenrolment?action=view&studentError=incorrect";
					}
					
					RequestDispatcher rd = request.getRequestDispatcher(path);
					try {
						rd.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				 
				  } catch (NumberFormatException e) {
					  path="admin_manageenrolment?action=view&studentError=incorrect";
					  RequestDispatcher rd = request.getRequestDispatcher(path);
						try {
							rd.forward(request, response);
						} catch (ServletException e1) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }
			
		}
		else if (action!=null&&action.equals("delete"))
		{
			System.out.println("delete");
			StudentDTO student=studentManager.findStudent(Integer.parseInt(request.getParameter("StudentID")));
			CourseDTO course =courseManager.findCourse(Integer.parseInt(request.getParameter("CourseID")));
			EnrolmentDTO enrol=new EnrolmentDTO(student,course);
			int deleteEnrol=enrolManager.deleteEnrolment(enrol);
			System.out.println(deleteEnrol);
			System.out.println(deleteEnrol);
			request.setAttribute("message", "success");
			RequestDispatcher rd = request.getRequestDispatcher("admin_manageenrolment?action=view");
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
		else
		{
			ArrayList<CourseDTO> data = courseManager.listAllCourses();
			request.setAttribute("course", data);
			request.setAttribute("usefor", "enrolment");
			RequestDispatcher rd = request.getRequestDispatcher("/admin_managecourses.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
