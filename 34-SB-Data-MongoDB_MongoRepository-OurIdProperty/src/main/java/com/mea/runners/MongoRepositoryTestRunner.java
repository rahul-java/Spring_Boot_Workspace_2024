package com.mea.runners;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.document.Artist;
import com.mea.service.IArtistInfoMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IArtistInfoMgmtService artistService;

	@Override
	public void run(String... args) throws Exception {

		
		
		try {
		
			Artist info1=new Artist(new Random().nextInt(100000),"VK","hero",50000.0,LocalDateTime.of(1989, 10,20,12,45,10),true);
			String resMsg = artistService.registerArtist(info1);
			System.out.println(resMsg);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
