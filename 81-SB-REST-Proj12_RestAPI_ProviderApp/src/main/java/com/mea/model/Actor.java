package com.mea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
	
	private Integer aid;
	private String name;
	private String address;
	private Double fee;
	private String category;

}
