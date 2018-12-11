package sg.iss.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.demo.model.Enrolment;
import sg.iss.demo.model.Student;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {
	
	@Query ("Select e.student from Enrolment e where e.course.cid = :cid")
	ArrayList<Student> findStudentsEnrolledForCourse(@Param("cid") int cid);

	@Query ("Select e from Enrolment e where e.course.cid = :cid")
	ArrayList<Enrolment> findEnrolmentForCourse(@Param("cid") int cid);

}
