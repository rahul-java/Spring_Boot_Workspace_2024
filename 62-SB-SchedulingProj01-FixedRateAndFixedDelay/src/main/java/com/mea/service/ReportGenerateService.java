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

	// Exception Will Occur
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

	// cron="* * 20 * * *" => every day 8pm each min each sec
	// cron="10 * 20 * * *" => every day 8pm each min 10 sec

	/*@Scheduled(cron =  "10 * 14 * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 14:42:10 IST 2024
		//Sun Jun 23 14:43:10 IST 2024
	}*/

	/*@Scheduled(cron =  "* * * * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//every hour every min every sec everyday
	}*/

	/*//Execute task every hour at 8th min and 10th min
	@Scheduled(cron =  "0 8,10 * * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: "+new Date());
		//Sun Jun 23 15:08:00 IST 2024
		//Sun Jun 23 15:10:00 IST 2024
	}*/

	/*// Execute task from 13th min to 20th min on 30 sec of every hour
	@Scheduled(cron = "30 13-20 * * * *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: " + new Date());
		// Sun Jun 23 15:13:30 IST 2024
		// Sun Jun 23 15:14:30 IST 2024
		// Sun Jun 23 15:15:30 IST 2024
		// Sun Jun 23 15:16:30 IST 2024
	}*/

	/*	// Execute task on leap Year February 29 at 10 am
		@Scheduled(cron = "0 0 10 29 2 *") // second minute hour date month WeekDay
		public void generateReport1() {
			System.out.println("ReportGenerateService.generateReport1() ::: " + new Date());
		}*/

	/*// Execute task on every 15th august 09:00:00am
	@Scheduled(cron = "0 0 9 15 8 *") // second minute hour date month WeekDay
	public void generateReport1() {
		System.out.println("Happy Independence Day ::: " + new Date());
	}*/

	/*// Execute task to wish me on my birthday only if it is Sunday 12:00AM
	//@Scheduled(cron = "0 0 0 23 6 SUN") // second minute hour date month WeekDay(SUN as Sunday)
	//@Scheduled(cron = "0 33 15 23 6 0") // second minute hour date month WeekDay(0/7 as Sunday)
	//@Scheduled(cron = "0 34 15 23 6 7") // second minute hour date month WeekDay(0/7 as Sunday)
	@Scheduled(cron = "0 35 15 23 6 SUN") // second minute hour date month WeekDay(SUN as Sunday)
	public void generateReport1() {
		System.out.println("Wish You a very happy birthday ::: " + new Date());
	}*/

	/*// Execute task at 10 am at every Sunday
		@Scheduled(cron = "0 0 9 * * SUN") // second minute hour date month WeekDay(SUN as Sunday)
		public void generateReport1() {
			System.out.println("Wish You a very happy Sunday ::: " + new Date());
		}*/

	/*// Execute task on every year 1st of jan only if Sunday
	@Scheduled(cron = "0 0 0 1 1 0") // Sun Jan 01 00:00:00 IST 2024
	public void generateReport1() {
		System.out.println("Wish You a very happy new Year Sunday ::: " + new Date());
	}*/

	/*// Execute task at 10am only on Sun -Thu days of week
	// @Scheduled(cron = "0 0 10 * * 0-4")
	@Scheduled(cron = "0 0 10 * * SUN-THU")
	public void generateReport1() {
		System.out.println("Daily Task ::: " + new Date());
	}*/

	/*// Execute task on every 23rd June only if it is Tuesday
	// @Scheduled(cron = "0 0 10 23 6 2")
	@Scheduled(cron = "0 0 10 23 6 TUE")
	public void generateReport1() {
		System.out.println("Daily Task ::: " + new Date());
	}*/

	/*// ? :: is used for any WeekDay for WeekDay Column
	// Execute task on any weekday of the Oct at 10am
	@Scheduled(cron = "0 0 10 * 10 ?")
	public void generateReport1() {
		System.out.println("Daily Task ::: " + new Date());
	}*/

	// ? :: is used for any WeekDay for WeekDay Column
	// ? can be used in place of * for any
	// Execute task on any weekday of the Nov month having weekday Sun-Thu
	/*@Scheduled(cron = "0 0 10 ? 11 SUN-THU")
	public void generateReport1() {
		System.out.println("Daily Task ::: " + new Date());
	}*/

	// 0/20 => inital time 0 and delay time 20
	/*@Scheduled(cron = "0/20 * * * * *")
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: " + new Date());
		//Sun Jun 23 16:10:00 IST 2024
		//Sun Jun 23 16:10:20 IST 2024
		//Sun Jun 23 16:10:40 IST 2024
		//Sun Jun 23 16:11:00 IST 2024
	}*/

	// every hour start at 0 min 10 sec and repeat after every 15 min delay
	@Scheduled(cron = "10 0/15 * * * *")
	public void generateReport1() {
		System.out.println("ReportGenerateService.generateReport1() ::: " + new Date());
		// Sun Jun 23 16:00:10 IST 2024
		// Sun Jun 23 16:15:10 IST 2024
	}
}
