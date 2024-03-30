package com.mea.service;

import com.mea.entity.Customer;

public interface ICustomerMgmtService {

	public String registerCustomer(Customer customer);
	public boolean isCustomerAvailable(int id);
	public long showCustomersCount();
}
