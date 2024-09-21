package com.mea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Application {

	public static void main(String[] args) {
		log.debug("Start of Billing Service main() method");
		SpringApplication.run(Application.class, args);
		log.debug("End of Billing Service main() method");
	}

}
