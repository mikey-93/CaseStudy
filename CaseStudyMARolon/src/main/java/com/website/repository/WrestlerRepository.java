package com.website.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Wrestler;

@Repository
public interface WrestlerRepository extends CrudRepository<Wrestler, Long> {
   
   Wrestler findByName(String name);
   List<Wrestler> findByDateOfBirth(Date date);
//   
//   List<Wrestler> findByDateOfBirthBetween(Date date1, Date date2);
}
