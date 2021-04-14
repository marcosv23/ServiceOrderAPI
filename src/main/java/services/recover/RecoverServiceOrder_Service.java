package services.recover;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.ServiceOrder;
import repositories.ServiceOrderRepository;

@Service
public class RecoverServiceOrder_Service {

	@Autowired
    ServiceOrderRepository repo;
	
	public  Optional<ServiceOrder> findById(Integer id) {
	 Optional<ServiceOrder> serviceOrder =  repo.findById(id);
	 return serviceOrder;
	 
	}
	
	public List<ServiceOrder> findAll(){
		return repo.findAll();
		
	}
	
	}
	

