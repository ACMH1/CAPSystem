package dao;

import java.util.ArrayList;

import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;

public interface EnrolmentDAO
{

	int createEnrolment(EnrolmentDTO enrolment);

	int removeEnrolment(EnrolmentDTO enrolment);

	ArrayList<EnrolmentDTO> findEnrolmentByCourse(CourseDTO course);

	ArrayList<EnrolmentDTO> findEnrolmentByStudent(StudentDTO student);

	ArrayList<EnrolmentDTO> listAllEnrolment();

}