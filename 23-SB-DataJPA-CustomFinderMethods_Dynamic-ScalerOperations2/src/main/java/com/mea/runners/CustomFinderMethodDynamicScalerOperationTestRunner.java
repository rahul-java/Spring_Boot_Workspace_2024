package com.mea.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Customer;
import com.mea.repository.ICustomerRepository;
import com.mea.view.IResultView1;
import com.mea.view.IResultView2;
import com.mea.view.IResultView3;
import com.mea.view.IResultView4;
import com.mea.view.IView;

@Component
public class CustomFinderMethodDynamicScalerOperationTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository custRepo;

	@Override
	public void run(String... args) throws Exception {

		
		try {
			System.out.println("Repository obj proxy class name :: "+custRepo.getClass().getName());
			
			System.out.println("-----------------------------IResultView1---------------------------------------------");
			
			List<IResultView1> list1=custRepo.findByBillAmtBetween(5000.0, 20000.0,IResultView1.class);
			list1.forEach(view1->{
				System.out.println("ResultView Proxy class name ::: "+view1.getClass().getName());
				System.out.println(view1.getCno()+"  :::  "+view1.getCname());
			});
			
			System.out.println("---------------------------IResultView2----------------------------------");
			
			List<IResultView2> list2=custRepo.findByBillAmtBetween(5000.0, 20000.0,IResultView2.class);
			list2.forEach(view2->{
				System.out.println("ResultView Proxy class name ::: "+view2.getClass().getName());
				System.out.println(view2.getCno()+"  :::  "+view2.getCname()+"  :::  "+view2.getCadd());
			});
			
			System.out.println("---------------------------IResultView3----------------------------------");
			
			List<IResultView3> list3=custRepo.findByBillAmtBetween(5000.0, 20000.0,IResultView3.class);
			list3.forEach(view3->{
				System.out.println("ResultView Proxy class name ::: "+view3.getClass().getName());
				System.out.println(view3.getCno()+"  :::  "+view3.getCname()+"  :::  "+view3.getBillAmt());
			});
			
			System.out.println("----------------------------IResultView4---------------------------------");
			
			List<IResultView4> list4=custRepo.findByBillAmtBetween(5000.0, 20000.0,IResultView4.class);
			list4.forEach(view4->{
				System.out.println("ResultView Proxy class name ::: "+view4.getClass().getName());
				System.out.println(view4.getCname()+"  :::  "+view4.getBillAmt());
			});
			System.out.println("-------------------------------------------------------------");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
