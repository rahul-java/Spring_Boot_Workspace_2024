package com.mea.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(30)
public class BReportTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("BReportTestRunner.run()");
		
		System.out.println("------------------------------------");
	}

}
