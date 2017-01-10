<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Admin Panel | Home</title>
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
	<!-- header -->
    <jsp:include page="./admin_header.jsp"></jsp:include>
	<!-- //header -->
	<!-- banner -->
	<!-- //banner -->
	<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<div class="banner-bottom-grids">
				<div class="col-md-4 bottom-grid">
					
				</div>
				<div class="col-md-4 bottom-grid">
					
				</div>
				<div class="col-md-4 bottom-grid">
					
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	
	<!-- sign-up -->
	<div class="sign-up">
		<!-- container -->
		<div class="container">
			<div class="sign-up-left">
				<p><span>Sign up</span> for exclusive sales and product news</p>
			</div>
			<div class="sign-up-right">
				<form>
					<input type="text" value="eony321v@gmail.com" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'eony321v@gmail.com';}" required="">
					<input type="submit" value="sign up">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
		<!-- //container -->
	</div>
	<!-- //sign-up -->
	<!-- footer -->
	<jsp:include page="./admin_footer.jsp"></jsp:include>
	<!-- //footer -->
</body>
</html>