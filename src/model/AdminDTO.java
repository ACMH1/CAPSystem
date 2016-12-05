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

	@Override
	public boolean equals(Object that)
	{
		if (that == null)
			return false;
		else if (that == this)
			return true;
		else if (!(that instanceof AdminDTO))
			return false;
		else
			return (this.getAdminID() == ((AdminDTO) that).getAdminID());
	}
}
