package com.mea.sbeans;

import org.springframework.stereotype.Component;

@Component("cEngine")
public class CNGEngine implements Engine {
	
   public CNGEngine() {
	   System.out.println("CNGEngine.CNGEngine() :: 0-param-constructor");

   }

	@Override
	public void startEngine() {

		System.out.println("CNGEngine.startEngine() :: CNG Engine Started");
	}

	@Override
	public void stopEngine() {

		System.out.println("CNGEngine.stopEngine() :: CNG Engine Stopped");
	}

}
