package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MyDataException;
import model.StudentDTO;
import service.StudentManager;

@WebServlet("/student")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;

		StudentDTO student = new StudentDTO();
		String action = request.getParameter("action");

		StudentManager smgr = new StudentManager();

		if (action != null && action.equals("add")) {

			try {
				date = formatter.parse(request.getParameter("enrollmentDate"));
				System.out.println("date" + date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			action = null;

			student.setPassword("12345");
			// student.setStudentID(10101);
			student.setLastName(request.getParameter("lastName"));
			student.setFirstMidName(request.getParameter("firstName"));
			student.setEmail(request.getParameter("confirmEmail"));
			student.setEnrolmentDate(date);

			try {
				int result = smgr.createStudent(student);

				if (result == 1) {
					request.setAttribute("message", "Student information is successfully registered");
					RequestDispatcher rd = request.getRequestDispatcher("student?action=");
					rd.forward(request, response);

				}
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action != null && action.equals("delete") && request.getParameter("studentId") != null) {

			try {

				student.setStudentID(Integer.parseInt(request.getParameter("studentId")));
				int result = smgr.removeStudent(student);

				if (result == 1) {
					System.out.println("Deleted Successfully");
					request.setAttribute("message", "Student information is successfully deleted");
					RequestDispatcher rd = request.getRequestDispatcher("student?action=");
					rd.forward(request, response);

				}

			} catch (NumberFormatException e) {
				request.setAttribute("error", "No student information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("student?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action != null && action.equals("edit") && request.getParameter("studentId") != null) {

			try {
				student.setStudentID(Integer.parseInt(request.getParameter("studentId")));
				StudentDTO studentDTO = smgr.searchById(student.getStudentID());

				if (studentDTO != null) {
					request.setAttribute("studentID", studentDTO.getStudentID());
					request.setAttribute("firstName", studentDTO.getFirstMidName());
					request.setAttribute("lastName", studentDTO.getLastName());
					request.setAttribute("email", studentDTO.getEmail());
					request.setAttribute("enrollmentDate", studentDTO.getEnrolmentDate());
					request.setAttribute("password", studentDTO.getPassword());
					request.setAttribute("status", "edit");
					RequestDispatcher rd = request.getRequestDispatcher("add_edit_student.jsp");
					rd.forward(request, response);

				} else {

					request.setAttribute("error", "No student information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("student?action=");
					rd.forward(request, response);
				}
			} catch (NumberFormatException e) {
				request.setAttribute("error", "No student information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("student?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action != null && action.equals("modify")) {

			try {
				date = formatter.parse(request.getParameter("enrollmentDate"));

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			action = null;

			// student.setPassword("12345");
			student.setStudentID(Integer.parseInt(request.getParameter("studentID")));
			student.setLastName(request.getParameter("lastName"));
			student.setFirstMidName(request.getParameter("firstName"));
			student.setEmail(request.getParameter("email"));
			student.setEnrolmentDate(date);
			student.setPassword(request.getParameter("password"));

			try {
				int result = smgr.changeStudent(student);

				if (result == 1) {
					request.setAttribute("message", "Student information is successfully modified");
					RequestDispatcher rd = request.getRequestDispatcher("student?action=");
					rd.forward(request, response);

				}
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				ArrayList<StudentDTO> slist = smgr.searchAllStudent();
				if (slist.size() != 0) {
					request.setAttribute("slist", slist);
				} else {
					request.setAttribute("message", "There is no student record");
				}
				RequestDispatcher rd = request.getRequestDispatcher("/student.jsp");
				rd.forward(request, response);
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
