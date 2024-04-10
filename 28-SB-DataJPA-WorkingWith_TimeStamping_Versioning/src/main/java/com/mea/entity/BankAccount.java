package com.mea.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "ACNO_SEQ",initialValue = 100000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Long acNo;
	@Column(length = 20)
	@NonNull
	private String type;
	@Column(length = 20)
	@NonNull
	private String ownerName;
	@NonNull
	private Double balance;
	
	//these three values will be automatically generated by Hibernate
	@Version
	private Integer updationCount;
	@CreationTimestamp
	private LocalDateTime openedOn;
	@UpdateTimestamp
	private LocalDateTime lastAccessedOn;
	
	
}
