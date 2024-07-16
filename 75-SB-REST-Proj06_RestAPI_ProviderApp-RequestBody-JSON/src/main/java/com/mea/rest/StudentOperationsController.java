package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.model.Student;

@RestController
@RequestMapping("/student")
public class StudentOperationsController {

	@PostMapping("/save")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		System.out.println("StudentOperationsController.registerStudent() ::: "+student);
		return new ResponseEntity<String>(student.toString(),HttpStatus.OK);
	}
}
