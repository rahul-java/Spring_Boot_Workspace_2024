package com.mea.model;

import lombok.Data;

@Data
public class Employee {

	private Integer empno;
	private String empname;
	private String address;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;
}
