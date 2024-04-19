package com.mea.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.repository.IArtistInfoRepository;

@Component
public class MongoRepositoryQueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IArtistInfoRepository artistRepo;

	@Override
	public void run(String... args) throws Exception {

		try {
			List<Object[]> list = artistRepo.getArtistDataByCategory("hero");
			list.forEach(row->{
				System.out.println(Arrays.toString(row));
			});
			
			System.out.println("-----------------------------Without QueryMethod----------------------------------------------------");
			artistRepo.getAllArtistInfosByCategory("hero").forEach(System.out::println);
			
			System.out.println("------------------------------With QueryMethod---------------------------------------------------");
			artistRepo.fetchAllArtistInfosByCategory("hero").forEach(System.out::println);
			
			System.out.println("------------------------------With multiple condition---------------------------------------------------");
			artistRepo.fetchAllArtistInfosByCategoryAndName("hero","raja").forEach(System.out::println);
			
			
			System.out.println("------------------------------With gte and lte condition---------------------------------------------------");
			artistRepo.getArtistInfosAllDataByRemuneration(100000.0,1000000.0).forEach(System.out::println);
			
			System.out.println("------------------------------two difft condition applying using AND/OR---------------------------------------------------");
			artistRepo.getArtistDataByCategoryOrName("hero","Rani").forEach(row->{
				System.out.println(Arrays.toString(row));
			});
			
			System.out.println("------------------------------Regular Expression regex---------------------------------------------------");
			artistRepo.getArtistDataByNameInitialChars("r").forEach(System.out::println);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
