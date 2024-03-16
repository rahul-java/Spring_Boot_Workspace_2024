package com.mea;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mea.sbeans.SeasonFinder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//get IOC container by starting the application
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		//get target spring bean class obj
		SeasonFinder finder = ctx.getBean("sf",SeasonFinder.class);
		
		//b.method
		String seasonName = finder.findSeasonName();
		System.out.println("Season Name :: "+seasonName);
		
		//close the container
		((ConfigurableApplicationContext)ctx).close();
	}
	
	@Bean(name = "dt")
	public LocalDate creaLocalDate() {
		return LocalDate.now();
	}

}
