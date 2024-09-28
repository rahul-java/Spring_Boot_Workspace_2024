package com.mea.ms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employee-api")
public class EmployeeOperationsController {

	@GetMapping("report")
	public ResponseEntity<String> showReport() {
		return new ResponseEntity<String>("Employee Report",HttpStatus.OK);
	}
	
	
}
