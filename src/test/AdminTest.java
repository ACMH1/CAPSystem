package test;

import dao.AdminDAO;
import dao.CourseDAO;
import dao.DAOFactory;
import dao.StudentDAO;
import model.AdminDTO;

public class AdminTest
{

	public static void main(String[] args)
	{
		DAOFactory DF = DAOFactory.loadInstance();
		AdminDAO A = DF.getAdminDAO();
		AdminDTO a1 = new AdminDTO(A.getNextAdminID(), "waddup");
		A.createAdmin(a1);
		AdminDTO a2 = A.findAdmin(3);
		a2.setPassword("hello");
		A.updateAdmin(a2);
		AdminDTO a3 = new AdminDTO(4, "waddup");
		A.removeAdmin(a3);
	}

}
