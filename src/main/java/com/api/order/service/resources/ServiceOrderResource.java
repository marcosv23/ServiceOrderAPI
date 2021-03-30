package com.api.order.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.order.service.entities.ServiceOrder;
import com.api.order.service.services.ServiceOrderService;

@RestController
public class ServiceOrderResource {
	
	@Autowired
	ServiceOrderService service;
	
	@GetMapping("/serviceOrder/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
	  ServiceOrder serviceOrder = service.findById(id);
	  return ResponseEntity.ok().body(serviceOrder);
		
	}
	
	@GetMapping("/serviceOrder")
	public ResponseEntity<?> findAll(){
		List<ServiceOrder> so = service.findAll();
		
		return ResponseEntity.ok().body(so);
		
	}
}