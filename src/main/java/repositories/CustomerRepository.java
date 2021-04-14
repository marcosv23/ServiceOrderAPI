package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	public List<Customer> findByName(final String name);
	
	public List<Customer> findByNameContaining(final String name);
	
	public List<Customer> findByEmail(final String email);
	
	public List<Customer> findByCpf(final String cpf);
}
