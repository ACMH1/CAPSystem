package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.MyDataException;
import model.StudentDTO;
import service.AdminManager;
import utility.EmailUtility;
import utility.PasswordUtility;

@WebServlet("/adminstudent")
public class AdminStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String host;
	private String port;
	private String user;
	private String pass;
	private String content;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminStudentController() {
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

		AdminManager amgr = new AdminManager();
		HttpSession session = request.getSession();
		if (session.getAttribute("role") != null && session.getAttribute("adminID") != null) {
			if (action != null && action.equals("add")) {

				try {
					date = formatter.parse(request.getParameter("enrollmentDate"));
					System.out.println("date" + date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				action = null;

				String studentPassword = PasswordUtility.randomString();
				System.out.print("generatedPassword" + studentPassword);
				student.setPassword(PasswordUtility.base64encode(studentPassword));
				System.out.println("encoded password" + PasswordUtility.base64encode((PasswordUtility.randomString())));
				student.setLastName(request.getParameter("lastName"));
				student.setFirstMidName(request.getParameter("firstName"));
				student.setEmail(request.getParameter("confirmEmail"));
				student.setEnrolmentDate(date);

				try {
					int result = amgr.createStudent(student);
					if (result == 1) {
						content = "Dear  " + student.getLastName()
								+ ",\r\n Your Account is successfully created. \r\n Please login your account with default password-"
								+ studentPassword + ".\r\n \r\n \r\n Best Regards,\r\n Admin Team";
						EmailUtility.sendEmail(host, port, user, pass, request.getParameter("confirmEmail"),
								"Student Account Registration ", content);

						request.setAttribute("message", "Student information is successfully registered");
						RequestDispatcher rd = request.getRequestDispatcher("adminstudent?action=");
						rd.forward(request, response);

					}
				} catch (MyDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("message", "There were an error: " + e.getMessage());
				}
			} else if (action != null && action.equals("delete") && request.getParameter("studentId") != null) {
				try {
					student.setStudentID(Integer.parseInt(request.getParameter("studentId")));
					int result = amgr.removeStudent(student);
					if (result == 1) {
						System.out.println("Deleted Successfully");
						request.setAttribute("message", "Student information is successfully deleted");
						RequestDispatcher rd = request.getRequestDispatcher("adminstudent?action=");
						rd.forward(request, response);

					}
				} catch (NumberFormatException e) {
					request.setAttribute("error", "No student information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("adminstudent?action=");
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
					StudentDTO studentDTO = amgr.searchByStudentId(student.getStudentID());
					if (studentDTO != null) {
						request.setAttribute("studentID", studentDTO.getStudentID());
						request.setAttribute("firstName", studentDTO.getFirstMidName());
						request.setAttribute("lastName", studentDTO.getLastName());
						request.setAttribute("email", studentDTO.getEmail());
						request.setAttribute("enrollmentDate", studentDTO.getEnrolmentDate());
						// request.setAttribute("password",
						// studentDTO.getPassword());
						request.setAttribute("status", "edit");
						RequestDispatcher rd = request.getRequestDispatcher("add_edit_student.jsp");
						rd.forward(request, response);

					} else {
						request.setAttribute("error", "No student information for your request");
						RequestDispatcher rd = request.getRequestDispatcher("adminstudent?action=");
						rd.forward(request, response);
					}
				} catch (NumberFormatException e) {
					request.setAttribute("error", "No student information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
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
					int result = amgr.changeStudent(student);
					if (result == 1) {
						request.setAttribute("message", "Student information is successfully modified");
						RequestDispatcher rd = request.getRequestDispatcher("adminstudent?action=");
						rd.forward(request, response);
					}
				} catch (MyDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				try {
					ArrayList<StudentDTO> slist = amgr.searchAllStudent();
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
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
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
