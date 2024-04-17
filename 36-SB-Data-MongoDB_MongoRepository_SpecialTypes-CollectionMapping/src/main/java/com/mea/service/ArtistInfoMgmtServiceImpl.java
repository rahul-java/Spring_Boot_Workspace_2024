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
	public String registerArtistInfo(ArtistInfo artistInfo) {
		String id = artistRepo.save(artistInfo).getId();
		return "Artist info document is saved with id value:"+id;
	}
	
}
