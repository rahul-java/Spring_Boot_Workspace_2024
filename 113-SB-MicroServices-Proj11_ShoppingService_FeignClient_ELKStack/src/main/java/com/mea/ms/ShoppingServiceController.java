package com.mea.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.client.IBillingServiceClientComp;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shopping-api")
@Slf4j
public class ShoppingServiceController {
	
	@Autowired
	private IBillingServiceClientComp clientComp;

	@GetMapping("/purchase")
	public ResponseEntity<String> shopping(){
		log.debug("start of shopping method..");
		System.out.println("Client Component Class Object :: "+clientComp.getClass());
		String resultMsg=clientComp.invokeDoPayment();
		log.debug("Target ms is invoked");
		//return final output
		String finalMsg="Shopping is done. "+resultMsg;
		log.debug("final msg is generated");
		return new ResponseEntity<String>("<br>"+finalMsg,HttpStatus.OK);
	}
	
	@GetMapping("/purchase/{cardNo}")
	public ResponseEntity<String> shopping1(@PathVariable("cardNo") Long cardNo){
		log.debug("start of shopping method.. with cardNo");
		System.out.println("Client Component Class Object :: "+clientComp.getClass());
		String resultMsg=clientComp.invokeDoPayment1(cardNo);
		log.debug("Target ms is invoked with cardNo");
		//return final output
		String finalMsg="Shopping is done. "+resultMsg;
		log.debug("final msg is generated with cardNo");
		return new ResponseEntity<String>("<br>"+finalMsg,HttpStatus.OK);
	}
}
