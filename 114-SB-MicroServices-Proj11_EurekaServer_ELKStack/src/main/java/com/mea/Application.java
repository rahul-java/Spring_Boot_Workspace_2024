package com.mea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {
	
	private static Logger logger=LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		logger.debug("Start of Eureka Server main() method");
		SpringApplication.run(Application.class, args);
		logger.debug("End of Eureka Server main() method");
	}

}
