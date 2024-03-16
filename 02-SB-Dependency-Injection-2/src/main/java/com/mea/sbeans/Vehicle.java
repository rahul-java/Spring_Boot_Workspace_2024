package com.mea.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

	@Autowired
	@Qualifier("eEngine")
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
