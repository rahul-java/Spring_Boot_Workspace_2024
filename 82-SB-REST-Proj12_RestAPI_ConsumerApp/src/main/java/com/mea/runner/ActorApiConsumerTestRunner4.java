package com.mea.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mea.model.Actor;

@Component
public class ActorApiConsumerTestRunner4 implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:4041/providerApp/actor-api/report";
		//send get mode request
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
		//ResponseEntity<Actor> response = restTemplate.getForEntity(baseUrl, Actor.class);
		
		System.out.println("Response Content ::: "+response.getBody());		
		System.out.println("Status Code ::: "+response.getStatusCode());		
		System.out.println("Response ::: "+response);	
		
		/*
		restTemplate.getForEntity(null, null); //Get Mode Request
		restTemplate.postForEntity(null, response, null); //Post Mode Request
		restTemplate.put(baseUrl, response, null); //Put Mode Request
		restTemplate.patchForObject(null, response, null); //Patch Mode Request
		restTemplate.delete(baseUrl, args); //Delete Mode Request
		*/
		
	}

}
