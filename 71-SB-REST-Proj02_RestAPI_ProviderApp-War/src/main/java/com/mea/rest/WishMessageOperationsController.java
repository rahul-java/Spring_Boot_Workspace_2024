package com.mea.rest;

import java.time.LocalTime;
import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api")
public class WishMessageOperationsController {

	@GetMapping("wish")
	public ResponseEntity<String> showWishMessage(){
		System.out.println("WishMessageOperationsController.showWishMessage()");
		
		//get calendar class object
		LocalTime localTime = LocalTime.now();
		int hour=localTime.getHour();
		String msg=null;
		
		if(hour<12)
			msg="Good Morning";
		else if(hour<16)
			msg="Good AfterNoon";
		else if(hour<20)
			msg="Good Evening";
		else 
			msg="Good Night";
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	
}
