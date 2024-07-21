package com.mea.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorApiConsumerTestRunner2 implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		//RestTemplate restTemplate = new RestTemplate();
		
		String baseUrl2="http://localhost:4041/providerApp/actor-api/wish/{id}/{name}";
		//String response = restTemplate.getForObject(baseUrl2, String.class,1001,"Raja");
		String response = restTemplate.getForObject(baseUrl2, String.class,Map.of("name","Raja","id","1001"));
		System.out.println("Response Content ::: "+response);		
		
	}

}
