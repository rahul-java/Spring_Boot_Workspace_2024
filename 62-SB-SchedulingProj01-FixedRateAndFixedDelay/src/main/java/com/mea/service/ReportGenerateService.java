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
	
	@Scheduled(fixedRate =  10000) //fixedRate is nothing but maximum time
	public void generateReport() {
		System.out.println("ReportGenerateService.generateReport() ::: Sales Report on:"+new Date());
		
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(":::::::::::============END===============::::::::::::"+new Date());
	}
}
