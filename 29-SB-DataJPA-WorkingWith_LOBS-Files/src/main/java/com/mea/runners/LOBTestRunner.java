package com.mea.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.JobSeekerInfo;
import com.mea.service.IJobSeekerMgmtService;

//@Component
public class LOBTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService jsService;
	
	@Override
	public void run(String... args) throws Exception {

		Scanner sc=new Scanner(System.in);
		System.out.println("JobSeeker Name::");
		String name=sc.next();
		System.out.println("JobSeeker Qualification::");
		String qlfy=sc.next();
		System.out.println("JobSeeker is Married Person::");
		Boolean maritalStatus=sc.nextBoolean();
		System.out.println("JobSeeker Photo File Path::");
		String photoPath=sc.next();
		System.out.println("JobSeeker Resume File Path::");
		String resumePath=sc.next();
		
		//create stream having photo file and get byte[] from that file
		FileInputStream fis=new FileInputStream(photoPath);
		byte[] photoContent=fis.readAllBytes();
		
		//create stream having resume file and get char[] from that file
		File resumeFile=new File(resumePath);
		FileReader reader=new FileReader(resumeFile);
		char[] resumeContent=new char[(int) resumeFile.length()];
		reader.read(resumeContent);
		
		//create object of JobSeeker
		JobSeekerInfo info = new JobSeekerInfo(name,qlfy,maritalStatus,photoContent,resumeContent);
		
		System.out.println("================================================================================");
		try {
			String resMsg = jsService.registerJobSeekerInfo(info);
			System.out.println(resMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
