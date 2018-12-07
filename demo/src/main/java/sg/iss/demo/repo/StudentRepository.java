package sg.iss.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.demo.model.Student;


public interface StudentRepository extends JpaRepository<Student, String> {
 
}
