package com.niit.shoppingcart.test;


import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Category category;

	@Autowired
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void inti() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		System.out.println("The object is created");
	}

//	@Test
//	public void getCategory(){
//		int result = categoryDAO.getCategoryIdByName("saree");
//		System.out.println("Category Name : saree  Category ID : "+result);
//	}
//	@Test
//	public void createCategoryTestCase() {
//		category.setName("saree");
//		Boolean status = categoryDAO.save(category);
//        System.out.println("Insert category : "+status);
//	}

//	@Test
//	public void deleteCategoryTestCase() {
//		category.setId("3");
//		boolean status = categoryDAO.delete(category);
//		System.out.println("Delete category Status : "+status);
//	}

//	@Test
//	public void update(){
//	  category.setId("5");
//	  category.setName("lehenga");
//	  boolean result = categoryDAO.update(category);
//	  System.out.println("Update category : "+result);
//	}
//	@Test
//	public void getCategoryList(){
//		List<Category> categoryList = categoryDAO.list();
//		System.out.println("Categor Total : "+categoryList.size());
//	}

//	@Test
//	public void checkCategory(){
//		category.setName("saree12");
//		boolean result = categoryDAO.isCategory(category);
//		System.out.println("Category Result : "+result);
//	}
}
