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
@Table(name = "product1")
@Component
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="productid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId;
	@Column(name = "productName")
	String productName;
	@Column(name = "productImagePath")
	String productImagePath;
	@Column(name = "categoryID")
	String categoryID;
	@Column(name = "imageserverpath")
	String imageserverpath;
	@Column(name="product_cost")
	double productCost;
	@Column(name = "product_description")
	String productDescription;
	
	public Product(){}
	
	public Product(int productId, String productName, String productImagePath, String categoryID,
			String imageserverpath,double productCost,String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImagePath = productImagePath;
		this.categoryID = categoryID;
		this.imageserverpath = imageserverpath;
		this.productCost = productCost;
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getImageserverpath() {
		return imageserverpath;
	}

	public void setImageserverpath(String imageserverpath) {
		this.imageserverpath = imageserverpath;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
}
