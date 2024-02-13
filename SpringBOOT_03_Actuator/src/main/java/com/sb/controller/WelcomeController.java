package com.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	// root mapping
	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome to Springboot Application !";
	}
}
