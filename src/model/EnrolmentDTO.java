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

	@Override
	public boolean equals(Object that)
	{
		if (that == null)
			return false;
		else if (that == this)
			return true;
		else if (!(that instanceof CompletedDTO))
			return false;
		else
			return (this.getStudent().getStudentID() == ((CompletedDTO) that).getStudent().getStudentID()
					&& this.getCourse().getCourseID() == ((CompletedDTO) that).getCourse().getCourseID());
	}
}
