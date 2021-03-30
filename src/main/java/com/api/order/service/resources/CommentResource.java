package com.api.order.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.order.service.entities.Comment;
import com.api.order.service.services.CommentService;

@RestController
public class CommentResource {
	
	@Autowired
	CommentService service;
	
	@GetMapping("/comments/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
	  Comment com = service.findById(id);
	  return ResponseEntity.ok().body(com);
		
	}

}
