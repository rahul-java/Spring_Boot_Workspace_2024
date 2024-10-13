package com.mea.service;

import java.util.List;

import com.mea.entity.Product;

public interface IProductMgmtService {
    public  Product  addProduct(Product prodcut);
    public  List<Product>  showAllProducts();
    public  String  deleteProduct(int pid);
    public  Product  findProductById(int pid);
    
}
