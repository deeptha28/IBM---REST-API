package com.example.demo.rest;

import java.util.Collection;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping(produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(UUID.randomUUID().toString());
		return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	public ResponseEntity<Collection<Customer>> getAllCustomers() {
		return new ResponseEntity<Collection<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") String customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer == null) {
			return new ResponseEntity<String>("customer with " + customerId + " not found ", HttpStatus.NOT_FOUND);
		}

		else {
			return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
		}
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("customerId") String customerId,
			@RequestBody Customer customer)

	{
		Customer tempCustomer = customerService.updateCustomerById(customerId, customer);
		if (tempCustomer == null) {
			return new ResponseEntity<String>("customer with " + customerId + " not found ", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Customer>(tempCustomer, HttpStatus.OK);
		}

	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteBycustomerId(@PathVariable("customerId") String customerId) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomerById(customerId));
	}

}