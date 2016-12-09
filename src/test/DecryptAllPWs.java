package test;

import dao.AdminDAO;
import dao.DAOFactory;
import dao.LecturerDAO;
import dao.StudentDAO;
import model.AdminDTO;
import model.LecturerDTO;
import model.StudentDTO;
import utility.PasswordUtility;

public class DecryptAllPWs
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

		System.out.println("Decrypting...");

		for (StudentDTO s : sd.listAllStudent())
		{
			String encrypted = s.getPassword();
			s.setPassword(PasswordUtility.base64decode(encrypted));
			sd.updateStudent(s);
		}

		for (AdminDTO a : ad.listAllAdmin())
		{
			String encrypted = a.getPassword();
			a.setPassword(PasswordUtility.base64decode(encrypted));
			ad.updateAdmin(a);
		}

		for (LecturerDTO l : ld.listAllLecturer())
		{
			String encrypted = l.getPassword();
			l.setPassword(PasswordUtility.base64decode(encrypted));
			ld.updateLecturer(l);
		}

		System.out.println("Complete!");
	}

}
