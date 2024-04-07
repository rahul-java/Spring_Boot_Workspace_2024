package com.mea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private EntityManager em;

	/* 
	 CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_CUSTOMER_BY_BILLAMT_RANGE`(in min float,in max float)
	BEGIN
	select * from jpa_customer where billamt>=min and billamt<=max;
	END
	 */
	@Override
	public List<Customer> showCustomersByBillAmtRange(double start, double end) {

		// create the stored procedure query obj
		StoredProcedureQuery query = em.createStoredProcedureQuery("GET_CUSTOMER_BY_BILLAMT_RANGE", Customer.class);
		// Register IN and OUT mode params by specifying their index and mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		// set values for IN mode params
		query.setParameter(1, start);
		query.setParameter(2, end);
		// execute the PL/SQL procedure
		List<Customer> list = query.getResultList();

		return list;
	}

}
