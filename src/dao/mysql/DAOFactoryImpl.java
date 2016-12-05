package dao.mysql;

import dao.AdminDAO;
import dao.CompletedDAO;
import dao.CourseDAO;
import dao.DAOFactory;
import dao.EnrolmentDAO;
import dao.LecturerDAO;
import dao.StudentDAO;

public class DAOFactoryImpl extends DAOFactory
{

	@Override
	public AdminDAO getAdminDAO()
	{
		return new AdminDAOImpl();
	}

	@Override
	public CompletedDAO getCompletedDAO()
	{
		return new CompletedDAOImpl();
	}

	@Override
	public CourseDAO getCourseDAO()
	{
		return new CourseDAOImpl();
	}

	@Override
	public EnrolmentDAO getEnrolmentDAO()
	{
		return new EnrolmentDAOImpl();
	}

	@Override
	public LecturerDAO getLecturerDAO()
	{
		return new LecturerDAOImpl();
	}

	@Override
	public StudentDAO getStudentDAO()
	{
		return new StudentDAOImpl();
	}

}
