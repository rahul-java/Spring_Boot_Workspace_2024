package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mea.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
