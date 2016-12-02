package dao;

import dao.mysql.LecturerDAOImpl;

public class LecturerDAOFactory
{
	public static LecturerDAO getLecturerDAOInstance() {
		return new LecturerDAOImpl();
	}
}
