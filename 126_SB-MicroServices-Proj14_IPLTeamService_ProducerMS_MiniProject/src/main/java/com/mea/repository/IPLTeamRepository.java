package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.IPLTeam;

public interface IPLTeamRepository extends JpaRepository<IPLTeam, Integer> {

}
