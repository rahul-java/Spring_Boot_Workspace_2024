package com.mea.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("empInfo")
@Data
@ConfigurationProperties("org.nic")
public class EmployeeInfo {

	private Integer id;
	private String name;
	private String address;
	private Long phone;
	
	
	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
	
}
