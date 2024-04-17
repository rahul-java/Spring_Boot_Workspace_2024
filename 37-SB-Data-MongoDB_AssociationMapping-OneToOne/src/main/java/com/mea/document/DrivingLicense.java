package com.mea.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "ONETOONE_LICENSE")
@NoArgsConstructor
@Getter
@Setter
public class DrivingLicense {

	@Id
	private String id;
	private String type;
	private LocalDate expiryDate;
	
	private PersonDetails person;  //HAS-A-Property

	@Override
	public String toString() {
		return "DrivingLicense [id=" + id + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}
	
}
