package sg.iss.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
