package com.mea.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class AReportTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("AReportTestRunner.run()");
		
		System.out.println("------------------------------------");
	}

}
