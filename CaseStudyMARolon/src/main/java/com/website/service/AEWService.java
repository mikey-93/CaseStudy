package com.website.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.model.User;
import com.website.model.Wrestler;
import com.website.repository.UserRepository;
import com.website.repository.WrestlerRepository;

@Transactional
@Service
public class AEWService {
   
   @Autowired
   WrestlerRepository wrestlerRepository;
   @Autowired
   UserRepository userRepository;
   
//   public AEWService(WrestlerRepository wrestlerRepository) {
//      this.wrestlerRepository = wrestlerRepository;
//   }
   
// public AEWService() {
// wrestlerRepository.findByDateOfBirth(date);
//}
   
   public Wrestler getWrestlerByName(String name) {
      return wrestlerRepository.findByName(name);
   }
   
   public List<Wrestler> getAllWrestlers() {
      List<Wrestler> wrestlers = new ArrayList<>();
      wrestlerRepository.findAll().forEach(
            (e) -> {wrestlers.add(e);
            });
      //wrestlerRepository.findAll().forEach(wrestlers::add);
      return wrestlers;
   }
   
   public User getUserByEmail(String email) {
      return userRepository.findByEmail(email);
   }
   
   public List<User> getAllUsers() {
      List<User> users = new ArrayList<>();
      userRepository.findAll().forEach(
            (e) -> {users.add(e);
            });
      return users;
   }
}