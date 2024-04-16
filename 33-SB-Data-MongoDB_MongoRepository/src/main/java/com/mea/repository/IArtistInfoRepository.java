package com.mea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mea.document.ArtistInfo;

public interface IArtistInfoRepository extends MongoRepository<ArtistInfo, String> {

}
