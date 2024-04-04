package com.mea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mea.entity.Customer;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer>,CrudRepository<Customer, Integer> {

}
