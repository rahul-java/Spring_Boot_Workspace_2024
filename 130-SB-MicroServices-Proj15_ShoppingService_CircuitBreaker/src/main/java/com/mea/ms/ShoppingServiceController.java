package com.mea.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.client.IBillingServiceClientComp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	
	@Autowired
	private IBillingServiceClientComp clientComp;

	@GetMapping("/purchase")
	@CircuitBreaker(name = "Shopping-Service",fallbackMethod = "billingFallback")
	public ResponseEntity<String> shopping(){
		System.out.println("Client Component Class Object :: "+clientComp.getClass());
		String resultMsg=clientComp.invokeDoPayment();
		//return final output
		String finalMsg="Shopping is done. "+resultMsg;
		return new ResponseEntity<String>("<br>"+finalMsg,HttpStatus.OK);
	}
	
	public ResponseEntity<String> billingFallback(Exception e){
		System.out.println("ShoppingServiceController.billingFallback()");
		return new ResponseEntity<String>("Billing Operation is out of service :::: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/purchase/{cardNo}")
	public ResponseEntity<String> shopping1(@PathVariable("cardNo") Long cardNo){
		System.out.println("Client Component Class Object :: "+clientComp.getClass());
		String resultMsg=clientComp.invokeDoPayment1(cardNo);
		//return final output
		String finalMsg="Shopping is done. "+resultMsg;
		return new ResponseEntity<String>("<br>"+finalMsg,HttpStatus.OK);
	}
}
