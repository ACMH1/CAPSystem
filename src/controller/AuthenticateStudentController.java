package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentDTO;
import service.StudentManager;

/**
 * Servlet implementation class AuthenticateStudent
 */
@WebServlet("/AuthenticateStudent")
public class AuthenticateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateStudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String path;
		try {
			Integer u = Integer.parseInt(request.getParameter("studentID"));
			String p = request.getParameter("password");
			StudentDTO s = new StudentDTO();
			s.setStudentID(u);
			s.setPassword(p);
			StudentManager service;
			boolean result = false;

			service = new StudentManager();
			result = service.authenticate(u, p, request);

			HttpSession session = request.getSession();
			session.setAttribute("role", "student");
			session.setAttribute("studentID", u);

			if (result) {
				path = "/CourseGradeController";
				request.getSession().setAttribute("status", " ");

			} else {
				path = "/student_login.jsp";
				request.getSession().setAttribute("status", "Wrong Password");
			}
		} catch (NumberFormatException n) {
			path = "/student_login.jsp";
			request.getSession().setAttribute("status", "Invalid Login ID/ Password");
		} catch (Exception e) {
			path = "/student_login.jsp";
			request.getSession().setAttribute("status", "Unknown Error: Contact Admin");
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
