package com.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.constants.GlobalConstants;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WelcomeController {

	// root mapping
	// some code for finding location
	// loggers

	@GetMapping(path=GlobalConstants.ROOT_MAPPING)
	public String welcomeMessage() {
		log.info(GlobalConstants.WELCOME_MESSAGE);
		return GlobalConstants.WELCOME_MESSAGE;
	}
}
