package model;

import java.io.Serializable;

public class LecturerDTO implements Serializable
{

	private int lecturerID;
	private String lastName;
	private String firstMidName;
	private String email;
	private String password;

	public LecturerDTO(int lecturerID, String lastName, String firstMidName, String email, String password)
	{
		super();
		this.lecturerID = lecturerID;
		this.lastName = lastName;
		this.firstMidName = firstMidName;
		this.email = email;
		this.password = password;
	}

	public LecturerDTO()
	{
		// TODO Auto-generated constructor stub
	}

	public int getLecturerID()
	{
		return lecturerID;
	}

	public void setLecturerID(int lecturerID)
	{
		this.lecturerID = lecturerID;
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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
			return (this.getLecturerID() == ((LecturerDTO) that).getLecturerID());
	}
}
