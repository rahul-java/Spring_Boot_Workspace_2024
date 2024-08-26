package com.mea.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceClientComp {

	@Autowired
	private DiscoveryClient client;
	
	public String invokeDoPayment() {
		//get service instance representing provider ms from Eureka Server
		List<ServiceInstance> instanceList=client.getInstances("Billing-Service");
		//u need to pick the service instance manually
		ServiceInstance instance=instanceList.get(0);
		//get details from service instance
	    String url = instance.getUri()+"/billing-api/payment";
	    //create RestTemplate object
	    RestTemplate restTemplate = new RestTemplate();
	    //invoke the service of the provider ms 
	    String response = restTemplate.getForObject(url, String.class);
		return response;
	}
}
