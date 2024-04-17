package com.mea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mea.document.Artist;

public interface IArtistInfoRepository extends MongoRepository<Artist, Integer> {

}
