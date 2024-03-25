package com.mea.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(2)
public class ReportTestRunner implements CommandLineRunner, Ordered {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ReportTestRunner.run()");
		for(String arg:args)
		{
			System.out.print(arg+"  ");
		}
		System.out.println();
		System.out.println("------------------------------------");
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
