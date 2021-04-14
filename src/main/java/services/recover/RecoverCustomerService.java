package services.recover;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Customer;
import repositories.CustomerRepository;

@Service
public class RecoverCustomerService {

	@Autowired
    CustomerRepository repo;
	
	public Optional<Customer> findById(Integer id) {
	Optional<Customer> customer =   repo.findById(id);
		   return customer;
	}

	public List<Customer> findAll(){
	return  repo.findAll();
			
	}
	
	public List<Customer> findByName(String keyword) {
	return  repo.findByName(keyword);
	}
	
	public List<Customer> findByNameContaining(String keyword){
	return repo.findByNameContaining(keyword);
	}
}
