<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Register</title>
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
	<!-- banner -->
	<div class="support-info">
		<!-- container -->
		<div class="container">
			<form:form action="register" method="post" modelAttribute="userDAO">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2"><h1>Sign up</h1></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Enter Your Name</td>
							<td><form:input path="userName" size="40" required=""/></td>
						</tr>
						<tr>
							<td>Enter Email ID</td>
							<td><form:input path="emailId" size="40" required=""/></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><form:password path="password" size="40" required=""/></td>
						</tr>
						<tr>
						   <td>Confirm Password</td>
						   <td><input type="password" name="cpassword" size="40" required="" /></td>
						</tr>
						<tr>
						   <td>Mobile NO.</td>
						   <td><form:input path="mobileNo" size="40" required="" /></td>
						</tr>
						
						<tr>
							<td colspan="2"><input type="submit" value="Sign up"></td>
						</tr>
						<tr>
							<td colspan="2" style="color: red;">${message }</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- //footer -->

</body>
</html>