package services.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Customer;
import exceptions.BusinessException;
import repositories.CustomerRepository;

@Service
public class CreateCustomerService {

	@Autowired
    CustomerRepository repo;

	
	
	

	
	public Customer create(Customer newCustomer) {
	
		var customerExists = repo.findByEmail(newCustomer.getEmail());
		var cpfExists = repo.findByCpf(newCustomer.getCpf());
		
		if(!cpfExists.isEmpty()) {
			throw new 
			BusinessException("Já existe um usuário com esse CPF cadastrado");
		}
		
		if(!customerExists.isEmpty() &&  !customerExists.equals(newCustomer)) {
			throw new
			BusinessException("Já existe um usuário cadastrado com esse email!");
		}
		return repo.save(newCustomer);
		
	}
	
}
