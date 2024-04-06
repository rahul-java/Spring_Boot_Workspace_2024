package com.mea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mea.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findByCnameEquals(String cname);
	public List<Customer> findByCnameIs(String cname);
	public List<Customer> findByCname(String cname); //if there is no condition applied then equals condition is applied bydefault
	public List<Customer> getByCname(String cname);
	public List<Customer> readByCname(String cname);
	
	public List<Customer> findByCnameStartingWith(String initialChars);
	public List<Customer> findByCnameEndingWith(String lastChars);
	public List<Customer> findByCnameContaining(String chars);
	public List<Customer> findByCnameEqualsIgnoreCase(String name);
	
	public List<Customer> findByBillAmtBetween(double start,double end);
	
	//===================Having Multiple Conditions=====================
	
	public List<Customer> findByBillAmtGreaterThanEqualAndBillAmtLessThanEqual(double min,double max);
	public List<Customer> findByCaddInOrCnameLikeIgnoreCase(List<String> addresses,String namePattern);

}
