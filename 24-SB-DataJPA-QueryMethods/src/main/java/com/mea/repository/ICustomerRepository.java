package com.mea.repository;

import java.util.List;

import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mea.entity.Customer;

import jakarta.transaction.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer where billAmt>=?1 and billAmt<=?2")
	public List<Customer> showCustomersByBillAmtRange(double start,double end);
	
	//@Query("from Customer where billAmt>=:min and billAmt<=:max")
	//public List<Customer> showCustomersByBillAmtRange(@Param("min")double start,@Param("max")double end);
	
	//@Query("from Customer where billAmt>=:start and billAmt<=:end")
	//public List<Customer> showCustomersByBillAmtRange(double start,double end);
	
	@Query("from Customer where billAmt>=?2 and billAmt<=?1")
	public List<Customer> showCustomersByBillAmtRange1(double end,double start);
	
	@Query("from Customer where cadd in (:address1,:address2) order by cadd")
	public List<Customer> showCustomersByAddresses(String address1,String address2);
	
	@Query("select cno,cname,billAmt from Customer where billAmt between :start and :end")
	public List<Object[]> showCustomersDataByBillAmt(double start,double end);
	
	@Query("select cname from Customer where cname like :initialChar")
	public List<String> showCustomersDataByCnameChars(String initialChar);
	
	@Transactional
	@Modifying
	@Query("update Customer set billAmt=billAmt-(billAmt*:discPrcnt/100.0f) where cadd in(:add1,:add2)")
	public int updateCustomersBillAmtWithDiscountByAddress(String add1,String add2,double discPrcnt);
	
	@Query("from Customer where cname=:name")
	public Customer fetchCustomerByName(String name);
	
	@Query("select cno,cname,billAmt from Customer where cname=:name")
	public Object fetchCustomerDataByName(String name);
	
	@Query("select billAmt from Customer where cname=:name")
	public Double fetchCustomerBillAmtByName(String name);
	
	@Query("select count(*) from Customer")
	public long fetchCustomersCount();
	
	@Query("select count(distinct cname) from Customer")
	public long fetchUniqueCustomersName();
	
	@Query("select count(*),max(billAmt),min(billAmt),sum(billAmt),avg(billAmt) from Customer")
	public Object fetchCustomersAggregateData();
	
	//===================================Native SQL Queries===================================
	
	//@Query(value= "insert into JPA_CUSTOMER(CNAME,CADD,BILLAMT) values(:name,:add,:amt)", nativeQuery=true)  //for MySQL and make sure auto-increment is enabled
	@Query(value="insert into JPA_CUSTOMER(CID,CNAME,CADD,BILLAMT) values(CNO_SEQ.NEXTVAL,:name,:add,:amt)", nativeQuery=true)  //for Oracle
	@Transactional
	@Modifying
	public int registerCustomer(String name,String add,double amt);
	
	//@Query(value = "select now() from dual",nativeQuery = true)  //for MySQL
	@Query(value = "select sysdate from dual",nativeQuery = true) //for Oracle
	public String showSystemDate();
	
	//@Query(value="create table Temp1_TBL(col1 integer,col2 varchar(20))",nativeQuery = true)  //for MySQL
	@Query(value="create table Temp1_TBL(col1 number(5),col2 varchar2(20))",nativeQuery = true)  //for Oracle
	@Transactional
	@Modifying
	public int createTempTable();
}
