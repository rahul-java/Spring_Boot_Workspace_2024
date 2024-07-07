package com.mea;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	 

	public static void main(String[] args) {
		
		System.out.println("Application.main() ::: START");
		
		SpringApplication.run(Application.class, args);
		
		
		System.out.println("Application.main() ::: END");
	}

}
