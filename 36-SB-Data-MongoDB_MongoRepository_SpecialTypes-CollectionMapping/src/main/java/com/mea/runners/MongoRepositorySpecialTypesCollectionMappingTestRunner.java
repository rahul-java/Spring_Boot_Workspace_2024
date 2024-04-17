package com.mea.runners;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.document.ArtistInfo;
import com.mea.service.IArtistInfoMgmtService;

@Component
public class MongoRepositorySpecialTypesCollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IArtistInfoMgmtService artistService;

	@Override
	public void run(String... args) throws Exception {

		try {
			ArtistInfo info=new ArtistInfo();
			info.setName("Rahul");
			info.setCategory("HERO");
			info.setNickNames(List.of("PandeyJi","Genius"));
			info.setFriends(new String[] {"Gagan","Ravi","Ajith"});
			info.setPhoneNumbers(Set.of(9565501695L,8299552516L));
			info.setRemuneration(50565.0);
			info.setMoviesInfo(Map.of("FirstMovie",2006,"SecondMovie",2008,"ThirdMovie",2011));
			Properties props=new Properties();
			props.setProperty("aadhar", "123654789321");
			props.setProperty("voterId", "14785239");
			props.setProperty("DriverLicense", "DL123456");
			info.setIdDetails(props);
			
			String resMsg = artistService.registerArtistInfo(info);
			System.out.println(resMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
