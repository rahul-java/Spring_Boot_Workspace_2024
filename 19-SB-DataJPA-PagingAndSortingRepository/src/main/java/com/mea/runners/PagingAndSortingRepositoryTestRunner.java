package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.service.ICustomerMgmtService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService custService;
	
	@Override
	public void run(String... args) throws Exception {

		/*try {
			Iterable<Customer> customersSorted = custService.showCustomersSorted(true, "cname","cadd");
			customersSorted.forEach(System.out::println);
			System.out.println("----------------------------------------------------");
			custService.showCustomersSorted(false, "cname","cadd").forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Page<Customer> page = custService.showCustomersByPageNo(2, 10);
			Iterable<Customer> content = page.getContent();
			System.out.println("Page No : "+(page.getNumber()+1)+"/"+page.getTotalPages()+" records are ::: ");
			content.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try {
			Page<Customer> page = custService.showCustomersByPageNoAndSorted(1, 5,true,"cname","cadd");
			Iterable<Customer> content = page.getContent();
			System.out.println("Page No : "+(page.getNumber()+1)+"/"+page.getTotalPages()+" records are ::: ");
			content.forEach(System.out::println);
			System.out.println("Total no. of pages ::: "+page.getTotalPages());
			System.out.println("Current Page No ::: "+page.getNumber()+1);
			System.out.println("Total no. of records ::: "+page.getTotalElements());
			System.out.println("Current page no. of records ::: "+page.getNumberOfElements());
			System.out.println("Is it First page ::: "+page.isFirst());
			System.out.println("Is it Last page ::: "+page.isLast());
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try {
			custService.showCustomersDataPageByPage(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
