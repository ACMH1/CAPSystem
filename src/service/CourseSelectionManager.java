package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import dao.CompletedDAO;
import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrolmentDAO;
import model.CompletedDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;

public class CourseSelectionManager
{
	public ArrayList<CourseDTO> findAvailableCourses(StudentDTO student)
	{
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();

		ArrayList<CourseDTO> studentCourses = findStudentCourses(student);

		DAOFactory df = DAOFactory.loadInstance();
		CourseDAO cd = df.getCourseDAO();
		ArrayList<CourseDTO> result = cd.listAllCourse();
		for (Iterator<CourseDTO> it = result.iterator(); it.hasNext();)
		{
			CourseDTO ct = it.next();
			if (ct.getStartDate().compareTo(now) > 0)
				it.remove();
			else if (studentCourses.contains(ct))
				it.remove();
			else if (courseSlots(ct) <= 0)
				it.remove();

		}
		return result;
	}

	public ArrayList<CourseDTO> findStudentCourses(StudentDTO student)
	{
		DAOFactory df = DAOFactory.loadInstance();
		EnrolmentDAO ed = df.getEnrolmentDAO();
		CompletedDAO cd = df.getCompletedDAO();
		ArrayList<EnrolmentDTO> studentEnrolled = ed.findEnrolmentByStudent(student);
		ArrayList<CompletedDTO> studentCompleted = cd.findCompletedByStudent(student);
		HashSet<CourseDTO> studentCourses = new HashSet<CourseDTO>();
		for (EnrolmentDTO et : studentEnrolled)
			studentCourses.add(et.getCourse());
		for (CompletedDTO ct : studentCompleted)
			studentCourses.add(ct.getCourse());
		return new ArrayList<CourseDTO>(studentCourses);
	}

	public int courseSlots(CourseDTO course)
	{
		DAOFactory df = DAOFactory.loadInstance();
		EnrolmentDAO ed = df.getEnrolmentDAO();
		return course.getSize() - ed.findEnrolmentByCourse(course).size();
	}
}
