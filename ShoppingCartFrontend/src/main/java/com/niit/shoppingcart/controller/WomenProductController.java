package com.niit.shoppingcart.controller;

import java.io.File;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.util.FileUtil;

@Controller
public class WomenProductController {

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	// ---------- Add Product form fields name ---------------
	String file_path = "E:/Vision/ShoppingCartFrontend/src/main/webapp/resources/upload_images/";
	String serverPath = "resources/upload_images/";
	String productName;
	String productCategoryId;
	String productCost;
	String productDescription;
	String productId;
	
	//------------------ DEFAULT WOMEN PRODUCT PAGE [ START ]---------------------
	@RequestMapping(value = "/women" , method = RequestMethod.GET)
	public String getAddProductDefaultForm(Model model){
		model.addAttribute("productDAO" , product);
		model.addAttribute("categoryList" , categoryDAO.list());
		return "women_add_product";
	}
	//------------------ DEFAULT WOMWN PRODUCT PAGE [ END ] ----------------------
	
	//------------------ ADD WOMEN PRODUCT [START] ----------------------------------
	@RequestMapping(value = "/women_add_product" , method = RequestMethod.GET)
	public String getAddProductForm(Model model){
		model.addAttribute("productDAO" , product);
		model.addAttribute("categoryList" , categoryDAO.list());
		return "women_add_product";
	}
	
	@RequestMapping(value = "/women_add_product" , method = RequestMethod.POST)
	public String addWomenProductAction(@ModelAttribute("productDAO") Product product,
			Map<String,Object> map, HttpServletRequest request){
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(!isMultipart){
        }else{
        	
      	FileItemFactory factory = new  DiskFileItemFactory();
      	ServletFileUpload upload = new ServletFileUpload(factory);
      	List<?> items = null;
      	try{ 
      		items = upload.parseRequest(request);
      	}catch(FileUploadException ex){
      		System.out.println("BugDatabase.java Servlet : ");
      		ex.printStackTrace();
      	}
      	Iterator<?> itr = items.iterator();
      	while(itr.hasNext()){
      		FileItem item = (FileItem) itr.next();
      		if(item.isFormField()){
      			if(item.getFieldName().equalsIgnoreCase("productName")){
      				productName = item.getString();
      				System.out.println("Product Name : "+productName);
      				product.setProductName(productName);
      			}else if(item.getFieldName().equalsIgnoreCase("categoryID")){
      				productCategoryId = item.getString();
      				System.out.println("Category ID : "+productCategoryId);
      				product.setCategoryID(productCategoryId);
      			}else if(item.getFieldName().equalsIgnoreCase("productCost")){
      				productCost = item.getString();
      				System.out.println("Product Cost : "+productCost);
      				product.setProductCost(Double.parseDouble(productCost));
      			}else if(item.getFieldName().equalsIgnoreCase("productDescription")){
      				productDescription  = item.getString();
      				System.out.println("Product Description : "+productDescription);
      				product.setProductDescription(productDescription);
      			}
      			
      		}else{
      			try{
      				String itemName = FileUtil.getCurrentDate()+"_"+FileUtil.getRandomNumber()+".jpg";
      				System.out.println("File Name : "+itemName);
      				File savedFile = new File(file_path+itemName);
      				item.write(savedFile);
      				System.out.println("File output : "+savedFile.getAbsolutePath());
      				System.out.println("File serverPath +"+serverPath+""+itemName);
      				product.setImageserverpath(serverPath+""+itemName);
      				product.setProductImagePath(savedFile.getAbsolutePath());
      			}catch (Exception e) {
					e.printStackTrace();
				}
      		}
      	}
      	
      	  if(productDAO.isProduct(product)){
      		  map.put("message", "Product name is alredy present in to database.");
      		  if(product.getProductImagePath() != null){
      			  File file = new File(product.getProductImagePath());
      			  if(file.exists()){
      				  if(file.delete()){
      					  System.out.println("File delete successfully....");
      				  }
      			  }
      		  }
      	  }else{
      		  productDAO.addProduct(product);
      		  //---------- remove product add details ----------------
      		  product.setCategoryID("");
      		  product.setImageserverpath("");
      		  product.setProductCost(0.0);
      		  product.setProductDescription("");
      		  product.setProductImagePath("");
      		  product.setProductId(0);
      		  product.setProductName("");
      		  map.put("message", "Product is add into database!...");
      	  }
      	
        }
		
		
		map.put("productDAO" , product);
		map.put("categoryList" , categoryDAO.list());
		return "women_add_product";
	}
	
	@RequestMapping(value="/women_view_all_product", method = RequestMethod.GET)
	public String getAllProductList(Model model){
		model.addAttribute("prduct", new Product());
		model.addAttribute("productList", productDAO.getProducts());
		return "women_view_all_product";
	}
	
	@RequestMapping(value = "/women_update_product", method = RequestMethod.GET)
	public String getWomenUpdateProductForm(Model model, HttpServletRequest request) {

		product = new Product();
		
		productId = request.getParameter("productId");
		productName = request.getParameter("productName");
		productCategoryId = request.getParameter("categoryID");
		productCost = request.getParameter("productCost");
		productDescription = request.getParameter("productDescription");
		serverPath = request.getParameter("imageserverpath");
		file_path = request.getParameter("productImagePath");
		
//		if (productId != null && productName != null && productCategoryId != null && productCost != null
//				&& productDescription != null && serverPath != null && file_path != null) {
   if(productId != null){
			System.out.println("Product Description : " + productId);
			product.setProductId(Integer.parseInt(productId));
            product = productDAO.get(Integer.parseInt(productId));
//			System.out.println("Product Name : " + productName);
//			product.setProductName(productName);
//
//			System.out.println("Category ID : " + productCategoryId);
//			product.setCategoryID(productCategoryId);
//
//			System.out.println("Product Cost : " + productCost);
//			product.setProductCost(Double.parseDouble(productCost));
//
//			System.out.println("Product Description : " + productDescription);
//			product.setProductDescription(productDescription);
//
//			product.setImageserverpath(serverPath);
//
//			product.setProductImagePath(file_path);

			model.addAttribute("message", "Product is ready for updation.");
		}
		
		model.addAttribute("productDAO", product);
		model.addAttribute("productList", productDAO.getProducts());
		model.addAttribute("categoryList", categoryDAO.list());
		return "women_update_product";
	}
	
	//------------------ ADD WOMEN PRODUCT [END] ----------------------------------
}
