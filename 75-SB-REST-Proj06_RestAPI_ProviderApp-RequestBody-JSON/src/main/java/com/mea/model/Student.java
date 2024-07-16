package com.mea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	private Integer sno;
	private String sname;
	private String sadd;
	private Float avg;
	
}
