package com.mea.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/customer-api")
public class CustomerOperationsController {

	@Value("${dbuser}")
	private String uname;
	@Value("${dbpwd}")
	private String upwd;
	
	@GetMapping("/cust-data")
	public ResponseEntity<String> showData(){
		return new ResponseEntity<String>("Customer MS Data is : Uname : "+uname+" , Pwd : "+upwd,HttpStatus.OK);
	}
}
