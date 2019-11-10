package com.website.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Wrestler;

@Repository
public interface WrestlerRepository extends CrudRepository<Wrestler, Long> {
   
   Wrestler findByName(String name);
   //List<Wrestler> findAll();
}
