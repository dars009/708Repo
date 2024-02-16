package com.sb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class WelcomeAspect {
	// access modifier - package - class - method -(parameters)- exceptions
	@Before("execution(* com.sb.controller.WelcomeController.welcomeMessage(..))")
	public void welcomeMessageMonitor() {
		log.info("AOP Before >> Welcome Controller called !!!!");
	}
	
	
	
}
