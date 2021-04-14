package com.api.order.service.services.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import entities.Customer;
import exceptions.BusinessException;
import repositories.CustomerRepository;

@Service
public class UpdateCustomerService {
	
	@Autowired
	private  CustomerRepository repo;
	
	 public ResponseEntity<Customer> updateEntireCustomer(Integer id, Customer customer){
		 
		if(!repo.existsById(id)) {
	        //return ResponseEntity.notFound().build();
			throw new BusinessException("Usuário não pode ser atualizado, pois não existe!");
		}
		
		customer.setId(id);
		Customer updatedCustomer = repo.save(customer);
		
		return ResponseEntity.ok().body(updatedCustomer);
		
	}

}
