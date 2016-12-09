package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.CompletedDAO;
import dao.CourseDAO;
import dao.EnrolmentDAO;
import dao.DAOFactory;
import dao.StudentDAO;
import exception.MyDataException;
import model.CompletedDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;
import utility.PasswordUtility;

public class StudentManager
{
	private DAOFactory df;
	private StudentDAO sdao;
	private EnrolmentDAO enrolDAO;

	public StudentManager()
	{
		df = DAOFactory.loadInstance();
		sdao = df.getStudentDAO();
		enrolDAO = df.getEnrolmentDAO();
	}

	public int createStudent(StudentDTO s) throws MyDataException
	{
		int result = sdao.createStudent(s);
		return result;
	}

	public int changeStudent(StudentDTO s) throws MyDataException
	{
		int result = sdao.updateStudent(s);
		return result;
	}

	public int removeStudent(StudentDTO student) throws MyDataException
	{
		int result = sdao.removeStudent(student);
		return result;
	}

	public ArrayList<StudentDTO> searchAllStudent() throws MyDataException
	{
		ArrayList<StudentDTO> result = sdao.listAllStudent();
		return result;
	}

	public StudentDTO searchById(int id) throws MyDataException
	{
		StudentDTO result = sdao.findStudent(id);
		return result;
	}
	
	public ArrayList<EnrolmentDTO> getEnrollCourseListByStudentId(int studentId)

	{
		StudentDTO student = new StudentDTO();
		student.setStudentID(studentId);
		ArrayList<EnrolmentDTO> courseEnrollList = new ArrayList<EnrolmentDTO>();
		courseEnrollList = enrolDAO.findEnrolmentByStudent(student);
		return courseEnrollList;
	}

	public ArrayList<CourseDTO> findAvailableCourses(StudentDTO student) {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();

		ArrayList<CourseDTO> studentCourses = findStudentCourses(student);

		DAOFactory df = DAOFactory.loadInstance();
		CourseDAO cd = df.getCourseDAO();
		ArrayList<CourseDTO> availableCourseList = cd.listAllCourse();

		if (studentCourses != null) {
			for (Iterator<CourseDTO> it = availableCourseList.iterator(); it.hasNext();) {
				CourseDTO ct = it.next();
				if (studentCourses.contains(ct))
					it.remove();
				else if (ct.getStartDate().compareTo(now) < 0)
					it.remove();

				else if (ct.courseSlots() <= 0)
					it.remove();
			}

		} else if (studentCourses == null) {
			for (Iterator<CourseDTO> it = availableCourseList.iterator(); it.hasNext();) {
				CourseDTO ct = it.next();
				if (ct.getStartDate().compareTo(now) < 0)
					it.remove();
			}
		}

		return availableCourseList;
	}
	
	public ArrayList<CourseDTO> findStudentCourses(StudentDTO student) {
		DAOFactory df = DAOFactory.loadInstance();
		EnrolmentDAO ed = df.getEnrolmentDAO();
		CompletedDAO cd = df.getCompletedDAO();
		ArrayList<EnrolmentDTO> studentEnrolled = ed.findEnrolmentByStudent(student);
		ArrayList<CompletedDTO> studentCompleted = cd.findCompletedByStudent(student);
		HashSet<CourseDTO> studentCourses = new HashSet<CourseDTO>();
		if (studentEnrolled != null) {
			for (EnrolmentDTO et : studentEnrolled)
				studentCourses.add(et.getCourse());
		}
		if(studentCompleted != null)
		{
			for (CompletedDTO ct : studentCompleted)
				studentCourses.add(ct.getCourse());
		}
		
		return new ArrayList<CourseDTO>(studentCourses);
	}
	
	public void insertEnrolment(int studentId, int courseId) {

		CourseDTO courseDto = new CourseDTO();
		courseDto.setCourseID(courseId);

		StudentDTO stu = new StudentDTO();
		stu.setStudentID(studentId);

		EnrolmentDTO enrolDto = new EnrolmentDTO(stu, courseDto);
		enrolDAO.createEnrolment(enrolDto);
		
	}
	
	public ArrayList<CompletedDTO> allStudentsCourses(StudentDTO student) {
		DAOFactory df = DAOFactory.loadInstance();
		CompletedDAO cd = df.getCompletedDAO();
		ArrayList<CompletedDTO> result=cd.findCompletedByStudent(student);
		return result;
	}
	
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

	public boolean authenticate(int studentID, String pass, HttpServletRequest request) throws SQLException
	{
		// if( this.sd.findStudent(studentID))
		boolean result = false;
		StudentDTO dto = sdao.findStudent(studentID);
		if (dto != null)
		{
			if (dto.getPassword().equals(PasswordUtility.base64encode(pass)))
			{
				HttpSession session = request.getSession();
				session.setAttribute("firstmidname", dto.getFirstMidName());
				result = true;

			}
		} else
		{
			result = false;
		}
		return result;
	}
	public StudentDTO getStudentName(int studentId)
	{
		StudentDTO studentDTO= new StudentDTO();		
		StudentDTO dto = sdao.findStudent(studentId);
		
	     return dto;
		
	}
}
