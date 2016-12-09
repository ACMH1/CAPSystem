package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.LecturerDAO;

import exception.MyDataException;
import model.LecturerDTO;
import utility.PasswordUtility;

public class LecturerManager
{

	private LecturerDAO ldao = DAOFactory.loadInstance().getLecturerDAO();

	public LecturerManager()
	{
		// ldao
	}

	public int createLecturer(LecturerDTO l) throws MyDataException
	{
		int result = ldao.createLecturer(l);
		return result;
	}

	public int changeLecturer(LecturerDTO s) throws MyDataException
	{
		int result = ldao.updateLecturer(s);
		return result;
	}

	public int removeLecturer(LecturerDTO Lecturer) throws MyDataException
	{
		int result = ldao.removeLecturer(Lecturer);
		return result;
	}

	public ArrayList<LecturerDTO> searchAllLecturer() throws MyDataException
	{
		ArrayList<LecturerDTO> result = ldao.listAllLecturer();
		return result;
	}

	public LecturerDTO searchById(int id) throws MyDataException
	{
		LecturerDTO result = ldao.findLecturer(id);
		return result;
	}

	public boolean authenticate(int lecturerID, String pass, HttpServletRequest request) throws SQLException
	{
		// if( this.sd.findStudent(studentID))
		boolean result = false;
		LecturerDTO dto = ldao.findLecturer(lecturerID);
		if (dto != null)
		{
			if (dto.getPassword().equals(PasswordUtility.base64encode(pass)))
			{
				HttpSession session = request.getSession();
				session.setAttribute("firstmidname", dto.getFirstMidName());
				result = true;

			}
		} else
		{
			result = false;
		}
		return result;
	}
}
