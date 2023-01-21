package com.ERMSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ERMSystem.exception.ResourceNotFoundException;
import com.ERMSystem.model.Customer;
import com.ERMSystem.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("protech/api/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//Get all Customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}

	//Create customers
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	//Get customers by Id
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id : " + id)) ;
		return ResponseEntity.ok(customer);
	}
	
	//Update Customer
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
		Customer cust = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id : " + id)) ;
		
		cust.setCname(customer.getCname());
		cust.setNic(customer.getNic());
		cust.setAddress(customer.getAddress());
		cust.setEmail(customer.getEmail());
		cust.setPhone(customer.getPhone());
		
		Customer updatedCustomer = customerRepository.save(cust);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	//Delete Customer
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id){
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exsit with id : " + id));
		
		customerRepository.delete(customer);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}



