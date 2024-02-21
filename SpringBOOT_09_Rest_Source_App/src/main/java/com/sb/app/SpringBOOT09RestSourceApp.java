package com.sb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBOOT09RestSourceApp {

	public static void main(final String[] args) {
		SpringApplication.run(SpringBOOT09RestSourceApp.class, args);
	}

}
