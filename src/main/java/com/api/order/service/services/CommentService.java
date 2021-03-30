package com.api.order.service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.order.service.entities.Comment;
import com.api.order.service.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
    CommentRepository repo;
	
	public Comment findById(Integer id) {
		
		 Optional<Comment> com =  repo.findById(id);
		 
		 return com.orElse(null);
	}

}
