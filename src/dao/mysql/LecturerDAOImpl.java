package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.LecturerDAO;
import model.LecturerDTO;

public class LecturerDAOImpl implements LecturerDAO
{
	private Connection openConnection()
	{
		try
		{
			Class.forName(MYSQLConstants.DRIVER_CLASS);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(MYSQLConstants.URL, MYSQLConstants.USER, MYSQLConstants.PASSWORD);
			connection.setAutoCommit(false);
		} catch (SQLException e)
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
					"INSERT INTO `lecturer` (`lecturerID`, `lastName`, `firstMidName`, `email`, `password`) VALUES (?, ?, ?, ?, ?);");
			ps.setInt(1, lecturer.getLecturerID());
			ps.setString(2, lecturer.getLastName());
			ps.setString(3, lecturer.getFirstMidName());
			ps.setString(4, lecturer.getEmail());
			ps.setString(5, lecturer.getPassword());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Update failed");
			conn.commit();
			ps.close();
			conn.close();
			return 1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.rollback();
				conn.close();
				return 0;
			} catch (SQLException e1)
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
					"UPDATE `lecturer` SET `lastName` = ?, `firstMidName` = ?,`email` = ?, `password` = ? WHERE LecturerID = ?");
			ps.setInt(5, lecturer.getLecturerID());
			ps.setString(1, lecturer.getLastName());
			ps.setString(2, lecturer.getFirstMidName());
			ps.setString(3, lecturer.getEmail());
			ps.setString(4, lecturer.getPassword());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Update failed");
			conn.commit();
			ps.close();
			conn.close();
			return 1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.rollback();
				conn.close();
				return 0;
			} catch (SQLException e1)
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM `lecturer` WHERE LecturerID = ?");
			ps.setInt(1, lecturer.getLecturerID());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Delete failed");
			conn.commit();
			ps.close();
			conn.close();
			return 1;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.rollback();
				conn.close();
				return 0;
			} catch (SQLException e1)
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
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `lecturer` WHERE LecturerID = ?");
			ps.setInt(1, lecturerID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			LecturerDTO result = new LecturerDTO();
			result.setLecturerID(rs.getInt("lecturerID"));
			result.setLastName(rs.getString("lastName"));
			result.setFirstMidName(rs.getString("firstMidName"));
			result.setEmail(rs.getString("email"));
			result.setPassword(rs.getString("password"));
			ps.close();
			conn.close();
			return result;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.close();
				return null;
			} catch (SQLException e1)
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `lecturer`");
			ResultSet rs = ps.executeQuery();
			ArrayList<LecturerDTO> result = new ArrayList<LecturerDTO>();
			while (rs.next())
			{
				LecturerDTO row = new LecturerDTO(rs.getInt("lecturerID"), rs.getString("lastName"),
						rs.getString("firstMidName"), rs.getString("email"), rs.getString("password"));
				result.add(row);
			}
			ps.close();
			conn.close();
			return result;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.close();
				return null;
			} catch (SQLException e1)
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
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(lecturerID) FROM `lecturer`");
			ResultSet rs = ps.executeQuery();
			rs.next();
			n = rs.getInt(1) + 1;
			ps.close();
			conn.close();
			return n;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try
			{
				conn.close();
				return n;
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return n;
		}
	}
}
