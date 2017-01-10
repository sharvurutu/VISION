<%@page import="com.niit.shoppingcart.model.Product"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>View Product</title>
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
<script src='<c:url value="resources/js/scripts.js"/>' type="text/javascript"></script>
<link href="<c:url value='resources/css/popuo-box.css'/>" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src='<c:url value="resources/js/easyResponsiveTabs.js"/>' type="text/javascript"></script>
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
<script type="text/javascript" src="<c:url value='resources/js/move-top.js'/>"></script>
<script type="text/javascript" src="<c:url value='resources/js/easing.js'/>"></script>
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
<link rel="stylesheet" href="<c:url value='resources/css/etalage.css' />">
<script src="<c:url value='resources/js/jquery.etalage.min.js' />"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 800,
					source_image_height: 1000,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="./header.jsp"></jsp:include>
	<!-- //header -->
	<!-- single -->
	<%
	   Product product = new Product();
	   product = (Product)request.getAttribute("product");
	%>
	<div class="single">
		<!-- container -->
		<div class="container">
			<div class="single-grids">
				<div class="col-md-9">
					<div class="single-left-left">
						<ul id="etalage" class="etalage" style="display: block; width: 300px; height: 533px;">
							<li class="etalage_thumb thumb_1" style="display: none; opacity: 0; background-image: none;">
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src="<c:url value='<%=product.getImageserverpath() %>'/>" style="display: inline; width: 300px; height: 400px; opacity: 1;" />
									<img class="etalage_source_image" src="<c:url value='<%=product.getImageserverpath() %>'/>" title="" />
								</a>
							</li>
							<li class="etalage_thumb thumb_2" style="display: none; opacity: 0; background-image: none;">
								<img class="etalage_thumb_image" src="<c:url value='<%=product.getImageserverpath() %>'/>" style="display: inline; width: 300px; height: 400px; opacity: 1;">
								<img class="etalage_source_image" src="<c:url value='<%=product.getImageserverpath() %>'/>" title="">
							</li>
							<li class="etalage_thumb thumb_3" style="display: none; opacity: 0; background-image: none;">
								<img class="etalage_thumb_image" src="<c:url value='<%=product.getImageserverpath() %>'/>" style="display: inline; width: 300px; height: 400px; opacity: 1;">
								<img class="etalage_source_image" src="<c:url value='<%=product.getImageserverpath() %>'/>">
							</li>
						    <li class="etalage_thumb thumb_4 etalage_thumb_active" style="display: list-item; opacity: 1; background-image: none;">
								<img class="etalage_thumb_image" src="<c:url value='<%=product.getImageserverpath() %>'/>" style="display: inline; width: 300px; height: 400px; opacity: 1;">
								<img class="etalage_source_image" src="<c:url value='<%=product.getImageserverpath() %>'/>">
							</li>
						   </ul>
						 <div class="clearfix"></div>		
					</div>
					<div class="single-left-right">
						<div class="single-left-info">
							<h4><font color="red"><%=product.getProductName() %></font></h4>
							<a href="#" class="view">View product details</a>
							<p>&#x20b9; <%=product.getProductCost() %> <a href="#" class="view">CLICK FOR OFFER</a></p>
						</div>
						<div class="select-size">
							<p>Select a size</p>
								<ul>
									 <li><a href="#">S</a></li>
									 <li><a href="#">M</a></li>
									 <li><a href="#">L</a></li>
									 <li><a href="#">XL</a></li>
								</ul>
							<div class="buy-now">
								<a href="./buy_product?product_id=<%=product.getProductId()%>&category_id=<%=product.getCategoryID() %>">BYE NOW</a>
							</div>
							<div class="wishlist">
								<a class="play-icon popup-with-zoom-anim" href="#small-dialog2">Add to Wishlist</a>
								<!-- pop-up-box -->
								<script type="text/javascript" src="<c:url value='resources/modernizr.custom.min.js' />" ></script>    
								<script src="<c:url value='resources/js/jquery.magnific-popup.js' />" type="text/javascript"></script>
								<!--//pop-up-box -->
								<div id="small-dialog2" class="mfp-hide">
									<h3>Create Account</h3> 
									<div class="social-sits">
										<ul>
											<li><a class="fb" href="#">Connect with Facebook</a></li>
											<li><a class="fb google" href="#">Connect with Google</a></li>
										</ul>
									</div>
									<div class="signup">
										<form>
											<input type="text" class="email" placeholder="Email" required="required" pattern="([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?" />
											<input type="password" placeholder="Password" required="required" pattern=".{6,}" title="Minimum 6 characters required" autocomplete="off" />
											<input type="text" class="email" placeholder="Mobile Number" maxlength="10" pattern="[1-9]{1}\d{9}" title="Enter a valid mobile number" />
											<input type="submit"  value="Sign In"/>
										</form>
									</div>
									<div class="clearfix"> </div>
								</div>	
								<script>
										$(document).ready(function() {
										$('.popup-with-zoom-anim').magnificPopup({
											type: 'inline',
											fixedContentPos: false,
											fixedBgPos: true,
											overflowY: 'auto',
											closeBtnInside: true,
											preloader: false,
											midClick: true,
											removalDelay: 300,
											mainClass: 'my-mfp-zoom-in'
										});
																										
										});
								</script>	
							</div>
							<div class="clearfix"> </div>
							<div class="free">
								<p>20 day returns Free Delivery *</p>
							</div>
							<div class="delivery">
								<a class="play-icon popup-with-zoom-anim" href="#small-dialog">Check delivery options</a>
								<div id="small-dialog" class="mfp-hide">
									<h3>DELIVERY TIME & COD AVAILABILITY</h3>
									<div class="social-sits">
										<p>Please enter your PIN Code to check delivery time & Cash On Delivery availability</p>
									</div>
									<div class="signup">
											<form>
												<input type="text" class="email" placeholder="Pin" maxlength="6" required="required" pattern="[1-9]{1}\d{5}"/>
												<input type="submit"  value="Submit"/>
											</form>
									</div>
									<div class="clearfix"> </div>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"> </div>
					<div class="product-details">
						<h3>PRODUCT DETAILS</h3>
						<p>
						   <%=product.getProductDescription() %>   
						</p>
					</div>
					<div class="related">
						<h3>RELATED PRODUCTS</h3>
						<div class="related-grids">
							<div class="related-grid">
								<div class="col-md-9 related-left">
									<div class="col-md-3 related-left-left">
										<img src="<c:url value='resources/images/c1.jpg' />" alt="" />
									</div>
									<div class="col-md-9 related-left-right">
										<h5>Vestibulum</h5>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a est at leo dictum 
											pharetra vel sit amet tellus.
										</p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="col-md-3 related-right">
									<p>$ 19</p>
									<a href="#">Add to cart</a>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="related-grid">
								<div class="col-md-9 related-left">
									<div class="col-md-3 related-left-left">
										<img src="<c:url value='resources/images/c2.jpg' />" alt="" />
									</div>
									<div class="col-md-9 related-left-right">
										<h5>Vestibulum</h5>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a est at leo dictum 
											pharetra vel sit amet tellus.
										</p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="col-md-3 related-right">
									<p>$ 19</p>
									<a href="#">Add to cart</a>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="related-grid">
								<div class="col-md-9 related-left">
									<div class="col-md-3 related-left-left">
										<img src="<c:url value='resources/images/c3.jpg'/>" alt="" />
									</div>
									<div class="col-md-9 related-left-right">
										<h5>Vestibulum</h5>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras a est at leo dictum 
											pharetra vel sit amet tellus.
										</p>
									</div>
									<div class="clearfix"> </div>
								</div>
								<div class="col-md-3 related-right">
									<p>$ 19</p>
									<a href="#">Add to cart</a>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 side-bar">
					<div class="categories">
						<h3>CATEGORIES</h3>
						<ul>
							<c:forEach items="${categoryList }" var="category">
						          <li><a href="#">${category.name }</a></li>
						    </c:forEach>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<!-- //container -->
	</div>
	<!-- //single -->
	<!-- footer -->
<jsp:include page="./footer.jsp"></jsp:include>
	<!-- //footer -->
</body>
</html>