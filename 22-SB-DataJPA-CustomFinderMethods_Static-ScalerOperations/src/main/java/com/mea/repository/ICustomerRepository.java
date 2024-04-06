package com.mea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mea.entity.Customer;
import com.mea.view.IResultView;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<IResultView> findByBillAmtBetween(double start,double end);
	
}
