package com.api.order.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.order.service.entities.ServiceOrder;
import com.api.order.service.repositories.ServiceOrderRepository;
@Service
public class ServiceOrderService {

	
	
	@Autowired
    ServiceOrderRepository repo;
	
	public ServiceOrder findById(Integer id) {
		
		 Optional<ServiceOrder> serviceOrder =  repo.findById(id);
		 
		 return serviceOrder.orElse(null);
	}
	
	public List<ServiceOrder> findAll(){
		
		return repo.findAll();
		
	}

}
