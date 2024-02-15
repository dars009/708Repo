package com.sb.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentNotFoundException extends RuntimeException {

	String errorMessage;

	public StudentNotFoundException(String message) {
		super();
		this.errorMessage = message;
	}

}
