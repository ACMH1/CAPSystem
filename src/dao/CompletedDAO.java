package dao;

import java.util.ArrayList;

import model.CompletedDTO;
import model.CourseDTO;
import model.StudentDTO;

public interface CompletedDAO
{

	int createCompleted(CompletedDTO completed);

	int removeCompleted(CompletedDTO completed);

	ArrayList<CompletedDTO> findCompletedByCourse(CourseDTO course);

	ArrayList<CompletedDTO> findCompletedByStudent(StudentDTO student);

	ArrayList<CompletedDTO> listAllCompleted();

}