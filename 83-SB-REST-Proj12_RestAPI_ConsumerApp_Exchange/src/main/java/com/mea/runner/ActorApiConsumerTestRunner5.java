package com.mea.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mea.model.Actor;

@Component
public class ActorApiConsumerTestRunner5 implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:4041/providerApp/actor-api/getAll";
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
		//List<Actor> actors = mapper.readValue(jsonBody, List.class); //[{aid=101021, name=A-Raja, address=Hyd-1, fee=550000.0, category=Villain}, {aid=101022, name=B-Raja, address=Hyd-2, fee=540000.0, category=Hero}, {aid=101023, name=C-Raja, address=Hyd-3, fee=530000.0, category=Vilain}, {aid=101024, name=D-Raja, address=Hyd-4, fee=520000.0, category=Hero}, {aid=101025, name=E-Raja, address=Hyd-5, fee=510000.0, category=Villain}]
		List<Actor> actors = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {}); //[Actor(aid=101021, name=A-Raja, address=Hyd-1, fee=550000.0, category=Villain), Actor(aid=101022, name=B-Raja, address=Hyd-2, fee=540000.0, category=Hero), Actor(aid=101023, name=C-Raja, address=Hyd-3, fee=530000.0, category=Vilain), Actor(aid=101024, name=D-Raja, address=Hyd-4, fee=520000.0, category=Hero), Actor(aid=101025, name=E-Raja, address=Hyd-5, fee=510000.0, category=Villain)]
		System.out.println("Actors ::: "+actors);
	}

}
