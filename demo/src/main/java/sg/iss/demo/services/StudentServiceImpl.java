package sg.iss.demo.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.demo.model.Student;
import sg.iss.demo.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	StudentRepository srepo;
	
	

	@Override
	@Transactional
	public ArrayList<Student> findAllStudents() {
		
		return (ArrayList<Student>) srepo.findAll();
	}

	@Override
	@Transactional
	public Student findStudent(String nric) {
		System.out.println("NRIC"+nric);
		
		Student student = srepo.findById(nric).get();
		System.out.println(student.toString());
		return student;

	}

	@Override
	@Transactional
	public Student createStudent(Student s) {
		return srepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public Student updateStudent(Student s) {
		return srepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public void removeStudent(Student s) {
		srepo.delete(s);
	}
	
	@Override
	@Transactional
	public ArrayList<Student> findStudentsByCriteria(Student student) {
		return null;
	}
	
	
	

}
