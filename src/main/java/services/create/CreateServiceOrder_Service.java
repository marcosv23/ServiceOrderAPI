package services.create;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Customer;
import entities.ServiceOrder;
import enums.StatusServiceOrder;
import exceptions.BusinessException;
import repositories.CustomerRepository;
import repositories.ServiceOrderRepository;
@Service
public class CreateServiceOrder_Service {
	@Autowired
    ServiceOrderRepository repo;
	
	@Autowired
	CustomerRepository customerRepo;
	

	public ServiceOrder create(ServiceOrder newServiceOrder) {
		
		
		Customer customer = customerRepo.findById(newServiceOrder.getCustomer().getId())
				.orElseThrow(()-> new BusinessException("Esse cliente não existe"));
		
		newServiceOrder.setCustomer(customer);
		newServiceOrder.setStartingDate(OffsetDateTime.now());
		newServiceOrder.setStatus(StatusServiceOrder.OPENED);
		
		return repo.save(newServiceOrder);
	}

}
