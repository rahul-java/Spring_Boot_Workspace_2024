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
	
	public Customer showCustomerById(Integer id);
	public String registerOrUpdateCustomer(Customer customer);
	public String updateCustomerAddress(Integer id,String newAddress);
	public String removeCustomerById(Integer id);
	public String removeCustomer(Customer customer);
	public String removeAllCustomers();
}
