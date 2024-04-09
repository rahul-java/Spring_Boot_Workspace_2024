package com.mea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Actor;
import com.mea.repository.IActorRepository;

@Service("actorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepository actorRepo;
	
	@Override
	public String registerActor(Actor actor) {

		Actor savedActor = actorRepo.save(actor);
		return "Actor object is saved with the id value : "+savedActor.getAid();
	}
	
	@Override
	public List<Actor> showAllActors() {
		return actorRepo.findAll();
	}

}
