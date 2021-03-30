package com.api.order.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.order.service.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
