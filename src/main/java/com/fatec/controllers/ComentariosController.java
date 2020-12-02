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
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fatec.entities.Comentario;
import com.fatec.entities.OrdemServico;
import com.fatec.repositories.ComentarioRepository;
import com.fatec.repositories.OrdemServicoRepository;

@RestController
@RequestMapping(value = "/comentarios")
public class ComentariosController {

  @Autowired
  ComentarioRepository comentarioRepository;

  @Autowired
  OrdemServicoRepository OrdemServicoRepository;

  @GetMapping
  public List<Comentario> listing() {
    return comentarioRepository.findAll();
  }

  @RequestMapping(value="/criar/{ordemServicoId}",method = RequestMethod.POST)
  public Comentario  create(@RequestBody Comentario comentario, 

  @PathVariable Integer ordemServicoId){

    Optional<OrdemServico> ordemServico;
    
    //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    //System.out.println(formatter.format(new Date()));

    comentario.setDataEnvio(new Date());
    ordemServico = OrdemServicoRepository.findById(ordemServicoId);
    
    comentario.setId(null);
    comentario.setOrdemServico(ordemServico);

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