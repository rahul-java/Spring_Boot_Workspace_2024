package com.mea.service;

import java.util.List;

import com.mea.entity.Customer;

public interface ICustomerMgmtService {

	public List<Customer> showCustomersByBillAmtRange(double start,double end);
}
