package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.CourseDAOFactory;
import dao.EnrolmentDAO;
import dao.StudentDAO;
import dao.StudentDAOFactory;
import model.CourseDTO;
import model.EnrolmentDTO;
import model.StudentDTO;

public class EnrolmentDAOImpl implements EnrolmentDAO
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
	 * @see dao.mysql.EnrolmentDAO#createEnrolment(model.EnrolmentDTO)
	 */
	@Override
	public int createEnrolment(EnrolmentDTO enrolment)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO `capsdb`.`enrolment` (`studentID`, `courseID`) VALUES (?, ?);");
			ps.setInt(1, enrolment.getStudent().getStudentID());
			ps.setInt(2, enrolment.getCourse().getCourseID());
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
	 * @see dao.mysql.EnrolmentDAO#removeEnrolment(model.EnrolmentDTO)
	 */
	@Override
	public int removeEnrolment(EnrolmentDTO enrolment)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM `capsdb`.`enrolment` WHERE studentID = ? AND courseID = ?");
			ps.setInt(1, enrolment.getStudent().getStudentID());
			ps.setInt(2, enrolment.getCourse().getCourseID());
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
	 * @see dao.mysql.EnrolmentDAO#findEnrolmentByCourse(int)
	 */
	@Override
	public ArrayList<EnrolmentDTO> findEnrolmentByCourse(CourseDTO course)
	{
		Connection conn = null;
		try
		{
			StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
			CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `capsdb`.`enrolment` WHERE courseID = ?");
			ps.setInt(1, course.getCourseID());
			ResultSet rs = ps.executeQuery();
			ArrayList<EnrolmentDTO> result = new ArrayList<EnrolmentDTO>();
			while (rs.next())
			{
				EnrolmentDTO row = new EnrolmentDTO();
				row.setStudent(sd.findStudent(rs.getInt("studentID")));
				row.setCourse(cd.findCourse(rs.getInt("courseID")));
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
	 * @see dao.mysql.EnrolmentDAO#findEnrolmentByStudent(int)
	 */
	@Override
	public ArrayList<EnrolmentDTO> findEnrolmentByStudent(StudentDTO student)
	{
		Connection conn = null;
		try
		{
			StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
			CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `capsdb`.`enrolment` WHERE studentID = ?");
			ps.setInt(1, student.getStudentID());
			ResultSet rs = ps.executeQuery();
			ArrayList<EnrolmentDTO> result = new ArrayList<EnrolmentDTO>();
			while (rs.next())
			{
				EnrolmentDTO row = new EnrolmentDTO();
				row.setStudent(sd.findStudent(rs.getInt("studentID")));
				row.setCourse(cd.findCourse(rs.getInt("courseID")));
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
	 * @see dao.mysql.EnrolmentDAO#listAllEnrolment()
	 */
	@Override
	public ArrayList<EnrolmentDTO> listAllEnrolment()
	{
		Connection conn = null;
		try
		{
			StudentDAO sd = StudentDAOFactory.getStudentDAOInstance();
			CourseDAO cd = CourseDAOFactory.getCourseDAOInstance();
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `capsdb`.`enrolment`");
			ResultSet rs = ps.executeQuery();
			ArrayList<EnrolmentDTO> result = new ArrayList<EnrolmentDTO>();
			while (rs.next())
			{
				EnrolmentDTO row = new EnrolmentDTO(sd.findStudent(rs.getInt("studentID")),
						cd.findCourse(rs.getInt("courseID")));
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
