package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import dao.CourseDAO;
import dao.DAOFactory;
import dao.LecturerDAO;
import dao.NoDataException;
import model.CourseDTO;

public class CourseDAOImpl implements CourseDAO
{
	private static HashSet<CourseDTO> CourseCache = new HashSet<CourseDTO>();

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
	 * @see dao.mysql.CourseDAO#createCourse(model.CourseDTO)
	 */
	@Override
	public int createCourse(CourseDTO course)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO `course` (`courseID`, `courseName`, `size`, `credits`, `lecturerID`, `startDate`, `endDate`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, 1);");
			ps.setInt(1, course.getCourseID());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getSize());
			ps.setInt(4, course.getCredits());
			ps.setInt(5, course.getLecturer().getLecturerID());
			ps.setDate(6, new java.sql.Date(course.getStartDate().getTime()));
			ps.setDate(7, new java.sql.Date(course.getEndDate().getTime()));
			if (ps.executeUpdate() != 1)
				throw new SQLException("Insert failed");
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
	 * @see dao.mysql.CourseDAO#updateCourse(model.CourseDTO)
	 */
	@Override
	public int updateCourse(CourseDTO course)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE `course` SET `courseName` = ?, `size` = ?, `credits` = ?, `lecturerID` = ?, `startDate` = ?, `endDate` = ? WHERE CourseID = ? AND `status` = 1");
			ps.setInt(7, course.getCourseID());
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getSize());
			ps.setInt(3, course.getCredits());
			ps.setInt(4, course.getLecturer().getLecturerID());
			ps.setDate(5, new java.sql.Date(course.getStartDate().getTime()));
			ps.setDate(6, new java.sql.Date(course.getEndDate().getTime()));
			if (ps.executeUpdate() != 1)
				throw new SQLException("Update failed");
			else
			{
				if (CourseCache.contains(course))
				{
					for (CourseDTO ct : CourseCache)
					{
						if (ct.equals(course))
						{
							ct.setCourseName(course.getCourseName());
							ct.setSize(course.getSize());
							ct.setCredits(course.getCredits());
							ct.setLecturer(course.getLecturer());
							ct.setStartDate(course.getStartDate());
							ct.setEndDate(course.getEndDate());
							break;
						}
					}
				}
			}
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
	 * @see dao.mysql.CourseDAO#removeCourse(model.CourseDTO)
	 */
	@Override
	public int removeCourse(CourseDTO course)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `course` SET `status` = 0 WHERE CourseID = ?");
			ps.setInt(1, course.getCourseID());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Delete failed");
			else
				CourseCache.remove(course);
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
	 * @see dao.mysql.CourseDAO#findCourse(int)
	 */
	@Override
	public CourseDTO findCourse(int courseID)
	{
		for (CourseDTO ct : CourseCache)
		{
			if (ct.getCourseID() == courseID)
				return ct;
		}
		Connection conn = null;
		try
		{
			DAOFactory DF = DAOFactory.loadInstance();
			LecturerDAO ld = DF.getLecturerDAO();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `course` WHERE CourseID = ?");
			ps.setInt(1, courseID);
			ResultSet rs = ps.executeQuery();
			CourseDTO result = null;
			if (rs.next())
			{
				result = new CourseDTO(rs.getInt("courseID"), rs.getString("courseName"), rs.getInt("size"),
						rs.getInt("credits"), ld.findLecturer(rs.getInt("LecturerID")), rs.getDate("startDate"),
						rs.getDate("endDate"));
			} else
				throw new NoDataException();
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
	 * @see dao.mysql.CourseDAO#listAllCourse()
	 */
	@Override
	public ArrayList<CourseDTO> findCourseByLecturerID(int lecturerID)
	{
		Connection conn = null;
		try
		{
			DAOFactory DF = DAOFactory.loadInstance();
			LecturerDAO ld = DF.getLecturerDAO();
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM `course` WHERE `lecturerID` = ? AND `status` = 1");
			ps.setInt(1, lecturerID);
			ResultSet rs = ps.executeQuery();
			ArrayList<CourseDTO> result = new ArrayList<CourseDTO>();
			while (rs.next())
			{
				CourseDTO row = new CourseDTO(rs.getInt("courseID"), rs.getString("courseName"), rs.getInt("size"),
						rs.getInt("credits"), ld.findLecturer(rs.getInt("lecturerID")), rs.getDate("startDate"),
						rs.getDate("endDate"));
				if (CourseCache.contains(row))
				{
					for (CourseDTO ct : CourseCache)
					{
						if (ct.equals(row))
						{
							result.add(ct);
							break;
						}
					}
				} else
					result.add(row);
			}
			ps.close();
			conn.close();
			if (result.isEmpty())
				throw new NoDataException();
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
	 * @see dao.mysql.CourseDAO#listAllCourse()
	 */
	@Override
	public ArrayList<CourseDTO> listAllCourse()
	{
		Connection conn = null;
		try
		{
			DAOFactory DF = DAOFactory.loadInstance();
			LecturerDAO ld = DF.getLecturerDAO();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `course` WHERE `status` = 1");
			ResultSet rs = ps.executeQuery();
			ArrayList<CourseDTO> result = new ArrayList<CourseDTO>();
			while (rs.next())
			{
				CourseDTO row = new CourseDTO(rs.getInt("courseID"), rs.getString("courseName"), rs.getInt("size"),
						rs.getInt("credits"), ld.findLecturer(rs.getInt("lecturerID")), rs.getDate("startDate"),
						rs.getDate("endDate"));
				if (CourseCache.contains(row))
				{
					for (CourseDTO ct : CourseCache)
					{
						if (ct.equals(row))
						{
							result.add(ct);
							break;
						}
					}
				} else
					result.add(row);
			}
			ps.close();
			conn.close();
			if (result.isEmpty())
				throw new NoDataException();
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
	 * @see dao.mysql.CourseDAO#getNextCourseID()
	 */
	@Override
	public int getNextCourseID()
	{
		Connection conn = null;
		int n = 0;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(courseID) FROM `course`");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				n = rs.getInt(1) + 1;
			else
				throw new NoDataException();
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
