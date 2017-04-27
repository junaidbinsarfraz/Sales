package com.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController extends BaseController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public ModelAndView showProducts() {
		List<Product> products = (List<Product>) productService.findAll();

		ModelAndView model = new ModelAndView("showProducts");

		model.addObject("products", products);

		return model;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {

		ModelAndView model = new ModelAndView("addProduct");

		return model;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addCustomer(Product product, String qty) {
		ModelAndView model = null;

		product.setQtyInStock(Integer.parseInt(qty));

		if (product.getpDesc() == null || product.getpDesc().isEmpty() || product.getQtyInStock() < 0) {
			model = new ModelAndView("addProduct");

			if (product.getpDesc() == null || product.getpDesc().isEmpty()) {
				model.addObject("emptyDescripion", "may not be empty");
			}
			if (product.getQtyInStock() < 0) {
				model.addObject("qtyInStockLessThenZero", "must be greater than or equal to 0");
			}
		} else {
			productService.add(product);

			List<Product> products = (List<Product>) productService.findAll();

			model = new ModelAndView("showProducts");

			model.addObject("products", products);
		}

		return model;

	}

}
