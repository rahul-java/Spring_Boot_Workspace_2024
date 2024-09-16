package com.mea.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "info.app")
@Data
public class Company {
	
	private String name;
	private int size;
	private String location;
	private String head;
	private String email;
	

}
