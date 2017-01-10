<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Panel | View Products</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstarp-css -->
<link href='<c:url value="resources/css/bootstrap.css"/>' rel="stylesheet" type="text/css" media="all" />
<!--// bootstarp-css -->
<!-- css -->
<link rel="stylesheet" href='<c:url value="resources/css/style.css"/>' type="text/css" media="all" />
<!--// css -->
<script src='<c:url value="resources/js/jquery.min.js"/>'></script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700' rel='stylesheet' type='text/css'>
<!--/fonts-->
<!-- dropdown -->
<script src='<c:url value="resources/js/jquery.easydropdown.js"/>'></script>
<link href='<c:url value="resources/css/nav.css"/>' rel="stylesheet" type="text/css" media="all"/>
<script src='<c:url value="resources/js/scripts.js"/>' type="text/javascript"></script>
<!--js-->
<script src='<c:url value="resources/js/easyResponsiveTabs.js"/>' type="text/javascript"></script>
		    <script type="text/javascript">
			    $(document).ready(function () {
			        $('#horizontalTab').easyResponsiveTabs({
			            type: 'default', //Types: default, vertical, accordion           
			            width: 'auto', //auto or any width like 600px
			            fit: true   // 100% fit in a container
			        });
			    });
			   </script>	
<!-- start-smoth-scrolling -->
		<script type="text/javascript" src="<c:url value='resources/js/move-top.js'/>"></script>
		<script type="text/javascript" src="<c:url value='resources/js/easing.js'/>"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
</head>
<body>
<jsp:include page="./admin_header.jsp"></jsp:include>
<div class="support-info">
		<!-- container -->
		<div class="container">
		<form:form action="women_update_product" method="post" modelAttribute="productDAO" enctype="multipart/form-data">
               <table class="table">
					<thead>
						<tr>
							<td colspan="2"><h1>Update Women Product</h1></td>
						</tr>
					</thead>
					<tbody>
					     <tr>
					        <td>ID</td>
					        <td><form:input path="productId" size="30" class="form-control"/></td>
					     </tr>
						 <tr>
							<td>Name :</td>
							<td><form:input path="productName" size="30" class="form-control"/></td>
						</tr>
						<tr>
						   <td>Category ID :</td>
						   <td>
						      <form:input class="form-control" path="categoryID" />
						   </td>
						</tr>
						<tr>
						   <td>Server Image :</td>
						   <td><form:input  path="imageserverpath" class="form-control" /></td>
						</tr>
						<tr>
						   <td>Server Stored Image :</td>
						   <td><form:input  path="productImagePath" class="form-control" /></td>
						</tr>
						<tr>
						   <td>Cost : </td>
						   <td><form:input path="productCost" class="form-control" /></td>
						</tr>
						<tr>
						   <td>Description :</td>
						   <td><form:textarea path="productDescription" class="form-control"/></td>
						</tr>
						<tr>
						   <td colspan="2"><input type="submit" value="Submit"></td>
						</tr>
						<tr>
						   <td colspan="2"><font color="red">${message}</font></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<!-- View Product List Table-->
				<table class="table">
					<thead>
						<tr>
						   <th align="center">ID</th>
						   <th align="center">Name</th>
						   <th align="center">Image</th>
						   <th align="center">Category Id</th>
						   <th align="center">Cost</th>
						   <th align="center">Description</th>
						   <th align="center">Action</th>
						</tr>
					</thead>
					<tbody>
					 <c:forEach items="${productList}" var="product">
					    <tr>
							<td align="left">${product.productId }</td>
							<td align="left">${product.productName }</td>
							<td align="left"><img src='<c:url value="${product.imageserverpath }"/>' width="140px" height="140px"/></td>
							<td align="left">${product.categoryID }</td>
							<td align="left">${product.productCost }</td>
							<td align="left">${product.productDescription }</td>
							<td align="left"><a href="women_update_product?productId=${product.productId }">Update</a></td>
						</tr>
					 </c:forEach>
						
					</tbody>
				</table>
			
		</div>
	</div>
	<jsp:include page="./admin_footer.jsp"></jsp:include>
</body>
</html>