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
@Table (name = "user_order")
@Component
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	@Column(name = "product_id")
    int productId;
	@Column(name = "user_id")
    int userId;
	@Column(name = "billing_address")
    String billingAddress;
	@Column(name = "shipping_address")
    String shippingAddress;
	@Column(name="product_quantity")
	int productQuantity;
	@Column(name="product_total_cost")
	double productTotalCost;
	
	public Order(){}

	public Order(int orderId, int productId, int userId, String billingAddress, String shippingAddress,
			int productQuantity,double productTotalCost,int categoryId ) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.productQuantity = productQuantity;
		this.productTotalCost = productTotalCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
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

	
}
