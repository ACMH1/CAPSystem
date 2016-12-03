package model;

import java.io.Serializable;

public class CompletedDTO implements Serializable
{
	private StudentDTO student;
	private CourseDTO course;
	private int grade;

	public CompletedDTO(StudentDTO student, CourseDTO course, int grade)
	{
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	public CompletedDTO()
	{
		super();
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

	public int getGrade()
	{
		return grade;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

}
