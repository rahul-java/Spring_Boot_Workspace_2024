package com.mea.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingServiceController {

	@GetMapping("/payment")
	public ResponseEntity<String> doPayment(){
		int amount=new Random().nextInt(1000000);
		return new ResponseEntity<String>("Bill Amount : "+amount+", Payment Can Be Done By Card/UPI/NetBanking",HttpStatus.OK);
	}
}
