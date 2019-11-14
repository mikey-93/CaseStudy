package com.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
   
   @RequestMapping("/")
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("home");
      return mav;
   }
}
