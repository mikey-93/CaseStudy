package com.website.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   
   User findByEmail(String email);
   User findByUsername(String username);
   //List<User> findAll();
}
