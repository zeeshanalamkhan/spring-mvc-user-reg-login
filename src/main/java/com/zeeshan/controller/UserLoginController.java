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
public class UserLoginController {

	@Autowired
	private UserDAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		String name = dao.loginUser(user);
		if (name != null) {
			mav.addObject("msg", "Welcome " + name + ", you have successfully logged in... !!!");
			mav.setViewName("welcome");
		} else {
			mav.addObject("msg", "Invalid user id or password..");
			mav.setViewName("login");
		}
		return mav;
	}
}
