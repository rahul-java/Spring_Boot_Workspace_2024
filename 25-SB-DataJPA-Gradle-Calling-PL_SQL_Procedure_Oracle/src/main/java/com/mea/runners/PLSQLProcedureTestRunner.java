package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.service.ICustomerMgmtService;

@Component
public class PLSQLProcedureTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;
	
	@Override
	public void run(String... args) throws Exception {

		try {
			List<Customer> list = custService.showCustomersByBillAmtRange(5000.0, 20000.0);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
