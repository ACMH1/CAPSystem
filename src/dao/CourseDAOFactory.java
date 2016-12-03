package dao;

import dao.mysql.CourseDAOImpl;

public class CourseDAOFactory
{
	public static CourseDAO getCourseDAOInstance() {
		return new CourseDAOImpl();
	}
}
