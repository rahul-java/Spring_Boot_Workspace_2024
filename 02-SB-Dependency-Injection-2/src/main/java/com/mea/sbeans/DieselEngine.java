package com.mea.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements Engine {
	
	public DieselEngine() {

		System.out.println("DieselEngine.DieselEngine() :: 0-param-constructor");
	}

	@Override
	public void startEngine() {

		System.out.println("DieselEngine.startEngine() :: Diesel Engine Started");
	}

	@Override
	public void stopEngine() {

		System.out.println("DieselEngine.stopEngine() :: Diesel Engine Stopped");
	}

}
