package com.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController extends BaseController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public ModelAndView showCustomers() {
		List<Customer> customers = (List<Customer>) customerService.findAll();

		ModelAndView model = new ModelAndView("showCustomers");

		model.addObject("customers", customers);

		return model;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addCustomer() {

		ModelAndView model = new ModelAndView("addCustomer");

		return model;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView addCustomer(Customer customer) {
		ModelAndView model = null;

		if (customer.getcName() == null || customer.getcName().isEmpty()) {
			model = new ModelAndView("addCustomer");

			model.addObject("error", "may not be empty");
		} else {
			customerService.add(customer);

			List<Customer> customers = (List<Customer>) customerService.findAll();

			model = new ModelAndView("showCustomers");

			model.addObject("customers", customers);
		}

		return model;

	}

}
