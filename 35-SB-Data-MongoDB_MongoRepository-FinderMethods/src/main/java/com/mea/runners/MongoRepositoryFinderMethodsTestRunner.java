package com.mea.runners;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.document.ArtistInfo;
import com.mea.service.IArtistInfoMgmtService;

@Component
public class MongoRepositoryFinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IArtistInfoMgmtService artistService;

	@Override
	public void run(String... args) throws Exception {

		List<ArtistInfo> list = artistService.showArtistByRemunerationBetween(10000.0, 2000000.0);
		list.forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------");
		List<ArtistInfo> list2 = artistService.showArtistByCategories("hero",null,"heroine");
		list2.forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------");
		ArtistInfo info = artistService.showArtistByName("Rahul");
		System.out.println(info);
		
	}

}
