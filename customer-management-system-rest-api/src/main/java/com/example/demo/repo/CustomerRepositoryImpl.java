package com.example.demo.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private final Map<String, Customer> customers;

	{
		customers = new HashMap<String, Customer>();
	}

	@Override

	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customers.put(customer.getCustomerId(), customer);
		return customer;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		Collection<Customer> collection = customers.values();
		return collection;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		// TODO Auto-generated method stub
		Customer customer = customers.get(customerId);
		if (customer == null) {
			return null;
		} else {
			return customer;
		}

	}

	@Override
	public Customer updateCustomerById(String customerId, Customer customer) {
		// TODO Auto-generated method stub
		Customer tempcustomer = customers.get(customerId);
		if (customer == null) {
			return null;
		} else {
			tempcustomer.setFirstName(customer.getFirstName());
			tempcustomer.setLastName(customer.getLastName());
			tempcustomer.setEmail(customer.getEmail());
			;
			return tempcustomer;
		}

	}

	@Override
	public String deleteCustomerById(String customerId) {
		// TODO Auto-generated method stub
		Customer tempCustomer = customers.get(customerId);
		if (tempCustomer != null) {
			customers.remove(customerId);
			return "removed.";
		}
		else
		{
			return "customer not found.. "+customerId;
		}

	}

}