package com.mea.service;

import java.util.List;

import com.mea.entity.Customer;

public interface ICustomerMgmtService {

	public String registerCustomer(Customer customer);
	public boolean isCustomerAvailable(int id);
	public long showCustomersCount();
	public Iterable<Customer> getAllCustomer();
	public Iterable<Customer> getAllCustomerByIds(Iterable<Integer> ids);
	public String registerGroupCustomer(List<Customer> custList);
}
