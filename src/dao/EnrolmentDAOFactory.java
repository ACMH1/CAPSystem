package dao;

import dao.mysql.EnrolmentDAOImpl;

public class EnrolmentDAOFactory
{
	public static EnrolmentDAO getEnrolmentDAOInstance() {
		return new EnrolmentDAOImpl();
	}
}
