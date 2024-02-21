package com.sb.constants;

public class GlobalConstants {

	private GlobalConstants() {
	}

	public static final String DEFAULT_MESSAGE = "Application UP and Running !";
	public static final String WELCOME_MAPPING = "/welcome";
	public static final String WELCOME_MESSAGE = "Welcome to Spring boot student Application !";
	
	public static final String FAIL_MAPPING = "/fail";
	public static final String FAIL_MESSAGE = "Application Failure !";

	
	public static final String ROOT_MAPPING = "/";

	public static final String STUDENT_CONTROLLER_MAPPING = "/student";
	public static final String STUDENT_ADD = "/addStudent";
	public static final String STUDENT_GET_ALL = "/getAllStudent";

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String LOGIN_FAIL_URL = "/fail";
	
	 public static final String[] ENDPOINTS_WHITELIST = {
	            "/css/**",
	            "/",
	            "/login",
	            "/home"
	    };
}
