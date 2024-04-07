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
	 create or replace NONEDITIONABLE PROCEDURE GET_CUSTOMER_BY_BILLAMT_RANGE 
	(
	DETAILS OUT SYS_REFCURSOR 
	, MINBILLAMT IN FLOAT 
	, MAXBILLAMT IN FLOAT 
	) AS 
	BEGIN
	OPEN DETAILS FOR
	SELECT * FROM JPA_CUSTOMER WHERE BILLAMT>=MINBILLAMT AND BILLAMT<=MAXBILLAMT;
	
	END GET_CUSTOMER_BY_BILLAMT_RANGE;
	 */
	@Override
	public List<Customer> showCustomersByBillAmtRange(double start, double end) {

		//create the stored procedure query obj
		StoredProcedureQuery query=em.createStoredProcedureQuery("GET_CUSTOMER_BY_BILLAMT_RANGE",Customer.class);
		//Register IN and OUT mode params by specifying their index and mode
		query.registerStoredProcedureParameter(1, Object.class, ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Double.class, ParameterMode.IN);
		//set values for IN mode params
		query.setParameter(2, start);
		query.setParameter(3, end);
		//execute the PL/SQL procedure
		List<Customer> list=query.getResultList();
		
		return list;
	}

}
