package com.niit.shoppingcart.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Controller
//@SessionAttributes("user_name_session")
public class AdminController {
    @Autowired
    UserDAO userDAO;
    HttpSession session;
    
	@RequestMapping(value="/adminlogin",  method = RequestMethod.POST)
	public String adminLoginAction(@ModelAttribute("userDAO") User user, Map<String, Object> map, HttpServletRequest request){
		String url_path = "";
		user.setUserType("Admin");
		session = request.getSession(true);
		if(userDAO.isLogin(user)){
			map.put("userDAO", user);
			map.put("message", "login successfully");
			session.setAttribute("user_name_session", user.getEmailId());
			url_path = "admin_home";
		}else{
		    map.put("userDAO", user);
		    map.put("message", "Please check user name and password!!!...");
		    url_path = "admin_login";
		}
		return url_path;
	}
	
	@RequestMapping(value="/admin_logout", method = RequestMethod.GET)
	public String adminLogout(Model model, HttpServletRequest  request){
//		String sessionName = request.getSession().getAttribute("user_name_session").toString();
//		System.out.println("Session variable name : "+sessionName);
		session = request.getSession(true);
		session.removeAttribute("user_name_session");
		session.invalidate();
		model.addAttribute("userDAO", new User());
		model.addAttribute("message", "Logout successfully!!.");
		return "admin_login";
	}
	
	@RequestMapping(value="/admin_home", method = RequestMethod.GET)
	public String adminHome(Model model, HttpServletRequest  request){
//		model.addAttribute("", arg1)
		return "admin_home";
	}
	
}
