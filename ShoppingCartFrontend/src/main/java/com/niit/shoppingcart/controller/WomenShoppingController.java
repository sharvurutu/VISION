package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.OrderDAO;
import com.niit.shoppingcart.dao.PaymentDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Order;
import com.niit.shoppingcart.model.Payment;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Controller
public class WomenShoppingController {

	@Autowired
	UserDAO userDAO;

	HttpSession session;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	User user;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@RequestMapping(value = "/women_shopping", method = RequestMethod.GET)
	public String getWomenShoppingDefaultPage(Model model){
        model.addAttribute("categoryList", categoryDAO.list());		
		model.addAttribute("productList", productDAO.getProducts());
        return "women";
	}
	
	@RequestMapping(value = "/view_product" , method = RequestMethod.GET)
	public String viewProduct(Model model,HttpServletRequest request){
		int productId = Integer.parseInt(request.getParameter("product_id"));
		model.addAttribute("product", productDAO.get(productId));
		model.addAttribute("categoryList", categoryDAO.list());
		return "view_product";
	}
	
	@RequestMapping(value = "/women_product_category", method = RequestMethod.GET)
	public String viewSareeProductes(Model model, HttpServletRequest request){
		String categoryName = request.getParameter("category_name").toLowerCase();
		if(categoryName == null || categoryName.isEmpty()){
			categoryName = "saree";
		}
		model.addAttribute("productList", productDAO.getProducts(categoryDAO.getCategoryIdByName(categoryName))) ;
		model.addAttribute("categoryList", categoryDAO.list());
		return "women";
	}
	
	@RequestMapping(value = "/buy_product", method= RequestMethod.GET)
	public String buyProductAction(Model model, HttpServletRequest request){
		String url_path = "";
		String productId = request.getParameter("product_id"); //Integer.parseInt(request.getParameter("product_id"));
		String categoryId = request.getParameter("category_id");
		session = request.getSession(true);
		model.addAttribute("userDAO" , new User());
		//this condition is not required
		if((productId == null && categoryId == null) || (productId.isEmpty() && categoryId.isEmpty())){
			model.addAttribute("message" , "Please select product!..");
			url_path = "login";
		}else{
			session.setAttribute("product_id_temp", productId);
			session.setAttribute("category_id_temp", categoryId);
			if(session.getAttribute("user_name_session") != null && session.getAttribute("user_id") != null){
				//if user login
				url_path = "order";
				Cart cart = new Cart();
				int productIdSession = Integer.parseInt(session.getAttribute("product_id_temp").toString());
				Product product = productDAO.get(productIdSession);
				cart.setProductId(productIdSession);
				
				cart.setProductTotalCost(product.getProductCost());
				cart.setUserId(Integer.parseInt(session.getAttribute("user_id").toString()));
				cart.setProductName(product.getProductName());
				cart.setImageServerPath(product.getImageserverpath());
				if(!cartDAO.isProductInCart(cart.getProductId() , cart.getUserId())){
					cart.setProductQuantity(1);    
					cartDAO.addToCart(cart);
				}else{
					Cart updateCart = cartDAO.getCart(cart.getProductId(), cart.getUserId());
					updateCart.setProductQuantity((updateCart.getProductQuantity()+1));
					updateCart.setProductTotalCost(product.getProductCost()*(updateCart.getProductQuantity()));
					cartDAO.updateCart(updateCart);
				}
				session.removeAttribute("product_id_temp");
				session.removeAttribute("category_id_temp");
				model.addAttribute("message", "Your product add into cart successfully.");
				model.addAttribute("cart", cart);
				model.addAttribute("userCartlist", cartDAO.getCartList(Integer.parseInt(session.getAttribute("user_id").toString())));
				
			}else{
				//User is not login
				url_path = "login";
				model.addAttribute("message", "Please login first.");
			}
		}
		
		return url_path;
	}
	
	@RequestMapping(value = "/delete_cart", method = RequestMethod.GET)
	public String deleteCartProduct(Model model , HttpServletRequest request){
		int cartId  = Integer.parseInt(request.getParameter("cart_id"));
		Cart cart = new Cart();
		cart.setCartId(cartId);
		if(cartDAO.delete(cart)){
			model.addAttribute("message", "Product is removed from cart successfully.");
		}
		model.addAttribute("cart" , new Cart());
		model.addAttribute("userCartlist", cartDAO.getCartList(Integer.parseInt(session.getAttribute("user_id").toString())));
		return "order";
	}

	@RequestMapping(value = "/update_cart", method = RequestMethod.POST)
	public String updateCartProduct(@ModelAttribute("cart") Cart cart,Model model , HttpServletRequest request){
		
		Product product = new Product();
		product = productDAO.get(cart.getProductId());
		cart.setProductTotalCost(cart.getProductQuantity()* product.getProductCost());
		session = request.getSession(true);
		cart.setUserId(Integer.parseInt(session.getAttribute("user_id").toString()));
		if(cartDAO.updateCart(cart)){
			model.addAttribute("message", "Product is update from cart successfully.");
		}
		model.addAttribute("cart" , cart);
		model.addAttribute("userCartlist", cartDAO.getCartList(Integer.parseInt(session.getAttribute("user_id").toString())));
		return "order";
	}
	
	@RequestMapping(value = "/order_now", method = RequestMethod.GET)
	public String orderProduct(Model model , HttpServletRequest request){
		session = request.getSession(true);
		model.addAttribute("orderDAO" , new Order());
		model.addAttribute("userCartlist", cartDAO.getCartList(Integer.parseInt(session.getAttribute("user_id").toString())));
		model.addAttribute("message", "Now you redy for order.");
		return "display_user_order";
	}
	
	@RequestMapping(value = "/order_now", method = RequestMethod.POST)
	public String displayOrderProduct(@ModelAttribute("orderDAO") Order order, Model model , HttpServletRequest request){
		session = request.getSession(true);
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");
		System.out.println("Billing Address : "+billingAddress+"\nShipping Address : "+shippingAddress);
		List<Cart> userCartlist = cartDAO.getCartList(Integer.parseInt(session.getAttribute("user_id").toString()));
		//--- add into order table -----------
		for(Cart cart : userCartlist){
			Order order1 = new Order();
			order1.setProductId(cart.getProductId());
			order1.setProductQuantity(cart.getProductQuantity());
			order1.setProductTotalCost(cart.getProductTotalCost());
			order1.setUserId(cart.getUserId());
			order1.setBillingAddress(billingAddress);
			order1.setShippingAddress(shippingAddress);
			orderDAO.createOrder(order1);
		}
		
		model.addAttribute("paymentDAO", new Payment());
		model.addAttribute("message", "Order is generated successfully..Please pay the payment.");
		return "payment";
	}  
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String userPayment(@ModelAttribute("paymentDAO") Payment payment, Model model , HttpServletRequest request){
		session = request.getSession(true);
		String paymentMode = request.getParameter("payment_mode");
		//------------------------ GET ALL ORDERS -------------
		
		List<Order> orderList = orderDAO.getAllOrders();
		for(Order order : orderList){
			Payment pay = new Payment();
			pay.setPaymentId(order.getOrderId());
			pay.setPaymentMode(paymentMode);
			paymentDAO.createPayment(pay);
		}
		
		List<Cart> userCartlist = cartDAO.getCartList(Integer.parseInt(session.getAttribute("user_id").toString()));
		//---- delete cart table records -------------
		for(Cart cart : userCartlist){
			cartDAO.delete(cart);
		}
		
		model.addAttribute("paymentDAO", new Payment());
		model.addAttribute("message", "Payment successfully..");
		return "payment";
	}	
	
}
