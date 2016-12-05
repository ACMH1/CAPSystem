package dao;

import java.util.ArrayList;

import model.LecturerDTO;

public interface LecturerDAO
{

	int createLecturer(LecturerDTO lecturer);

	int updateLecturer(LecturerDTO lecturer);

	int removeLecturer(LecturerDTO lecturer);

	LecturerDTO findLecturer(int lecturerID);

	ArrayList<LecturerDTO> listAllLecturer();

	int getNextLecturerID();

}