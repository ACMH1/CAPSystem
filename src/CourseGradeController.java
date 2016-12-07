
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CourseGradeManager;
import model.CompletedDTO;
import model.StudentDTO;

/**
 * Servlet implementation class CourseGradeController
 */
@WebServlet("/CourseGradeController")
public class CourseGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseGradeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		CourseGradeManager cmgr = new CourseGradeManager();
		StudentDTO student = new StudentDTO();
		student.setStudentID(10001);
		ArrayList<CompletedDTO> elist = cmgr.allStudentsCourses(student);
		double gpa=cmgr.CalculateGPA(student);
		String strDouble = String.format("%.2f", gpa);
		request.setAttribute("gpa",strDouble);
		System.out.println("list"+elist.get(0).getCourse().getCourseID());
		request.setAttribute("courseGradeList", elist);
		RequestDispatcher rd = request.getRequestDispatcher("Grades_GPA.jsp");
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
