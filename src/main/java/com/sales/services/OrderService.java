package com.sales.services;

import java.util.Collection;

import com.sales.models.Order;

public interface OrderService {
	
	Collection<Order> findAll();
	
	String save(Order order);
	
}
