package test;

import dao.LecturerDAO;
import dao.LecturerDAOFactory;
import model.LecturerDTO;

public class LecturerTest
{

	public static void main(String[] args)
	{
		LecturerDAO L = LecturerDAOFactory.getLecturerDAOInstance();
//		LecturerDTO l1 = new LecturerDTO(L.getNextLecturerID(), "Alice", "aa","dodo@gmail.com", "dfgfggfj");
//		L.createLecturer(l1);
//		LecturerDTO l2 = new LecturerDTO(L.getNextLecturerID(), "Bob", "bb","b@gmail.com", "dfdfgdfg");
//		L.createLecturer(l2);
//		LecturerDTO l3 = new LecturerDTO(L.getNextLecturerID(), "Charlie", "cc","v@gmail.com", "dfgfgdfgdfg");
//		L.createLecturer(l3);
//		LecturerDTO l4 = new LecturerDTO(L.getNextLecturerID(), "Dave", "dd","dsf@gmail.com", "fhdfhh");
//		L.createLecturer(l4);
//		LecturerDTO l5 = new LecturerDTO(L.getNextLecturerID(), "Eve", "ee","ddfs@gmail.com", "gfffd");
//		L.createLecturer(l5);
		
		LecturerDTO l2 = L.findLecturer(2005);
		System.out.println(l2.getLecturerID());
		System.out.println(l2.getLastName());
		System.out.println(l2.getFirstMidName());
		System.out.println(l2.getEmail());
		System.out.println(l2.getPassword());
		
		//L.removeLecturer(l2);
		
		LecturerDTO l3 = new LecturerDTO(2010, "Bob", "bb","pig@gmail.com", "bye");
		L.updateLecturer(l3);
		
//		for (LecturerDTO l : L.listAllLecturer())
//		{
//			System.out.println(l.getLecturerID());
//			System.out.println(l.getLastName());
//			System.out.println(l.getFirstMidName());
//			System.out.println(l.getEmail());
//			System.out.println(l.getPassword());
//		}
	}

}
