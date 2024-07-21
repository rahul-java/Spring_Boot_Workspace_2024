package com.mea.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mea.model.Actor;

//@Component
public class ActorApiConsumerTestRunner4 implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:4041/providerApp/actor-api/report";
		//send get mode request
		//ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
		//ResponseEntity<Actor> response = restTemplate.getForEntity(baseUrl, Actor.class);
		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET,null,String.class);
		
		System.out.println("Response Content ::: "+response.getBody());		
		System.out.println("Status Code ::: "+response.getStatusCode());		
		System.out.println("Response ::: "+response);	
		
		//Use JACKSON API to convert JSON String content into Java class object
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(jsonBody, Actor.class);
		System.out.println("Actor ::: "+actor);
	}

}
