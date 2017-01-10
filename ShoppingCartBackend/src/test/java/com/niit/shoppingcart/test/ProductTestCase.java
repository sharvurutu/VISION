package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static Product product;
	@Autowired
	static ProductDAO productDAO;
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
		System.out.println("Product object is created");
	}
	
//	@Test
//	public void getProductsByCategoryName(){
//		List<Product> products = productDAO.getProducts(15);
//		for(Product product : products){
//			System.out.println(""+product.getProductName());
//		}
//	}
//	@Test
//	public void createProductTest() {
//		product.setCategoryID("1");
//		product.setProductImagePath("C://ganesh_patil/ganesh.png");
//		product.setProductName("saree-S1200");
//		productDAO.addProduct(product);
//	}
//	@Test
//	public void updateProductTest() {
//		product.setProductId(2);
//		product.setCategoryID("2");
//		product.setProductImagePath("C://ganesh_patil/ganesh.png");
//		product.setProductName("saree-S124900");
//		boolean result = productDAO.isUpdateProduct(product);
//		System.out.println("Update Product : "+result);
//	}
	
//	@Test
//	public void deleteProductTest(){
//		product.setProductId(3);
//		boolean result = productDAO.deleteProduct(product);
//		System.out.println("Delete Product Result :  "+result);
//	}

//	@Test
//	public void getProductList(){
//		List<Product> productList = productDAO.getProducts();
//		System.out.println("Total Product  :"+productList.size());
//	}
}
