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
import org.springframework.context.annotation.Profile;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Repository;

import com.mea.model.Employee;

@Repository("mysqlEmpDAO")
@Profile({"dev","test","staging"})
public class MySQLEmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_JOB="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;
	
	public MySQLEmployeeDAOImpl() {
		System.out.println("MySQLEmployeeDAOImpl.MySQLEmployeeDAOImpl() :: 0-param-constructor");
	}
	
	@Override
	public List<Employee> getEmployeesByDesig(String desg1, String desg2, String desg3) throws Exception {

		System.out.println("EmployeeDAOImpl.getEmployeesByDesig() :: "+ds.getClass());
		List<Employee> list=new ArrayList<Employee>();
		
		//try with resource
		try(//get Pooled jdbc con object
				Connection con=ds.getConnection();
				//create the prepared stmt object
				PreparedStatement ps =con.prepareStatement(GET_EMPS_BY_JOB);
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
