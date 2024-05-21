package com.mea.service;

import com.mea.entity.Employee;

public interface IEmployeeMgmtService {

	public Iterable<Employee> showAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeeById(Integer id);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(Integer id);
}
