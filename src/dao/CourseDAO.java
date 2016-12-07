package dao;

import java.util.ArrayList;

import model.CourseDTO;
import model.LecturerDTO;

public interface CourseDAO
{

	int createCourse(CourseDTO course);

	int updateCourse(CourseDTO course);

	int removeCourse(CourseDTO course);

	CourseDTO findCourse(int courseID);
	
	ArrayList<CourseDTO> findCourseByLecturer(LecturerDTO lecturer);

	ArrayList<CourseDTO> listAllCourse();

	int getNextCourseID();

}