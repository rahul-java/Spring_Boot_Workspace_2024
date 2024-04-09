package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

	
}
