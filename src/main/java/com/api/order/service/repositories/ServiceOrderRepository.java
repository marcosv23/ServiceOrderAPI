package com.api.order.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.order.service.entities.ServiceOrder;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer>{

}