<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>E-Commerce online Shopping | Home</title>
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
    <jsp:include page="./header.jsp"></jsp:include>
	<!-- //header -->
	<!-- banner -->
	<div class="banner">
			<!-- banner Slider starts Here -->
					<script src='<c:url value="resources/js/responsiveslides.min.js"/>'></script>
					 <script>
						// You can also use "$(window).load(function() {"
						$(function () {
						  // Slideshow 4
						  $("#slider3").responsiveSlides({
							auto: true,
							pager: true,
							nav: true,
							speed: 500,
							namespace: "callbacks",
							before: function () {
							  $('.events').append("<li>before event fired.</li>");
							},
							after: function () {
							  $('.events').append("<li>after event fired.</li>");
							}
						  });
					
						});
					  </script>
					<!--//End-slider-script -->
					<div  id="top" class="callbacks_container">
						<ul class="rslides" id="slider3">
							<li>
								<div class="banner-bg">
									<div class="container">
										<div class="banner-info">
											<h2>RIGHT IS WHITE.<span>LEFT IS BLACK</span></h2>
											<p>Inspired by Brasil’s bold colors and matching up to football’s on-pitch
												playmakers, these kicks are ready to stand out.
											</p>
											<a href="#">SHOP PUNE</a>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="banner-bg banner-img2">
									<div class="container">
										<div class="banner-info">
											<h2>RIGHT IS BLUE.<span>LEFT IS PINK</span></h2>
											<p>Inspired by bold colors and matching up to football’s on-pitch
												playmakers, these kicks are ready to stand out.
											</p>
											<a href="#">SHOP PUNE</a>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="banner-bg banner-img">
									<div class="container">
										<div class="banner-info">
											<h2>RIGHT IS PINK.<span>LEFT IS BLUE</span></h2>
											<p>Inspired by Brasil’s bold colors and matching up to football’s on-pitch
												playmakers, these Brasil’s kicks are ready to stand out.
											</p>
											<a href="#">SHOP PUNE</a>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="banner-bg">
									<div class="container">
										<div class="banner-info">
											<h2>RIGHT IS WHITE.<span>LEFT IS BLACK</span></h2>
											<p>Inspired by bold colors and matching up to football’s on-pitch
												playmakers, these kicks are ready to stand out.
											</p>
											<a href="#">SHOP PUNE</a>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="banner-bg banner-img2">
									<div class="container">
										<div class="banner-info">
											<h2>RIGHT IS BLUE.<span>LEFT IS PINK</span></h2>
											<p>Inspired by Brasil’s bold colors and matching up to football’s on-pitch
												playmakers, these kicks Brasil’s are ready to stand out.
											</p>
											<a href="#">SHOP PUNE</a>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
	</div>
	<!-- //banner -->
	<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<div class="banner-bottom-grids">
				<div class="col-md-4 bottom-grid">
					<img src='<c:url value="resources/images/25.jpg"/>' alt="" />
					<div class="bottom-grid-info">
						<a href="#">LEHENGA</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing,
							vivamus congue nulla leo, quis imperdiet magna.
						</p>
					</div>
				</div>
				<div class="col-md-4 bottom-grid">
					<img src='<c:url value="resources/images/26.jpg"/>' alt="" />
					<div class="bottom-grid-info">
						<a href="#">MODERN CLOTHES</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing,
							vivamus congue nulla leo, quis imperdiet magna.
						</p>
					</div>
				</div>
				<div class="col-md-4 bottom-grid">
					<img src='<c:url value="resources/images/27.jpg"/>' alt="" />
					<div class="bottom-grid-info">
						<a href="#">SAREES</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing,
							vivamus congue nulla leo, quis imperdiet magna.
						</p>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-4 bottom-grid">
					<img src='<c:url value="resources/images/28.jpg"/>' alt="" />
					<div class="bottom-grid-info">
						<a href="#">SAREES</a>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing,
							vivamus congue nulla leo, quis imperdiet magna.
						</p>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<%-- <!-- banner-bottom -->
	<!-- products -->
	<div class="products">
		<!-- container -->
		<div class="container">
			<div class="products-heading">
				<h3>POPULAR PRODUCTS</h3>
			</div>
			<div class="products-grids">
				<div class="col-md-3 product-left-grid">
					<div class="product-grid">
						<div class="sap_tabs">	
							<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
								<div class="resp-tabs-container">
									<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
										<div class="facts">
											<img src='<c:url value="resources/images/t1.jpg"/>' class="img-responsive" alt=""/> 
										</div>
									</div>	
									<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
										<div class="facts">
											<img src='<c:url value="/resources/images/t2.jpg"/>' class="img-responsive" alt=""/>   
										</div>
									</div>	
									<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
										<div class="facts">
											<img src='<c:url value="/resources/images/t3.jpg"/>' class="img-responsive" alt=""/> 
										</div>
									</div>	         	  
								</div>
								<ul class="resp-tabs-list">
									<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span><img src='<c:url value="resources/images/t1.jpg"/>' class="img-responsive" alt=""/></span></li>
									<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span><img src='<c:url value="/resources/images/t2.jpg"/>' class="img-responsive" alt=""/></span></li>
									<li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span><img src='<c:url value="/resources/images/t3.jpg"/>' class="img-responsive" alt=""/></span></li>
									<div class="clearfix"> </div>
								</ul>	
							</div>
						</div>
						<div class="products-grid-info">
							<h3>Nike Tailwind Loose</h3>
							<h4>Running Tank Top</h4>
							<p>The Nike Tailwind Loose Women's Running Tank 
								Top is made with sweat-wicking fabric to help you 
								stay dry and comfortable on your run.
							</p>
							<div class="price">
								<p>$ 36.99</p>
							</div>
							<div class="like">
								<a href="#"><img src='<c:url value="resources/images/like.png"/>' alt="" /></a>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="col-md-3 product-left-grid">
					<div class="product-grid">
						<div class="product-grid-text">
							<a href="single.html"><img src='<c:url value="resources/images/t4.jpg"/>' alt="" /></a>
							<div class="products-grid-info">
								<h3>Nike g87</h3>
								<h4>Training Tank Top</h4>
								<p>The Nike Tailwind Loose Women's Running Tank 
									Top is made with sweat-wicking fabric to help you 
									stay dry and comfortable on your run.
								</p>
								<div class="price">
									<p>$ 49.99</p>
								</div>
								<div class="like">
									<a href="#"><img src="<c:url value='/resources/images/like.png'/>" alt="" /></a>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="plus">
								<a href="single.html"><img src="<c:url value='/resources/images/plus.png'/>" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 product-left-grid">
					<div class="product-grid">
						<div class="product-grid-text">
							<a href="single.html"><img src="<c:url value='/resources/images/t5.jpg'/>" alt="" /></a>
							<div class="products-grid-info">
								<h3>Nike I-Beam Swoosh</h3>
								<h4>Sports Top</h4>
								<p>The Nike Tailwind Loose Women's Running Tank 
									Top is made with sweat-wicking fabric to help you 
									stay dry and comfortable on your run.
								</p>
								<div class="price">
									<p>$ 70.00</p>
								</div>
								<div class="like">
									<a href="#"><img src="<c:url value='/resources/images/like.png'/>" alt="" /></a>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="plus">
								<a href="single.html"><img src="<c:url value='/resources/images/plus.png'/>" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 product-left-grid">	
					<div class="product-grid">
						<div class="product-grid-text">
							<a href="single.html"><img src="<c:url value='/resources/images/t6.jpg'/>" alt="" /></a>
							<div class="products-grid-info">
								<h3>Nike lux</h3>
								<h4>Running Top</h4>
								<p>The Nike Tailwind Loose Women's Running Tank 
									Top is made with sweat-wicking fabric to help you 
									stay dry and comfortable on your run.
								</p>
								<div class="price">
									<p>$ 28.49</p>
								</div>
								<div class="like">
									<a href="#"><img src="<c:url value='/resources/images/like.png'/>" alt="" /></a>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="plus">
								<a href="single.html"><img src="<c:url value='/resources/images/plus.png'/>" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<!-- //container -->
	</div>
	<!-- // products -->
	<!-- products-bottom -->
	 --%>
	<!-- //products-bottom -->
	<!-- <!-- sign-up -->
	<div class="sign-up">
		container
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
		//container
	</div> -->
	<!-- //sign-up -->
	<!-- footer -->
	<jsp:include page="./footer.jsp"></jsp:include>
	<!-- //footer -->
</body>
</html>