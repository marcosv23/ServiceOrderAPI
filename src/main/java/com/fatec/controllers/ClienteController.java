package com.fatec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.repositories.ClienteRepository;
import com.fatec.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listing() {
		return (clienteRepository.findAll());
	}

	@GetMapping("/teste")
	public ResponseEntity<String> teste() {
		return new ResponseEntity<>("testado", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Cliente> findOne(@PathVariable Integer id) {
		return clienteRepository.findById(id);
	}

	//Here can be @PostMapping("/criar") or RequestMappin
	@RequestMapping(value="/criar",  method=RequestMethod.POST)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		/**
		 * MUST HAVE THIS INTO JSON REQUEST TO CREATE ORDEM_SERVICO

		descricao;

    preco;

  	pattern ="dd/MM/yyyy HH:mm"
  	dataAbertura;

 		pattern ="dd/MM/yyyy HH:mm"
  	private Date dataFinalizacao;

	  status;
	 
    private Cliente cliente;

		private List<Comentario> comentarios;
		
		 */
		cliente.setId(null);
		return clienteRepository.save(cliente);
	}

}
