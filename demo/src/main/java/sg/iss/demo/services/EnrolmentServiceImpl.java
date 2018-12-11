package sg.iss.demo.services;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.iss.demo.model.Course;
import sg.iss.demo.model.Enrolment;
import sg.iss.demo.model.Student;
import sg.iss.demo.repo.CourseRepository;
import sg.iss.demo.repo.EnrolmentRepository;
import sg.iss.demo.repo.LecturerRepository;
import sg.iss.demo.repo.StudentRepository;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {
	
	@Resource
	StudentRepository srepo;
	
	@Resource
	LecturerRepository lrepo;
	
	@Resource
	EnrolmentRepository erepo;
	
	@Resource
	CourseRepository crepo;

	@Override
	@Transactional
	public ArrayList<Course> listCoursesTaughtByLecturer(String lnric) {	
		return crepo.findCoursesByLNRIC(lnric);
	}

	@Override
	@Transactional
	public ArrayList<Student> listStudentsEnrolledForCourse(int cid) {
		return erepo.findStudentsEnrolledForCourse(cid);
	}

	@Override
	@Transactional
	public ArrayList<Enrolment> gradeCourse(int cid) {
		return erepo.findEnrolmentForCourse(cid);
	}

}
