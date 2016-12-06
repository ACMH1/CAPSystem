package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import dao.LecturerDAO;
import dao.NoDataException;
import model.LecturerDTO;

public class LecturerDAOImpl implements LecturerDAO
{

	private static HashSet<LecturerDTO> LecturerCache = new HashSet<LecturerDTO>();

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
	 * @see dao.mysql.LecturerDAO#createLecturer(dao.LecturerDTO)
	 */
	@Override
	public int createLecturer(LecturerDTO lecturer)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO lecturer (lecturerID, lastName, firstMidName, email, password, status) VALUES (?, ?, ?, ?, ?, 1);");
			ps.setInt(1, lecturer.getLecturerID());
			ps.setString(2, lecturer.getLastName());
			ps.setString(3, lecturer.getFirstMidName());
			ps.setString(4, lecturer.getEmail());
			ps.setString(5, lecturer.getPassword());
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
	 * @see dao.mysql.LecturerDAO#updateLecturer(dao.LecturerDTO)
	 */
	@Override
	public int updateLecturer(LecturerDTO lecturer)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE lecturer SET lastName = ?, firstMidName = ?,email = ?, password = ? WHERE LecturerID = ? AND status = 1");
			ps.setInt(5, lecturer.getLecturerID());
			ps.setString(1, lecturer.getLastName());
			ps.setString(2, lecturer.getFirstMidName());
			ps.setString(3, lecturer.getEmail());
			ps.setString(4, lecturer.getPassword());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Update failed");
			else
			{
				if (LecturerCache.contains(lecturer))
				{
					for (LecturerDTO lt : LecturerCache)
					{
						if (lt.equals(lecturer))
						{
							lt.setLastName(lecturer.getLastName());
							lt.setFirstMidName(lecturer.getFirstMidName());
							lt.setEmail(lecturer.getEmail());
							lt.setPassword(lecturer.getPassword());
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
	 * @see dao.mysql.LecturerDAO#removeLecturer(dao.LecturerDTO)
	 */
	@Override
	public int removeLecturer(LecturerDTO lecturer)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE lecturer SET status = 0 WHERE LecturerID = ?");
			ps.setInt(1, lecturer.getLecturerID());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Delete failed");
			else
				LecturerCache.remove(lecturer);
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
	 * @see dao.mysql.LecturerDAO#findLecturer(int)
	 */
	@Override
	public LecturerDTO findLecturer(int lecturerID)
	{
		for (LecturerDTO lt : LecturerCache)
		{
			if (lt.getLecturerID() == lecturerID)
				return lt;
		}
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lecturer WHERE LecturerID = ? AND status = 1");
			ps.setInt(1, lecturerID);
			ResultSet rs = ps.executeQuery();
			LecturerDTO result = null;
			if (rs.next())
			{
				result = new LecturerDTO(rs.getInt("lecturerID"), rs.getString("lastName"),
						rs.getString("firstMidName"), rs.getString("email"), rs.getString("password"));
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
	 * @see dao.mysql.LecturerDAO#listAllLecturer()
	 */
	@Override
	public ArrayList<LecturerDTO> listAllLecturer()
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lecturer WHERE status = 1");
			ResultSet rs = ps.executeQuery();
			ArrayList<LecturerDTO> result = new ArrayList<LecturerDTO>();
			while (rs.next())
			{
				LecturerDTO row = new LecturerDTO(rs.getInt("lecturerID"), rs.getString("lastName"),
						rs.getString("firstMidName"), rs.getString("email"), rs.getString("password"));
				if (LecturerCache.contains(row))
				{
					for (LecturerDTO lt : LecturerCache)
					{
						if (lt.equals(row))
						{
							result.add(lt);
							break;
						}
					}
				}
				else
				{
					result.add(row);
					LecturerCache.add(row);
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
	 * @see dao.mysql.LecturerDAO#getNextLecturerID()
	 */
	@Override
	public int getNextLecturerID()
	{
		Connection conn = null;
		int n = 0;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(lecturerID) FROM lecturer");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				n = rs.getInt(1) + 1;
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
