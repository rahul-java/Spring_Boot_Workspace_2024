package com.mea.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorApiConsumerTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
		//RestTemplate restTemplate = new RestTemplate();
		
		//prepare base url
		String baseUrl="http://localhost:4041/providerApp/actor-api/wish";
		
		//send get mode req to consumer by getForEntity
		ResponseEntity<String> response = restTemplate.exchange(baseUrl,HttpMethod.GET,null,String.class);		
		System.out.println("Response Content ::: "+response.getBody());		
		System.out.println("Response StatusCode ::: "+response.getStatusCode());		
		
		
	}

}
