package com.mea.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.product.Product;
import com.mea.entity.promotions.Promotions;
import com.mea.service.ITwoDBsMgmtService;

@Component
public class TwoDBsTestRunner implements CommandLineRunner {

	@Autowired
	private ITwoDBsMgmtService twoDBsService;
	
	@Override
	public void run(String... args) throws Exception {

		Product product=new Product(null,"table",90000.0,20.0);
		Promotions promotions=new Promotions(null,"holi-offer","holi-50",10.0,LocalDateTime.of(2024, 5, 10, 11, 30));

		try {
			String resMsg = twoDBsService.saveData(product, promotions);
			System.out.println(resMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
