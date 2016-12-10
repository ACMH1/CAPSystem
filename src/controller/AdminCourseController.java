package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.JasperException;

import dao.NoDataException;
import exception.ApplicationException;
import model.CourseDTO;
import model.LecturerDTO;
import service.AdminManager;

/**
 * Servlet implementation class admin_managecourses
 */
@WebServlet("/admin_managecourses")
public class AdminCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				processRequest(request,response);

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				processRequest(request,response);

	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session=request.getSession();

		if(session.getAttribute("role")!=null&&session.getAttribute("role").equals("admin"))
		{
		request.setAttribute("usefor", "Course");
		String action=request.getParameter("action");
		CourseDTO course= new CourseDTO();
		String courseID = request.getParameter("courseID");
		AdminManager adminManager = new AdminManager();
		String path="";
		String error=request.getParameter("error");
		if(action!=null&&action.equals("add"))
		{
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date start=null;
			Date end=null;
			try {

				start = format.parse(request.getParameter("StartDate"));
				end=format.parse(request.getParameter("EndDate"));
			} catch (ParseException e1)
			{
				path="/processCourse.jsp?startError=start/end date format is incorrect";
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
			}catch (NumberFormatException e) {
				  path="/error.jsp";
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

			boolean dateResult=adminManager.dateValidation(start, end);
			System.out.println(dateResult);
			if(dateResult)
			{


						if(adminManager.lecturerValidation(Integer.parseInt(request.getParameter("LecturerId"))))
						{

								try {
									course.setLecturer(adminManager.findThatLecturer(Integer.parseInt(request.getParameter("LecturerId"))));
								} catch (NoDataException e) {
									path="/processCourse.jsp?lecturerError=incorrect.";
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

								course.setCourseID(1);
								course.setCourseName(request.getParameter("CourseName"));
								course.setSize(Integer.parseInt(request.getParameter("Size")));
								course.setCredits(Integer.parseInt(request.getParameter("Credits")));
							    course.setStartDate(start);
								course.setEndDate(end);
								int addrow=adminManager .addCourses(course);
								request.setAttribute("message", "success");
								path="/admin_managecourses?action=";
						}
						else
						{
							path="/processCourse.jsp?lecturerError=incorrect.";
						}

					}
			else
			{
				path="/processCourse.jsp?startError=start date should be before end date.";

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
	}
		else if(action!=null&&action.equals("delete"))
		{
			CourseDTO coursefind=adminManager .findCourse(Integer.parseInt(courseID));
			int ins=adminManager.removeCourses(coursefind);
			request.setAttribute("message", "success");
			RequestDispatcher rd = request.getRequestDispatcher("/admin_managecourses?action=");
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
		else if (action !=null&&action.equals("edit"))
		{
			course=adminManager.findCourse(Integer.parseInt(courseID));
			if(course!=null)
			{


				request.setAttribute("CourseId", course.getCourseID());
				request.setAttribute("CourseName", course.getCourseName());
				request.setAttribute("Size", course.getSize());
				request.setAttribute("Credits", course.getCredits());
				request.setAttribute("LecturerId", course.getLecturer().getLecturerID());
				request.setAttribute("StartDate", course.getStartDate());
				request.setAttribute("EndDate", course.getEndDate());
				request.setAttribute("status", "edit");

				RequestDispatcher rd = request.getRequestDispatcher("processCourse.jsp");
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
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
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
		else if ( action !=null&&action.equals("modify"))
		{
			String ID=request.getParameter("CourseId").trim();
			course= adminManager.findCourse(Integer.parseInt(ID));
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date start=null;
			Date end=null;
			try {
				start = format.parse(request.getParameter("StartDate"));
				end=format.parse(request.getParameter("EndDate"));
			} catch (ParseException e1) {

				path="admin_managecourses?action=edit&startError=start/end date format is incorrect&courseID="+ID;
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

			}

			LecturerDTO lec=null;
			try {
				lec=adminManager.findThatLecturer(Integer.parseInt(request.getParameter("LecturerId")));

			} catch (NoDataException e) {
				path="/processCourse.jsp?action=edit&lecturerError=incorrect&LecturerId=0&courseID="+ID;
				RequestDispatcher rd = request.getRequestDispatcher(path);
				try {
					rd.forward(request, response);
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


			 boolean dateResult=adminManager.dateValidation(start, end);
				if(dateResult&&lec!=null)
				{
					course.setLecturer(lec);
					course.setCourseName(request.getParameter("CourseName"));
					course.setCredits(Integer.parseInt(request.getParameter("Credits")));
					course.setSize(Integer.parseInt(request.getParameter("Size")));
					course.setStartDate(start);
					course.setEndDate(end);
					int editend=adminManager.updateCourses(course);
					request.setAttribute("message", "success");
					path="/admin_managecourses?action=";

				}

				else
				{
					if(dateResult&&lec==null)
					{
						course.setCourseName(request.getParameter("CourseName"));
						course.setCredits(Integer.parseInt(request.getParameter("Credits")));
						course.setSize(Integer.parseInt(request.getParameter("Size")));
						course.setStartDate(start);
						course.setEndDate(end);
						int editlecturer=adminManager.updateCourses(course);
						path="/processCourse.jsp?action=edit&lecturerError=incorrect&LecturerId=0&courseID="+ID;
					}
					if(!dateResult&&lec!=null)
					{
						course.setLecturer(lec);
						course.setCourseName(request.getParameter("CourseName"));
						course.setCredits(Integer.parseInt(request.getParameter("Credits")));
						course.setSize(Integer.parseInt(request.getParameter("Size")));
						course.setStartDate(start);
						course.setEndDate(end);
						int editlecturer=adminManager .updateCourses(course);
						path="admin_managecourses?action=edit&startError=start date should be before end date.&courseID="+ID;
					}
					if(!dateResult&&lec==null)
					{
						LecturerDTO lecturererror=new LecturerDTO();
						course.setCourseName(request.getParameter("CourseName"));
						course.setCredits(Integer.parseInt(request.getParameter("Credits")));
						course.setSize(Integer.parseInt(request.getParameter("Size")));
						course.setStartDate(start);
						course.setEndDate(end);
						course.setLecturer(lecturererror);
						int editlecturer=adminManager .updateCourses(course);

						path="admin_managecourses?action=edit&startError=start date should be before end date.&courseID="+ID;
					}

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
		}

		else
		{
			ArrayList<CourseDTO> data = adminManager .listAllCourses();
			request.setAttribute("course", data);
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
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/admin_login.jsp");
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
}
