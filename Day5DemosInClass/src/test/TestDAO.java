package test;

import java.sql.SQLException;


import dao.StudentDAO;
import model.Student;

public class TestDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Not Factory
		
		StudentDAO sdao = dao.DAOFactory.getStudentDAO();
		Student testStudent = new Student(4, "ADAM PNG YEE SOON", "Sweet&Bitter");
		int result = sdao.insertStudent(testStudent);
		System.out.println("Rows inserted" + result);
		for(Student current: sdao.findAllStudents()) {
			System.out.println(current.toString());
		}
		
	}

}
