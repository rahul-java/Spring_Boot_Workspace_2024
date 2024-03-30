package com.mea.repository;

import org.springframework.data.repository.CrudRepository;

import com.mea.entity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
