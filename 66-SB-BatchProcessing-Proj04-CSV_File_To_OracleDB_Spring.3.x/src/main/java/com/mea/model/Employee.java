package com.mea.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BATCH_EMPLOYEE")
public class Employee {

	@Id
	private Integer empno;
	@Column(length = 40)
	private String empname;
	@Column(length = 100)
	private String address;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;
}
