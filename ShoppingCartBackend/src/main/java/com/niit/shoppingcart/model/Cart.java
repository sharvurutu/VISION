package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "cart1")
@Component
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
    int cartId;
	@Column(name = "product_id")
    int productId;
	@Column(name = "user_id")
    int userId;
	@Column(name = "product_quantity")
    int productQuantity;
	@Column(name = "product_total_cost")
    double productTotalCost;
	@Column(name = "productName")
	String productName;
	@Column(name = "imageserverpath")
	String imageServerPath;
	
	public Cart(){}
	
	public Cart(int cartId, int productId, int userId, int productQuantity, double productTotalCost,
			String imageServerPath, String productName) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
		this.productQuantity = productQuantity;
		this.productTotalCost = productTotalCost;
		this.imageServerPath = imageServerPath;
	    this.productName = productName;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductTotalCost() {
		return productTotalCost;
	}

	public void setProductTotalCost(double productTotalCost) {
		this.productTotalCost = productTotalCost;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageServerPath() {
		return imageServerPath;
	}

	public void setImageServerPath(String imageServerPath) {
		this.imageServerPath = imageServerPath;
	}
    
}
