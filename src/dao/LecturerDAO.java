package dao;

import java.util.ArrayList;

import model.LecturerDTO;

public interface LecturerDAO
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.LecturerDAO#createLecturer(dao.LecturerDTO)
	 */
	int createLecturer(LecturerDTO lecturer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.LecturerDAO#updateLecturer(dao.LecturerDTO)
	 */
	int updateLecturer(LecturerDTO lecturer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.LecturerDAO#removeLecturer(dao.LecturerDTO)
	 */
	int removeLecturer(LecturerDTO lecturer);

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.LecturerDAO#findLecturer(int)
	 */
	LecturerDTO findLecturer(int lecturerID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.LecturerDAO#listAllLecturer()
	 */
	ArrayList<LecturerDTO> listAllLecturer();

	int getNextLecturerID();

}