package com.mea.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlayerControllerAdvice {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String>  handleIAE(IllegalArgumentException iae){
		return  new ResponseEntity<String>(iae.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>  handleAllExceptions(Exception e){
		return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
