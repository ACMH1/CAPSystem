package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CompletedDAO;
import dao.CourseDAO;
import dao.CourseDAOFactory;
import dao.StudentDAO;
import dao.StudentDAOFactory;
import model.CompletedDTO;

public class CompletedDAOImpl implements CompletedDAO
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
	 * @see dao.mysql.CompletedDAO#createCompleted(model.CompletedDTO)
	 */
	@Override
	public int createCompleted(CompletedDTO completed)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO `capsdb`.`completed` (`studentID`, `courseID`, `grade`) VALUES (?, ?, ?);");
			ps.setInt(1, completed.getStudent().getStudentID());
			ps.setInt(2, completed.getCourse().getCourseID());
			ps.setInt(3, completed.getGrade());
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
	 * @see dao.mysql.CompletedDAO#removeCompleted(model.CompletedDTO)
	 */
	@Override
	public int removeCompleted(CompletedDTO completed)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM `capsdb`.`completed` WHERE studentID = ? AND courseID = ?");
			ps.setInt(1, completed.getStudent().getStudentID());
			ps.setInt(2, completed.getCourse().getCourseID());
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
	 * @see dao.mysql.CompletedDAO#findCompletedByCourse(int)
	 */
	@Override
	public CompletedDTO findCompletedByCourse(int courseID)
	{
		Connection conn = null;
		try
		{
			StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
			CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `capsdb`.`completed` WHERE courseID = ?");
			ps.setInt(1, courseID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			CompletedDTO result = new CompletedDTO();
			result.setStudent(sd.findStudent(rs.getInt("studentID")));
			result.setCourse(cd.findCourse(rs.getInt("courseID")));
			result.setGrade(rs.getInt("grade"));
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
	 * @see dao.mysql.CompletedDAO#findCompletedByStudent(int)
	 */
	@Override
	public CompletedDTO findCompletedByStudent(int studentID)
	{
		Connection conn = null;
		try
		{
			StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
			CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `capsdb`.`completed` WHERE studentID = ?");
			ps.setInt(1, studentID);
			ResultSet rs = ps.executeQuery();
			rs.next();
			CompletedDTO result = new CompletedDTO();
			result.setStudent(sd.findStudent(rs.getInt("studentID")));
			result.setCourse(cd.findCourse(rs.getInt("courseID")));
			result.setGrade(rs.getInt("grade"));
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
	 * @see dao.mysql.CompletedDAO#listAllCompleted()
	 */
	@Override
	public ArrayList<CompletedDTO> listAllCompleted()
	{
		Connection conn = null;
		try
		{
			StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
			CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `capsdb`.`completed`");
			ResultSet rs = ps.executeQuery();
			ArrayList<CompletedDTO> result = new ArrayList<CompletedDTO>();
			while (rs.next())
			{
				CompletedDTO row = new CompletedDTO(sd.findStudent(rs.getInt("studentID")),
						cd.findCourse(rs.getInt("courseID")), rs.getInt("grade"));
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
}