package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.model.Order;

public class OrderTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static Order order;
	@Autowired
	static OrderDAO orderDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		orderDAO = (OrderDAO)context.getBean("orderDAO");
		order = (Order) context.getBean("order");
		System.out.println("Order object is created....");
	}
//	@Test
//	public void createOrder() {
//		order.setProductId(1);
//		order.setUserId(1);
//		order.setBillingAddress("Hadapsar,Pune-28");
//		order.setShippingAddress("Shivaji Nagar");
//		orderDAO.createOrder(order);
//		System.out.println("Create order...");
//	}

}
