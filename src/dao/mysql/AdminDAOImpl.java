package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import dao.AdminDAO;
import dao.NoDataException;
import model.AdminDTO;

public class AdminDAOImpl implements AdminDAO
{
	private static HashSet<AdminDTO> AdminCache = new HashSet<AdminDTO>();

	private Connection openConnection()
	{
		try
		{
			Class.forName(MYSQLConstants.DRIVER_CLASS);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(MYSQLConstants.URL, MYSQLConstants.USER, MYSQLConstants.PASSWORD);
			connection.setAutoCommit(false);
		}
		catch (SQLException e)
		{
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.AdminDAO#createAdmin(model.AdminDTO)
	 */
	@Override
	public int createAdmin(AdminDTO admin)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO admin (adminID, password, status) VALUES (?, ?, 1);");
			ps.setInt(1, admin.getAdminID());
			ps.setString(2, admin.getPassword());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Insert failed");
			conn.commit();
			ps.close();
			conn.close();
			return 1;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.rollback();
				conn.close();
				return 0;
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.AdminDAO#updateAdmin(model.AdminDTO)
	 */
	@Override
	public int updateAdmin(AdminDTO admin)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE admin SET password = ? WHERE AdminID = ? AND status = 1");
			ps.setInt(2, admin.getAdminID());
			ps.setString(1, admin.getPassword());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Update failed");
			else
			{
				if (AdminCache.contains(admin))
				{
					for (AdminDTO at : AdminCache)
					{
						if (at.equals(admin))
						{
							at.setPassword(admin.getPassword());
							break;
						}
					}
				}
			}
			conn.commit();
			ps.close();
			conn.close();
			return 1;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.rollback();
				conn.close();
				return 0;
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.AdminDAO#removeAdmin(model.AdminDTO)
	 */
	@Override
	public int removeAdmin(AdminDTO admin)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE admin SET status = 0 WHERE AdminID = ?");
			ps.setInt(1, admin.getAdminID());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Delete failed");
			else
				AdminCache.remove(admin);
			conn.commit();
			ps.close();
			conn.close();
			return 1;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.rollback();
				conn.close();
				return 0;
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.AdminDAO#findAdmin(int)
	 */
	@Override
	public AdminDTO findAdmin(int adminID)
	{
		for (AdminDTO at : AdminCache)
		{
			if (at.getAdminID() == adminID)
				return at;
		}
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM admin WHERE AdminID = ? AND status = 1");
			ps.setInt(1, adminID);
			ResultSet rs = ps.executeQuery();
			AdminDTO result = null;
			if (rs.next())
			{
				result = new AdminDTO();
				result.setAdminID(rs.getInt("adminID"));
				result.setPassword(rs.getString("password"));
				AdminCache.add(result);
			}
			else
				throw new NoDataException();
			ps.close();
			conn.close();
			return result;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.close();
				return null;
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.AdminDAO#listAllAdmin()
	 */
	@Override
	public ArrayList<AdminDTO> listAllAdmin()
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM admin WHERE status = 1");
			ResultSet rs = ps.executeQuery();
			ArrayList<AdminDTO> result = new ArrayList<AdminDTO>();
			while (rs.next())
			{
				AdminDTO row = new AdminDTO(rs.getInt("adminID"), rs.getString("password"));
				if (AdminCache.contains(row))
				{
					for (AdminDTO at : AdminCache)
					{
						if (at.equals(row))
						{
							result.add(at);
							break;
						}
					}
				}
				else
				{
					result.add(row);
					AdminCache.add(row);
				}
			}
			ps.close();
			conn.close();
			if (result.isEmpty())
				throw new NoDataException();
			return result;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.close();
				return null;
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.AdminDAO#getNextAdminID()
	 */
	@Override
	public int getNextAdminID()
	{
		Connection conn = null;
		int n = 0;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(adminID) FROM admin");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				n = rs.getInt(1) + 1;
			}
			else
				throw new NoDataException();
			ps.close();
			conn.close();
			return n;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.close();
				return n;
			}
			catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return n;
		}
	}
}
