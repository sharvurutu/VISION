package com.niit.shoppingcart.controller;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Autowired
	Category category;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String getCategoryModel(Model model) {
		model.addAttribute("categoryDAO", new Category());
		return "add_category";
	}

	//-------------------- ADD CATEGORY [ START ] ---------------------------
	
	@RequestMapping(value = "/add_category", method = RequestMethod.GET)
	public String getCategoryForm(Model model) {
		model.addAttribute("categoryDAO", new Category());
		return "add_category";
	}

	@RequestMapping(value = "/add_category", method = RequestMethod.POST)
	public String categoryAddAction(@ModelAttribute("categoryDAO") Category cotegory, Map<String, Object> map,
			HttpServletRequest request) {
		String categoryName = request.getParameter("name");
		if (!categoryName.isEmpty()) {
			map.put("categoryDAO", new Category());
			if (categoryDAO.isCategory(cotegory)) {
				map.put("message", "This category name is already present into database.");
			} else {
				if (categoryDAO.save(cotegory)) {
					map.put("message", "Add category successfully!!..");
				} else {
					map.put("message", "Somthing is wrong!!!");
				}
			}
		} else {
			map.put("message", "Please fill up all fields.");
		}
		return "add_category";
	}

	//-------------------- ADD CATEGORY [ END ] ---------------------------
	
	@RequestMapping(value = "/view_all_category", method = RequestMethod.GET)
	public String getCategoryList(Model model){
		
		model.addAttribute("categoryDAO" , categoryDAO.list());
		return "view_all_category";
	}
	
	//---------------------- UPDATE CATEGORY [ START ]-------------------------
	
	@RequestMapping(value="/update_category", method=RequestMethod.GET)
	public String getUpdateCategoryForm(Model model, HttpServletRequest request){
		String categoryId = request.getParameter("id");
		String categoryName = request.getParameter("name");
		Category category = new Category();
		 System.out.println("Category Id : "+categoryId+" category Name : "+categoryName);
		if(categoryId != null  && categoryName != null){
			category.setId(categoryId);
			category.setName(categoryName);
			model.addAttribute("message", "Ready for updation!!..");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryDAO", categoryDAO.list());
		return "update_category";
	}
	
	@RequestMapping(value = "update_category", method = RequestMethod.POST)
	public String updateCategoryAction(@ModelAttribute("category") Category category, Map<String,Object> map, 
			                 HttpServletRequest request){
		String categoryId = request.getParameter("id");
		String categoryName = request.getParameter("name");
		if(!categoryId.isEmpty() && !categoryName.isEmpty()){
			categoryDAO.update(category);
			category.setId("");
			category.setName("");
			map.put("message", "Update category successfully!!..");
		}else{
			map.put("message", "All fileds are necessary!!..");
		}
		
		map.put("category", category);
		map.put("categoryDAO", categoryDAO.list());
		return "update_category";
	}
	
	//-------------- UPDATE CATEGORY [ END ] ----------------------------------------
	
	//-------------- DELETE CATEGORY [ START ] --------------------------------------
	@RequestMapping(value="/delete_category", method = RequestMethod.GET)
	public String getDeleteCategoryForm(Model model, HttpServletRequest request){
		String categoryId = request.getParameter("id");
		String categoryName = request.getParameter("name");
		Category category = new Category();
		 System.out.println("Category Id : "+categoryId+" category Name : "+categoryName);
		if(categoryId != null  && categoryName != null){
			category.setId(categoryId);
			category.setName(categoryName);
			model.addAttribute("message", "This record is ready for delete!!..");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryDAO", categoryDAO.list());
		return "delete_category";
	}
	
	@RequestMapping(value="/delete_category", method = RequestMethod.POST)
	public String deleteCategoryAction(@ModelAttribute("category") Category category, Map<String,Object> map,
			HttpServletRequest request) {
		String categoryId = request.getParameter("id");
		String categoryName = request.getParameter("name");
		if(!categoryId.isEmpty() && !categoryName.isEmpty()){
			categoryDAO.delete(category);
			category.setId("");
			category.setName("");
			map.put("message", "Delete category successfully!!..");
		}else{
			map.put("message", "All fileds are necessary!!..");
		}
		
		map.put("category", category);
		map.put("categoryDAO", categoryDAO.list());
		return "delete_category";
	}
	//-------------- DELETE CATEGORY [ END ] ----------------------------------------
	
	@RequestMapping(value="/staticCategoryList", method=RequestMethod.GET)
	public String getCategorys(Model model){
		model.addAttribute("categoryList" , categoryDAO.list());
		return "temp";
	}
}
