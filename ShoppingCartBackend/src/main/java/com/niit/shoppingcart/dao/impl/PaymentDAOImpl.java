package com.niit.shoppingcart.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.model.Payment;

@Repository("paymentDAO")
public class PaymentDAOImpl implements PaymentDAO {
    
	@Autowired
	SessionFactory sessionFactory;
	
	public PaymentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void createPayment(Payment payment) {
           sessionFactory.getCurrentSession().save(payment);
	}

}
