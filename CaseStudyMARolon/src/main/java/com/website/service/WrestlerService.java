package com.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.model.Wrestler;
import com.website.repository.WrestlerRepository;

@Transactional
@Service
public class WrestlerService {
   
   @Autowired
   WrestlerRepository wrestlerRepository;
   
   public Wrestler getWrestlerByName(String name) {
      return wrestlerRepository.findByName(name);
   }
   
   public List<Wrestler> getAllWrestlers() {
      List<Wrestler> wrestlers = new ArrayList<>();
      wrestlerRepository.findAll().forEach(
            (e) -> {wrestlers.add(e);
            });
      return wrestlers;
   }
}