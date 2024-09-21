package com.mea.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing-api")
@Slf4j
public class BillingServiceController {

	@Value("${server.port}")
	private int portNo;
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/payment")
	public ResponseEntity<String> doPayment(){

		log.debug("from doPament() method");
		int amount=new Random().nextInt(1000000);
		log.debug("amount generated");
		return new ResponseEntity<String>("Bill Amount : "+amount+" ::: Payment Can Be Done By Card/UPI/NetBanking :::\n PortNo: "+portNo+" , Instance-Id : "+instanceId,HttpStatus.OK);
	}
	
	@GetMapping("/payment/{cardNo}")
	public ResponseEntity<String> doPayment1(@PathVariable("cardNo") Long cardNo){
		log.debug("from doPament() method with cardNo");
		int amount=new Random().nextInt(1000000);
		log.debug("amount generated with cardNo");
		return new ResponseEntity<String>("Bill Amount : "+amount+" ::: Payment Can Be Done By Card No: "+cardNo+" PortNo: "+portNo+" , Instance-Id : "+instanceId,HttpStatus.OK);
	}
}
