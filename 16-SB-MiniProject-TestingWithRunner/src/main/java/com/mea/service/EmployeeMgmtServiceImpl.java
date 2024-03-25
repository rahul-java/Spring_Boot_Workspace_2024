package com.mea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.dao.IEmployeeDAO;
import com.mea.model.Employee;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;
	
	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl.EmployeeMgmtServiceImpl() :: 0-param-constructor");

	}
	
	@Override
	public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {

		//convert the desg to UPPERCASE letters
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		List<Employee> list=empDAO.getEmployeesByDesig(desg1, desg2, desg3);
		return list;
	}

}
