package com.mea.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		super();
		System.out.println("EmployeeNotFoundException.EmployeeNotFoundException()");
		
	}
	
	 public EmployeeNotFoundException(String msg){
		 super(msg);
		 System.err.println("EmployeeNotFoundException ::: 1-param-constructor");
	 }
}
