package com.mea.model;

import lombok.Data;

@Data
public class Customer {
	
	private Integer cno;
	private String cname;
	private String cadd="New Delhi";
	private Double billAmt;
	
	public Customer() {
		System.out.println("Customer.Customer() : "+this.hashCode());
	}
	

}
