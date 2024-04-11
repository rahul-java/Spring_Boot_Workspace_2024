package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

}
