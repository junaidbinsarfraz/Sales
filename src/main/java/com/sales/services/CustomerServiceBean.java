package com.sales.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerServiceBean implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Collection<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public void add(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer findOne(Long id) {
		return customerRepository.findOne(id);
	}

}
