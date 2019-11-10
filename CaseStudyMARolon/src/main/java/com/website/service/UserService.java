package com.website.service;

import com.website.model.User;
import com.website.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	//Use email instead
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//From DB
		User user = userRepository.findByEmail(email);
		
		//To comply with Spring Sec User
		UserBuilder builder = null;
		
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			builder.password(user.getPassword());
			builder.disabled(!user.isEnabled());
			String [] authorities = user.getAuthorities()
					.stream().map(
							a -> a.getAuthority()).toArray(String[]::new);
			
			builder.authorities(authorities);
		}else {
			throw new UsernameNotFoundException("User Not Found!");
		}
		
		return builder.build();
	}
	
	public boolean addUser(User user) {
      return (userRepository.save(user) != null);
   }
   
   public boolean updateUser(User user) {
      return (userRepository.save(user) != null);
   }
   
   public User getUserByEmail(String email) {
      return userRepository.findByEmail(email);
   }
   
   public User getUserByUsername(String username) {
      return userRepository.findByUsername(username);
   }
   
   public List<User> getAllUsers() {
      List<User> users = new ArrayList<>();
      userRepository.findAll().forEach(
            (e) -> {users.add(e);
            });
      return users;
   }
}
