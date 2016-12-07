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
import model.StudentDTO;
import services.coursemanager;

/**
 * Servlet implementation class courseEnrolment
 */
@WebServlet("/courseEnrollment")
public class courseEnrolment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseEnrolment() {
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
		System.out.println("here");
		CourseDTO course=new CourseDTO();
		course.setCourseID(Integer.parseInt(request.getParameter("cid")));
			try {
			
				ArrayList<EnrolmentDTO> mlis = cmgr.findCourseEnrolment(course);
				StudentDTO stuDto=null;
				ArrayList<StudentDTO> enrolList=new ArrayList<StudentDTO>();
			for(int i=0;i<mlis.size();i++)
			{
				stuDto=new StudentDTO();
				stuDto= cmgr.findStudentsEnroll(mlis.get(i).getStudent().getStudentID());
				enrolList.add(stuDto);	
			}	
				request.setAttribute("elist", enrolList);	
			RequestDispatcher rd = request.getRequestDispatcher("/button2.jsp");
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
		//doGet(request, response);
	}

}
