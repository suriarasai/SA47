package sg.iss.demo.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("SELECT c from Course c WHERE c.lecturer.nric = :lnric")
	ArrayList<Course> findCoursesByLNRIC(@Param("lnric") String lnric);

}
