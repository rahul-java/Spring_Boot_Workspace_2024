package com.mea.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class ReportTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ReportTestRunner.run()");
		for(String arg:args)
		{
			System.out.print(arg+"  ");
		}
		System.out.println("------------------------------------");
	}

}
