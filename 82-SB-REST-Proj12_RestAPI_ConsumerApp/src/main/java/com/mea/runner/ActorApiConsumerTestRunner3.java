package com.mea.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorApiConsumerTestRunner3 implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public void run(String... args) throws Exception {
		//prepare base url
		String baseUrl="http://localhost:4041/providerApp/actor-api/register";
		//prepare json content
		String json_content="{\"aid\":1010,\"name\":\"raja\",\"address\":\"Hyd\",\"fee\":5000000.0,\"category\":\"Hero\"}";
		//set application/json as the request header value
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare http request as httpEntity obj having head, body
		HttpEntity<String> requestEntity=new HttpEntity<String>(json_content, headers);
		//send post mode request
		ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, requestEntity, String.class);
		
		System.out.println("Response Content ::: "+response);		
		
	}

}
