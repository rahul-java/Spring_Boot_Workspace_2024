package com.mea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.mea.sbeans.CompanyInfo;

@SpringBootApplication
@PropertySource("myfile.properties")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		CompanyInfo companyInfo = ctx.getBean("company",CompanyInfo.class);
		System.out.println(companyInfo);
		((ConfigurableApplicationContext) ctx).close();
	}

}
