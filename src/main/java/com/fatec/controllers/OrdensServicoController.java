package com.fatec.controllers;

import com.fatec.repositories.OrdemServicoRepository;

import java.util.List;
import java.util.Optional;

import com.fatec.entities.OrdemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ordemservico")
public class OrdensServicoController {

  @Autowired
  OrdemServicoRepository repo;


  @GetMapping
  public List<OrdemServico> listing() {
    return repo.findAll();
  }

  @RequestMapping(value="/criar",method = RequestMethod.POST)
  public OrdemServico  create(@RequestBody OrdemServico ordemServico ){
    ordemServico.setId(null);

    /**MUST HAVE THIS INTO JSON REQUEST TO CREATE
     * descricao
     * dataEnvio
     */
    return this.repo.save(ordemServico);
  }

  public Optional<OrdemServico> findOne(@PathVariable Integer id) {
    return repo.findById(id);
  }

}