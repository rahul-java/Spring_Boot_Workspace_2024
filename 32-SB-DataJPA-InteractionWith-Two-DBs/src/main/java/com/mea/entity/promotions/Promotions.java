package com.mea.entity.promotions;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MULTIDB_PROMOTIONS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Promotions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long prid;
	
	@Column(length = 30)
	private String offerName;
	@Column(length = 30)
	private String offerCode;
	//private Double price;
	private Double discountPercentage;
	private LocalDateTime expiryDate;
	
	
}
