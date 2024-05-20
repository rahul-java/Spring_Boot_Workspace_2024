package com.mea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Employee;
import com.mea.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<Employee> showAllEmployee() {

		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {

		Employee save = empRepo.save(emp);
		return "Employee Record is inserted with id value :"+save.getEmpNo();
	}

}
