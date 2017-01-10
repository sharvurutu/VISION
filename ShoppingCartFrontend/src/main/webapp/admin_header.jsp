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
						<li class="mail"><% if(session.getAttribute("user_name_session")!= null){out.print(session.getAttribute("user_name_session"));} %></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<!-- //header-top -->
			<div class="top-nav">
				<span class="menu"><img src='<c:url value="/images/menu.png"/>' alt="">Shopping Cart</span>
				<ul class="nav">
					<li class="dropdown1"><a href="admin_home">HOME</a></li>
					<li class="dropdown1"><a href="men">MEN</a>
						<ul class="dropdown2">
							<li><a href="men_add_product">Add Product</a></li>
							<li><a href="men_update_product">Update Product</a></li>
							<li><a href="men_delete_product">Delete Product</a></li>
							<li><a href="men_view_all_product">View All Product</a></li>
						</ul>
					</li>     
					<li class="dropdown1"><a href="women">WOMEN</a>
						<ul class="dropdown2">
							<li><a href="women_add_product">Add Product</a></li>
							<li><a href="women_update_product">Update Product</a></li>
							<li><a href="women_delete_product">Delete Product</a></li>
							<li><a href="women_view_all_product">View All Product</a></li>
						</ul>
					</li> 
					<li class="dropdown1"><a href="category">Category</a>
						<ul class="dropdown2">
						    <li><a href="add_category">Add Category</a></li>
							<li><a href="update_category">Update Category</a></li>
							<li><a href="delete_category">Delete Category</a></li>
							<li><a href="view_all_category">View All Category</a></li>
						</ul>
					</li>
					<li class="dropdown1"><a href="supplier">Supplier</a>
						<ul class="dropdown2">
						    <li><a href="add_supplier">Add Supplier</a></li>
							<li><a href="update_supplier">Update Supplier</a></li>
							<li><a href="delete_supplier">Delete Supplier</a></li>
							<li><a href="view_all_supplier">View All Supplier</a></li>
						</ul>
					</li>
					<li class="dropdown1"><a href="user">User</a>
						<ul class="dropdown2">
						    <li><a href="add_user">Add User</a></li>
							<li><a href="update_user">Update User</a></li>
							<li><a href="delete_user">Delete User</a></li>
							<li><a href="view_all_user">View All User</a></li>
						</ul>
					</li>
					<li class="dropdown1"><a href="cart">Cart</a>
						<ul class="dropdown2">
							<li><a href="view_all_cart">View All Cart</a></li>
						</ul>
					</li>
					<li class="dropdown1"><a href="order">Order</a>
						<ul class="dropdown2">
							<li><a href="view_all_order">View All Order</a></li>
						</ul>
					</li>
					<li class="dropdown1"><a href="payment">Payment</a>
						<ul class="dropdown2">
							<li><a href="view_all_payment">View All Payment</a></li>
						</ul>
					</li>
					<li class="dropdown1"><a href="admin_logout">Logout</a></li>  	 
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
