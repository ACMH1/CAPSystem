package dao;

import java.util.ArrayList;

import model.CompletedDTO;

public interface CompletedDAO
{

	int createCompleted(CompletedDTO completed);

	int removeCompleted(CompletedDTO completed);

	CompletedDTO findCompletedByCourse(int courseID);

	CompletedDTO findCompletedByStudent(int studentID);

	ArrayList<CompletedDTO> listAllCompleted();

}