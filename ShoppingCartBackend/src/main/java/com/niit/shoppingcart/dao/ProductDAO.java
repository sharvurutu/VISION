package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	 public void addProduct(Product product);
	 public boolean isProduct(Product product);
	 public boolean deleteProduct(Product product);
	 public boolean isUpdateProduct(Product product);
	 public Product getProduct(Product product);
	 public List<Product> getProducts();
	 public List<Product> getProducts(int categoryId);
	 public Product get(int productId);
}
