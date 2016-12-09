package controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.ApplicationException;
import exception.MyDataException;
import model.LecturerDTO;
import service.AdminManager;
import utility.EmailUtility;
import utility.PasswordUtility;

@WebServlet("/adminlecturer")
public class AdminLecturerController extends HttpServlet {
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
	public AdminLecturerController() {
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
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Wrapped Excep", e);
			// e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ApplicationException {

		LecturerDTO lecturer = new LecturerDTO();
		AdminManager amgr = new AdminManager();
		HttpSession session = request.getSession();
		if (session.getAttribute("role") != null && session.getAttribute("adminID") != null) {
			
			String action = request.getParameter("action");
			if (action != null && action.equals("add")) {
				action = null;
				lecturer.setPassword(PasswordUtility.randomString());
				lecturer.setLastName(request.getParameter("lastName"));
				lecturer.setFirstMidName(request.getParameter("firstName"));
				lecturer.setEmail(request.getParameter("confirmEmail"));
				// lecturer.setEnrolmentDate(date);

				try {
					int result = amgr.createLecturer(lecturer);
					if (result == 1) {
						content = "Dear  " + lecturer.getLastName()
								+ ",\r\n Your Account is successfully created. \r\n Please login your account with default password-"
								+ lecturer.getPassword() + ".\r\n \r\n \r\n Best Regards,\r\n Admin Team";
						EmailUtility.sendEmail(host, port, user, pass, request.getParameter("confirmEmail"),
								"Student Account Registration ", content);
						request.setAttribute("message", "Lecturer information is successfully registerd.");
						RequestDispatcher rd = request.getRequestDispatcher("adminlecturer?action=");
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
			} else if (action != null && action.equals("delete") && request.getParameter("lecturerId") != null) {

				try {

					lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerId")));
					int result = amgr.removeLecturer(lecturer);
					if (result == 1) {
						request.setAttribute("message", "Lecturer information is successfully Deleted");
						RequestDispatcher rd = request.getRequestDispatcher("adminlecturer?action=");
						rd.forward(request, response);

					}
				} catch (MyDataException e) {
					request.setAttribute("error", "No lecturer information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("adminlecturer?action=");
					rd.forward(request, response);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (action != null && action.equals("edit") && request.getParameter("lecturerId") != null) {

				try {
					lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerId")));
					LecturerDTO lecturerDTO = amgr.searchByLecturerId(lecturer.getLecturerID());
					if (lecturerDTO != null) {
						request.setAttribute("lecturerID", lecturerDTO.getLecturerID());
						request.setAttribute("firstName", lecturerDTO.getFirstMidName());
						request.setAttribute("lastName", lecturerDTO.getLastName());
						request.setAttribute("email", lecturerDTO.getEmail());
						request.setAttribute("password", lecturerDTO.getPassword());
						request.setAttribute("status", "edit");
						RequestDispatcher rd = request.getRequestDispatcher("add_edit_lecturer.jsp");
						rd.forward(request, response);
					} else {
						request.setAttribute("error", "No lecturer information for your request");
						RequestDispatcher rd = request.getRequestDispatcher("adminlecturer?action=");
						rd.forward(request, response);
					}
				} catch (NumberFormatException e) {
					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
					e.printStackTrace();
				} catch (MyDataException e) {
					request.setAttribute("error", "No lecturer information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("adminlecturer?action=");
					rd.forward(request, response);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (action != null && action.equals("modify")) {
				action = null;
				lecturer.setLastName(request.getParameter("lastName"));
				lecturer.setFirstMidName(request.getParameter("firstName"));
				lecturer.setEmail(request.getParameter("email"));
				lecturer.setPassword(request.getParameter("password"));

				try {
					lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerID")));
					int result = amgr.changeLecturer(lecturer);

					if (result == 1) {
						request.setAttribute("message", "Lecturer information is successfully modified");
						RequestDispatcher rd = request.getRequestDispatcher("adminlecturer?action=");
						rd.forward(request, response);

					}
				} catch (MyDataException e) {
					request.setAttribute("error", "No lecturer information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
					rd.forward(request, response);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				try {
					ArrayList<LecturerDTO> llist = amgr.searchAllLecturer();
					request.setAttribute("llist", llist);
					RequestDispatcher rd = request.getRequestDispatcher("/lecturer.jsp");
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
		try {
			doProcess(request, response);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Wrapped Excep", e);
		}

	}

}
