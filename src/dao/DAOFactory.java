package dao;

public abstract class DAOFactory
{
	public abstract AdminDAO getAdminDAO();
	public abstract CompletedDAO getCompletedDAO();
	public abstract CourseDAO getCourseDAO();
	public abstract EnrolmentDAO getEnrolmentDAO();
	public abstract LecturerDAO getLecturerDAO();
	public abstract StudentDAO getStudentDAO();
	
	public static DAOFactory loadInstance()
	{
		return new dao.mysql.DAOFactoryImpl();
	}
}
