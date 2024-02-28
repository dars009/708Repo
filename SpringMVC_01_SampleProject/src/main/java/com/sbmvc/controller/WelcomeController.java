package com.sbmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	
	@RequestMapping("/")
	public String welcomeMessage() {
	
		// get data 
		
		// process data 
		
		
		// navigate data
		// it will look for the view
		return "index";
	}
	
	 
}
