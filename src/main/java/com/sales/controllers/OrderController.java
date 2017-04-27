package com.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sales.exceptions.OrderCreationException;
import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.OrderService;

@Controller
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public ModelAndView showOrders() {
		List<Order> orders = (List<Order>) orderService.findAll();

		ModelAndView model = new ModelAndView("showOrders");

		model.addObject("orders", orders);

		return model;
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public ModelAndView addOrder() {

		ModelAndView model = new ModelAndView("addOrder");

		return model;
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST) 
	public ModelAndView addOrder(String qty, String cId, String pId) throws OrderCreationException {
		ModelAndView model = null;
		
		int quantity = Integer.parseInt(qty);
		
		if (quantity < 1) {
			model = new ModelAndView("addOrder");

			model.addObject("qtyInStockLessThenOne", "must be greater than or equal to 1");
		} else {
			
			Product product = new Product();
			
			product.setpId(Long.parseLong(pId));
			
			Customer customer = new Customer();
			
			customer.setcId(Long.parseLong(cId));
			
			Order order = new Order();
			
			order.setProd(product);
			order.setCust(customer);
			order.setQty(quantity);
			
			String result = orderService.save(order);
			
			if(Boolean.TRUE.equals(result.isEmpty())) {
				
				List<Order> orders = (List<Order>) orderService.findAll();
				
				model = new ModelAndView("showOrders");
				
				model.addObject("orders", orders);
			} else {
				throw new OrderCreationException(result, order);
			}
		}

		return model;
	}
	
	@ExceptionHandler(OrderCreationException.class)
	public ModelAndView handleOrderCreationException(OrderCreationException orderCreationException) {
		logger.error("> handleOrderCreationException");
		
		Order order = orderCreationException.getOrder();
		
		ModelAndView model = new ModelAndView("orderCreationException");
		
		model.addObject("exception", orderCreationException.getMessage());
		model.addObject("productId", order.getProd().getpId() + "");
		model.addObject("customerId", order.getCust().getcId() + "");
		model.addObject("quantity", order.getQty() + "");
		
		logger.error("< handleOrderCreationException");
		
		return model;
	}

}
