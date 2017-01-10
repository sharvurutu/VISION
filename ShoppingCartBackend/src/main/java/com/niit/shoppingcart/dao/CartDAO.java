package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
    public void addToCart(Cart cart);
    public boolean updateCart(Cart cart);
    public boolean delete(Cart cart);
    public boolean delete(int cartID);
    public List<Cart> getCartList(int userId);
    public boolean isProductInCart(int productId,int userId);
    public Cart getCart(int productId , int userId);
    
}
