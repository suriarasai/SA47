package edu.iss.cats.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.cats.javabeans.Approve;
import edu.iss.cats.model.Course;
import edu.iss.cats.model.CourseEvent;
import edu.iss.cats.model.Employee;
import edu.iss.cats.service.CourseEventService;
import edu.iss.cats.service.CourseService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	private CourseService cService;

	@Autowired
	private CourseEventService ceService;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		//binder.setValidator(studentValidator);
	}
	
	@RequestMapping(value = "/pending")
	public ModelAndView pendingApprovals(HttpSession session) {
		HashMap<Employee, ArrayList<Course>> hm = new HashMap<Employee, ArrayList<Course>>();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		System.out.println(us.toString());
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			for (Employee employee : us.getSubordinates()) {
				ArrayList<Course> clist = cService.findPendingCoursesByEID(employee.getEmployeeId());
				hm.put(employee, clist);
			}
			mav = new ModelAndView("manager-pending-course-history");
			mav.addObject("pendinghistory", hm);
			return mav;
		}
		return mav;

	}
	
	@RequestMapping(value = "/shistory")
	public ModelAndView subordinatesHistory(HttpSession session) {
		
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		HashMap<Employee, ArrayList<Course>> submap = new HashMap<Employee, ArrayList<Course>>();		
		for (Employee subordinate : us.getSubordinates()) {
			submap.put(subordinate, cService.findCoursesByEID(subordinate.getEmployeeId()));
		}
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null && us.getSubordinates() != null) {
			mav = new ModelAndView("/subordinates-course-history");
			mav.addObject("submap", submap);
			return mav;
		}
		return mav;
		

	}

	@RequestMapping(value = "/course/display/{id}", method = RequestMethod.GET)
	public ModelAndView newDepartmentPage(@PathVariable int id) {
		Course course = cService.findCourse(id);
		ModelAndView mav = new ModelAndView("manager-course-detail", "course", course);
		mav.addObject("approve", new Approve());
		return mav;
	}

	@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectCourse(@ModelAttribute("approve") Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("manager-course-detail");
		Course c = cService.findCourse(id);
		CourseEvent ce = new CourseEvent();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		if (approve.getDecision().equalsIgnoreCase(Course.APPROVED)) {
			ce.setEventType(Course.APPROVED);
			c.setStatus(Course.APPROVED);
		} else {
			ce.setEventType(Course.REJECTED);
			c.setStatus(Course.REJECTED);
		}
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setComment(approve.getComment());
		ce.setTimeStamp(Calendar.getInstance().getTime());
		ce.setCourse(c);
		ArrayList<CourseEvent> celist = c.getEvents();
		celist.add(ce);
		c.setEvents(celist);
		System.out.println(c.toString());
		cService.changeCourse(c);
		ceService.createCourseEvent(ce);
		ModelAndView mav = new ModelAndView("redirect:/manager/pending");
		String message = "Course was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
