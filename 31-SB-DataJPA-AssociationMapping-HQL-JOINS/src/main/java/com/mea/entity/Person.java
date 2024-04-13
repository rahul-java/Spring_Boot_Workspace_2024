package com.mea.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_OTM_PERSON")
//@Data
@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@NonNull
	@Column(length = 20)
	private String pName;
	
	@NonNull
	@Column(length = 20)
	private String pAddress;
	
	@OneToMany(targetEntity = PhoneNumber.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "person")
	//@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> contactDetails;
    //if we do not mention FetchType , default fetch type is LAZY 
	
	public Person() {

		System.out.println("Person.Person() ::: 0-param-constructor ::"+this.getClass());
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pName=" + pName + ", pAddress=" + pAddress + "]";
	}
	
	
}
