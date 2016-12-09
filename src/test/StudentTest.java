package test;

import java.util.Calendar;

import dao.DAOFactory;
import dao.StudentDAO;
import model.StudentDTO;

public class StudentTest
{
	public static void main(String[] args)
	{
		DAOFactory DF = DAOFactory.loadInstance();
		StudentDAO sd = DF.getStudentDAO();
		Calendar cal = Calendar.getInstance();
		
//		StudentDTO s1 = new StudentDTO(10101, "alan", "aeiou", cal.getTime(), "aaa@aa.org", "AAAA");
//		sd.createStudent(s1);
		
		//StudentDTO s2 = new StudentDTO(3, "alan", "aeiou", cal.getTime(), "aaa@aa.org", "AAAA");
		//sd.createStudent(s2);
		
//		sd.removeStudent(s1);
		
//		StudentDTO s3 = S.findStudent(10095);
//		s3.setEmail("bbb@bb.com");
//		sd.updateStudent(s3);
		
		for (StudentDTO s : sd.listAllStudent())
		{
			System.out.println(s.getStudentID());
		}
	}

}
