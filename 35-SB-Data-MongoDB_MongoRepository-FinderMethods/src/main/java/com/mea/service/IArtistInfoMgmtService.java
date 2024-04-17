package com.mea.service;

import java.util.List;

import com.mea.document.ArtistInfo;

public interface IArtistInfoMgmtService {
	
	public List<ArtistInfo> showArtistByRemunerationBetween(Double start,Double end);
	public List<ArtistInfo> showArtistByCategories(String... category);
	public ArtistInfo showArtistByName(String name);
}
