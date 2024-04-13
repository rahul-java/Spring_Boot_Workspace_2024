package com.mea.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.product.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
