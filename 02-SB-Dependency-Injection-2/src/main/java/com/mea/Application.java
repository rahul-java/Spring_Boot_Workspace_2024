package com.mea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mea.sbeans.Vehicle;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//get access to IOC container
		ApplicationContext ctx =SpringApplication.run(Application.class, args);
		//get target spring bean class obj
		Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
		//invoke the b.method
		vehicle.journey("New Delhi", "Chitrakoot");
		//close the container
		((ConfigurableApplicationContext)ctx).close();
	}

}
