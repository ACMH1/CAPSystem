package dao;

import dao.mysql.StudentDAOImpl;

public class StudentDAOFactory
{
	public static StudentDAO getStudentDAOInstance() {
		return new StudentDAOImpl();
	}
}
