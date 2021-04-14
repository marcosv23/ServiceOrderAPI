package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.ServiceOrder;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer>{

}