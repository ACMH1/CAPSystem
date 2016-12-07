package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import dao.AdminDAO;
import dao.DAOFactory;
import model.AdminDTO;

public class AdminManager {

	DAOFactory DF = DAOFactory.loadInstance();
	AdminDAO ad = DF.getAdminDAO();

	public boolean authenticate(int adminID, String pass, HttpServletRequest request) throws SQLException {

		boolean result = false;
		AdminDTO dto = ad.findAdmin(adminID);
		if (dto != null) {
			if (dto.getPassword().equals(pass)) {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}

}
