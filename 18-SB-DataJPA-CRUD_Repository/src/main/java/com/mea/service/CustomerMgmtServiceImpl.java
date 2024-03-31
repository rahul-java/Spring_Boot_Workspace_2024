package com.mea.service;

import java.util.Arrays;
import java.util.List;

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

	@Override
	public boolean isCustomerAvailable(int id) {
		return custRepo.existsById(id);
	}

	@Override
	public long showCustomersCount() {
		return custRepo.count();
	}

	@Override
	public Iterable<Customer> getAllCustomer() {
		return custRepo.findAll();
	}

	@Override
	public Iterable<Customer> getAllCustomerByIds(Iterable<Integer> ids) {
		return custRepo.findAllById(ids);
	}

	@Override
	public String registerGroupCustomer(List<Customer> custList) {
		 Iterable<Customer> saveAll = custRepo.saveAll(custList);
		 return custList.size()+" no. of records are inserted successfully...";
	}

}
