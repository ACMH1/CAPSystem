package dao;

import dao.mysql.AdminDAOImpl;

public class AdminDAOFactory
{
	public static AdminDAO getAdminDAOInstance() {
		return new AdminDAOImpl();
	}
}
