package service;

import java.util.ArrayList;

import dao.CompletedDAO;
import dao.DAOFactory;
import model.CompletedDTO;
import model.StudentDTO;

public class CourseGradeManager {

	public ArrayList<CompletedDTO> allStudentsCourses(StudentDTO student) {
		DAOFactory df = DAOFactory.loadInstance();
		CompletedDAO cd = df.getCompletedDAO();
		ArrayList<CompletedDTO> result=cd.findCompletedByStudent(student);
		return result;
	}


	// public ArrayList<CourseGradeDTO> getCourseGradeList()
	// {
	// ArrayList<CourseGradeDTO> courseList = new ArrayList<CourseGradeDTO>();
	// courseList=courseDAO.getGradesAndGPA();
	//
	// return courseList;
	// }
	
	public double CalculateGPA(StudentDTO student){
		DAOFactory df = DAOFactory.loadInstance();
		CompletedDAO ds = df.getCompletedDAO();
		ArrayList<CompletedDTO> result=ds.findCompletedByStudent(student);
		double gpa=0;
		double pga=0;
		for(CompletedDTO completed : result){
			double a = completed.getCourse().getCredits()*completed.getGrade();
			double b = completed.getCourse().getCredits();
			gpa+=a;
			pga+=b;
		}
		return (gpa/pga);
		
		
		
	}


}
