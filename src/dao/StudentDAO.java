package dao;

import java.util.ArrayList;

import model.StudentDTO;

public interface StudentDAO
{

	int createStudent(StudentDTO student);

	int updateStudent(StudentDTO student);

	int removeStudent(StudentDTO student);

	StudentDTO findStudent(int studentID);

	ArrayList<StudentDTO> listAllStudent();

	int getNextStudentID();

}