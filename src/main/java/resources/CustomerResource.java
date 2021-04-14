package resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.order.service.services.update.UpdateCustomerService;

import entities.Customer;
import services.create.CreateCustomerService;
import services.delete.DeleteCustomerService;
import services.recover.RecoverCustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
	
	@Autowired
	RecoverCustomerService recoverService;
	@Autowired
	CreateCustomerService createService;
	@Autowired
	DeleteCustomerService deleteService;
	@Autowired
	UpdateCustomerService updateService;
	
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@Valid @RequestBody() Customer newCustomer) {
		return createService.create(newCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable Integer id) {
		 deleteService.deleteCustomer(id);	 
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateEntireCustomer(
			@Valid
			@PathVariable Integer id, 
			@RequestBody Customer customer ){
		
		var updatedUser = updateService.updateEntireCustomer(id, customer);
		
		return updatedUser;
				
	}
	
	@GetMapping()
	public List<Customer> findAll() {
		return  recoverService.findAll();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById( @PathVariable Integer id) {
	 Optional<Customer> customer =  recoverService.findById(id);
	  
	  if(customer.isPresent()) {
		  return ResponseEntity.ok(customer.get());
	  }
	  
	  return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/name/{keyword}")
	public ResponseEntity<?> findByKeyword(@PathVariable String keyword){
		List<Customer> customers =  recoverService.findByName(keyword);
		
		return ResponseEntity.ok().body(customers);	
	}
	
	
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<?> findByNameContaining(@PathVariable String keyword){
		List<Customer> customers =  recoverService.findByNameContaining(keyword);
		
		return ResponseEntity.ok().body(customers);
		
	}
	
}
