package com.mea.scheduler;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired 
	private Job job;
	
	@Scheduled(cron = "0 29/2 * * * *")
	public void executeJob() {
		System.out.println("JobScheduler.executeJob() ::: "+new Date());
		
		try {
			JobParameters jobParameters = new JobParametersBuilder().addDate("startDate", new Date()).toJobParameters();
			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("JobExecution Status ::: "+execution.getExitStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
