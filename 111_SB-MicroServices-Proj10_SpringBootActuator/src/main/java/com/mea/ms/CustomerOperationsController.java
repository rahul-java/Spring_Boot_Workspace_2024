package com.mea.ms;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer-api")
@Slf4j
public class CustomerOperationsController {
	
	@GetMapping("/cust-data")
	public ResponseEntity<String> showData(){
		log.debug("From the begining of show data msg....");
		return new ResponseEntity<String>("Showing Customer info Details :: ",HttpStatus.OK);
	}
	
	@Scheduled(cron = "10 * * * * *")
	public void showReport() {
		System.out.println("Report on :: "+new Date());
	}
}
