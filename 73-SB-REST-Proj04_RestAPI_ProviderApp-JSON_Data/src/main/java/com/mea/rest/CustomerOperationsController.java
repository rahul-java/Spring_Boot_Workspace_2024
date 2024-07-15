package com.mea.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.model.Company;
import com.mea.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showReports(){
		
		System.out.println("CustomerOperationsController.showReports()");
		
		Customer customer = new Customer();
		customer.setCno(101);
		customer.setCname("Raja");
		customer.setCaddress("New Delhi");
		customer.setBillAmt(7500.50f);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/report1")
	public ResponseEntity<Customer> showReports1(){
		
		System.out.println("CustomerOperationsController.showReports1()");
		
		Customer customer = new Customer();
		customer.setCno(101);
		customer.setCname("Raja");
		customer.setCaddress("New Delhi");
		customer.setBillAmt(7500.50f);
		
		customer.setFavColors(new String[]{"Red","Black","Blue"});
		customer.setFriends(Arrays.asList("Ravi","Kavi","Abhi"));
		customer.setPhoneNos(Set.of(999999999l,8888888888l));
		customer.setIdDetails(Map.of("adhar",123123123,"voterId","V123456","panNo","BKWPP123456"));
		
		customer.setCompany(new Company(1010,"TCS","New Delhi",50000));
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	
	@GetMapping("/report2")
	public ResponseEntity<List<Customer>> showReports2(){
		
		System.out.println("CustomerOperationsController.showReports2()");
		
		Customer customer1 = new Customer(101,"Raja","New Delhi",9500.5f);
		Customer customer2 = new Customer(102,"Ravi","New Delhi",8500.5f);
		Customer customer3 = new Customer(103,"Rakesh","Mumbai",5760.5f);
		Customer customer4 = new Customer(104,"Vivek","Prayagraj",8500.5f);
		Customer customer5 = new Customer(105,"Ashish","Noida",5700.5f);
		Customer customer6 = new Customer(106,"Jay","Patna",6500.5f);
		
	
		
		return new ResponseEntity<List<Customer>>(List.of(customer1,customer2,customer3,customer4,customer5,customer6),HttpStatus.OK);
	}
	
}
