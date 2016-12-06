package model;

import java.io.Serializable;
import java.util.Date;

public class CourseDTO implements Serializable
{
	private int courseID;
	private String courseName;
	private int size;
	private int credits;
	private LecturerDTO lecturer;
	private Date startDate;
	private Date endDate;

	public CourseDTO(int courseID, String courseName, int size, int credits, LecturerDTO lecturer, Date startDate,
			Date endDate)
	{
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.size = size;
		this.credits = credits;
		this.lecturer = lecturer;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CourseDTO()
	{
		super();
	}

	public int getCourseID()
	{
		return courseID;
	}

	public void setCourseID(int courseID)
	{
		this.courseID = courseID;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getCredits()
	{
		return credits;
	}

	public void setCredits(int credits)
	{
		this.credits = credits;
	}

	public LecturerDTO getLecturer()
	{
		return lecturer;
	}

	public void setLecturer(LecturerDTO lecturer)
	{
		this.lecturer = lecturer;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object that)
	{
		if (that == null)
			return false;
		else if (that == this)
			return true;
		else if (!(that instanceof CourseDTO))
			return false;
		else
			return (this.getCourseID() == ((CourseDTO) that).getCourseID());
	}
}
