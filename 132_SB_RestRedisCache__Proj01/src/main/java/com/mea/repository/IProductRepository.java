package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.Product;


public interface IProductRepository extends JpaRepository<Product, Integer> {

}
