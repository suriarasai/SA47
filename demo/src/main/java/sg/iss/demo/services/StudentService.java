package sg.iss.demo.services;

import java.util.ArrayList;

import sg.iss.demo.model.Student;

public interface StudentService {

	ArrayList<Student> findAllStudents();

	Student findStudent(String nric);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);

	ArrayList<Student> findStudentsByCriteria(Student student);

}