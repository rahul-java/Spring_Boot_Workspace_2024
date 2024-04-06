package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;

@Component
public class CustomFinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public void run(String... args) throws Exception {

		/*try {
			System.out.println("--------------------------findByCnameEquals---------------------------------");
			List<Customer> list = custRepo.findByCnameEquals("rama");
			list.forEach(System.out::println);
		
			System.out.println("--------------------findByCnameIs-----------------------------");
			custRepo.findByCnameIs("rama").forEach(System.out::println);
		
			System.out.println("-------------------findByCname------------------------------");
			custRepo.findByCname("rama").forEach(System.out::println);
			
			System.out.println("----------------------getByCname---------------------------");
			custRepo.getByCname("rama").forEach(System.out::println);
			
			System.out.println("---------------------readByCname----------------------------");
			custRepo.readByCname("rama").forEach(System.out::println);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			System.out.println("----------------------findByCnameStartingWith----------------------------");
			custRepo.findByCnameStartingWith("r").forEach(System.out::println);
			System.out.println("-----------------------findByCnameEndingWith---------------------------");
			custRepo.findByCnameEndingWith("a").forEach(System.out::println);
			System.out.println("------------------------findByCnameContaining----------------------------");
			custRepo.findByCnameContaining("a").forEach(System.out::println);
			System.out.println("------------------------findByCnameEqualsIgnoreCase----------------------------");
			custRepo.findByCnameEqualsIgnoreCase("RaMa").forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			System.out.println("----------------------findByBillAmtBetween----------------------------");
			custRepo.findByBillAmtBetween(10000.0, 20000.0).forEach(System.out::println);
			
			System.out.println("----------------------findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual----------------------------");
			custRepo.findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(10999.99, 200000.0).forEach(System.out::println);
			
			System.out.println("----------------------findByCaddInOrCnameLikeIgnoreCase----------------------------");
			custRepo.findByCaddInOrCnameLikeIgnoreCase(List.of("Hyd","CKT","Pune","Noida"), "r%").forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
