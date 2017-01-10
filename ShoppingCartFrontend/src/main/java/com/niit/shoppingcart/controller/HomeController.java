package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.User;

@Controller
public class HomeController {
   
	 @Autowired
	 CategoryDAO categoryDAO;
	 
	 
	 @RequestMapping(value = "/home" , method = RequestMethod.GET)
	 public String getHomePage(Model model){
//		 model.addAttribute("message", );
//		 model.addAttribute("categorys", categoryDAO.list());
		 return "index";
	 }
	 
	 @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	 public String getAdminHome(Model model){
		 model.addAttribute("userDAO", new User());
		 return "admin_login";
	 }
}
