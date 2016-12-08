package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.CourseDAO;
import dao.DAOFactory;
import dao.LecturerDAO;
import model.CourseDTO;
import model.LecturerDTO;

public class AdminCourseManager {

	private CourseDAO coursedao;
	
	
	public AdminCourseManager() {
		
		this.coursedao = DAOFactory.loadInstance().getCourseDAO();
		
	}
	public int addCourses(CourseDTO course) 
	{
		course.setCourseID(coursedao.getNextCourseID());
		return coursedao.createCourse(course);
	}
	
	public int updateCourses(CourseDTO course)
	{
		return  coursedao.updateCourse(course);
	}
	public CourseDTO findCourse(int id)
	{
		return coursedao.findCourse(id);
	}
	public int removeCourses(CourseDTO course)
	{

				return  coursedao.removeCourse(course);
			
    }
	public ArrayList<CourseDTO> listAllCourses()
	{
				return coursedao.listAllCourse();		
	}
	public boolean dateValidation(Date start, Date end)
	{
		System.out.println(start);
		System.out.println(end);
        Date today = Calendar.getInstance().getTime();
        System.out.println(today);
        
		if (start.before(end)&&start.after(today))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean numberValidation(int num, int start, int end)
	{
		if(num<=end&&num>=start) 
			{
			return true;
			}
		else
		{
			return false;
		}		
	}
}
