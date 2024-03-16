package com.mea.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public class ElectricEngine implements Engine {
	
	public ElectricEngine() {

		System.out.println("ElectricEngine.ElectricEngine() :: 0-param-constructor");
	}

	@Override
	public void startEngine() {

		System.out.println("ElectricEngine.startEngine() :: Electric Engine Started");
	}

	@Override
	public void stopEngine() {

		System.out.println("ElectricEngine.stopEngine() :: Electric Engine Stopped");
	}

}
