package com.website.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
   
   Event findByName(String name);
   Event findByCity(String city);
   Event findByState(String state);
   //List<Event> findAll();
}
