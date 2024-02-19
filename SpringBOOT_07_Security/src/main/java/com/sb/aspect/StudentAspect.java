package com.sb.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class StudentAspect {

	@Before("execution(* com.sb.controller.*.*(..))")
	public void studentCommonMonitor1() {
		log.info("APO Controller Package Monitor");
	}

}
