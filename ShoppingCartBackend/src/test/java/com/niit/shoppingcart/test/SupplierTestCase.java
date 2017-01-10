package com.niit.shoppingcart.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class SupplierTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static Supplier supplier;
	@Autowired
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
		System.out.println("Supplier object is created...");
	}
//	@Test
//	public void createSupplierTest() {
//          supplier.setSupplierName("Ganesh Deshmukh");
//          supplierDAO.createSupplier(supplier);
//	}
//   @Test
//   public void deleteUser(){
//	   supplier.setSupplierId(0);
//	   boolean result = supplierDAO.deleteSupplier(supplier);
//	   System.out.println("Delete Supplier : "+result);
//   }
//   
//   @Test
//   public void updateSupplier(){
//	   supplier.setSupplierId(0);
//	   supplier.setSupplierName("Komal Deshmukh");
//	   boolean result = supplierDAO.updateSupplier(supplier);
//	   System.out.println("Supplier update : "+result);
//   }
//   @Test
//   public void isSupplier(){
//	   supplier.setSupplierId(12);
//	   boolean result = supplierDAO.isSupplier(supplier);
//	   System.out.println("Is Supplier : "+result);
//   }
//	@Test
//	public void supplierTest(){
//		List<Supplier> supplierList =  (List<Supplier>)supplierDAO.getSuppliers();
//		System.out.println("Total Supplier List : "+supplierList.size());
//	}
}
