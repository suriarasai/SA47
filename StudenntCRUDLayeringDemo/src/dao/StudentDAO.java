package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public interface StudentDAO {

	public ArrayList<Student> findAll();

	public Student findByID(int id);

	public int createStudent(Student s);

	public int updateStudent(Student s);

	public int removeStudent(int id);

}
