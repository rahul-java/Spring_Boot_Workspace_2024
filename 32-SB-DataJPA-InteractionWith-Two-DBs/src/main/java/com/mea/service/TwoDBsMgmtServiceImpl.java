package com.mea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.product.Product;
import com.mea.entity.promotions.Promotions;
import com.mea.repository.product.IProductRepository;
import com.mea.repository.promotions.IPromotionsRepository;

@Service
public class TwoDBsMgmtServiceImpl implements ITwoDBsMgmtService {

	@Autowired
	private IProductRepository productRepo;
	@Autowired
	private IPromotionsRepository promotionsRepo;
	
	@Override
	public String saveData(Product product, Promotions promotions) {

		Integer pid = productRepo.save(product).getPid();
		Long prid = promotionsRepo.save(promotions).getPrid();
		
		return "Product and Promotions are saved in two difft DBs having values pid:"+pid+" , prid:"+prid;
	}
}
