package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.createCustomer(customer);
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Customer updateCustomerById(String customerId, Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.updateCustomerById(customerId, customer);
	}

	@Override
	public String deleteCustomerById(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.deleteCustomerById(customerId);

	}

}