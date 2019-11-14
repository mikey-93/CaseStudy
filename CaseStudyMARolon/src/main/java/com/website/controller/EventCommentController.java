package com.website.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.website.model.Comment;
import com.website.model.Event;
import com.website.repository.CommentRepository;
import com.website.repository.EventRepository;
import com.website.repository.UserRepository;
import com.website.service.EventService;

@Controller
public class EventCommentController {
   
   @Autowired
   UserRepository userRepository;
   @Autowired
   EventRepository eventRepository;
   @Autowired
   EventService eventService;
   @Autowired
   CommentRepository commentRepository;
   
   @RequestMapping("/events")
   public ModelAndView eventsPage() {
      ModelAndView mav = new ModelAndView("eventsPage");
      List<Event> events = eventService.getAllEvents();
      mav.addObject("events", events);
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
         comment.setUser(userRepository.findByUsername(principal.getName()));
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
   @RequestMapping(value = "deleteConf", method = RequestMethod.POST)
   public ModelAndView deleteConf(@RequestParam("commentId") long commentId) {
      
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
      redirect.addFlashAttribute("deleteConf", "Comment deleted!");
      return mav;
   }
}
