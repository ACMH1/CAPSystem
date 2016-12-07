package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.StudentDAO;
import model.StudentDTO;

public class StudentManager {
	
	DAOFactory DF = DAOFactory.loadInstance();
	StudentDAO sd = DF.getStudentDAO();
		
	public boolean authenticate(int studentID , String pass,HttpServletRequest request) throws SQLException {
		//if( this.sd.findStudent(studentID))
		boolean result = false;
			StudentDTO dto=sd.findStudent(studentID);
			if(dto != null)
			{	
				if(dto.getPassword().equals(pass))
				{
					HttpSession session = request.getSession();
			    	session.setAttribute("firstmidname", dto.getFirstMidName());
					result= true;
					
				}
			}
			else
			{result= false;}
			return result;
	}

}
