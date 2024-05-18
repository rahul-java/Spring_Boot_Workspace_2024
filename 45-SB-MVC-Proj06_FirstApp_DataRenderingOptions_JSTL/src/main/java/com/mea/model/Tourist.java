package com.mea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist {

	private Integer tid;
	private String tname;
	private Long mobileNo;
	private String destLocation;
	private String fromLocation;
	private Double budget;
}
