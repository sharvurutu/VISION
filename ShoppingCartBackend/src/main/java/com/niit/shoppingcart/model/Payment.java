package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="payment")
@Component
public class Payment {
    @Id
    @Column(name="payment_id")
    int paymentId;
    @Column(name="order_id")
    int orderId;
    @Column(name="payment_mode")
    String paymentMode;
    
    public Payment(){
    	
    }
    
	public Payment(int paymentId, int orderId, String paymentMode) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentMode = paymentMode;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
    
}
