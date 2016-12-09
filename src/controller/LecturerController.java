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
import model.LecturerDTO;

import service.LecturerManager;

@WebServlet("/lecturer")
public class LecturerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LecturerController() {
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
		LecturerDTO lecturer = new LecturerDTO();
		String action = request.getParameter("action");
		System.out.println("action" + action);
		LecturerManager smgr = new LecturerManager();

		if (action != null && action.equals("add")) {

			action = null;
//hellooo
			lecturer.setPassword("12345");
			// lecturer.setlecturerID(10101);
			lecturer.setLastName(request.getParameter("lastName"));
			lecturer.setFirstMidName(request.getParameter("firstName"));
			lecturer.setEmail(request.getParameter("confirmEmail"));
			// lecturer.setEnrolmentDate(date);

			try {
				int result = smgr.createLecturer(lecturer);

				if (result == 1) {
					request.setAttribute("message", "Lecturer information is successfully registerd.");
					RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
					rd.forward(request, response);

				}
			} catch (MyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action != null && action.equals("delete") && request.getParameter("lecturerId") != null) {

			try {
				int result = smgr.removeLecturer(lecturer);
				lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerId")));
				if (result == 1) {

					request.setAttribute("message", "Lecturer information is successfully Deleted");
					RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
					rd.forward(request, response);

				}
			} catch (NumberFormatException e) {
				request.setAttribute("error", "No lecturer information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyDataException e) {
				request.setAttribute("error", "No lecturer information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action != null && action.equals("edit") && request.getParameter("lecturerId") != null) {

			try {
				lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerId")));
				LecturerDTO lecturerDTO = smgr.searchById(lecturer.getLecturerID());

				if (lecturerDTO != null) {
					request.setAttribute("lecturerID", lecturerDTO.getLecturerID());
					request.setAttribute("firstName", lecturerDTO.getFirstMidName());
					request.setAttribute("lastName", lecturerDTO.getLastName());
					request.setAttribute("email", lecturerDTO.getEmail());
					request.setAttribute("password", lecturerDTO.getPassword());
					request.setAttribute("status", "edit");
					RequestDispatcher rd = request.getRequestDispatcher("add_edit_lecturer.jsp");
					rd.forward(request, response);

				}
				else {

					request.setAttribute("error", "No lecturer information for your request");
					RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
					rd.forward(request, response);
				}
			} catch (NumberFormatException e) {
				request.setAttribute("error", "No lecturer information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyDataException e) {
				request.setAttribute("error", "No lecturer information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (action != null && action.equals("modify")) {

			action = null;
			// lecturer.setPassword("12345");

			lecturer.setLastName(request.getParameter("lastName"));
			lecturer.setFirstMidName(request.getParameter("firstName"));
			lecturer.setEmail(request.getParameter("email"));
			lecturer.setPassword(request.getParameter("password"));

			try {
				int result = smgr.changeLecturer(lecturer);
				lecturer.setLecturerID(Integer.parseInt(request.getParameter("lecturerID")));
				if (result == 1) {
					request.setAttribute("message", "Lecturer information is successfully modified");
					RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
					rd.forward(request, response);

				}
			} catch (NumberFormatException e) {
				request.setAttribute("error", "No lecturer information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MyDataException e) {
				request.setAttribute("error", "No lecturer information for your request");
				RequestDispatcher rd = request.getRequestDispatcher("lecturer?action=");
				rd.forward(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				ArrayList<LecturerDTO> llist = smgr.searchAllLecturer();

				request.setAttribute("llist", llist);
				RequestDispatcher rd = request.getRequestDispatcher("/lecturer.jsp");
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
