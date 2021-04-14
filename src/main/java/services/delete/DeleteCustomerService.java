package services.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.CustomerRepository;

@Service
public class DeleteCustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public void deleteCustomer(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
	
	}
}
