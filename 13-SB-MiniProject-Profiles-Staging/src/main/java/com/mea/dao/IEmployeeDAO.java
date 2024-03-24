package com.mea.dao;

import java.util.List;

import com.mea.model.Employee;

public interface IEmployeeDAO {

	public List<Employee> getEmployeesByDesig(String desg1,String desg2,String desg3)throws Exception;
	
}
