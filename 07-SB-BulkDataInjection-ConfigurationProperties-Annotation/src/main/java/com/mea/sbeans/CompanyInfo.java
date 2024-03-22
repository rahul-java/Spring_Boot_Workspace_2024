package com.mea.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("company")
@ConfigurationProperties(prefix = "org.nic")
@Setter
public class CompanyInfo {

	private String name;
	private String address;
	private Long pincode;
	private Long contactno;
	
	@Value("${nic.size}")
	private Integer size;
	
	@Value("${org.nic.ceo}")
	private String owner;
	
	
	@Override
	public String toString() {
		return "CompanyInfo [name=" + name + ", address=" + address + ", pincode=" + pincode + ", contactno="
				+ contactno + ", size=" + size + ", owner=" + owner + "]";
	}
	
	
	
	
	
}
