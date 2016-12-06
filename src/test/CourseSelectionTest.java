package test;

import java.util.ArrayList;

import dao.CourseDAO;
import dao.DAOFactory;
import dao.StudentDAO;
import model.CourseDTO;
import service.CourseSelectionManager;

public class CourseSelectionTest
{

	public static void main(String[] args)
	{
		DAOFactory df = DAOFactory.loadInstance();
		StudentDAO sd = df.getStudentDAO();
		CourseDAO cd = df.getCourseDAO();
		CourseSelectionManager csm = new CourseSelectionManager();
		ArrayList<CourseDTO> studentCourses = csm.findStudentCourses(sd.findStudent(10001));
		ArrayList<CourseDTO> ctArr = csm.findAvailableCourses(sd.findStudent(10001));
		// ArrayList<CourseDTO> ctArr = cd.listAllCourse();
		for (CourseDTO ct : ctArr)
		{
			System.out.println(ct.getCourseID());
			System.out.println(ct.getSize());
			System.out.println(studentCourses.contains(ct));
		}
		System.out.println(ctArr.size());
	}

}
