package com.mea.service;

import java.util.List;
import java.util.Optional;

import com.mea.entity.Customer;

public interface ICustomerMgmtService {

	public String deleteCustomersByIdsInBatch(List<Integer> ids);
	public List<Customer> showCustomersByExampleData(Customer cust,boolean flagOrder,String ...properties);
	public Customer showCustomerById(int cno);
	public Optional<Customer> fetchCustomerById(int cno);
}
