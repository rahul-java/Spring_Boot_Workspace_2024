package com.mea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class Application {

	public static void main(String[] args) {
		log.debug("Start of Shopping Service main() method");
		SpringApplication.run(Application.class, args);
		log.debug("End of Shopping Service main() method");
	}

}
