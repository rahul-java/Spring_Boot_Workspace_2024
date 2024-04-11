package com.mea.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JPA_OTM_PHONE_NUMBER")
//@Data
@Setter
@Getter
//@NoArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber {

	@SequenceGenerator(name = "gen1",sequenceName = "REGNO_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer regNo;
	
	@NonNull
	private Long mobileNo;
	
	@Column(length = 20)
	@NonNull
	private String numberType;
	
	@Column(length = 20)
	@NonNull
	private String provider;
	
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Person person;

	
	public PhoneNumber() {

		System.out.println("PhoneNumber.PhoneNumber() ::: 0-param-constructor ::"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", mobileNo=" + mobileNo + ", numberType=" + numberType + ", provider="
				+ provider + "]";
	}
	
	
}
