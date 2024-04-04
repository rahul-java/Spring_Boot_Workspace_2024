package com.mea.service;

import org.springframework.data.domain.Page;

import com.mea.entity.Customer;

public interface ICustomerMgmtService {

	public Iterable<Customer> showCustomersSorted(boolean asc,String ...properties );
	public Page<Customer> showCustomersByPageNo(int pageNo, int pageSize);
	public Page<Customer> showCustomersByPageNoAndSorted(int pageNo, int pageSize,boolean flagOrder,String ...properties);
	public void showCustomersDataPageByPage(int pageSize);
}
