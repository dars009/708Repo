package com.sbmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sbmvc.pojo.User;
import com.sbmvc.services.UserService;

// only navigation code 
@Controller
public class UserController {

	@Autowired
	UserService userServie;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute User user) {
		// get data
		System.out.println("login controller called");
		// process data - write service for the processing
		if (userServie.validateUser(user)) {
			System.out.println("User found in database");
			return new ModelAndView("dashboard", "Message", "Welcome to Dashboard Login Success !");
		} else {
			System.out.println("user not found");
			return new ModelAndView("index", "errorMessage", "UserNotFound in DB Login Fail !");
		}

	}

	@RequestMapping(path = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user) {
		// get data
		System.out.println("register controller called");
		// process data - write service for the processing
		userServie.saveUser(user);
		return new ModelAndView("login", "Message", "User Register Successfully !");
	}

}
