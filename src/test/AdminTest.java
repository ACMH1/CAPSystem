package test;

import dao.AdminDAO;
import dao.AdminDAOFactory;
import model.AdminDTO;

public class AdminTest
{

	public static void main(String[] args)
	{
		AdminDAO A = AdminDAOFactory.getAdminDAOInstance();
		AdminDTO a1 = new AdminDTO(A.getNextAdminID(), "waddup");
		A.createAdmin(a1);
		AdminDTO a2 = A.findAdmin(3);
		a2.setPassword("hello");
		A.updateAdmin(a2);
		AdminDTO a3 = new AdminDTO(4, "waddup");
		A.removeAdmin(a3);
	}

}
