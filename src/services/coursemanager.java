package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.CourseDAOFactory;
import exception.MyDataException;
import model.CourseDTO;


public class coursemanager {
	private CourseDAO cdao=CourseDAOFactory.getCourseDAOInstance();
	public ArrayList<CourseDTO> searchAllMovies() throws MyDataException {
		try {
			ArrayList<CourseDTO> result = cdao.listAllCourse();
			return result;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");
//		} catch (ClassNotFoundException ce) {
//			throw new MyDataException("ERROR IN CREATE METHOD");
		}
	}

}
