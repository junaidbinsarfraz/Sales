package com.sales.services;

import java.util.Collection;

import com.sales.models.Product;

public interface ProductService {
	
	Collection<Product> findAll();
	
	void add(Product product);
	
	Product findOne(Long id);
	
}
