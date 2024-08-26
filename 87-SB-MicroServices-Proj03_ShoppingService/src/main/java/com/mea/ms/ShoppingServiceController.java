package com.mea.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.client.BillingServiceClientComp;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	
	@Autowired
	private BillingServiceClientComp clientComp;

	@GetMapping("/purchase")
	public ResponseEntity<String> shopping(){
		String resultMsg=clientComp.invokeDoPayment();
		//return final output
		String finalMsg="Shopping is done. "+resultMsg;
		return new ResponseEntity<String>(finalMsg,HttpStatus.OK);
	}
}
