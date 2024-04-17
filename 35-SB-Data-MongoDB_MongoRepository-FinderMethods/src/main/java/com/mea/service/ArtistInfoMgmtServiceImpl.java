package com.mea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mea.document.ArtistInfo;
import com.mea.repository.IArtistInfoRepository;

@Service("artistService")
public class ArtistInfoMgmtServiceImpl implements IArtistInfoMgmtService {

	@Autowired
	private IArtistInfoRepository artistRepo;

	@Override
	public List<ArtistInfo> showArtistByRemunerationBetween(Double start, Double end) {
		
		return artistRepo.findByRemunerationBetween(start, end);
	}

	@Override
	public List<ArtistInfo> showArtistByCategories(String... category) {
		return artistRepo.findByCategoryIn(category);
	}

	@Override
	public ArtistInfo showArtistByName(String name) {
		return artistRepo.findByName(name);
	}
	
	
}
