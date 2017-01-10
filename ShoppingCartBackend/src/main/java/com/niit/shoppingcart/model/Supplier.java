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
@Table(name = "supplier1")
@Component
public class Supplier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "supplierId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int supplierId;
	@Column(name = "supplierName")
	String supplierName;
	
	public Supplier(){}
	
	public Supplier(int supplierId, String supplierName) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
}
