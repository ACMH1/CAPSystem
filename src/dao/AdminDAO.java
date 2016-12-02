package dao;

import java.util.ArrayList;

import model.AdminDTO;

public interface AdminDAO
{

	int createAdmin(AdminDTO admin);

	int updateAdmin(AdminDTO admin);

	int removeAdmin(AdminDTO admin);

	AdminDTO findAdmin(int adminID);

	ArrayList<AdminDTO> listAllAdmin();

	int getNextAdminID();

}