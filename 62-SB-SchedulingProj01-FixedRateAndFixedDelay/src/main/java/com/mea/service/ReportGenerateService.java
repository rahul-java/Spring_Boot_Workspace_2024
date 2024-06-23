package com.mea.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerateService {

	/*@Scheduled(initialDelay = 2000,fixedDelay = 3000)
	public void generateReport() {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
	}*/
	
	/*	@Scheduled(fixedDelay = 3000)
		public void generateReport() {
			System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
		}*/
	
	//Exception Will Occur
	/*@Scheduled()
	public void generateReport {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
	}*/
	
	/*@Scheduled(fixedDelayString = "3000")
	public void generateReport() {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(":::::::::::============END===============::::::::::::"+new Date());
	}*/
	
	/*@Scheduled(fixedRate =  10000)
	public void generateReport() {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(":::::::::::============END===============::::::::::::"+new Date());
	}
	*/
	
	/*@Scheduled(fixedRate =  10000) //fixedRate is nothing but maximum time
	public void generateReport() {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(":::::::::::============END===============::::::::::::"+new Date());
	}*/
	
	/*@Scheduled(fixedRate =  10000) //fixedRate is nothing but maximum time
	public void generateReport() {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
		
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(":::::::::::============END===============::::::::::::"+new Date());
	}*/
	
	/*@Scheduled(fixedDelay = 3000)
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: Sales Report on:"+new Date()+" Started... Thread Name :::"+Thread.currentThread().getName());
		System.out.println("--------------------------------------------");
	}
	
	@Scheduled(fixedDelay = 3000)
	public void generateReport2() {
		System.out.println("ReportGenerateService.generateReport2() ::: Sales Report on:"+new Date()+" Started... Thread Name :::"+Thread.currentThread().getName());
		System.out.println("=================================================");
	}*/
	
	/*@Scheduled(cron =  "15 * * * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 14:25:15 IST 2024
	}*/
	
	/*@Scheduled(cron =  "30 27 * * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 14:27:30 IST 2024
	}*/
	
	/*//                  s :m :h :date : everyMonth : 
	@Scheduled(cron =  "40 30 10 1 * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sat Jun 01 10:30:40 IST 2024
	}*/
	
	/*@Scheduled(cron =  "40 32 14 23 * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 14:32:40 IST 2024
	}*/
	
	/*//every day evening 8:30:20pm task should be executed
	@Scheduled(cron =  "20 30 20 * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 20:30:30 IST 2024
	}*/
	
	//cron="* * 20 * * *" => every day 8pm each min each sec
	//cron="10 * 20 * * *" => every day 8pm each min 10 sec
	
	
	@Scheduled(cron =  "10 * 14 * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 14:42:10 IST 2024
		//Sun Jun 23 14:43:10 IST 2024
	}
}
