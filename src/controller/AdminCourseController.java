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

import dao.NoDataException;
import model.CourseDTO;
import service.AdminCourseManager;
import service.AdminLecturerManager;

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
		request.setAttribute("usefor", "Course");
		String action=request.getParameter("action");
		System.out.println(action);
		CourseDTO course= new CourseDTO();
		String courseID = request.getParameter("courseID");
		System.out.println(courseID);
		AdminCourseManager courseManager = new AdminCourseManager();
		String path="";
		if(action!=null&&action.equals("add"))
		{
			System.out.println("add");
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date start=null;
			Date end=null;
			try {
				
				start = format.parse(request.getParameter("StartDate"));
				end=format.parse(request.getParameter("EndDate"));
			} catch (ParseException e1) {
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
			}		 
			boolean dateResult=courseManager.dateValidation(start, end);
			System.out.println(dateResult);
			if(dateResult)
			{	
				
						 AdminLecturerManager lecturerManager=new AdminLecturerManager();
						if(lecturerManager.lecturerValidation(Integer.parseInt(request.getParameter("LecturerId"))))
						{
							
								try {
									course.setLecturer(lecturerManager.findThatLecturer(Integer.parseInt(request.getParameter("LecturerId"))));
								} catch (NumberFormatException | NoDataException e) {
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
								System.out.println(course);
								course.setCourseName(request.getParameter("CourseName"));
								course.setSize(Integer.parseInt(request.getParameter("Size")));
								course.setCredits(Integer.parseInt(request.getParameter("Credits")));								
							    course.setStartDate(start);
								course.setEndDate(end);		
								System.out.println(course);
								int addrow=courseManager .addCourses(course);
								System.out.println(addrow);
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
				path="/processCourse.jsp?startError=start date should be before end date and after today.";
				
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
			System.out.println(course.toString());
			CourseDTO coursefind=courseManager .findCourse(Integer.parseInt(courseID));
			int ins=courseManager .removeCourses(coursefind);
			System.out.println("delete"+ins);
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
			System.out.println("edit");
			course=courseManager.findCourse(Integer.parseInt(courseID));
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
				System.out.println(course);
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
			System.out.println("modify");
			String ID=request.getParameter("CourseId").trim();
			course= courseManager .findCourse(Integer.parseInt(ID));
			System.out.println(ID);
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			Date start=null;
			Date end=null;
			try {
				start = format.parse(request.getParameter("StartDate"));
				end=format.parse(request.getParameter("EndDate"));
			} catch (ParseException e1) {
				
				path="admin_managecourses?startError=start/end date format is incorrect&courseID="+ID;		
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
			
			AdminLecturerManager lecturerManager=new AdminLecturerManager();
			 boolean dateResult=courseManager.dateValidation(start, end);
				System.out.println(dateResult);
				if(dateResult)
				{						
						
						if(lecturerManager.lecturerValidation(Integer.parseInt(request.getParameter("LecturerId"))))
							{
									try {
										course.setLecturer(lecturerManager.findThatLecturer(Integer.parseInt(request.getParameter("LecturerId"))));
									
										int editlecturer=courseManager .updateCourses(course);
									    System.out.println(editlecturer);
									} catch (NumberFormatException | NoDataException e) {
										
										path="/processCourse.jsp?lecturerError=incorrect.";
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
							    course.setCourseName(request.getParameter("CourseName"));
							    int editName=courseManager .updateCourses(course);
							    System.out.println(editName);
								course.setCredits(Integer.parseInt(request.getParameter("Credits")));	
								int editcredit=courseManager .updateCourses(course);
								System.out.println(editcredit);
								course.setSize(Integer.parseInt(request.getParameter("Size")));
								int editsize=courseManager .updateCourses(course);
								System.out.println(editsize);
								course.setStartDate(start);
								int editstart=courseManager .updateCourses(course);
								System.out.println(editstart);
								course.setEndDate(end);
								int editend=courseManager .updateCourses(course);
								System.out.println(editend);
								System.out.println(course.getCourseID());
									
								
								
								request.setAttribute("message", "success");
									path="/admin_managecourses?action=";
							}
							else
							{
								
								course.setCourseName(request.getParameter("CourseName"));
							    int editName=courseManager .updateCourses(course);
							    
								course.setCredits(Integer.parseInt(request.getParameter("Credits")));	
								int editcredit=courseManager .updateCourses(course);
								System.out.println(editcredit);
								course.setSize(Integer.parseInt(request.getParameter("Size")));
								int editsize=courseManager .updateCourses(course);
								System.out.println(editsize);
								course.setStartDate(start);
								int editstart=courseManager .updateCourses(course);
								System.out.println(editstart);
								course.setEndDate(end);
								int editend=courseManager .updateCourses(course);
								System.out.println(editend);
								System.out.println(course.getCourseID());
								path="admin_managecourses?action=edit&lecturerError=incorrect";
							}							
						}													
				
				else
				{
					try {
						course.setLecturer(lecturerManager.findThatLecturer(Integer.parseInt(request.getParameter("LecturerId"))));
					} catch (NumberFormatException | NoDataException e) {
						path="/processCourse.jsp?lecturerError=incorrect.";
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
					
					int editlecturer=courseManager .updateCourses(course);
				    System.out.println(editlecturer);
					course.setCourseName(request.getParameter("CourseName"));
				    int editName=courseManager .updateCourses(course);
				    
					course.setCredits(Integer.parseInt(request.getParameter("Credits")));	
					int editcredit=courseManager .updateCourses(course);
					System.out.println(editcredit);
					course.setSize(Integer.parseInt(request.getParameter("Size")));
					int editsize=courseManager .updateCourses(course);
					System.out.println(editsize);
					path="admin_managecourses?action=edit&startError=start date should be before end date and after today&courseID="+ID;				
				}
				System.out.println(path);
					RequestDispatcher rd = request.getRequestDispatcher(path);
					System.out.println(rd.toString());
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
			ArrayList<CourseDTO> data = courseManager .listAllCourses();
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

}
