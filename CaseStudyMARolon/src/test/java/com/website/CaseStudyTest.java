package com.website;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.website.model.Authorities;
import com.website.model.User;
import com.website.service.UserService;

public class CaseStudyTest {
   
   @Autowired
   private static UserService userService;
   User user;
   
   @BeforeAll
   static void setup() {
      
   }
   
   @BeforeEach
   void init() {
      String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
      user = new User("jjjjj_junit", "junit@j.com", encoded, new Date(), "Testing 123 ABC");
      
      user.setEnabled(true);
      Authorities role = new Authorities();
      role.setUser(user);
      role.setAuthority("ROLE_USER");
      
      user.getAuthorities().add(role);
      
      userService.addUser(user);
   }
   
   @Test
   //@Disabled
   void testGetUserByUsername() {
      assertEquals(user.getUsername(), userService.getUserByUsername(user.getUsername()).getUsername());
   }
   
   @Test
   @Disabled
   void testGetUserByEmail() {
      assertEquals(user.getEmail(), userService.getUserByEmail(user.getEmail()).getEmail());
   }
   
   @Test
   @Disabled
   void testDeleteUser() {
      userService.deleteUser(user);
      assertEquals(null, userService.getUserByUsername(user.getUsername()));
   }
   
   @AfterAll
   static void tearDown() {
      
   }
}
