package com.mea.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorApiConsumerTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//prepare base url
		String baseUrl="http://localhost:4041/providerApp/actor-api/wish";
		
		//send get mode req to consumer
		/*
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(baseUrl, String.class);
		System.out.println("Response Content ::: "+responseEntity.getBody());
		System.out.println("Response Status Code ::: "+responseEntity.getStatusCode());
		*/

		String response = restTemplate.getForObject(baseUrl, String.class);
		System.out.println("Response Content ::: "+response);		
		
		System.exit(0);
	}

}
