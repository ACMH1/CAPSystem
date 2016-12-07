package model;

import java.io.Serializable;

public class EnrolmentDTO implements Serializable
{
	private StudentDTO student;
	private CourseDTO course;

	public EnrolmentDTO()
	{
		super();
	}

	public EnrolmentDTO(StudentDTO student, CourseDTO course)
	{
		super();
		this.student = student;
		this.course = course;
	}

	public StudentDTO getStudent()
	{
		return student;
	}

	public void setStudent(StudentDTO student)
	{
		this.student = student;
	}

	public CourseDTO getCourse()
	{
		return course;
	}

	public void setCourse(CourseDTO course)
	{
		this.course = course;
	}
}
