package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	//(name = {"abc1","abc2"})
	@Bean
	Student stu() {
		return new Student();
	}
	
	@Bean
	Address address() {
		return new Address();
	}
}
