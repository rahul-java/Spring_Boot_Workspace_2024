package com.mea.service;

import com.mea.entity.product.Product;
import com.mea.entity.promotions.Promotions;

public interface ITwoDBsMgmtService {

	public String saveData(Product product,Promotions promotions);
}
