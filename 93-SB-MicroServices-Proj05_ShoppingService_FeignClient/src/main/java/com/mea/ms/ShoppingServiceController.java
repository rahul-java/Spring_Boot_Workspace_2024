package com.mea.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.client.IBillingServiceClientComp;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	
	@Autowired
	private IBillingServiceClientComp clientComp;

	@GetMapping("/purchase")
	public ResponseEntity<String> shopping(){
		System.out.println("Client Component Class Object :: "+clientComp.getClass());
		String resultMsg=clientComp.invokeDoPayment();
		//return final output
		String finalMsg="Shopping is done. "+resultMsg;
		return new ResponseEntity<String>("<br>"+finalMsg,HttpStatus.OK);
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
