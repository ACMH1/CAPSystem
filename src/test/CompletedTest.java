package test;

import dao.CompletedDAO;
import dao.CompletedDAOFactory;
import dao.CourseDAO;
import dao.CourseDAOFactory;
import dao.StudentDAO;
import dao.StudentDAOFactory;
import model.CompletedDTO;
import model.StudentDTO;

public class CompletedTest
{

	public static void main(String[] args)
	{
		CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
		StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
		CompletedDAO ed = CompletedDAOFactory.getCompletedDAOInstance();
//		
//		CompletedDTO e1 = new CompletedDTO(sd.findStudent(3), cd.findCourse(2), 55);
//		CompletedDTO e2 = new CompletedDTO(sd.findStudent(3), cd.findCourse(4), 38);
//		CompletedDTO e3 = new CompletedDTO(sd.findStudent(3), cd.findCourse(5), 77);
//		CompletedDTO e4 = new CompletedDTO(sd.findStudent(5), cd.findCourse(1), 68);
//		CompletedDTO e5 = new CompletedDTO(sd.findStudent(5), cd.findCourse(2), 79);
//		ed.createCompleted(e1);
//		ed.createCompleted(e2);
//		ed.createCompleted(e3);
//		ed.createCompleted(e4);
//		ed.createCompleted(e5);
		
		
//		CompletedDTO e2 = new CompletedDTO(sd.findStudent(3), cd.findCourse(4), 38);
//		ed.removeCompleted(e2);
		
//		StudentDTO s1 = sd.findStudent(5);
//		System.out.println(s1.getLastName());
//		for (CompletedDTO e : ed.findCompletedByStudent(s1))
//		{
//			System.out.println(e.getCourse().getCourseID() + e.getCourse().getCourseName());
//		}
		
		for (CompletedDTO e : ed.findCompletedByCourse(cd.findCourse(2)))
		{
			System.out.println(e.getStudent().getStudentID() + e.getStudent().getLastName());
		}
		
//		for (CompletedDTO e : ed.listAllCompleted())
//		{
//			System.out.println(e.getCourse().getCourseID() + e.getCourse().getCourseName());
//			System.out.println(e.getStudent().getStudentID() + e.getStudent().getLastName());
//		}
	}

}
