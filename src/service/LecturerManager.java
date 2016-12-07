package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.LecturerDAO;
import model.LecturerDTO;


public class LecturerManager {
	DAOFactory DF = DAOFactory.loadInstance();
	LecturerDAO sd = DF.getLecturerDAO();
	
	public boolean authenticate(int lecturerID , String pass,HttpServletRequest request) throws SQLException {
		//if( this.sd.findStudent(studentID))
		boolean result = false;
			LecturerDTO dto=sd.findLecturer(lecturerID);
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
