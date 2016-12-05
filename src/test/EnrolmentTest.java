package test;

import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrolmentDAO;
import dao.StudentDAO;
import model.EnrolmentDTO;
import model.StudentDTO;

public class EnrolmentTest
{
	public static void main(String[] args)
	{
		DAOFactory DF = DAOFactory.loadInstance();
		StudentDAO sd = DF.getStudentDAO();
		CourseDAO cd = DF.getCourseDAO();
		EnrolmentDAO ed = DF.getEnrolmentDAO();
		/*
		EnrolmentDTO e1 = new EnrolmentDTO(sd.findStudent(3), cd.findCourse(2));
		EnrolmentDTO e2 = new EnrolmentDTO(sd.findStudent(3), cd.findCourse(4));
		EnrolmentDTO e3 = new EnrolmentDTO(sd.findStudent(3), cd.findCourse(5));
		EnrolmentDTO e4 = new EnrolmentDTO(sd.findStudent(5), cd.findCourse(1));
		EnrolmentDTO e5 = new EnrolmentDTO(sd.findStudent(5), cd.findCourse(2));
		
		ed.createEnrolment(e1);
		ed.createEnrolment(e2);
		ed.createEnrolment(e3);
		ed.createEnrolment(e4);
		ed.createEnrolment(e5);
		*/
		
//		EnrolmentDTO e2 = new EnrolmentDTO(sd.findStudent(3), cd.findCourse(4));
//		ed.removeEnrolment(e2);
		
//		StudentDTO s1 = sd.findStudent(5);
//		System.out.println(s1.getLastName());
//		for (EnrolmentDTO e : ed.findEnrolmentByStudent(s1))
//		{
//			System.out.println(e.getCourse().getCourseID() + e.getCourse().getCourseName());
//		}
//		for (EnrolmentDTO e : ed.findEnrolmentByCourse(cd.findCourse(2)))
//		{
//			System.out.println(e.getStudent().getStudentID() + e.getStudent().getLastName());
//		}
		for (EnrolmentDTO e : ed.listAllEnrolment())
		{
			System.out.println(e.getCourse().getCourseID() + e.getCourse().getCourseName());
			System.out.println(e.getStudent().getStudentID() + e.getStudent().getLastName());
		}
	}
}
