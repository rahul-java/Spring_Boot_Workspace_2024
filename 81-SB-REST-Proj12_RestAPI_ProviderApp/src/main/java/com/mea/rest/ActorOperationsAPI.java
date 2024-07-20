package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsAPI {

	@GetMapping("/wish")
	public ResponseEntity<String> showResultMsg(){
		return new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> showResultMsg1(@PathVariable Integer id,@PathVariable String name){
		return new ResponseEntity<String>("Good Morning : "+id+" ::: "+name,HttpStatus.OK);
	}
}
