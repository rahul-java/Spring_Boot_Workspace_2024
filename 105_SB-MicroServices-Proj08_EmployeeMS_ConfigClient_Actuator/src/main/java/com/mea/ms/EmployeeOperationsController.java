package com.mea.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-api")
@RefreshScope
public class EmployeeOperationsController {

	@Value("${dbuser}")
	private String uname;
	@Value("${dbpwd}")
	private String upwd;
	
	@GetMapping("/emp-data")
	public ResponseEntity<String> showData(){
		return new ResponseEntity<String>("Employee MS Data is : Uname : "+uname+" , Pwd : "+upwd,HttpStatus.OK);
	}
}
