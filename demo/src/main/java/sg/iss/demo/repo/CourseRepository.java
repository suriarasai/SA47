package sg.iss.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
