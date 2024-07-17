package com.mea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Tourist;
import com.mea.repo.ITouristRepository;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepository touristRepo;
	
	
	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid = touristRepo.save(tourist).getTid();		
		return "Tourist is saved with id value : "+tid;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		return touristRepo.findAll();
	}

	@Override
	public Tourist fetchTouristById(Integer tid) {
		return touristRepo.findById(tid).orElseThrow(()->new IllegalArgumentException("Invalid Id : "+tid));
	}

	@Override
	public String updateTourist(Tourist tourist) {
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if(optional.isPresent())
		{
			touristRepo.save(tourist);
			return "Tourist Details are UPDATED SUCCESSFULLY... ";
		}
		return "Tourist is not Found for UPDATION";
	}

	@Override
	public String updateBudgetById(Integer tid, Double hikePercentage) {
		
		return null;
	}

	@Override
	public String deleteTouristById(Integer tid) {
		
		return null;
	}

}
