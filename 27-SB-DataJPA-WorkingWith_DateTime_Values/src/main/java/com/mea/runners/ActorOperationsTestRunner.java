package com.mea.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mea.entity.Actor;
import com.mea.service.IActorMgmtService;

@Component
public class ActorOperationsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService actorService;
	
	@Override
	public void run(String... args) throws Exception {

		/*try {
			Actor actor=new Actor("Ranbir Kapoor","Hero",LocalDate.of(1982,9,28),
					LocalTime.of(11, 21, 31),LocalDateTime.of(2007,11,21,12,10,20));
			String resMsg=actorService.registerActor(actor);
			System.out.println(resMsg);
		} catch (Exception e) {
		
			e.printStackTrace();
		}*/
		
		try {
			actorService.showAllActors().forEach(System.out::println);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
