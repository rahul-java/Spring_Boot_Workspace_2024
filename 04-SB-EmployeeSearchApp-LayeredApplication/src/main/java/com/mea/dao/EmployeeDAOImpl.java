package com.mea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Repository;

import com.mea.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,EMPNAME,EMPDESIG,EMPSALARY,EMPDEPTNO FROM EMPLOYEE WHERE EMPDESIG IN(?,?,?) ORDER BY EMPDESIG";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> getEmployeesByDesig(String desg1, String desg2, String desg3) throws Exception {

		System.out.println("EmployeeDAOImpl.getEmployeesByDesig() :: "+ds.getClass());
		List<Employee> list=new ArrayList<Employee>();
		
		//try with resource
		try(//get Pooled jdbc con object
				Connection con=ds.getConnection();
				//create the prepared stmt object
				PreparedStatement ps =con.prepareStatement(GET_EMPS_BY_DESGS);
				){
			
			//set the query param value
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//execute the query
			try(ResultSet rs=ps.executeQuery()){
				//copy the records of ResultSet obj to ArrayList Collection
				while(rs.next())
				{
					Employee emp = new Employee();
					emp.setEmpNo(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setEmpDesig(rs.getString(3));
					emp.setEmpSalary(rs.getFloat(4));
					emp.setEmpDeptNo(rs.getInt(5));
					
					list.add(emp);
				}
			}
			
		}
		catch (SQLException se) {

			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
