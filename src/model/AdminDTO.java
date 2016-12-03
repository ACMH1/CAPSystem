package model;

import java.io.Serializable;

public class AdminDTO implements Serializable
{
	private int adminID;
	private String password;

	public AdminDTO(int adminID, String password)
	{
		super();
		this.adminID = adminID;
		this.password = password;
	}

	public AdminDTO()
	{
		super();
	}

	public int getAdminID()
	{
		return adminID;
	}

	public void setAdminID(int adminID)
	{
		this.adminID = adminID;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
