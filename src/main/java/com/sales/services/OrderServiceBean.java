package com.sales.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderRepository;

@Service
public class OrderServiceBean implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	private ProductService productService;
	private CustomerService customerService;
	
	@Override
	public Collection<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public String save(Order order) {
		
		String result = "";
		
		Product product = productService.findOne(order.getProd().getpId());
		Customer customer = customerService.findOne(order.getCust().getcId());

//		(product == null) ? (result += "No such product: " + order.getProd().getpId()) : result = "";
		if(product == null) {
			result += "No such product: " + order.getProd().getpId() + " ";
		}
		
		if(customer == null) {
			result += "No such customer: " + order.getCust().getcId();
		}
		
		int qtyInStock = product.getQtyInStock();
		
		if(qtyInStock < order.getQty()) {
			result += " Quantity too large: Product stock = " + qtyInStock;
		}
		
		if(Boolean.TRUE.equals(result.isEmpty())) {
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			order.setOrderDate(dateFormat.format(calendar.getTime()));
			order.getProd().setQtyInStock(qtyInStock - order.getQty());
			
			orderRepository.save(order);
		}
 		
		return result;
	}
	
}
