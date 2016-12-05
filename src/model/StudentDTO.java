package model;

import java.io.Serializable;
import java.util.Date;

public class StudentDTO implements Serializable
{

	private int studentID;
	private String lastName;
	private String firstMidName;
	private Date enrolmentDate;
	private String email;
	private String password;

	public StudentDTO()
	{
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(int studentID, String lastName, String firstMidName, Date enrolmentDate, String email,
			String password)
	{
		super();
		this.studentID = studentID;
		this.lastName = lastName;
		this.firstMidName = firstMidName;
		this.enrolmentDate = enrolmentDate;
		this.email = email;
		this.password = password;
	}

	public int getStudentID()
	{
		return studentID;
	}

	public void setStudentID(int studentID)
	{
		this.studentID = studentID;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFirstMidName()
	{
		return firstMidName;
	}

	public void setFirstMidName(String firstMidName)
	{
		this.firstMidName = firstMidName;
	}

	public Date getEnrolmentDate()
	{
		return enrolmentDate;
	}

	public void setEnrolmentDate(Date enrolmentDate)
	{
		this.enrolmentDate = enrolmentDate;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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
			return (this.getStudentID() == ((StudentDTO) that).getStudentID());
	}
}
