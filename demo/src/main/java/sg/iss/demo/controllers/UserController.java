package sg.iss.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.demo.model.User;
import sg.iss.demo.services.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<User> ulist = uservice.findAllUsers();
		ModelAndView mav = new ModelAndView("UserCRUD");
		mav.addObject("users", ulist);
		return mav;
		
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("UserNewForm", "user", new User());
		return mav;
		
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public ModelAndView newUserPage(@ModelAttribute User user) {
		uservice.updateUser(user);
		ArrayList<User> ulist = uservice.findAllUsers();
		ModelAndView mav = new ModelAndView("UserCRUD");
		mav.addObject("users", ulist);
		return mav;
		
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Long id) {
		User user = uservice.findUserById(id);
		ModelAndView mav = new ModelAndView("UserEditForm", "user", user);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUserPage(@PathVariable Long id, @ModelAttribute User user) {
		uservice.updateUser(user);
		ArrayList<User> ulist = uservice.findAllUsers();
		ModelAndView mav = new ModelAndView("UserCRUD");
		mav.addObject("users", ulist);
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Long id) {
		User user = uservice.findUserById(id);
		uservice.removeUser(user);
		ArrayList<User> ulist = uservice.findAllUsers();
		ModelAndView mav = new ModelAndView("UserCRUD");
		mav.addObject("users", ulist);
		return mav;
	}

}
