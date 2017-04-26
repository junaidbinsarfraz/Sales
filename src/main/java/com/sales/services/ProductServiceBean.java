package com.sales.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

public class ProductServiceBean implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Collection<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void add(Product product) {
		productRepository.save(product);
	}

	@Override
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

}
