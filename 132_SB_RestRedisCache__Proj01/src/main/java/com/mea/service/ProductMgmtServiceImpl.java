package com.mea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mea.entity.Product;
import com.mea.repository.IProductRepository;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {
	@Autowired
	private IProductRepository  prodRepo;

	@Override
	@CachePut(value="prods",key="#product.pid")
	public Product addProduct(Product product) {
		Product savedProduct=prodRepo.save(product);
		return savedProduct;
	}

	@Override
	@Cacheable(value="prods")
	public List<Product> showAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	@CacheEvict(value="prods", key="#pid")
	public String deleteProduct(int pid) {
		//load product
		Optional<Product> opt=prodRepo.findById(pid);
		if(opt.isPresent()) {
			prodRepo.deleteById(pid);
			return " Product is found and deleted";
		}
		return "Product is not found for deletion";
	}

	@Override
	@Cacheable(value="prods",key="#pid")
	public Product findProductById(int pid) {
		return prodRepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Invalid  Pid"));
	}

}
