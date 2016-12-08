package service;
import dao.DAOFactory;
import dao.StudentDAO;
import model.StudentDTO;

public class AdminStudentManager {
private StudentDAO studentdao;

public AdminStudentManager() {
	
	this.studentdao = DAOFactory.loadInstance().getStudentDAO();
}

public StudentDTO findStudent(int ID)
{
	return studentdao.findStudent(ID);
}


}
