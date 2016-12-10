package service;

import dao.AdminDAO;
import dao.DAOFactory;
import dao.LecturerDAO;
import dao.StudentDAO;
import exception.MyDataException;
import model.AdminDTO;
import model.LecturerDTO;
import model.StudentDTO;

public class ProfilePassword {
	private LecturerDAO ldao = DAOFactory.loadInstance().getLecturerDAO();
	private AdminDAO adao = DAOFactory.loadInstance().getAdminDAO();
	private StudentDAO sdao = DAOFactory.loadInstance().getStudentDAO();
	 
	public LecturerDTO findpwd(int lecturer) throws MyDataException
	{
		try{
		LecturerDTO oldpass=ldao.findLecturer(lecturer);
		return oldpass;
	} catch (Exception sql) {
		throw new MyDataException("ERROR IN CREATE METHOD");

	}
	}
		public boolean updatepwd(LecturerDTO lecturer) throws MyDataException
		{
			try{
			ldao.updateLecturer(lecturer);
			return true;
			
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");

		}
		
		
		
		
	}
			
		public AdminDTO findadminpwd(int admin) throws MyDataException
		{
			try{
			AdminDTO oldpass=adao.findAdmin(admin);
			return oldpass;
		} catch (Exception sql) {
			throw new MyDataException("ERROR IN CREATE METHOD");

		}
		}
			public boolean updateadminpwd(AdminDTO admin) throws MyDataException
			{
				try{
				adao.updateAdmin(admin);
				return true;
				
			} catch (Exception sql) {
				throw new MyDataException("ERROR IN CREATE METHOD");

			}
			
			
			
			
		}			
			public StudentDTO findstudpwd(int student) throws MyDataException
			{
				try{
				StudentDTO oldpass=sdao.findStudent(student);
				return oldpass;
			} catch (Exception sql) {
				throw new MyDataException("ERROR IN CREATE METHOD");

			}
			}
				public boolean updatestudpwd(StudentDTO student) throws MyDataException
				{
					try{
					sdao.updateStudent(student);
					return true;
					
				} catch (Exception sql) {
					throw new MyDataException("ERROR IN CREATE METHOD");

				}
				
				
				
				
			}

}
