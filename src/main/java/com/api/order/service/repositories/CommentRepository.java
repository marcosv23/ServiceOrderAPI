package com.api.order.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.order.service.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
