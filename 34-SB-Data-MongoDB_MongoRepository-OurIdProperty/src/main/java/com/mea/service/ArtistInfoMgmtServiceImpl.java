package com.mea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mea.document.Artist;
import com.mea.repository.IArtistInfoRepository;

@Service("artistService")
public class ArtistInfoMgmtServiceImpl implements IArtistInfoMgmtService {

	@Autowired
	private IArtistInfoRepository artistRepo;
	
	@Override
	public String registerArtist(Artist artistInfo) {
		
		Integer id = artistRepo.save(artistInfo).getId();
		return "ArtistInfo document is saved with id value :"+id;
	}
	
	
}
