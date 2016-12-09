package service;

import java.util.ArrayList;
import dao.CompletedDAO;
import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrolmentDAO;
import dao.StudentDAO;
import exception.MyDataException;
import model.CompletedDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
//import model.LecturerDTO;
import model.StudentDTO;


public class coursemanager {
	DAOFactory DF = DAOFactory.loadInstance();
	CourseDAO cdao=DF.getCourseDAO();
	EnrolmentDAO edao=DF.getEnrolmentDAO();
	StudentDAO sdao=DF.getStudentDAO();
	CompletedDAO compdao=DF.getCompletedDAO();
	
	
	
	
	
	public ArrayList<CourseDTO> searchAllCourses() throws MyDataException {
		try {
			ArrayList<CourseDTO> result = cdao.listAllCourse();
			return result;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");

		}	
	}
	public ArrayList<StudentDTO> searchAllStudents() throws MyDataException {
		try {
			ArrayList<StudentDTO> result = sdao.listAllStudent();
			return result;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");

		}	
	}
	public ArrayList<CourseDTO> findCourseByLecturer(int lecturer) throws MyDataException {
		try {
			ArrayList<CourseDTO> result = cdao.findCourseByLecturerID(lecturer);
			return result;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");

		}	
	}

	 
	public ArrayList<EnrolmentDTO> findCourseEnrolment(CourseDTO c) throws MyDataException{
		
	
		
		try{
			ArrayList<EnrolmentDTO> result=edao.findEnrolmentByCourse(c);
			return result;
		}catch(Exception sql){
			throw new MyDataException("ERROR IN CREATE METHOD");
			
		}
	}
public ArrayList<CompletedDTO> findStudentEnrolment(StudentDTO student) throws MyDataException{
		
	
		
		try{
			ArrayList<CompletedDTO> result=compdao.findCompletedByStudent(student);
			return result;
		}catch(Exception sql){
			throw new MyDataException("ERROR IN CREATE METHOD");
			
		}
	}
	
	public void GradeCourse(CompletedDTO completed) throws MyDataException {

           compdao.createCompleted(completed);
		
	}
	public void DeleteEnrol(EnrolmentDTO enrol) throws MyDataException {

        edao.removeEnrolment(enrol);
		
	}
	
	
	
	public StudentDTO findStudentsEnroll(int id) throws MyDataException {
		try {
			StudentDTO result = sdao.findStudent(id);
			return result;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");
	
	
	

}
	}
}
