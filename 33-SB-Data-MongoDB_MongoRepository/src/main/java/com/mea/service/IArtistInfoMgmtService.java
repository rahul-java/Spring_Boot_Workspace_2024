package com.mea.service;

import java.util.List;

import com.mea.document.ArtistInfo;

public interface IArtistInfoMgmtService {

	public String registerArtist(ArtistInfo artistInfo);
	public List<ArtistInfo> showAllArtistInfo();
	public String showArtistById(String id);
	public String updateArtistrRemuneration(String id,Double hike);
	public String removeArtistById(String id);
	
	public List<ArtistInfo> showAllArtistInfoBySorting(Boolean asc,String...properties);
	public String insertArtistInfo(ArtistInfo artistInfo);
}
