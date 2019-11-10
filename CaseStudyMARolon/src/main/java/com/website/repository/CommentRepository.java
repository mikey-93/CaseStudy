package com.website.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
   
   Comment findByPost(String name);
   //List<Event> findAll();
}
