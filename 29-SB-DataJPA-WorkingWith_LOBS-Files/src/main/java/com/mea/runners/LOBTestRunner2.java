package com.mea.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.JobSeekerInfo;
import com.mea.service.IJobSeekerMgmtService;

@Component
public class LOBTestRunner2 implements CommandLineRunner {

	@Autowired
	private IJobSeekerMgmtService jsService;
	
	@Override
	public void run(String... args) throws Exception {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter JobSeeker id::");
		int id=sc.nextInt();
		
		
		
		System.out.println("================================================================================");
		try {
			JobSeekerInfo info = jsService.fetchJobSeekerInfoById(id);
			if(info!=null)
			{
				System.out.println(info.getJsId()+" : "+info.getJsName()+" : "+info.getJsQlfy());
				
				//read byte[] content of photo and write to destination file using streams
				byte[] photoContent=info.getPhoto();
				FileOutputStream fos=new FileOutputStream("retrieve_photo.png");
				fos.write(photoContent);
				fos.flush();
				fos.close();
				
				//read char[] content of resume and write to destination file using streams
				char[] resumeContent=info.getResume();
				FileWriter writer=new FileWriter("retieve_resume.txt");
				writer.write(resumeContent);
				writer.flush();
				writer.close();
				
				System.out.println("==========Photo and Resume are retrieved into file Successfully=============");
			}
			else {
				System.out.println("Record Not Found.....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
