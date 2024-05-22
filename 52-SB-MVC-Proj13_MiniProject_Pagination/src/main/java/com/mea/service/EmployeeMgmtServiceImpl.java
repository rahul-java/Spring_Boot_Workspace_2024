package com.mea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mea.entity.Employee;
import com.mea.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Page<Employee> showAllEmployeeByPagination(Pageable pageable) {

		return empRepo.findAll(pageable);
	}

	@Override
	public String registerEmployee(Employee emp) {

		Employee save = empRepo.save(emp);
		return "Employee Record is inserted with id value :"+save.getEmpNo();
	}

	@Override
	public Employee fetchEmployeeById(Integer id) {
		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Emp No"));
	}

	@Override
	public String updateEmployee(Employee emp) {
		Optional<Employee> optional=empRepo.findById(emp.getEmpNo());
		if(optional.isPresent())
		{
			Employee saved = empRepo.save(emp);
			return "Employee with id : "+saved.getEmpNo()+" is updated successfully.";
		}
		
		return "Employee with id : "+emp.getEmpNo()+" is not found for updation.";
	}

	@Override
	public String deleteEmployeeById(Integer id) {
		Optional<Employee> optional=empRepo.findById(id);
		if(optional.isPresent())
		{
			empRepo.deleteById(id);
			return "Employee with id : "+id+" is deleted successfully.";
		}
		
		return "Employee with id : "+id+" is not found for deletion.";
	}

}
