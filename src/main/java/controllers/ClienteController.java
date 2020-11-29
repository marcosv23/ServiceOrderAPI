package controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Cliente;
import repositories.ClienteRepository;

@RestController
@RequestMapping()
public class ClienteController {

@Autowired
private ClienteRepository clienteRepository;	

	@GetMapping
	public List<Cliente> listing(){
	 return (clienteRepository.findAll());
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Optional<Cliente> findOne(@PathVariable Integer id) {
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/criar/")
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	

	
}
