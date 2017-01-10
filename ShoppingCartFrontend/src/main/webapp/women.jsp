<%@page import="com.niit.shoppingcart.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Women Product List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- bootstarp-css -->
<link href='<c:url value="resources/css/bootstrap.css"/>'
	rel="stylesheet" type="text/css" media="all" />
<!--// bootstarp-css -->
<!-- css -->
<link rel="stylesheet" href='<c:url value="resources/css/style.css"/>'
	type="text/css" media="all" />
<!--// css -->
<script src='<c:url value="resources/js/jquery.min.js"/>'></script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700'
	rel='stylesheet' type='text/css'>
<!--/fonts-->
<!-- dropdown -->
<script src='<c:url value="resources/js/jquery.easydropdown.js"/>'></script>
<link href='<c:url value="resources/css/nav.css"/>' rel="stylesheet"
	type="text/css" media="all" />
<script src='<c:url value="resources/js/scripts.js"/>'
	type="text/javascript"></script>
<!--js-->
<script src='<c:url value="resources/js/easyResponsiveTabs.js"/>'
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true
		// 100% fit in a container
		});
	});
</script>
<!-- start-smoth-scrolling -->
<script type="text/javascript"
	src="<c:url value='resources/js/move-top.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='resources/js/easing.js'/>"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="./header.jsp"></jsp:include>
	<!-- //header -->
	<!-- men -->
	<div class="men">
		<!-- container -->
		<div class="container">
			<div class="col-md-9 fashions">
				<div class="title">
					<h3>WOMEN PRODUCTS</h3>
				</div>
				<div class="fashion-section">
				<%  %>
				<%-- <c:forEach items="${productList }" var="product"></c:forEach> --%>
			    <% 
			     ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
			 	  int divCounter = 0;
			 	  int totalCounter = productList.size();
			 	  int imageCounter = 0;
			 	  
			    for(Product product : productList ) {
			 		if(divCounter==0) {
				%>
				
					<div class="fashion-grid1">
				<%
			 		} //create new div
				 %>
				      <div class="col-md-3 fashion-grid">
							 <a href="view_product?product_id=<%=product.getProductId()%>&category_id=<%=product.getCategoryID()%>"><img src=<c:url value="<%=product.getImageserverpath() %>" /> alt=""/>
								 <div class="product">
									 <h3><%=product.getProductName() %></h3>
									 <p><span></span> Rs.<%=product.getProductCost() %></p>								 
								 </div>							 
							 </a>
							 <div class="fashion-view"><span></span>
										<div class="clearfix"></div>
									 <h4><a href="view_product?product_id=<%=product.getProductId()%>&category_id=<%=product.getCategoryID()%>">Quick View</a></h4>
							 </div>
						 </div>
			   <%  
			    imageCounter++;
			    divCounter++;
			   if(divCounter > 0 && (totalCounter == imageCounter)){
				   divCounter = 0;
			%>
			   		 <div class="clearfix"></div>
					</div>
			<%	   
				   
			   }
			   
			 	if(divCounter == 4){		
			 		divCounter = 0;
					
				%>
						 <div class="clearfix"></div>
					</div>
				<%
			 		} // close div 
			 		
			     }// end for loop
				%>	
				</div>
			</div>
			<div class="col-md-3 side-bar">
				<div class="categories">
					<h3>CATEGORIES</h3>
					<ul>
					   <c:forEach items="${categoryList }" var="category">
						<li><a href="./women_product_category?category_name=${category.name }">${category.name }</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="sales">
					<h3>SALE</h3>
					 <div class="pricing">
						 <h4>Price range</h4>
						 <input type="text" placeholder="price from" required/>
						 <input type="text" placeholder="price to" required/>
						 <div class="clearfix"></div>
					 </div>
					 <div class="size">
						 <h4>Size</h4>
						 <ul>
							 <li><a href="#">XS</a></li>
							 <li><a href="#">S</a></li>
							 <li><a href="#">M</a></li>
							 <li><a href="#">L</a></li>
							 <li><a href="#">XL</a></li>
						 </ul>
					 </div>
				</div>
			</div>

			<div class="clearfix"> </div>
		</div>
		<!-- //container -->
	</div>
	<!-- //men -->
	<!-- footer -->
		<!-- container -->
   <jsp:include page="./footer.jsp"></jsp:include>
	<!-- //footer -->
</body>
</html>