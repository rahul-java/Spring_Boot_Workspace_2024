package com.mea.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.service.ICustomerMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;
	
	@Override
	public void run(String... args) throws Exception {

		try {
			Customer cust=new Customer();
			cust.setCname("Rama");
			cust.setCadd("New Delhi");
			cust.setBillAmt(100000.00f);
			
			String msg = custService.registerCustomer(cust);
			System.out.println("Result ::: "+msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
