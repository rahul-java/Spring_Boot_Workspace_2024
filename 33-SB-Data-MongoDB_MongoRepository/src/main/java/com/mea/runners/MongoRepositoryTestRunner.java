package com.mea.runners;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.document.ArtistInfo;
import com.mea.service.IArtistInfoMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IArtistInfoMgmtService artistService;
	
	@Override
	public void run(String... args) throws Exception {

		/*try {
			ArtistInfo info1=new ArtistInfo("raja","hero",456788.0,LocalDateTime.of(1989, 10,20,12,45,10),true);
			String resMsg1 = artistService.registerArtist(info1);
			System.out.println("Artist Document is saved : "+resMsg1);
			System.out.println("---------------------------------------------------------------");
			ArtistInfo info2=new ArtistInfo("rani","heroine",456788.0,LocalDateTime.of(1999, 11,24,01,45,10),true);
			String resMsg2 = artistService.registerArtist(info2);
			System.out.println("Artist Document is saved : "+resMsg2);
			System.out.println("---------------------------------------------------------------");
			ArtistInfo info3=new ArtistInfo();
			info3.setName("Rahul");
			info3.setCategory("software developer");
			info3.setRemuneration(1000000.0);
			String resMsg3 = artistService.registerArtist(info3);
			System.out.println("Artist Document is saved : "+resMsg3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<ArtistInfo> showAllArtistInfo = artistService.showAllArtistInfo();
			System.out.println("===========================All Artist Info=========================");
			showAllArtistInfo.forEach(System.out::println);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}*/
		
		/*try {
			String msg = artistService.showArtistById("661e997bc739a85a101c5253");
			System.out.println(msg);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}*/
		
		/*try {
			String msg = artistService.updateArtistrRemuneration("661e997bc739a85a101c5253",100.0);
			System.out.println(msg);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}*/
		
		try {
		String msg = artistService.removeArtistById("661e997bc739a85a101c5253");
		System.out.println(msg);
	
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	}

}
