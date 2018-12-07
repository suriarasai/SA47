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

import edu.iss.cats.exception.DepartmentNotFound;
import edu.iss.cats.model.Department;
import edu.iss.cats.service.DepartmentService;
import edu.iss.cats.service.EmployeeService;
import edu.iss.cats.validator.DepartmentValidator;

@RequestMapping(value="/admin/department")
@Controller
public class AdminDepartmentController {
	
	@Autowired
	private DepartmentService dService;
	@Autowired
	private EmployeeService eService;
 	@Autowired
	private DepartmentValidator dValidator;
 	
 	@InitBinder("department")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(dValidator);
	}
	/**
	 * DEPARTMENT CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newDepartmentPage() {
		ModelAndView mav = new ModelAndView("department-new", "department", new Department());
		mav.addObject("eidlist", eService.findAllEmployeeIDs());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewDepartment(@ModelAttribute @Valid Department department, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("department-new");

		ModelAndView mav = new ModelAndView();
		String message = "New department " + department.getDepartmentId() + " was successfully created.";

		dService.createDepartment(department);
		mav.setViewName("redirect:/admin/department/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView departmentListPage() {
		ModelAndView mav = new ModelAndView("department-list");
		List<Department> departmentList = dService.findAllDepartments();
		mav.addObject("departmentList", departmentList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDepartmentPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("department-edit");
		Department department = dService.findDepartment(id);
		mav.addObject("department", department);
		mav.addObject("eidlist", eService.findAllEmployeeIDs());
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editDepartment(@ModelAttribute @Valid Department department, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) throws DepartmentNotFound {

		if (result.hasErrors())
			return new ModelAndView("department-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/department/list");
		String message = "Department was successfully updated.";

		dService.changeDepartment(department);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws DepartmentNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/department/list");
		Department department = dService.findDepartment(id);
		dService.removeDepartment(department);
		String message = "The department " + department.getDepartmentId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
