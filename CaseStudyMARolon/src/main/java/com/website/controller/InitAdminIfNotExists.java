package com.website.controller;

import com.website.model.Authorities;
import com.website.model.User;
import com.website.repository.UserRepository;
import com.website.service.UserService;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class InitAdminIfNotExists {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	//Optional
//	@RequestMapping("/login")
//	public void initAdmin() {
//
//		User user = userRepository.findByUsername("kun");
//
//		if (user == null) {
//			System.out.println("Creating admin...");
//			User adminUser = new User();
////			adminUser.setName("Kun");
//			adminUser.setUsername("kun");
//			String encoded = new BCryptPasswordEncoder().encode("123456");
//			adminUser.setPassword(encoded);
//			adminUser.setEnabled(true);
//
//			Authorities role = new Authorities();
//			role.setUser(adminUser);
//			role.setAuthority("ROLE_ADMIN");
//			
//			adminUser.getAuthorities().add(role);
//			
//			userService.saveUser(adminUser);
//		}
//	}

}
