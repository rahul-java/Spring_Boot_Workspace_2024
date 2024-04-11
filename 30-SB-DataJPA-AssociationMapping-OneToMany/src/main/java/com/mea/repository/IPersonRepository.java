package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
