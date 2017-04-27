package com.sales.exceptions;

import com.sales.models.Order;

public class OrderCreationException extends Exception {
	
	private Order order;
	
	public OrderCreationException(String message, Order order) {
        super(message);
        this.order = order;
    }

	public Order getOrder() {
		return order;
	}

}
