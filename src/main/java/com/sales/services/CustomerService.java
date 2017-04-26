package com.sales.services;

import java.util.Collection;

import com.sales.models.Customer;

public interface CustomerService {
	
	Collection<Customer> findAll();
	
	void add(Customer customer);
	
	Customer findOne(Long id);
	
}
