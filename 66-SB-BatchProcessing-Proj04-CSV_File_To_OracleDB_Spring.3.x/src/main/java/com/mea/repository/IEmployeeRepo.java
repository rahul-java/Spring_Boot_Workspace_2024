package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
