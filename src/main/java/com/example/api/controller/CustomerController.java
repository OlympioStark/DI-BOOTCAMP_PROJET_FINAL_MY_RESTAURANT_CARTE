package com.example.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.exception.ResourceNotFoundException;
import com.example.api.model.Customer;
import com.example.api.repository.CustomerRepository;


@RestController
@RequestMapping("/api/mrc")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//get all customer REST api
	@GetMapping("/customer")
	public List<Customer> getAllUsers() {
		return customerRepository.findAll();
	}
	
	//create customer
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//get one customer REST api
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id : "+ id));
		return ResponseEntity.ok(customer);
	}
	
	//update REST api
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customerDetails) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id : "+ id));
		
		customer.setLastName(customerDetails.getLastName());
		customer.setFirstName(customerDetails.getFirstName());
		customer.setAddressNumber(customerDetails.getAddressNumber());
		customer.setEmail(customerDetails.getEmail());
		customer.setPassword(customerDetails.getPassword());
		
		Customer updateCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updateCustomer);
	}

	//delete REST api
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id : "+ id));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
