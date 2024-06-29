package com.mea.runners;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchTestRunner implements CommandLineRunner {

	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;
	
	@Override
	public void run(String... args) throws Exception {
		
		JobParameters parameter=new JobParametersBuilder()
				                     .addDate("date", new Date())
				                     .toJobParameters();
		JobExecution execution=launcher.run(job, parameter);
		System.out.println("Job Execution Status ::: "+execution.getExitStatus());
		
		System.out.println("Press Any Key to Continue.......");
		System.in.read();
	}

}
