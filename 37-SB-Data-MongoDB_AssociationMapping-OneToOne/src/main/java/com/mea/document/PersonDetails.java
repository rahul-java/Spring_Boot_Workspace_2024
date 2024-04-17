package com.mea.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "OneToOne_Person_Details")
@Setter
@Getter
@NoArgsConstructor
public class PersonDetails {

	@Id
	private String id;
	private String name;
	private String address;
	
	private DrivingLicense license; //HAS-A-Property

	@Override
	public String toString() {
		return "PersonDetails [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
