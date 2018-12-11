package sg.iss.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.demo.model.Course;
import sg.iss.demo.model.Enrolment;
import sg.iss.demo.model.Student;
import sg.iss.demo.services.EnrolmentService;

@Controller
@RequestMapping(value = "/extra")
public class ExtraController {

	@Autowired
	EnrolmentService eService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Course> clist = new ArrayList<Course>();
		ArrayList<Student> slist = new ArrayList<Student>();
		ArrayList<Enrolment> elist = new ArrayList<Enrolment>();
		ModelAndView mav = new ModelAndView("ExtraList");
		clist = eService.listCoursesTaughtByLecturer("S2345678E");
		slist = eService.listStudentsEnrolledForCourse(1);
		elist = eService.gradeCourse(5);
		mav.addObject("clist",clist);
		mav.addObject("slist",slist);
		mav.addObject("elist",elist);
		return mav;
	}
	

}
