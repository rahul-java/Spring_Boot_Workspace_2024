package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.JobSeekerInfo;

public interface IJobSeekerRepository extends JpaRepository<JobSeekerInfo, Integer> {

}
