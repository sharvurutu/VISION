package com.niit.shoppingcart.test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static User user;

	@Autowired
	static UserDAO userDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
		System.out.println("User object is created");
	}

//	 @Test
//	 public void createNewUser(){
//	// user.setUserId(1);
//	 user.setEmailId("ganeshkhatmode@gmail.com");
//	 user.setPassword("gk");
//	 user.setMobileNo("9096888722");
//	 user.setUserName("Ganesh Khatmode");
//	 userDAO.saveUser(user);
//	 System.out.println("User create successfully");
//	 }

	/*@Test
	public void getUser() {
		User user = userDAO.getuser("ganeshpatil@gmail.com");
		System.out.println("User ID : " + user.getUserId() + " user name : " + user.getUserName() + "\nEmail ID : "
				+ user.getEmailId() + " Password : " + user.getPassword() + "\n" + "Mobile Number : "
				+ user.getMobileNo());
	}
	*/
//	@Test
//	public void updateUserTest(){
//		User user = new User();
//		user.setUserId(2);
//		boolean result = userDAO.updateUser(user);
//		System.out.println("Update Reuslt : "+result);
//	}
//	@Test
//	public void deleteuser(){
//		User user = new User();
//		user.setUserId(1);
//	    boolean result = userDAO.deleteUser(user);
//	    System.out.println("Delete Result : "+result);
//	}
	
//	@Test
//	public void checkUser(){
//		User user = new User();
//		user.setEmailId("admin@admin.com");
//		user.setPassword("gk");
//		user.setUserType("Admin");
//		boolean result = userDAO.isLogin(user);
//		System.out.println("User type : "+result);
//	}
	
}
