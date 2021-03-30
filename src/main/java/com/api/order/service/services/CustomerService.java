package com.api.order.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.order.service.entities.Customer;
import com.api.order.service.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    CustomerRepository repo;
	
	public Customer findById(Integer id) {
		
		 Optional<Customer> com =  repo.findById(id);
		 
		 return com.orElse(null);
	}

	
public List<Customer> findAll(){
		
		return repo.findAll();
		
	}

}
