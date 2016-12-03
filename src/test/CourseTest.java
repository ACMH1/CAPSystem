package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.CourseDAO;
import dao.CourseDAOFactory;
import dao.LecturerDAO;
import dao.LecturerDAOFactory;
import model.CourseDTO;

public class CourseTest
{

	public static void main(String[] args)
	{
		CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
		LecturerDAO ld = LecturerDAOFactory.getLecturerDAOInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		/*
		try
		{
			CourseDTO c1 = new CourseDTO(cd.getNextCourseID(), "How Not to Be Seen", 25, 30, ld.findLecturer(4), df.parse("01-01-2016"), df.parse("01-03-2016"));
			System.out.println(cd.createCourse(c1));
			CourseDTO c2 = new CourseDTO(cd.getNextCourseID(), "Intermediate Cat=Fighting", 60, 30, ld.findLecturer(5), df.parse("01-02-2016"), df.parse("01-04-2016"));
			System.out.println(cd.createCourse(c2));
			CourseDTO c3 = new CourseDTO(cd.getNextCourseID(), "Philosophy and Mein Kampf", 80, 45, ld.findLecturer(3), df.parse("01-05-2016"), df.parse("01-08-2016"));
			System.out.println(cd.createCourse(c3));
			CourseDTO c4 = new CourseDTO(cd.getNextCourseID(), "Common Sense and How to use it", 40, 20, ld.findLecturer(2), df.parse("01-06-2016"), df.parse("01-09-2016"));
			System.out.println(cd.createCourse(c4));
			CourseDTO c5 = new CourseDTO(cd.getNextCourseID(), "Rennaisance Art and Fast Food Delivery", 50, 10, ld.findLecturer(1), df.parse("01-07-2016"), df.parse("01-12-2016"));
			System.out.println(cd.createCourse(c5));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CourseDTO c6 = cd.findCourse(3);
		System.out.println(c6.getCourseID());
		System.out.println(c6.getCourseName());
		System.out.println(c6.getSize());
		System.out.println(c6.getCredits());
		System.out.println(c6.getLecturer().getLastName() + " " + c6.getLecturer().getFirstMidName());
		System.out.println(c6.getStartDate());
		System.out.println(c6.getEndDate());
		
		try
		{
			CourseDTO c7 = new CourseDTO(3, "Intermediate Cat-Fighting", 60, 30, ld.findLecturer(5), df.parse("01-02-2016"), df.parse("01-04-2016"));
			cd.updateCourse(c7);
			cd.removeCourse(c7);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		for (CourseDTO c : cd.listAllCourse())
		{
			System.out.println(c.getCourseID());
			System.out.println(c.getCourseName());
			System.out.println(c.getSize());
			System.out.println(c.getCredits());
			System.out.println(c.getLecturer().getLastName() + " " + c.getLecturer().getFirstMidName());
			System.out.println(c.getStartDate());
			System.out.println(c.getEndDate());
		}
	}
}
