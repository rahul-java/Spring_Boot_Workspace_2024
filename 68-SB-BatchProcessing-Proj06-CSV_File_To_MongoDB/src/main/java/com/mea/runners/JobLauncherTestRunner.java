package com.mea.runners;

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
public class JobLauncherTestRunner implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired 
	private Job job;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			JobParameters jobParameters = new JobParametersBuilder().addDate("startDate", new Date()).toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("JobExecution Status ::: "+execution.getExitStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
