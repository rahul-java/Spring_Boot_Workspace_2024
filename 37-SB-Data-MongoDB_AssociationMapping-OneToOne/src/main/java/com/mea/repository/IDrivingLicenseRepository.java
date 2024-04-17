package com.mea.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mea.document.DrivingLicense;

public interface IDrivingLicenseRepository extends MongoRepository<DrivingLicense, String> {

}
