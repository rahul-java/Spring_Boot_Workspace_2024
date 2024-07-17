package com.mea.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
	private LocalDateTime dob;
	
	private String[] friends;
	private List<String> favColors;
	private Set<Long> phoneNos;
	private Map<String, Object> idDetails;
	private Address address;
	
}
