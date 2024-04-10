package com.mea.service;

import java.util.Optional;

import com.mea.entity.JobSeekerInfo;

public interface IJobSeekerMgmtService {

	public String registerJobSeekerInfo(JobSeekerInfo info);
	//public Optional<JobSeekerInfo> fetchJobSeekerInfoById(int id);
	public JobSeekerInfo fetchJobSeekerInfoById(int id);
}
