package edu.iss.cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.cats.model.CourseEvent;

public interface CourseEventRepository extends JpaRepository<CourseEvent, Integer>{

}
