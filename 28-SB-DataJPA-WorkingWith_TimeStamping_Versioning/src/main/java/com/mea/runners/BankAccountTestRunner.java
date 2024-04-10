package com.mea.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.BankAccount;
import com.mea.service.IBankAccountMgmtService;

@Component
public class BankAccountTestRunner implements CommandLineRunner {

	@Autowired
	private IBankAccountMgmtService bankService;
	@Override
	public void run(String... args) throws Exception {

		/*try {
			String resMsg = bankService.registerBankAccount(new BankAccount("Saving","Rajesh",100000.00));
			System.out.println("Result ::: "+resMsg);
		} catch (Exception e) {
		
			e.printStackTrace();
		}*/
		
		try {
			String resMsg = bankService.withdrawAmount(100000l, 1500.0);
			System.out.println("Result ::: "+resMsg);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
