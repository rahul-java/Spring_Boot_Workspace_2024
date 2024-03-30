package com.mea.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepository custRepo;
	
	@Override
	public String registerCustomer(Customer customer) {

		System.out.println("Proxy Class Name ::: "+custRepo.getClass()+"..."+Arrays.toString(custRepo.getClass().getInterfaces()));
		Customer savedCust = custRepo.save(customer);
		return "Customer is saved (record inserted) with the id value :: "+savedCust.getCno();
	}

}
