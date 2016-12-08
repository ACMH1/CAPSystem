package service;
import dao.DAOFactory;
import dao.LecturerDAO;
import dao.NoDataException;
import model.LecturerDTO;

public class AdminLecturerManager {
	private LecturerDAO lecturerdao;

	public AdminLecturerManager() {
		
		this.lecturerdao=DAOFactory.loadInstance().getLecturerDAO();
	}
	
	public LecturerDTO findThatLecturer(int lecturerID) throws NoDataException
	{ 
		
		LecturerDTO thatlecturer=lecturerdao.findLecturer(lecturerID);
		
		return thatlecturer;
				
	}
	public boolean lecturerValidation(int lecturerID) 
	
	{
		LecturerDTO thatlecturer=lecturerdao.findLecturer(lecturerID);
		
		if( thatlecturer!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
}
