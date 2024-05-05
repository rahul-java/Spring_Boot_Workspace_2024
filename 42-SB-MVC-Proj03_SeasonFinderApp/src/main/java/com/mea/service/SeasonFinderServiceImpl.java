package com.mea.service;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.stereotype.Service;

@Service("seasonFinderService")
public class SeasonFinderServiceImpl implements ISeasonFinderService {

	@Override
	public String findSeason() {
		LocalDateTime ldt = LocalDateTime.now();
		int monthValue = ldt.getMonthValue();
		if(monthValue>=3&&monthValue<=6)
			return "Summer Season";
		else if(monthValue>=7&&monthValue<=10)
			return "Rainy Season";
		else
			return "Winter Season";
		
		
	}

}
