package com.sbmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

	@RequestMapping(path = "/register")
	public String navToRegisterPage() {
		return "register";
	}
	
	@RequestMapping(path = "/navLogin")
	public String navToLoginPage() {
		return "login";
	}
}
