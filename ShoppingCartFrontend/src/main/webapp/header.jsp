<%@page import="java.util.List"%>
<%@page import="com.niit.shoppingcart.dao.CartDAO"%>
<%@page import="com.niit.shoppingcart.model.Cart"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="header">
		<!-- container -->
		<div class="container">
			<!-- header-top -->
			<div class="header-top">
				<div class="header-logo">
					<a href="index.jsp"><img src="<c:url value='resources/images/logo1.png' />" alt="" />Shopping Cart</a>
				</div>
				<div class="header-right">
					<ul>
						<li class="phone">+371 282 20 760</li>
						<li class="mail"><a href="mailto:example@mail.com"><c:if test="${not empty user_name_session }"> <font color="green" >${user_first_name } </font></c:if></a></li>
						<li class="checkout">
						<c:if test="${not empty userCartlist }">
						  <% 
						    List<Cart> cartList = (List<Cart>)request.getAttribute("userCartlist");
						    double totalCost = 0.0;
						    for(Cart cart : cartList){
						    	totalCost += cart.getProductTotalCost();
						    }
						  %>
						  <a href="#">
							<span class="cart">RS. <%=totalCost %></span>
							<span class="check">Checkout</span>
						  </a>
						  <div class="shopping">
								<h5>Your Shopping Cart</h5>
								<p><font color="black">Product Id &nbsp;&nbsp;Name&nbsp;&nbsp;Cost</font></p>
								<% for(Cart cart : cartList){ %>
								
								  <p><font color="black"><%=cart.getProductId()%>&nbsp;&nbsp;<%=cart.getProductName() %> &nbsp;&nbsp;<%=cart.getProductTotalCost() %></font></p>
								<% } %>
								
						  </div>
						</c:if>
						<c:if test="${empty userCartlist }">
							<a href="add-to-cart.html">
								<span class="cart">RS. 00.00</span>
								<span class="check">Checkout</span>
							</a>
							<div class="shopping">
								<h5>Your Shopping Cart is empty.</h5>
								<p>Give it purpose—fill it with books, movies, mobiles, cameras, toys and fashion jewellery.</p>
							</div>
					     </c:if>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- //header-top -->
			<div class="top-nav">
				<span class="menu"><img src="<c:url value='resources/images/menu.png'/>" alt="">Shopping Cart</span>
				<ul class="nav">
					<li class="dropdown1"><a href="home">HOME</a></li>
					<!-- <li class="dropdown1"><a href="men.jsp">MEN</a>
						<ul class="dropdown2">
							<li><a href="men.html">Clothing</a></li>
							<li><a href="men.html">Footwear</a></li>
							<li><a href="men.html">Watches</a></li>
							<li><a href="men.html">Accessories</a></li>
						</ul>
					</li>     --> 
					<li class="dropdown1"><a href="women_shopping">WOMEN</a>
						<ul class="dropdown2">
							<li><a href="women_product_category?category_name=saree">Saree</a></li>
							<li><a href="women_product_category?category_name=jacket">Jacket</a></li>
							<li><a href="women_product_category?category_name=lehenga">Lehenga</a></li>
							<!-- <li><a href="women_product_category?category_name=">Beauty & Wellness</a></li> -->
						</ul>
					</li> 
					<c:if test="${not empty user_name_session }">
					    <li class="dropdown1"><a href="order_now">My Cart</a></li>
					    <li class="dropdown1"><a href="user_logout">Logout</a></li>
					</c:if>
					<c:if test="${empty user_name_session }">
						<li class="dropdown1"><a href="login">Login</a></li>  	
						<li class="dropdown1"><a href="signup">Register</a></li>
					</c:if>
					 
				</ul>
			</div>
			<div class="search">
				<form>
					<input type="text" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}" required="">
				</form>
			</div>
			<div class="clearfix"> </div>
			<!-- script-for-menu -->
		 <script>
				$("span.menu").click(function(){
					$(" ul.nav").slideToggle("slow" , function(){
					});
				});
		 </script>
		</div>
		<!-- //container -->
	</div>
