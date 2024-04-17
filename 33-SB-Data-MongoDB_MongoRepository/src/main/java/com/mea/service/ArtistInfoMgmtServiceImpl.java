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
	public String registerArtist(ArtistInfo artistInfo) {
		
		String id = artistRepo.save(artistInfo).getId();
		return "ArtistInfo document is saved with id value :"+id;
	}
	
	@Override
	public List<ArtistInfo> showAllArtistInfo() {

		List<ArtistInfo> list = artistRepo.findAll();
		return list;
	}
	
	@Override
	public String showArtistById(String id) {
		Optional<ArtistInfo> optional=artistRepo.findById(id);
		if(optional.isPresent())
		{
			ArtistInfo info = optional.get();
			System.out.println(info);
			return id+" Artist is Found...";
		}
		return id+" Artist is not Present..";
	}
	
	@Override
	public String updateArtistrRemuneration(String id, Double hike) {
		Optional<ArtistInfo> optional = artistRepo.findById(id);
		if(optional.isPresent())
		{
			ArtistInfo info = optional.get();
			double newRemuneration=info.getRemuneration()*hike/100.0+info.getRemuneration();
			info.setRemuneration(newRemuneration);
			artistRepo.save(info);
			return id+" Document is updated with new Remuneration Hike :"+hike+"%";
		}
		return id+" Artist in not FOUND...";
	}
	
	@Override
	public String removeArtistById(String id) {
		Optional<ArtistInfo> optional = artistRepo.findById(id);
		if(optional.isPresent())
		{
			artistRepo.deleteById(id);
			return id+" is found and deleted.";
		}
		return id+" is not FOUND for deletion...";
	}
	
	@Override
	public List<ArtistInfo> showAllArtistInfoBySorting(Boolean asc, String... properties) {
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, properties);
		List<ArtistInfo> list = artistRepo.findAll(sort);
		return list;
	}
	
	@Override
	public String insertArtistInfo(ArtistInfo artistInfo) {

		String id = artistRepo.insert(artistInfo).getId();
		
		return " ArtistInfo document is saved having id value :"+id;
	}

}
