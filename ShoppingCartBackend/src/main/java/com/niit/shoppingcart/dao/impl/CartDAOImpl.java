package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
   
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public void addToCart(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
	}

	@Transactional
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean delete(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean delete(int cartID) {
		try {
			sessionFactory.getCurrentSession().delete(cartID);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public List<Cart> getCartList(int userId) {
		try {
			String hql = "FROM Cart cart WHERE user_id="+userId;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Cart> cartList = query.list();
			return cartList;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public boolean isProductInCart(int productId,int userId) {
		try {
			String sql = "FROM Cart cart WHERE product_id="+productId+" AND user_id="+userId;
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			List<Cart> cartList = query.list();
			if(cartList != null && !cartList.isEmpty()){
			   return true;	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Transactional
	public Cart getCart(int productId, int userId) {
		try {
			String sql = "FROM Cart cart WHERE product_id="+productId+" AND user_id="+userId;
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			List<Cart> cartList = query.list();
			if(cartList != null && !cartList.isEmpty()){
			   return cartList.get(0);	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
