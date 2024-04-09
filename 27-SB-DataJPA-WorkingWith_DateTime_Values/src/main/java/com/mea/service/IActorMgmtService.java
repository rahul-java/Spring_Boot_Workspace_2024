package com.mea.service;

import java.util.List;

import com.mea.entity.Actor;

public interface IActorMgmtService {

	public String registerActor(Actor actor);
	public List<Actor> showAllActors();
}
