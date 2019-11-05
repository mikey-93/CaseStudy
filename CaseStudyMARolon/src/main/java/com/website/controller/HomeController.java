package com.website.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.website.model.User;
import com.website.service.AEWService;

@Controller
public class HomeController {
   
   @Autowired
   AEWService aewService;
   
   @InitBinder
   public void initBuilder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(sdf, false));
   }
   
   @RequestMapping("/")
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("home");
      return mav;
   }
   
   
   
   
   
   @RequestMapping("/login")
   public ModelAndView loginPage() {
      ModelAndView mav = new ModelAndView("loginPage");
      mav.addObject("userObj", new User());
      return mav;
   }
   
   @RequestMapping(value = "loginProcess", method = RequestMethod.POST)
   //Added BindingResult
   public ModelAndView loginProcess(@RequestParam("dateOfBirth") Optional<Date> dateOfBirth, 
         @Valid @ModelAttribute("userObj") User user, 
         BindingResult br, 
         RedirectAttributes redirect) {
      
      ModelAndView mav = null;
      if (!br.hasErrors() || br.getRawFieldValue("dateOfBirth") == null) {
         
         String emailForm = user.getEmail();
         String passwordForm = user.getPassword();
         User userDB = aewService.getUserByEmail(emailForm);
         if (userDB != null 
               && passwordForm.equals(userDB.getPassword())) {
            mav = new ModelAndView("redirect:/");
            redirect.addFlashAttribute("email", userDB.getEmail());
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
}
