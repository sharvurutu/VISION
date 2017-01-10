package com.niit.shoppingcart.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;

	HttpSession session;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	User user;
	
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm(Model model) {
		user = new User();
		model.addAttribute("message", "You are ready for login");
		model.addAttribute("userDAO", user);
		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getRegisterForm(Model model) {
		user = new User();
		model.addAttribute("message", "You are ready for signup.");
		model.addAttribute("userDAO", user);
		return "signup";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String userRegisterAction(@ModelAttribute("userDAO") User user, Map<String , Object> map, 
			                       HttpServletRequest request){
		String url_path = "signup";
		String userName = user.getUserName();
		String emailId = user.getEmailId();
		String password = user.getPassword();
		String cPassword = request.getParameter("cpassword");
		String mobileNo = user.getMobileNo();
		if(userName != null && emailId != null && password != null && cPassword != null && mobileNo != null){
			if(password.equals(cPassword)){
				User user1 = userDAO.getuser(user.getEmailId());
				if(user1 != null){
					System.out.println("User is present is to database..");
					map.put("message", "User already register.");
				}else{
				   user.setUserType("User");
				   userDAO.saveUser(user);
				   map.put("message", "You are gegister successfully.");
				   map.put("userDAO", new User());
				   url_path = "login";
				}
			}else{
				map.put("message", "Password and confirm password are incorrect.");
				
			}
			map.put("userDAO", user);
		}else{
			map.put("message", "All fields are required.");
		}
		
		return url_path;
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String userLoginAction(@ModelAttribute("userDAO") User user, Map<String,Object> map,
			HttpServletRequest request){
		String url_path = "login";
		
		
		String user_name = request.getParameter("emailId");
		String user_password = request.getParameter("password");
		if(user_name != null && user_password != null){
			user.setEmailId(user_name);
			user.setPassword(user_password);
			user.setUserType("User");
			if(userDAO.isLogin(user)){
				User userDB = userDAO.getuser(user.getEmailId());
				session = request.getSession(true);
				System.out.println("User is login");
				session.setAttribute("user_first_name", userDB.getUserName());
				session.setAttribute("user_id", userDB.getUserId());
				session.setAttribute("user_name_session", user.getEmailId());
				if(session.getAttribute("product_id_temp") == null && session.getAttribute("category_id_temp") == null){
				  url_path = "index";
				}else{
					//--- CHECK HERE REQUEST PAGE NAME ------------
				  url_path = "view_product";
				  
				  map.put("product", productDAO.get(Integer.parseInt(session.getAttribute("product_id_temp").toString())));
				}
			}else{
				
				map.put("message", "Please check user name and password.");
				url_path = "login";
			}
	   }
		return url_path;
	}
	
	@RequestMapping(value="/user_logout" , method = RequestMethod.GET)
	public String userLogoutAction(Model model,HttpServletRequest request){
		session = request.getSession(true);
		session.removeAttribute("user_name_session");
		session.invalidate();
		model.addAttribute("userDAO", new User());
		model.addAttribute("message", "Logout successfully!!.");
		return "login";
	}
	
}
