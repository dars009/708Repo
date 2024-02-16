package com.sb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class StudentAspect {

	@Pointcut("execution(* com.sb.controller.StudentController.*(..))")
	public void StudentAround() {

	}
	
	@Around("StudentAround()")
	public void studentCommonMonitor(ProceedingJoinPoint pjp){
		log.info("APO studentCommonMonitor Method called"+ pjp.getArgs());
	}
	
	
	/*
	 * @Around("execution(* com.sb.controller.StudentController.*(..))") public void
	 * studentCommonMonitor1(){ log.info("APO studentCommonMonitor Method called");
	 * }
	 */
	
}
