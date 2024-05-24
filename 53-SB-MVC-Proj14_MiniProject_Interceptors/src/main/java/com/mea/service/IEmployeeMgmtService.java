package com.mea.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mea.entity.Employee;

public interface IEmployeeMgmtService {

	public Page<Employee> showAllEmployeeByPagination(Pageable pageable);
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeeById(Integer id);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(Integer id);
}
