package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public interface StudentDAO {

	ArrayList<Student> findAllStudents() throws ClassNotFoundException, SQLException;

	int insertStudent(Student s) throws ClassNotFoundException, SQLException;

	int updateStudent(Student s) throws ClassNotFoundException, SQLException;

	int deleteStudent(Student s) throws ClassNotFoundException, SQLException;

}