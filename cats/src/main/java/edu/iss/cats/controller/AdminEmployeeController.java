package edu.iss.cats.controller;

import java.util.List;

import javax.validation.Valid;

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

import edu.iss.cats.exception.EmployeeNotFound;
import edu.iss.cats.model.Employee;
import edu.iss.cats.service.EmployeeService;
import edu.iss.cats.validator.EmployeeValidator;

@RequestMapping("/admin/employee")
@Controller
public class AdminEmployeeController {

	@Autowired
	private EmployeeService eService;
	@Autowired
	private EmployeeValidator eValidator;

	@InitBinder("employee")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.addValidators(eValidator);
	}

	/**
	 * EMPLOYEE CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEmployeePage() {
		ModelAndView mav = new ModelAndView("employee-new", "employee", new Employee());
		mav.addObject("eidlist", eService.findAllEmployeeIDs());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEmployee(@ModelAttribute @Valid Employee employee, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("employee-new");

		ModelAndView mav = new ModelAndView();
		String message = "New employee " + employee.getEmployeeId() + " was successfully created.";

		eService.createEmployee(employee);
		mav.setViewName("redirect:/admin/employee/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView employeeListPage() {
		ModelAndView mav = new ModelAndView("employee-list");
		List<Employee> employeeList = eService.findAllEmployees();
		mav.addObject("employeeList", employeeList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployeePage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("employee-edit");
		Employee employee = eService.findEmployee(id);
		mav.addObject("employee", employee);
		mav.addObject("eidlist", eService.findAllEmployeeIDs());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute @Valid Employee employee, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) throws EmployeeNotFound {

		if (result.hasErrors())
			return new ModelAndView("employee-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/employee/list");
		String message = "Employee was successfully updated.";

		eService.changeEmployee(employee);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws EmployeeNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/employee/list");
		Employee employee = eService.findEmployee(id);
		eService.removeEmployee(employee);
		String message = "The employee " + employee.getEmployeeId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
