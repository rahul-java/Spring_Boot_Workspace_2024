package com.mea.runners;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;
	
	@Override
	public void run(String... args) throws Exception {

		/*try{
			List<Customer> list = custRepo.showCustomersByBillAmtRange(10000.0, 20000.0);
			list.forEach(System.out::println);
			
			System.out.println("=========================================");
			custRepo.showCustomersByBillAmtRange1(20000.0, 10000.0).forEach(System.out::println);;
			
			System.out.println("=========================================");
			custRepo.showCustomersByAddresses("Hyd","New Delhi").forEach(System.out::println);
			
			System.out.println("=========================================");
			custRepo.showCustomersDataByBillAmt(10000.0, 20000.0).forEach(row->{
				for(Object obj:row)
				{
					System.out.print(obj+"  ");
				}
				System.out.println();
			});
			
			System.out.println("=========================================");
			custRepo.showCustomersDataByCnameChars("r%").forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try{
			System.out.println("====================Before=====================");
			custRepo.showCustomersByAddresses("Hyd","New Delhi").forEach(System.out::println);
			
			int i = custRepo.updateCustomersBillAmtWithDiscountByAddress("Hyd", "New Delhi", 10.0);
			System.out.println("No. of records affected :: "+i);
			
			System.out.println("====================After=====================");
			custRepo.showCustomersByAddresses("Hyd","New Delhi").forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try{
			Customer cust = custRepo.fetchCustomerByName("ramu");
			System.out.println("Single Complete Record ::: "+cust);
			System.out.println("--------------------------------------------------------");
			
			Object object = custRepo.fetchCustomerDataByName("ramu");
			Object[] obj=(Object[])object;
			System.out.println("Single Record , Multiple Column ::: "+Arrays.toString(obj));
			System.out.println("--------------------------------------------------------");
			
			Double billAmt = custRepo.fetchCustomerBillAmtByName("ramu");
			System.out.println("Single Value, ramu billAmt ::: "+billAmt);
			System.out.println("--------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*try{
			System.out.println("All Customers Count ::: "+custRepo.fetchCustomersCount());
			System.out.println("All Customers Unique Name Count ::: "+custRepo.fetchUniqueCustomersName());
			Object row[]=(Object[])custRepo.fetchCustomersAggregateData();
			System.out.println("Aggregate Results ::: "+Arrays.toString(row));
			System.out.println("Total Count : "+row[0]);
			System.out.println("Max : "+row[1]);
			System.out.println("Min : "+row[2]);
			System.out.println("Sum : "+row[3]);
			System.out.println("Avg : "+row[4]);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		try{
			System.out.println("======================Native Queries========================");
			custRepo.createTempTable();
			System.out.println("------------------------------------------------------");
			System.out.println(custRepo.showSystemDate());
			System.out.println("-------------------------------------------------------");
			custRepo.registerCustomer("manish", "Hyd", 25000.0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
