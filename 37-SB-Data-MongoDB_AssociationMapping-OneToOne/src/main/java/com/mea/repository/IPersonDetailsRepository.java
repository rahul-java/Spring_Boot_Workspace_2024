package com.mea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mea.document.PersonDetails;

public interface IPersonDetailsRepository extends MongoRepository<PersonDetails, String> {

}
