package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.document.StockDetails;
import com.mea.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private IStockMgmtService stockService;
	
	@Override
	public void run(String... args) throws Exception {

		//StockDetails details=new StockDetails(null, "SBI", "BSE", "SBI", 105.56f);
		//System.out.println(stockService.registerStockDetails(details));
		
		List<StockDetails> list = stockService.showStockDetailsByName("ICICI");
		list.forEach(System.out::println);
		
		System.out.println("---------------------Range between start and end--------------------------");
		List<StockDetails> showStockDetailsByPriceRange = stockService.showStockDetailsByPriceRange(500.0, 600.0);
		showStockDetailsByPriceRange.forEach(System.out::println);
		
		System.out.println("---------------------Names IN Collection--------------------------");
		stockService.showStockDetailsByNames("SBI","ICICI").forEach(System.out::println);
		
		/*System.out.println("---------------------Find and Update--------------------------");
		String resMsg = stockService.showAndUpdateStockDetailsByName("ICICI", "NYSE", 555.55f);
		System.out.println(resMsg);*/
		
		/*System.out.println("---------------------multiUpdate--------------------------");
		String resMsg = stockService.modifyExchangeByStockPriceRange(100.0, 500.0, "NSC");
		System.out.println(resMsg);*/
		
		/*System.out.println("---------------------upsert--------------------------");
		String resMsg = stockService.updateOrInsertStockDetails("HDFC", "BSE", 1200.50, "HDFC-BANK");
		System.out.println(resMsg);*/
		
		System.out.println("---------------------find And Remove--------------------------");
		System.out.println(stockService.fetchAndRemoveByStockName("ICICICICI"));
		
		System.out.println("---------------------find by range And Remove Multiple Records--------------------------");
		System.out.println(stockService.removeStockDetailsByPriceRange(600.0, 1000.00));
	}

}
