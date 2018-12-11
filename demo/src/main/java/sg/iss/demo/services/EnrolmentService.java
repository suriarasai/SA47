package sg.iss.demo.services;

import java.util.ArrayList;

import sg.iss.demo.model.Course;
import sg.iss.demo.model.Enrolment;
import sg.iss.demo.model.Student;

public interface EnrolmentService {
	
	public ArrayList<Course> listCoursesTaughtByLecturer(String lnric);
	public ArrayList<Student> listStudentsEnrolledForCourse(int cid);
	public ArrayList<Enrolment> gradeCourse(int cid);

}
