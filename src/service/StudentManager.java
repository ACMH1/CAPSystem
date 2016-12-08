package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.StudentDAO;
import exception.MyDataException;
import model.StudentDTO;

public class StudentManager
{
	private DAOFactory df = DAOFactory.loadInstance();
	private StudentDAO sdao = df.getStudentDAO();

	public StudentManager()
	{
		// mdao
	}

	public int createStudent(StudentDTO s) throws MyDataException
	{
		int result = sdao.createStudent(s);
		return result;
	}

	public int changeStudent(StudentDTO s) throws MyDataException
	{
		int result = sdao.updateStudent(s);
		return result;
	}

	public int removeStudent(StudentDTO student) throws MyDataException
	{
		int result = sdao.removeStudent(student);
		return result;
	}

	public ArrayList<StudentDTO> searchAllStudent() throws MyDataException
	{
		ArrayList<StudentDTO> result = sdao.listAllstudent();
		return result;
	}

	public StudentDTO searchById(int id) throws MyDataException
	{
		StudentDTO result = sdao.findStudent(id);
		return result;
	}

	public boolean authenticate(int studentID, String pass, HttpServletRequest request) throws SQLException
	{
		// if( this.sd.findStudent(studentID))
		boolean result = false;
		StudentDTO dto = sdao.findStudent(studentID);
		if (dto != null)
		{
			if (dto.getPassword().equals(pass))
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
