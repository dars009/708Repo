package com.sb.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sb.model.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerUtil {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorResponse> StudentExceptionHandler(StudentNotFoundException e){
		ErrorResponse errRes = new ErrorResponse();
		errRes.setErrorMessage(e.getErrorMessage());
		errRes.setErrorCode(HttpStatus.NOT_FOUND.toString());
		errRes.setDate(new Date());
		return new ResponseEntity<ErrorResponse>(errRes, HttpStatus.NOT_FOUND);
	}
	
}
