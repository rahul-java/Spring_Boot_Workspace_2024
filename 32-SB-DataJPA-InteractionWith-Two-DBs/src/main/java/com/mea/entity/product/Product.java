package com.mea.entity.product;

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
@Table(name = "MULTIDB_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(length = 20)
	private String pname;
	
	private Double price;
	private Double quantity;
}
