package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsAPI {

	@GetMapping("/wish")
	public ResponseEntity<String> showResultMsg(){
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
}
