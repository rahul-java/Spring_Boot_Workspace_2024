package com.mea.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceClientComp {

	@Autowired
	private LoadBalancerClient client;
	
	public String invokeDoPayment() {
		//get service instance obj representing provider ms from Eureka Server having less load factor
		ServiceInstance instance=client.choose("Billing-Service");
		//get details from service instance
	    String url = instance.getUri()+"/billing-api/payment";
	    //create RestTemplate object
	    RestTemplate restTemplate = new RestTemplate();
	    //invoke the service of the provider ms 
	    String response = restTemplate.getForObject(url, String.class);
		return response;
	}
}
