package com.mea;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	//Runners through @Bean methods
	@Bean
	public CommandLineRunner createRunner() {
		CommandLineRunner runner1=args->{
			System.out.println("Special Runner1 :::"+args);
		};
		return runner1;
	}
	
	@Bean
	public ApplicationRunner createAppRunner() {
		ApplicationRunner runner2=args->{
			System.out.println("Special Runner2 :::"+args);
		};
		return runner2;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
