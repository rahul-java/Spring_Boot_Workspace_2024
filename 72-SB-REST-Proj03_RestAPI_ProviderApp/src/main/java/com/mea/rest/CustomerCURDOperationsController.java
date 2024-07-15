package com.mea.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerCURDOperationsController {

	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(){
		return new ResponseEntity<String>("Customer is saved",HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<String> showReport(){
		return new ResponseEntity<String>("Gives all the Customer Info.",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
		return new ResponseEntity<String>("Customer is updated",HttpStatus.OK);
	}
	
	@PatchMapping("/partial-update")
	public ResponseEntity<String> updateCustomerEmail(){
		return new ResponseEntity<String>("Customer Email is updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		return new ResponseEntity<String>("Customer is deleted",HttpStatus.OK);
	}
	
}
