package services;

import java.util.ArrayList;

import dao.CompletedDAO;
import dao.CompletedDAOFactory;
import dao.CourseDAO;
import dao.CourseDAOFactory;
import dao.EnrolmentDAO;
import dao.EnrolmentDAOFactory;
import dao.StudentDAO;
import dao.StudentDAOFactory;
import exception.MyDataException;
import model.CompletedDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.LecturerDTO;
import model.StudentDTO;


public class coursemanager {
	private CourseDAO cdao=CourseDAOFactory.getCourseDAOInstance();
	private EnrolmentDAO edao=EnrolmentDAOFactory.getEnrolmentDAOInstance();
	private StudentDAO sdao=StudentDAOFactory.getStudentDAOInstance();
	private CompletedDAO compdao=CompletedDAOFactory.getCompletedDAOInstance();
	
	
	
	
	
	public ArrayList<CourseDTO> searchAllMovies() throws MyDataException {
		try {
			ArrayList<CourseDTO> result = cdao.listAllCourse();
			return result;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");

		}	
	}
	public ArrayList<CourseDTO> findCourseByLecturer(LecturerDTO lecturer) throws MyDataException {
		try {
			ArrayList<CourseDTO> result = cdao.findCourseByLecturer(lecturer);
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
