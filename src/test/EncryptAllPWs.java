package test;

import dao.AdminDAO;
import dao.DAOFactory;
import dao.LecturerDAO;
import dao.StudentDAO;
import model.AdminDTO;
import model.LecturerDTO;
import model.StudentDTO;
import utility.PasswordUtility;

public class EncryptAllPWs
{

	public static void main(String[] args)
	{
		// WARNING!!! WARNING!!! WARNING!!!
		// RUN ONLY ONCE!!!
		// WARNING!!! WARNING!!! WARNING!!!
		DAOFactory df = DAOFactory.loadInstance();
		StudentDAO sd = df.getStudentDAO();
		AdminDAO ad = df.getAdminDAO();
		LecturerDAO ld = df.getLecturerDAO();

		System.out.println("Encrypting...");

		for (StudentDTO s : sd.listAllStudent())
		{
			String unencrypted = s.getPassword();
			s.setPassword(PasswordUtility.base64encode(unencrypted));
			sd.updateStudent(s);
		}

		for (AdminDTO a : ad.listAllAdmin())
		{
			String unencrypted = a.getPassword();
			a.setPassword(PasswordUtility.base64encode(unencrypted));
			ad.updateAdmin(a);
		}

		for (LecturerDTO l : ld.listAllLecturer())
		{
			String unencrypted = l.getPassword();
			l.setPassword(PasswordUtility.base64encode(unencrypted));
			ld.updateLecturer(l);
		}

		System.out.println("Complete!");
	}

}
