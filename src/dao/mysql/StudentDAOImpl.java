package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import dao.NoDataException;
import dao.StudentDAO;
import model.StudentDTO;

public class StudentDAOImpl implements StudentDAO
{

	private static HashSet<StudentDTO> StudentCache = new HashSet<StudentDTO>();

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
	 * @see dao.mysql.StudentDAO#createStudent(model.StudentDTO)
	 */
	@Override
	public int createStudent(StudentDTO student)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO student (studentID, lastName, firstMidName, enrolmentDate, email, password, status) VALUES (?, ?, ?, ?, ?, ?, 1);");
			ps.setInt(1, student.getStudentID());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getFirstMidName());
			ps.setDate(4, new java.sql.Date(student.getEnrolmentDate().getTime()));
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getPassword());
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
	 * @see dao.mysql.StudentDAO#updateStudent(model.StudentDTO)
	 */
	@Override
	public int updateStudent(StudentDTO student)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE student SET lastName = ?, firstMidName = ?, enrolmentDate = ?, email = ?, password = ? WHERE studentID = ? AND status = 1");
			ps.setInt(6, student.getStudentID());
			ps.setString(1, student.getLastName());
			ps.setString(2, student.getFirstMidName());
			ps.setDate(3, new java.sql.Date(student.getEnrolmentDate().getTime()));
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getPassword());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Update failed");
			else
			{
				if (StudentCache.contains(student))
				{
					for (StudentDTO st : StudentCache)
					{
						if (st.equals(student))
						{
							st.setLastName(student.getLastName());
							st.setFirstMidName(student.getFirstMidName());
							st.setEnrolmentDate(student.getEnrolmentDate());
							st.setEmail(student.getEmail());
							st.setPassword(student.getPassword());
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
	 * @see dao.mysql.StudentDAO#removeStudent(model.StudentDTO)
	 */
	@Override
	public int removeStudent(StudentDTO student)
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE student SET status = 1 WHERE studentID = ?");
			ps.setInt(1, student.getStudentID());
			if (ps.executeUpdate() != 1)
				throw new SQLException("Delete failed");
			else
				StudentCache.remove(student);
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
	 * @see dao.mysql.StudentDAO#findStudent(int)
	 */
	@Override
	public StudentDTO findStudent(int studentID)
	{
		for (StudentDTO st : StudentCache)
		{
			if (st.getStudentID() == studentID)
				return st;
		}
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM student WHERE studentID = ? AND status = 1");
			ps.setInt(1, studentID);
			ResultSet rs = ps.executeQuery();
			StudentDTO result = null;
			if (rs.next())
				result = new StudentDTO(rs.getInt("studentID"), rs.getString("lastName"), rs.getString("firstMidName"),
						rs.getDate("enrolmentDate"), rs.getString("email"), rs.getString("password"));
			else
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
	 * @see dao.mysql.StudentDAO#listAllstudent()
	 */
	@Override
	public ArrayList<StudentDTO> listAllstudent()
	{
		Connection conn = null;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE status = 1");
			ResultSet rs = ps.executeQuery();
			ArrayList<StudentDTO> result = new ArrayList<StudentDTO>();
			while (rs.next())
			{
				StudentDTO row = new StudentDTO(rs.getInt("studentID"), rs.getString("lastName"),
						rs.getString("firstMidName"), rs.getDate("enrolmentDate"), rs.getString("email"),
						rs.getString("password"));
				if (StudentCache.contains(row))
				{
					for (StudentDTO st : StudentCache)
					{
						if (st.equals(row))
						{
							result.add(st);
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
	 * @see dao.mysql.StudentDAO#getNextStudentID()
	 */
	@Override
	public int getNextStudentID()
	{
		Connection conn = null;
		int n = 0;
		try
		{
			conn = openConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(studentID) FROM student");
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
