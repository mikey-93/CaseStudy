package com.website.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.website.model.Authorities;
import com.website.model.User;
import com.website.repository.UserRepository;
import com.website.repository.WrestlerRepository;
import com.website.service.WrestlerService;

@Controller
public class UsernameController {
   
   @Autowired
   UserRepository userRepository;
   @Autowired
   WrestlerRepository wrestlerRepository;
   @Autowired
   WrestlerService wrestlerService;
   
   @InitBinder
   public void initBuilder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(sdf, false));
   }
   
   @RequestMapping("/login")
   public ModelAndView loginPage() {
      ModelAndView mav = new ModelAndView("loginPage");
      mav.addObject("userObj", new User());
      return mav;
   }
   
   @RequestMapping("/register")
   public ModelAndView registerPage() {
      ModelAndView mav = new ModelAndView("registerPage");
      mav.addObject("registerFormObj", new User());
      return mav;
   }
   
   @RequestMapping(value = "registerProcess", method = RequestMethod.POST)
   public ModelAndView registerProcess(@Valid @ModelAttribute("registerFormObj") User user, 
          BindingResult br, @RequestParam("confPassword") String confPassword) {
      
      ModelAndView mav = null;
      
      if (!br.hasErrors() && user.getPassword().equals(confPassword)) {
         //Check if username or email are in the database
         User userDB = userRepository.findByEmail(user.getEmail());
         if (userDB != null && user.getEmail().equals(userDB.getEmail())) {
            mav = new ModelAndView("registerPage");
            mav.addObject("message", "Email already exists!");
            return mav;
         }
         userDB = userRepository.findByUsername(user.getUsername());
         if (userDB != null && user.getUsername().equals(userDB.getUsername())) {
            mav = new ModelAndView("registerPage");
            mav.addObject("message", "Username already exists!");
            return mav;
         }
         
         //USE SPRING SECURITY!
         String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
         

         //Change from user.getPassword() to encoded
         User credential = new User(user.getUsername(), user.getEmail(), encoded, user.getDateOfBirth(), user.getDesc());
         
         //CONTINUATION OF SPRING SECURITY
         credential.setEnabled(true);
         Authorities role = new Authorities();
         role.setUser(credential);
         role.setAuthority("ROLE_USER");
         
         credential.getAuthorities().add(role);
         
         //
         userRepository.save(credential);
         
         mav = new ModelAndView("registerConfirmation");
         mav.addObject("user", userRepository.findByUsername(credential.getUsername()));
         mav.addObject("message", "Registration complete!");
      }
      
      else {
         mav = new ModelAndView("registerPage");
         if (!br.hasErrors())
            mav.addObject("message", "Passwords do not match!");
      }
      return mav;
   }
   
   @RequestMapping("/{username}")
   public ModelAndView userProfile(@PathVariable String username) {
      ModelAndView mav = new ModelAndView("userProfile");
      mav.addObject("user", userRepository.findByUsername(username));
      mav.addObject("allWrestlers", wrestlerService.getAllWrestlers());
      return mav;
   }
   
   @RequestMapping(value = "addFavWrestlerProcess", method = RequestMethod.POST)
   public ModelAndView addFavWrestlerProcess(@RequestParam("wrestlerNames") Set<String> wrestlerNames, 
         Principal principal, 
         RedirectAttributes redirect) {
      
      User user = userRepository.findByUsername(principal.getName());
      
      wrestlerNames.forEach(
            (e) -> {user.getWrestlers().add(wrestlerRepository.findByName(e));
            });
      
      userRepository.save(user);
      
      ModelAndView mav = new ModelAndView("redirect:/" + user.getUsername());
      redirect.addFlashAttribute("wrestlersAdded", "Wrestler(s) added!");
      return mav;
   }
   
   @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
   public ModelAndView deleteUser(Principal principal) {
      ModelAndView mav = new ModelAndView("deleteUserConf");
      return mav;
   }
   
   @RequestMapping(value = "deleteUserProcess", method = RequestMethod.POST)
   public ModelAndView deleteUserProcess(Principal principal, RedirectAttributes redirect) {
      userRepository.delete(userRepository.findByUsername(principal.getName()));
      ModelAndView mav = new ModelAndView("redirect:/logout");
      return mav;
   }
}
