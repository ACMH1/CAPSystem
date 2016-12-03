package dao;

import dao.mysql.CompletedDAOImpl;

public class CompletedDAOFactory
{
	public static CompletedDAO getCompletedDAOInstance()
	{
		return new CompletedDAOImpl();
	}
}
