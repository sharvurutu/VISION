package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.model.User;

public interface UserDAO {
	
   public void saveUser(User user);
   
   public boolean isLogin(User user);
   
   public List getAllUsers();
   
   public User getuser(String emailId);
   
   public boolean deleteUser(User user);
   
   public boolean delete(int userId);
   
   public boolean updateUser(User user);
   
}
