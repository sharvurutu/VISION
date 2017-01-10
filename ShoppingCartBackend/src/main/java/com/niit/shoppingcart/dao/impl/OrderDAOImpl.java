package com.niit.shoppingcart.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void createOrder(Order order) {
       sessionFactory.getCurrentSession().save(order);
	}

	@Transactional
	public boolean deleteOrder(Order order) {
		try {
			sessionFactory.getCurrentSession().delete(order);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean updateOrder(Order order) {
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public Order getOrder(int orderId) {
		try {
			String hql = "from order where orderId='"+orderId+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<Order> orderList = query.list();
			if(orderList != null && !orderList.isEmpty()){
				return orderList.get(0);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public List<Order> getAllOrders() {
		String hql = "from Order order";
		return (List<Order>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}
