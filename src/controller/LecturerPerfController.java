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
import model.CompletedDTO;
import model.StudentDTO;
import service.CourseManager;

/**
 * Servlet implementation class StudentPerformance
 */
@WebServlet("/StudentPerformance")
public class LecturerPerfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturerPerfController() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
		if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("lecturer"))
		{
		CourseManager cmgr=new CourseManager();
		StudentDTO student=new StudentDTO();
		int studentid=Integer.parseInt(request.getParameter("studentId"));
		student.setStudentID(studentid);
		try {
			ArrayList<CompletedDTO> elist=cmgr.findStudentEnrolment(student);
			request.setAttribute("elist", elist);
			RequestDispatcher rd = request.getRequestDispatcher("/LecturerViewStudent"
					+ ".jsp");
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
