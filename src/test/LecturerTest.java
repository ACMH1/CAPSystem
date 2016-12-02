package test;

import dao.LecturerDAO;
import dao.LecturerDAOFactory;
import model.LecturerDTO;

public class LecturerTest
{

	public static void main(String[] args)
	{
		LecturerDAO L = LecturerDAOFactory.getLecturerDAOInstance();
		//LecturerDTO l1 = new LecturerDTO(L.getNextLecturerID(), "Alice", "aa","dodo@gmail.com", "hello");
		
		//L.createLecturer(l1);
		//LecturerDTO l2 = L.findLecturer(5);
		/*System.out.println(l2.getLecturerID());
		System.out.println(l2.getLastName());
		System.out.println(l2.getFirstMidName());
		System.out.println(l2.getEmail());
		System.out.println(l2.getPassword());*/
		
		//L.removeLecturer(l2);
		
		//LecturerDTO l3 = new LecturerDTO(1, "Bob", "bb","pig@gmail.com", "bye");
		//L.updateLecturer(l3);
		
		//LecturerDTO l4 = L.findLecturer(1);
		//System.out.println(l4.getLecturerID());
		//System.out.println(l4.getLastName());
		//System.out.println(l4.getFirstMidName());
		//System.out.println(l4.getEmail());
		//System.out.println(l4.getPassword());
		
		for (LecturerDTO l : L.listAllLecturer())
		{
			System.out.println(l.getLecturerID());
			System.out.println(l.getLastName());
			System.out.println(l.getFirstMidName());
			System.out.println(l.getEmail());
			System.out.println(l.getPassword());
		}
	}

}
