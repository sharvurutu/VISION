<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Panel | Women add product</title>
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
			<form:form action="women_add_product" method="post" modelAttribute="productDAO" enctype="multipart/form-data">
               <table class="table">
					<thead>
						<tr>
							<td colspan="2"><h1>Add Women Product</h1></td>
						</tr>
					</thead>
					<tbody>
						 <tr>
							<td>Name :</td>
							<td><form:input path="productName" size="30" class="form-control"/></td>
						</tr>
						<tr>
						   <td>Category :</td>
						   <td>
						      <form:select class="form-control" path="categoryID">
						         <c:forEach items="${categoryList }" var="category">
						            <form:option value="${category.id }">
						                      ${category.name }
						             </form:option>
						         </c:forEach>
						      </form:select>
						   </td>
						</tr>
						<tr>
						   <td>Select Image :</td>
						   <td><input type="file" name="productImagePath" path="productImagePath" class="form-control"></td>
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
		</div>
	</div>
	<jsp:include page="./admin_footer.jsp"></jsp:include>
</body>
</html>