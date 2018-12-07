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

import edu.iss.cats.exception.RoleNotFound;
import edu.iss.cats.model.Role;
import edu.iss.cats.service.RoleService;
import edu.iss.cats.validator.RoleValidator;

@RequestMapping(value="/admin/role")
@Controller
public class AdminRoleController {
	@Autowired
	private RoleService rService;
	@Autowired
	private RoleValidator rValidator;

	@InitBinder("role")
	private void initRoleBinder(WebDataBinder binder) {
		binder.addValidators(rValidator);
	}

	/**
	 * ROLE CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newRolePage() {
		ModelAndView mav = new ModelAndView("role-new", "role", new Role());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewRole(@ModelAttribute @Valid Role role, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("role-new");

		ModelAndView mav = new ModelAndView();
		String message = "New role " + role.getRoleId() + " was successfully created.";

		rService.createRole(role);
		mav.setViewName("redirect:/admin/role/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView roleListPage() {
		ModelAndView mav = new ModelAndView("role-list");
		List<Role> roleList = rService.findAllRoles();
		mav.addObject("roleList", roleList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editRolePage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("role-edit");
		Role role = rService.findRole(id);
		mav.addObject("role", role);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editRole(@ModelAttribute @Valid Role role, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes) throws RoleNotFound {

		if (result.hasErrors())
			return new ModelAndView("role-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/role/list");
		String message = "Role was successfully updated.";

		rService.changeRole(role);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteRole(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws RoleNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/role/list");
		Role role = rService.findRole(id);
		rService.removeRole(role);
		String message = "The role " + role.getRoleId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
