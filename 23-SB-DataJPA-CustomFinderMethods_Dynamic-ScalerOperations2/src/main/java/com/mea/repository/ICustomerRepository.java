package com.mea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.Customer;
import com.mea.view.IView;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	public <T extends IView> List<T> findByBillAmtBetween(double start,double end,Class<T> clazz);
	
}
