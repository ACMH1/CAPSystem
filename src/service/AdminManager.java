package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import dao.AdminDAO;
import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrolmentDAO;
import dao.LecturerDAO;
import dao.NoDataException;
import dao.StudentDAO;
import exception.MyDataException;
import model.AdminDTO;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.LecturerDTO;
import model.StudentDTO;
import utility.PasswordUtility;

public class AdminManager {

	
	private AdminDAO ad;
	private LecturerDAO ldao;
	private CourseDAO coursedao;
	private EnrolmentDAO enrolmentdao;
	private StudentDAO sdao;
	public AdminManager() {

		this.ad = DAOFactory.loadInstance().getAdminDAO();
		this.ldao =DAOFactory.loadInstance().getLecturerDAO();
		this.coursedao =  DAOFactory.loadInstance().getCourseDAO();
		this.enrolmentdao =  DAOFactory.loadInstance().getEnrolmentDAO();
		this.sdao =  DAOFactory.loadInstance().getStudentDAO();
	}

	

	public boolean authenticate(int adminID, String pass, HttpServletRequest request) throws SQLException {

		boolean result = false;
		AdminDTO dto = ad.findAdmin(adminID);
		if (dto != null) {
			if (dto.getPassword().equals(PasswordUtility.base64encode(pass))) {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}

	public int createLecturer(LecturerDTO l) throws MyDataException
	{
		int result = ldao.createLecturer(l);
		return result;
	}

	public int changeLecturer(LecturerDTO s) throws MyDataException
	{
		int result = ldao.updateLecturer(s);
		return result;
	}

	public int removeLecturer(LecturerDTO Lecturer) throws MyDataException
	{
		int result = ldao.removeLecturer(Lecturer);
		return result;
	}

	public ArrayList<LecturerDTO> searchAllLecturer() throws MyDataException
	{
		ArrayList<LecturerDTO> result = ldao.listAllLecturer();
		return result;
	}

	public LecturerDTO searchByLecturerId(int id) throws MyDataException
	{
		LecturerDTO result = ldao.findLecturer(id);
		return result;
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

	public StudentDTO searchByStudentId(int id) throws MyDataException
	{
		StudentDTO result = sdao.findStudent(id);
		return result;
	}
	public int addCourses(CourseDTO course) 
	{
		course.setCourseID(coursedao.getNextCourseID());
		return coursedao.createCourse(course);
	}
	
	public int updateCourses(CourseDTO course)
	{
		return  coursedao.updateCourse(course);
	}
	public CourseDTO findCourse(int id)
	{
		return coursedao.findCourse(id);
	}
	public int removeCourses(CourseDTO course)
	{

				return  coursedao.removeCourse(course);
			
    }
	public ArrayList<CourseDTO> listAllCourses()
	{
				return coursedao.listAllCourse();		
	}
	public boolean dateValidation(Date start, Date end)
	{
		System.out.println(start);
		System.out.println(end);
        Date today = Calendar.getInstance().getTime();
        System.out.println(today);
        
		if (start.before(end)&&start.after(today))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean numberValidation(int num, int start, int end)
	{
		if(num<=end&&num>=start) 
			{
			return true;
			}
		else
		{
			return false;
		}		
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
	 public LecturerDTO findThatLecturer(int lecturerID) throws NoDataException
		{ 
			
				LecturerDTO thatlecturer=ldao.findLecturer(lecturerID);
			return thatlecturer;
					
		}
	 public boolean lecturerValidation(int lecturerID) 
		
		{
			LecturerDTO thatlecturer=ldao.findLecturer(lecturerID);
			
			if( thatlecturer!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
	 public StudentDTO findStudent(int ID)
	 {
	 	return sdao.findStudent(ID);
	 }
	
}
