package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.website.model.Wrestler;
import com.website.repository.WrestlerRepository;
import com.website.service.WrestlerService;

@Controller
public class WrestlerController {
   
   @Autowired
   WrestlerRepository wrestlerRepository;
   @Autowired
   WrestlerService wrestlerService;
   
   @RequestMapping("/roster")
   public ModelAndView rosterPage() {
      ModelAndView mav = new ModelAndView("rosterPage");
      mav.addObject("wrestlers", wrestlerService.getAllWrestlers());
      return mav;
   }
   
   @RequestMapping("/roster/{name}")
   public ModelAndView wrestlerPage(@PathVariable String name) {
      ModelAndView mav = new ModelAndView("wrestlerPage");
      Wrestler wrestler = wrestlerRepository.findByName(name);
      mav.addObject("wrestler", wrestler);
      return mav;
   }
}
