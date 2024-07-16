package com.mea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private Integer compId;
	private String compName;
	private String compLocation;
	private Integer compSize;
}
