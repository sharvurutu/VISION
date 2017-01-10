package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;

public interface OrderDAO {
     public void createOrder(Order order);
     public boolean deleteOrder(Order order);
     public boolean updateOrder(Order order);
     public Order getOrder(int orderId);
     public List<Order> getAllOrders();
}
