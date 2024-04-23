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
			
			System.out.println("\n\n\n\n------------------------------Regular Expression regex-----------containing given data----------------------------------------");
			artistRepo.getArtistDataByNameInitialChars("r").forEach(System.out::println); //containing given data
			
			System.out.println("------------------------------Regular Expression regex------starting with given data---------------------------------------------");
			artistRepo.getArtistDataByNameInitialChars("^r").forEach(System.out::println); //starting with given data
			
			System.out.println("------------------------------Regular Expression regex------ending with given data---------------------------------------------");
			artistRepo.getArtistDataByNameInitialChars("a$").forEach(System.out::println); //ending with given data
			
			System.out.println("\n=================================Count Records=============================================");
			System.out.println("Count Of Records By Salary Range ::: "+artistRepo.getArtistAllDataByRemunerationCount(500000.0, 1000000.0));
			
			System.out.println("\n=================================Sorting By Name=============================================");
			artistRepo.getArtistAllDataSortedByName().forEach(System.out::println);
			
			System.out.println("\n=================================Delete Records=============================================");
			System.out.println("Delete Artist whose category is null ::: "+artistRepo.removeArtistWithNoCategory()+" record is deleted successfully..");
			
			System.out.println("\n=================================Artist Records Exist or not=============================================");
			System.out.println("Artist Records Exist or not ::: "+artistRepo.isArtistDataGivenByRemunerationExistOrNot(1000000.0, 2000000.0));
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
