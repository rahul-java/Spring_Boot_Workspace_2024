package com.mea.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jobListener")
public class JobMonitoringListener implements JobExecutionListener {
	
	private Long start,end;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob() :: Job started at : "+new Date());
		start=System.currentTimeMillis();
	}
	
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.afterJob() :: Job Exit status : "+jobExecution.getExitStatus()+" at ::: "+new Date());
		end=System.currentTimeMillis();
		System.out.println("Job Execution Time is ::: "+(end-start)+" ms");
	}
}
