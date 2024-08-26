package com.mea.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingServiceController {

	@Value("${server.port}")
	private int portNo;
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/payment")
	public ResponseEntity<String> doPayment(){
		int amount=new Random().nextInt(1000000);
		return new ResponseEntity<String>("Bill Amount : "+amount+" ::: Payment Can Be Done By Card/UPI/NetBanking :::\n PortNo: "+portNo+" , Instance-Id : "+instanceId,HttpStatus.OK);
	}
}
