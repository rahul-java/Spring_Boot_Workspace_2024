package com.mea.service;

import java.util.List;

import com.mea.document.StockDetails;

public interface IStockMgmtService {

	public String registerStockDetails(StockDetails details);
	public List<StockDetails> showStockDetailsByName(String name);
	public List<StockDetails> showStockDetailsByPriceRange(double start,double end);
	public List<StockDetails> showStockDetailsByNames(String...names );
	
	public String showAndUpdateStockDetailsByName(String name,String newExchange,double newPrice);
	public String modifyExchangeByStockPriceRange(double start,double end,String newExchange);
	
	//upsert
	public String updateOrInsertStockDetails(String name,String exchange,double price,String company);
	public String fetchAndRemoveByStockName(String name);
	public String removeStockDetailsByPriceRange(Double start,Double end);
}
