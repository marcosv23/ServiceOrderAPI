package com.fatec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.fatec.entities.Comentario;
import com.fatec.repositories.ComentarioRepository;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentariosController {

  @Autowired
  ComentarioRepository comentarioRepository;


  @GetMapping
  public List<Comentario> listing() {
    return comentarioRepository.findAll();
  }

  @RequestMapping(value="/criar",method = RequestMethod.POST)
  public Comentario  create(@RequestBody Comentario comentario){
    comentario.setId(null);

    /**MUST HAVE THIS INTO JSON REQUEST TO CREATE
     * descricao
     * dataEnvio
     */
    return this.comentarioRepository.save(comentario);
  }

  public Optional<Comentario> findOne(@PathVariable Integer id) {
    return comentarioRepository.findById(id);
  }

}