package com.niit.shoppingcart.test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

public class CartTestCase {
//	@Autowired
//	static AnnotationConfigApplicationContext context;
//    @Autowired 
//    static Cart cart;
//    @Autowired
//    static CartDAO cartDAO;
//    
//    @BeforeClass
//	public static void inti() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com.niit.shoppingcart");
//		context.refresh();
//		cartDAO = (CartDAO) context.getBean("cartDAO");
//		cart = (Cart) context.getBean("cart");
//		System.out.println("The Cart object is created");
//	}
//	@Test
//	public void test() {
//		cart.setCartId(20);
//		cart.setProductQuantity(12);
//		if(cartDAO.updateCart(cart)){
//			System.out.println("Cart update successfully...");
//		}
//	}

}
