package edu.iss.cats.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import edu.iss.cats.exception.CourseNotFound;
import edu.iss.cats.model.Course;
import edu.iss.cats.model.CourseEvent;
import edu.iss.cats.service.CourseEventService;
import edu.iss.cats.service.CourseService;
import edu.iss.cats.validator.CourseValidator;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {
	@Autowired
	private CourseService cService;

	@Autowired
	private CourseValidator cValidator;

	@Autowired
	private CourseEventService ceService;

	@InitBinder("course")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.addValidators(cValidator);

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";

	}

	/**
	 * COURSE CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/history")
	public ModelAndView employeeCourseHistory(HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			mav = new ModelAndView("/staff-course-history");
			mav.addObject("chistory", cService.findCoursesByEID(us.getEmployee().getEmployeeId()));
			return mav;
		}
		return mav;

	}

	@RequestMapping(value = "/course/create", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("staff-course-new");
		mav.addObject("course", new Course());
		return mav;
	}

	@RequestMapping(value = "/course/create", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@ModelAttribute @Valid Course course, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("staff-course-new");

		ModelAndView mav = new ModelAndView();
		String message = "New course " + course.getCourseId() + " was successfully created.";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		course.setEmployeeId(us.getEmployee().getEmployeeId());
		course.setStatus(Course.SUBMITTED);
		mav.setViewName("redirect:/staff/history");
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setEventType(Course.SUBMITTED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.createCourse(course);
		ceService.createCourseEvent(ce);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("staff-course-edit");
		Course course = cService.findCourse(id);
		mav.addObject("course", course);
		return mav;
	}

	@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCourse(@ModelAttribute @Valid Course course, BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes, HttpSession session) throws CourseNotFound {
		if (result.hasErrors())
			return new ModelAndView("staff-course-edit");
		ModelAndView mav = new ModelAndView();
		System.out.println("DATES****" + course.getFromDate() + course.getToDate());
		String message = "New course " + course.getCourseId() + " was successfully created.";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		course.setEmployeeId(us.getEmployee().getEmployeeId());
		course.setStatus(Course.UPDATED);
		mav.setViewName("redirect:/staff/history");
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setEventType(Course.UPDATED);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.changeCourse(course);
		ceService.createCourseEvent(ce);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/course/withdraw/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable Integer id, final RedirectAttributes redirectAttributes,
			HttpSession session) throws CourseNotFound {

		ModelAndView mav = new ModelAndView("redirect:/staff/history");
		Course course = cService.findCourse(id);
		String message = "Course " + course.getCourseId() + " was successfully withdrawn.";
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		course.setStatus(Course.WITHDRAWN);
		CourseEvent ce = new CourseEvent();
		ce.setCourse(course);
		ce.setEventBy(us.getEmployee().getEmployeeId());
		ce.setEventType(Course.WITHDRAWN);
		ce.setTimeStamp(Calendar.getInstance().getTime());
		cService.changeCourse(course);
		ceService.createCourseEvent(ce);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
