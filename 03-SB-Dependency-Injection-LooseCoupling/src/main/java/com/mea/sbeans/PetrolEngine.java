package com.mea.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PetrolEngine implements Engine {
	
	public PetrolEngine() {
		System.out.println("PetrolEngine.PetrolEngine() :: 0-param-constructor");
	}

	@Override
	public void startEngine() {

		System.out.println("PetrolEngine.startEngine() :: Petrol Engine Started");
	}

	@Override
	public void stopEngine() {

		System.out.println("PetrolEngine.stopEngine() :: Petrol Engine Stopped");
	}

}
