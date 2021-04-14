package resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import entities.ServiceOrder;
import services.create.CreateServiceOrder_Service;
import services.recover.RecoverCustomerService;
import services.recover.RecoverServiceOrder_Service;

@RestController
@RequestMapping(value="/serviceOrder")
public class ServiceOrderResource {
	
	@Autowired
	RecoverServiceOrder_Service recoverService;
	
	@Autowired
	CreateServiceOrder_Service createService;
	
	@Autowired
	RecoverCustomerService recoverCustomerService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceOrder createServiceOrder(@Valid @RequestBody ServiceOrder serviceOrder) {
		System.out.print(serviceOrder);
		 
		return createService.create(serviceOrder);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
	  Optional<ServiceOrder> so = recoverService.findById(id);
	  
	  if(so.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	  
	  return ResponseEntity.ok().body(so);
		
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll(){
		List<ServiceOrder> so = recoverService.findAll();
		
		if(so.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(so);
		
	}
}