package com.mea.runners;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.service.ICustomerMgmtService;

@Component
public class JPARepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;
	
	@Override
	public void run(String... args) throws Exception {

		/*try {
			//String resMsg = custService.deleteCustomersByIdsInBatch(List.of(101,103,104,105,106));
			//String resMsg = custService.deleteCustomersByIdsInBatch(List.of(101,103,104,105,106,null)); //throws exception
			String resMsg = custService.deleteCustomersByIdsInBatch(Arrays.asList(101,103,104,105,106)); //doesn't throw exception
			System.out.println(resMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Customer customer=new Customer();
			customer.setCname("rama");
			customer.setCadd("CKT");
			List<Customer> list = custService.showCustomersByExampleData(customer, true, "billAmt");
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Customer customer = custService.showCustomerById(102);
			System.out.println(customer.getClass()+" ::: "+customer.getClass().getSuperclass());
			//System.out.println(customer);
			System.out.println(customer.getBillAmt());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			Optional<Customer> optional = custService.fetchCustomerById(102);
			if(optional.isPresent())
			{
				System.out.println("Record is ::: "+optional.get());
			}
			else {
				System.out.println("Record not found...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
