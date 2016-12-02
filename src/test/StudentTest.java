package test;

import java.util.Calendar;

import dao.StudentDAO;
import dao.StudentDAOFactory;
import model.StudentDTO;

public class StudentTest
{
	public static void main(String[] args)
	{
		StudentDAO S = StudentDAOFactory.getStudentDAOInstance();
		Calendar cal = Calendar.getInstance();
		StudentDTO s1 = new StudentDTO(4, "alan", "aeiou", cal.getTime(), "aaa@aa.org", "AAAA");
		//S.createStudent(s1);
		//StudentDTO s2 = new StudentDTO(3, "alan", "aeiou", cal.getTime(), "aaa@aa.org", "AAAA");
		//S.createStudent(s2);
		//S.removeStudent(s2);
		StudentDTO s3 = S.findStudent(3);
		s3.setEmail("bbb@bb.com");
		S.updateStudent(s3);
		S.removeStudent(s1);
		for (StudentDTO s : S.listAllstudent())
		{
			System.out.println(s.getStudentID());
		}
	}

}
