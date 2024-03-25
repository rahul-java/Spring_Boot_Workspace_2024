package com.mea.runners;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SalesReportRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("ReportTestRunner.run()");
		System.out.println("Non-Option args ::: "+args.getNonOptionArgs());
		System.out.println("============Option Args are================");
		Set<String> optArgNames = args.getOptionNames();
		for(String name:optArgNames)
		{
			System.out.println(name+"..."+args.getOptionValues(name));
		}
	}

}
