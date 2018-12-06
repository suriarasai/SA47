package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public interface StudentDAO {
	
	public ArrayList<Student> findAll();
	public Student findByNRIC(String nric);
	public int createStudent(Student s) ;
	public int updateStudent(Student s);
	public int removeStudent(String nric);
	

}
