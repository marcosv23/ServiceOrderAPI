package com.api.order.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.order.service.entities.Customer;
import com.api.order.service.services.CustomerService;

@RestController
public class CustomerResource {
	
	@Autowired
	CustomerService service;
	
	
	@GetMapping("/customers")
	public List<Customer> findAll() {
		//return customerManager.createQuery("from Cliente", Customer.class)
		//.getResultList();
		
		return service.findAll();
	}
	
	@GetMapping("customers/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
	  Customer customer = service.findById(id);
	  return ResponseEntity.ok().body(customer);
		
	}
}
