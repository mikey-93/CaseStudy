package com.website.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.website.model.Comment;
import com.website.model.Event;
import com.website.model.User;
import com.website.model.Wrestler;
import com.website.repository.CommentRepository;
import com.website.repository.EventRepository;
import com.website.repository.UserRepository;
import com.website.repository.WrestlerRepository;
import com.website.service.EventService;
import com.website.service.UserService;
import com.website.service.WrestlerService;

@Controller
public class HomeController {
   
   @Autowired
   WrestlerRepository wrestlerRepository;
   @Autowired
   WrestlerService wrestlerService;
   @Autowired
   UserRepository userRepository;
   @Autowired
   UserService userService;
   @Autowired
   EventRepository eventRepository;
   @Autowired
   EventService eventService;
   @Autowired
   CommentRepository commentRepository;
   //TODO Add CommentService?
   
   @InitBinder
   public void initBuilder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(sdf, false));
   }
   
   @RequestMapping("/")
   public ModelAndView homePage(Principal principal) {
      ModelAndView mav = new ModelAndView("home");
      if (principal != null) {
         User user = userRepository.findByEmail(principal.getName());
         mav.addObject("welcome", ("Welcome, " + user.getUsername()));
      }
      return mav;
   }
   
   @RequestMapping("/roster")
   public ModelAndView rosterPage() {
      ModelAndView mav = new ModelAndView("rosterPage");
      List<Wrestler> wrestlers = wrestlerService.getAllWrestlers();
      mav.addObject("wrestlers", wrestlers);
      return mav;
   }
   
   @RequestMapping("/roster/{name}")
   public ModelAndView wrestlerPage(@PathVariable String name) {
      ModelAndView mav = new ModelAndView("wrestlerPage");
      Wrestler wrestler = wrestlerRepository.findByName(name);
      mav.addObject("wrestler", wrestler);
      return mav;
   }
   
   @RequestMapping("/events")
   public ModelAndView eventsPage() {
      ModelAndView mav = new ModelAndView("eventsPage");
      List<Event> events = eventService.getAllEvents();
      mav.addObject("events", events);
      mav.addObject("", "");
      return mav;
   }
   
   @RequestMapping("/events/{name}")
   public ModelAndView oneEvent(@PathVariable String name) {
      ModelAndView mav = new ModelAndView("event");
      mav.addObject("event", eventRepository.findByName(name));
      mav.addObject("commentObj", new Comment());
      return mav;
   }
   
   @RequestMapping(value = "commentProcess", method = RequestMethod.POST)
   public ModelAndView commentProcess(@Valid @ModelAttribute("commentObj") Comment comment, 
         BindingResult br, 
         @RequestParam("eventName") String eventName, 
         Principal principal, 
         RedirectAttributes redirect) {
      
      ModelAndView mav = null;
      if (!br.hasErrors() || !comment.getPost().isEmpty()) {
         comment.setDate(new Date());
         comment.setEvent(eventRepository.findByName(eventName));
         comment.setUser(userRepository.findByEmail(principal.getName()));
         commentRepository.save(comment);

         mav = new ModelAndView("redirect:/events/" + eventName);
      }
      else {
         mav = new ModelAndView("event");
         mav.addObject("event", eventRepository.findByName(eventName));
      }
      return mav;
   }
   
   //Delete
   @RequestMapping(value = "deleteCon", method = RequestMethod.POST)
   public ModelAndView deleteCon(@RequestParam("commentId") long commentId) {
      
      ModelAndView mav = new ModelAndView("deleteConfirmation");
      mav.addObject("comment", commentRepository.findById(commentId));
      return mav;
   }
   
   @RequestMapping(value = "deleteProcess", method = RequestMethod.POST)
   public ModelAndView deleteProcess(@RequestParam("commentId") long commentId, 
         RedirectAttributes redirect) {
      
      Comment comment = commentRepository.findById(commentId);
      String eventName = comment.getEvent().getName();
      commentRepository.delete(comment);
      
      ModelAndView mav = new ModelAndView("redirect:/events/" + eventName);
      redirect.addFlashAttribute("deleteCon", "Comment deleted!");
      return mav;
   }
   
   @RequestMapping("/login")
   public ModelAndView loginPage() {
      ModelAndView mav = new ModelAndView("loginPage");
      mav.addObject("userObj", new User());
      return mav;
   }
   
   @RequestMapping(value = "loginProcess", method = RequestMethod.POST)
   public ModelAndView loginProcess(@RequestParam("username") Optional<String> username, 
         @RequestParam("dateOfBirth") Optional<Date> dateOfBirth, 
         @Valid @ModelAttribute("userObj") User user, 
         BindingResult br, 
         RedirectAttributes redirect) {
      
      ModelAndView mav = null;
      if (!br.hasErrors() || br.getRawFieldValue("username") == null || 
            br.getRawFieldValue("dateOfBirth") == null) {
         
         String emailForm = user.getEmail();
         //Encr
         String passwordForm = user.getPassword();
         User userDB = userRepository.findByEmail(emailForm);
         System.out.println("Password: " + userDB.getPassword());
         
         if (userDB != null 
               && passwordForm.equals(userDB.getPassword())) {
            mav = new ModelAndView("redirect:/");
            //redirect.addFlashAttribute("welcome", ("Welcome, " + userDB.getEmail() + '!'));
         }
         else {
            mav = new ModelAndView("loginPage");
            mav.addObject("message", "Username or password is wrong!");
         }
      }
      else {
         mav = new ModelAndView("loginPage");
      }
      
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
      
      System.out.println("Go here");
      
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
}
