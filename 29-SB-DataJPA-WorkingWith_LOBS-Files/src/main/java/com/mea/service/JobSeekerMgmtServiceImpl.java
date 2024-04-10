package com.mea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.JobSeekerInfo;
import com.mea.repository.IJobSeekerRepository;

@Service("jsService")
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJobSeekerRepository jsRepo;
	
	@Override
	public String registerJobSeekerInfo(JobSeekerInfo info) {

		JobSeekerInfo savedinfo = jsRepo.save(info);
		return "JobSeeker Object is saved with the id value : "+savedinfo.getJsId();
	}

	/*@Override
	public Optional<JobSeekerInfo> fetchJobSeekerInfoById(int id) {
		
		return Optional.ofNullable(jsRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid JS_ID:"+id)));
	}*/
	
	@Override
	public JobSeekerInfo fetchJobSeekerInfoById(int id) {
		
		return jsRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid JS_ID:"+id));
	}
}
