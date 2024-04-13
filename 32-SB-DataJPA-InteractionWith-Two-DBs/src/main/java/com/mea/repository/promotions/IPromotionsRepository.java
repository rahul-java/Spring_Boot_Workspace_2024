package com.mea.repository.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.promotions.Promotions;

public interface IPromotionsRepository extends JpaRepository<Promotions, Long> {

}
