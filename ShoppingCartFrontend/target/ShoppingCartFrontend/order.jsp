<%@page import="com.niit.shoppingcart.model.Cart"%>
<%@page import="java.util.List"%>
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
	
	<div class="men">
		<!-- container -->
		<div class="container">
		<div class="alert alert-success">${message }</div>
	<form:form action="./update_cart" method="post" modelAttribute="cart">
	 <table class="table">
		   <thead>
		   <tr>
		      <th>Id</th>
		      <th>Name</th>
		      <th>Image</th>
		      <th>Quantity</th>
		      <th>Cost</th>
		      <th>Total Cost</th>
		      <th align="center" colspan="2">Action</th>
		   </tr>
		   </thead>
		   <tbody>
		 <%--   <c:forEach items="userCartlist" var="cart"> --%>
		 <%
		    List<Cart> cartList = (List<Cart>)request.getAttribute("userCartlist");
		    double totalCost = 0.0;
		    for(Cart cart : cartList){
		 %>
		      <tr>
		          <form:hidden path="cartId"/>
		         <td><%=cart.getProductId() %><form:hidden path="productId"/></td>
		         <td><%=cart.getProductName() %><form:hidden path="productName"/></td>
		         <td><img src="<c:url value='<%=cart.getImageServerPath() %>' />" width="40px" height="40px"/>
		            <form:hidden path="imageServerPath"/>
		         </td>
		         <td><form:input path="productQuantity" value="<%=cart.getProductQuantity() %>"/></td>
		         <td><%=(cart.getProductTotalCost()/cart.getProductQuantity()) %></td>
		         <td><%=cart.getProductTotalCost() %><form:hidden path="productTotalCost"/></td>
		         <td><a href="./delete_cart?cart_id=<%=cart.getCartId() %>" class="btn btn-primary">Delete</a></td>
		         <td><input type="Submit" value="Edit" class="btn btn-primary"></td>
		      </tr>
		   <%
		     totalCost += cart.getProductTotalCost();
		     } 
		   %>
		   <%--  </c:forEach> --%>
		   </tbody>
		   <% if(!cartList.isEmpty()){%>
		   <tfoot>
		     <tr>
		        <td colspan="4"></td>
		        <td>Total Cost</td>
		        <td><%=totalCost %></td>
		        <td colspan="2"><a href="./order_now" class="btn btn-primary">Order Now</a></td>
		     </tr>
		   </tfoot>
		   <% }else{ %>
		     <tfoot>
		        <tr>
		           <td colspan="8">You cart is empty.</td>
		        </tr>
		     </tfoot>
		   <%} %>
		</table>
	 </form:form>
	</div>
</div>
	<!-- footer -->
   <jsp:include page="./footer.jsp"></jsp:include>
	<!-- //footer -->
</body>
</html>