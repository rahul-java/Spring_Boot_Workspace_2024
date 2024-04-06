package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;
import com.mea.view.IResultView;

@Component
public class CustomFinderMethodScalerOperationTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public void run(String... args) throws Exception {

		
		try {
			System.out.println("Repository obj proxy class name :: "+custRepo.getClass().getName());
			List<IResultView> list = custRepo.findByBillAmtBetween(5000.0, 20000.0);
			list.forEach(view->{
				System.out.println("ResultView Proxy class name ::: "+view.getClass().getName());
				System.out.println(view.getCno()+"  :::  "+view.getCname());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
