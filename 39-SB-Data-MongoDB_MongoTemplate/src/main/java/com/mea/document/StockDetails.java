package com.mea.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "STOCK_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDetails {

	@Id
	private String id;
	private String name;
	private String exchange;
	private String company;
	private Double price;
}
