package com.zeeshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zeeshan.dao.UserDAO;
import com.zeeshan.model.User;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserDAO dao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("userId") String userId,
			@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		int counter = dao.registerUser(user);
		if (counter > 0) {
			mav.addObject("msg", "User Registration Successfull... !!");
		} else {
			mav.addObject("msg", "Error -  check the console log");
		}
		mav.setViewName("registration");
		return mav;
	}
}
