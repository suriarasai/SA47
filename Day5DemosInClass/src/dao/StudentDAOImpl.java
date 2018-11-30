package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/sa47";
	private static final String user = "root";
	private static final String password = "password";

	/* (non-Javadoc)
	 * @see dao.StudentDAO#findAllStudents()
	 */
	@Override
	public ArrayList<Student> findAllStudents() throws ClassNotFoundException, SQLException {
		ArrayList<Student> slist = new ArrayList<Student>();
		// 1. Driver
		Class.forName(driver);
		// 2. DB Connection
		Connection connection = DriverManager.getConnection(url, user, password);
		// 3. Create Statement
		Statement statement = connection.createStatement();
		// 4. Select Query
		ResultSet rs = statement.executeQuery("SELECT * FROM sa47.student;");
		// 5. Process
		while (rs.next()) {
			Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("naick"));
			//System.out.println(model.toString());
			slist.add(student);
		}
		statement.close();
		connection.close();
		return slist;
	}

	/* (non-Javadoc)
	 * @see dao.StudentDAO#insertStudent(model.Student)
	 */
	@Override
	public int insertStudent(Student s) throws ClassNotFoundException, SQLException {
		// 1. Driver
		Class.forName(driver);
		// 2. DB Connection
		Connection connection = DriverManager.getConnection(url, user, password);
		// 3. Create Statement
		Statement statement = connection.createStatement();
		// 4. Result is int - affected rows
		String insertQuery = "INSERT INTO sa47.student(id, name, naick) VALUES ("
				             + s.getId() + ", \""
				             + s.getName() + "\", \""
				             + s.getNick() + "\");";
		int result = statement.executeUpdate(insertQuery);
		statement.close();
		connection.close();
		return result;

	}

	/* (non-Javadoc)
	 * @see dao.StudentDAO#updateStudent(model.Student)
	 */
	@Override
	public int updateStudent(Student s) throws ClassNotFoundException, SQLException {
		// For you to complete and have fun
		return 0;
	}

	/* (non-Javadoc)
	 * @see dao.StudentDAO#deleteStudent(model.Student)
	 */
	@Override
	public int deleteStudent(Student s) throws ClassNotFoundException, SQLException {
		// For you to complete and have fun
		return 0;
	}

}
