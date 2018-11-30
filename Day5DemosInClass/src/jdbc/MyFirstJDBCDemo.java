package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import student.Student;



public class MyFirstJDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// 1. Driver
		Class.forName("com.mysql.jdbc.Driver");
		// 2. DB Connection
		String url ="jdbc:mysql://localhost:3306/sa47";
		String user="root";
		String password = "password";
		Connection connection = DriverManager.getConnection(url, user, password);
		// 3. Create Statement
		Statement statement = connection.createStatement();
		// Statment PreparedStatement (??) CallableStatement (Stored Procedures)
		// 4. Select Query
		ResultSet rs = statement.executeQuery("SELECT * FROM sa47.student;");
		// 5. Process
		while (rs.next()) {
			Student student = new Student(rs.getInt("id"),rs.getString("name"), rs.getString("naick"));
			System.out.println(student.toString());
		}
		statement.close();
		connection.close();
		

	}

}
