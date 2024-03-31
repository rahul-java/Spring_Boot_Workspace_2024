package com.mea.runners;

import java.util.List;

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

		/*try {
			Customer cust=new Customer();
			cust.setCname("Rama");
			cust.setCadd("New Delhi");
			cust.setBillAmt(100000.00f);
			
			String msg = custService.registerCustomer(cust);
			System.out.println("Result ::: "+msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println("Is 100 id Customer Available ::: "+custService.isCustomerAvailable(100));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println("Customer Count ::: "+custService.showCustomersCount());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println("All Customers are ::: ");
			Iterable<Customer> list = custService.getAllCustomer();
			//System.out.println(list);
			//for(Customer cust:list)
				//System.out.println(cust);
			//list.forEach(cust->System.out.println(cust));
			list.forEach(System.out::println); //static method reference
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Iterable<Customer> list = custService.getAllCustomerByIds(List.of(100,101,110,120));
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
			Customer c1 = new Customer("john", "Hyd", 8999.99f);
			Customer c2 = new Customer("Dev", "Bnglr", 18999.99f);
			Customer c3 = new Customer("Vicky", "Dlh", 10999.99f);
			Customer c4 = new Customer("Micky", "Noida", 28999.99f);
			Customer c5 = new Customer("RAMA", "CKT", 49999.99f);
			String registerGroupCustomer = custService.registerGroupCustomer(List.of(c1,c2,c3,c4,c5));
			System.out.println(registerGroupCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
