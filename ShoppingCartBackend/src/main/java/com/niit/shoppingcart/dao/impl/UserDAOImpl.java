package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
	
	@Transactional
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = (List<User>)session.createQuery("from user").list();
		return userList;
	}

	
	@Transactional
	public User getuser(String emailId) {
		String hql = "from User user WHERE email_id='" + emailId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}

	
	@Transactional
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Transactional
	public User get(int userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	
	@Transactional
	public boolean deleteUser(User user) {
		try {
			if (get(user.getUserId()) == null) {
				return false;
			}
			System.out.println("come into method : ");
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean delete(int userID) {
		try {
			sessionFactory.getCurrentSession().delete(userID);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean updateUser(User user) {
		try {
			if(get(user.getUserId()) != null ){
				sessionFactory.getCurrentSession().update(user);
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Transactional
	public boolean isLogin(User user) {
		try {
			String hql = "from User user where email_id='"+user.getEmailId()
			               +"' AND password='"+user.getPassword()+"' AND "+
					       " user_type='"+user.getUserType()+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<User> listUser = (List<User>) query.list();
			if (listUser != null && !listUser.isEmpty()) {
				 return true;
			}	
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
