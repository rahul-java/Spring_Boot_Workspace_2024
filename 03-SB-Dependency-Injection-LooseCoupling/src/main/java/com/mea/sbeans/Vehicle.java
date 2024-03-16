package com.mea.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

	//@Autowired
	//@Qualifier("eEngine")  //dependent bean id , it works but hard coded NOT RECOMENDED
	//@Qualifier("${engine.id}")  //FAILED => bcoz place holder is allowed only inside the @Value
	//@Qualifier("@Value('${engine.id}')")  //FAILED => bcoz @Value is used as the independent annotation i.e it can not be used inside @Qualifier annotation
	//@Qualifier("beanId") //doesn't work
	//private Engine engine;
	
	//@Value("${engine.id}")
	//private String beanId;
	
	@Autowired
	@Qualifier("motor") //this is alias name fetching from applicationContext.xml
	private Engine engine;
	
	public Vehicle() {

		System.out.println("Vehicle.Vehicle() :: 0-param-constructor");
	}
	
	public void journey(String source,String destination) {
		System.out.println("Vehicle.journey() :: Journey started from : "+source);
		engine.startEngine();
		System.out.println("Vehicle.journey() :: Journey is going on...");
		engine.stopEngine();
		System.out.println("Vehicle.journey() :: Journey Stopped at : "+destination);
	}
}
