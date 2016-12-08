package service;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrolmentDAO;
import dao.StudentDAO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;

public class AdminEnrolmentManager {
	private EnrolmentDAO enrolmentdao;
	
	public AdminEnrolmentManager() {		 
		this.enrolmentdao = DAOFactory.loadInstance().getEnrolmentDAO();
		
	}
	
	public ArrayList<EnrolmentDTO> findEnrolmentByCourse(CourseDTO course)
	{
		ArrayList<EnrolmentDTO> enrolmentList=new ArrayList<EnrolmentDTO>();
			enrolmentList=enrolmentdao.findEnrolmentByCourse(course);
		 return enrolmentList;
	}
	public int createEnrolment(EnrolmentDTO enrol)
	{
		return enrolmentdao.createEnrolment(enrol);
	}
	public int deleteEnrolment(EnrolmentDTO enrol)
	{
		return enrolmentdao.removeEnrolment(enrol);
	}
	public boolean checkDuplicate(StudentDTO student,CourseDTO course)
	{
		ArrayList<EnrolmentDTO> enrolmentList=enrolmentdao.findEnrolmentByStudent(student);
		for(EnrolmentDTO enrol : enrolmentList)
		{
			if(enrol.getCourse().getCourseID()==course.getCourseID())
			{
				return false;
			}
		}
		return true;
	}
	 public boolean checkSize (CourseDTO course)
	 {
		 ArrayList<EnrolmentDTO> enrolmentList=enrolmentdao.findEnrolmentByCourse(course);
		 if(enrolmentList.size()<course.getSize())
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
		 
	 }
	
}
