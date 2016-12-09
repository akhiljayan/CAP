<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Basic Page Needs
		================================================== -->
	
	<meta charset="utf-8" />
	<meta name="description" content="Coralix Themes">
	<meta name="author" content="Coralix Themes">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	
	<!-- Custom styles ================================================== -->
	<!-- Bootstrap -->

	<link href="<c:url value="/css/home/bootstrap/bootstrap.css"/>" rel="stylesheet">
	
	<!-- Custom Stylesheet -->
	<link href="<c:url value="/css/home/styles.css"/>" rel="stylesheet" media="screen">
	
	<!-- Media Queries -->
	<link href="<c:url value="/css/home/media-queries.css"/>" rel="stylesheet" media="screen">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- Lightbox -->
	<link href="<c:url value="/css/home/lightbox/lightbox.css"/>" rel="stylesheet" media="screen">
	
	<!-- Font icons -->
	<link href="<c:url value="/css/home/fontello.css"/>" rel="stylesheet">
	
	<link rel="stylesheet" href="<c:url value="/css/home/nivo-slider/nivo-slider.css"/>" type="text/css" media="screen" />
	<!-- nivo slider -->
	<link rel="stylesheet" href="<c:url value="/css/home/nivo-slider/default.css"/>" type="text/css" media="screen" />
	
	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
	<link rel="shortcut icon" href="<c:url value="/image/home/images/favicon.png"/>">
	
	<!-- Select-->
	<link rel="stylesheet" href="<c:url value="/js/home/select/chosen.css"/>">
	
	<!--effect bxslider-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/js/home/bxslider/jquery.bxslider.css"/>" />
</head>
<body>
	
	<!--Header-->
	<header>

	    <!--Top bar-->
	    <section class="topbar">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-12 sb">
	                <h1><a title="Home" href="index.html">University Landing</a></h1>
	                </div>
	            </div>
	        </div>
	    </section>
	    <!--End Top bar-->
	    

	    <!--Menu bar-->
	    <nav class="navbar navbar-default navbar-inverse navbar-static-top" role="navigation">
	        <div class="navbar-inner"> 
	            <div class="container mn">                    
	                <div class="navbar-header">
	                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
	                      <span class="sr-only">Toggle navigation</span>
	                      <span class="icon-bar"></span>
	                      <span class="icon-bar"></span>
	                      <span class="icon-bar"></span>
	                    </button>                            
	                </div>                 
	                <div class="collapse navbar-collapse navbar-ex1-collapse">
	                    <ul class="nav navbar-nav">
	                        <li class="active"><a href="#menu-homepage">Home</a></li>
	                        <li><a href="#menu-features">Features</a></li>
	                        <li><a href="#menu-courses">Courses</a></li>
	                        <li><a href="#menu-pricing">Pricing</a></li>
	                        <li><a href="#menu-gallery"> Locations</a></li>
	                        <li><a href="#menu-map">Map</a></li>
	                        <li><a href="#menu-contact">Contact</a></li>
	                    </ul>
	                </div><!--/.nav-collapse -->
	            </div>
	        </div>
	    </nav>    
	</header>
	<!--Header-->

	<!-- slider box-->
	<section class="sliderbox" id="menu-homepage">
		<div class="container">
		    <div class="row">
		    
		        <!-- slider -->
		        <div class="col-md-8 theme-default">
		            <div id="slider" class="nivoSlider">
		                <a href="#"><img src="<c:url value="/image/home/img/nivo-slider/slider-01.jpg"/>" alt="" title="This is an example of a caption" /></a>
		                <a href="#"><img src="<c:url value="/image/home/img/nivo-slider/slider-02.jpg"/>" alt="" title="This is an example of a caption2" /></a>

		            </div>
		            <div id="htmlcaption" class="nivo-html-caption">
		                <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.
		            </div>
		        </div>
		        <!-- end slider -->
		        
		        <!-- main form -->
		        <div class="col-md-4 course-form-box">
		        	<h3>Login to CAPS</h3>
		            <p style="height:40px">Continue all your activities by loging in to CAPS system</p>
		            
		            <!--<form id="curse-form" class="nm" action="/login" method="post" accept-charset="utf-8"> ${pageContext.request.contextPath} -->
		            <form:form modelAttribute="user" method="POST" action="/caps/home/authenticate" >
		        		<div  id="loading" style="display: none" class='alert'>
		                    <a class='close' data-dismiss='alert'>�</a>
		                    Loading
		                </div>
		                <div id="response"></div>
		                
						<div class="content_form">

		                        <input class="input-large" type="text" required placeholder="Username" name="username" />


		                        <input class="input-large" type="password" required placeholder="Password" name="password" style="margin-top: 10px;"/>
								
		                        <input class="input-small" style="width:15%;margin-top: 10px;" type="checkbox" placeholder="" name="remember" />
									<h3 style="; float:right;margin-top: 18px;">Remember Login</h3>
		                        
		                        <button class="btn btn-large btn-primary" type="submit" style="margin-top:10px; margin-bottom:45px"><i class="fa fa-lock"></i>Login</button>
		                        
		                        <h4 style="text-align:center"><a href="#" >Forgot Password</a></h4></br>
		                        <h4 style="text-align:center"><a href="#" >Forgot Username</a></h4>
		            	</div>
		            	</form:form>                                      
		            <!--</form>-->
		        </div>
		        <!-- end main form -->
		        
		    </div>
		</div>
	</section>
	<!-- end slider box-->

	<!-- features -->
	<section class="features generic-section" >
		<div class="container" id="menu-features">

			<!--title of the section-->
			<div class="row title">
		    	<h1>Check Out This Awesome Features</h1>
		        <h3>Designed to get the highest rate of interaction</h3>
		    </div>
		    <!--end title of the section-->
		    
			<div class="row">
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/01.png"/>" alt="image study at your  time">
		            <h4>study at your  time</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/02.png"/>" alt="image from anywhere you want">
		            <h4>from anywhere you want </h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/03.png"/>" alt="image video tutorials">
		            <h4>video tutorials</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/04.png"/>" alt="image community support">
		            <h4>community support</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    </div>

			<div class="row">
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/05.png"/>" alt="image classes organization">
		            <h4>classes organization</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/06.png"/>" alt="image user focus courses">
		            <h4>user focus courses</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/07.png"/>" alt="image get the news by email">
		            <h4>get the news by email</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    	<div class="col-md-3 col-xs-6 fea">
		        	<img src="<c:url value="/image/home/img/features/08.png"/>" alt="image online certificate tests">
		            <h4>online certificate tests</h4>
		            <p>Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, molestie eget eros. Donec felis nisl.</p>
		        </div>
		    </div>
		</div>
	</section>
	<!-- end features -->    
    
    
	<!-- gallery -->
	<section class="gallery generic-section">
		<div class="container" id="menu-gallery">
	    
	    	<!--title of the section-->
	    	<div class="row title">
	        	<h1>Meet all our locations</h1>
	            <h3>You can learn online, or at our ground locations where you can learn on campus, online, or a blend of both. </h3>
	        </div>
	        <!--end title of the section-->
	        
	        <div class="row">
	            <ul class="grid cs-style-4">
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/01.jpg"/>" alt="Realm"></div>
	                        <figcaption>
	                            <h3>Safari</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/01.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/02.jpg"/>" alt="Realm"></div>
	                        <figcaption>
	                            <h3>Game Center</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/02.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/03.jpg"/>" alt="Realm"></div>
	                        <figcaption>
	                            <h3>Music</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/03.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/04.jpg"/>" alt="img04"></div>
	                        <figcaption>
	                            <h3>Settings</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/04.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	            </ul>
	        </div>

	        <div class="row">
	            <ul class="grid cs-style-4">
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/05.jpg"/>" alt="img02"></div>
	                        <figcaption>
	                            <h3>Safari</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/05.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/06.jpg"/>" alt="img02"></div>
	                        <figcaption>
	                            <h3>Game Center</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/06.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/07.jpg"/>" alt="img02"></div>
	                        <figcaption>
	                            <h3>Music</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/07.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	                <li class="col-md-3 col-xs-6">
	                    <figure>
	                        <div><img src="<c:url value="/image/home/img/gallery/08.jpg"/>" alt="img02"></div>
	                        <figcaption>
	                            <h3>Settings</h3>
	                            <span>Jacob Cummings</span>
	                            <a class="btn example-image-link" href="<c:url value="/image/home/img/gallery/08.jpg"/>" data-lightbox="example-set" data-title="See image">Take a look</a>
	                        </figcaption>
	                    </figure>
	                </li>
	            </ul>
	        </div>

	    </div>
	</section>
	<!-- end gallery -->    
    
    
    <!-- testimonials -->
    <section class="testimonials generic-section">
    	<div class="container" id="menu-testimonials">
        
        	<!--title of the section-->
        	<div class="row title">
            	<h1>Loved By Over 25 000 Customer</h1>
                <h3>What they say about us</h3>
            </div>
            <!--end title of the section-->
            
            <div class="row">
            	<div class="col-md-12">
                    
                    <!-- Cataloge Carousel Starts -->
                    <div id="myCarousel2" class="carousel slide">
                        <div class="carousel-inner">
                            <!-- Item One Starts --> 
                            <div class="item active">
                                    <div class="featurette">
                                            <img class="featurette-image img-circle" src="<c:url value="/image/home/img/testimonials/testimonials-01.jpg"/>" alt="image">
                                        <div class="text">
                                            <p class="lead">�One of the great needs in ministerial training these days is for living a balance of academic excellence, practical training and godly spiritual development, not only among the students but also in those who teach them. Denver Seminary seems to be achieving and maintaining this balance. I'm impressed with the faculty and the graduates I have met�</p>
                                            <h2 class="featurette-user">amanda Ferdinand <br> - 21 July 2015 - </h2>
                                        </div>
                                    </div>
                            </div>
                            <!-- Item One Ends -->
                            <!-- Item Two Starts --> 
                            <div class="item">
                                    <div class="featurette">
                                            <img class="featurette-image img-circle" src="<c:url value="/image/home/img/testimonials/testimonials-02.jpg"/>" alt="image">
                                        <div class="text">
                                            <p class="lead">�One of the great needs in ministerial training these days is for living a balance of academic excellence, practical training and godly spiritual development, not only among the students but also in those who teach them. Denver Seminary seems to be achieving and maintaining this balance. I'm impressed with the faculty and the graduates I have met�</p>
                                            <h2 class="featurette-user">amanda Ferdinand <br>- 21 July 2015 - </h2>
                                        </div>
                                    </div>
                            </div>
                            <!-- Item Two Ends -->
                            <!-- Item Three Starts --> 
                            <div class="item">
                                    <div class="featurette">
                                            <img class="featurette-image img-circle" src="<c:url value="/image/home/img/testimonials/testimonials-03.jpg"/>" alt="image">
                                        <div class="text">
                                            <p class="lead">�One of the great needs in ministerial training these days is for living a balance of academic excellence, practical training and godly spiritual development, not only among the students but also in those who teach them. Denver Seminary seems to be achieving and maintaining this balance. I'm impressed with the faculty and the graduates I have met�</p>
                                            <h2 class="featurette-user">amanda Ferdinand <br>- 21 July 2015 - </h2>
                                        </div>
                                    </div>
                            </div>
                            <!-- Item Three Ends -->
                        </div>
                        <a class="left carousel-control" href="#myCarousel2" data-slide="prev"><img src="<c:url value="/image/home/img/left.png"/>" alt="//"></a>
                        <a class="right carousel-control" href="#myCarousel2" data-slide="next"><img src="<c:url value="/image/home/img/right.png"/>" alt="//"></a>
                    </div>
                    <!-- Cataloge Carousel Ends -->
                
                </div>
            </div>
        </div>
    </section>
    <!-- end testimonials -->  
    
    
	<!-- pricing tables -->
	<section class="pricing generic-section">
		<div class="container" id="menu-pricing">

			<!--title of the section-->
			<div class="row title">
		    	<h1>Loved By Over 25 000 Customer</h1>
		        <h3>What they say about us</h3>
		    </div>
		    <!--end title of the section-->
		    
		    <!-- tables -->
		    <div class="pricing_table">
		        <div class="row">
		            <div class="col-md-3 col-xs-6 item">
		            	<div class="header">
		                    <h3>Basic</h3>
		                    <h5>Great to take the first step</h5>
		                </div>
		                <h4 class="price"><span>$</span>19</h4>
		                <ul class="unstyled">
		                	<li>Basic Grammar </li>
		                    <li>Strategic Management </li>
		                    <li>Critical Reading </li>
		                    <li>Journalism </li>
		                    <li>Biotechnology</li>
		                    <li class="last"><a href="" class="btn btn-large"><i class="icon-right-circle"></i> Register Now</a></li>
		                </ul>
		            </div>
		            
		        	<div class="col-md-3 col-xs-6 item">
		            	<div class="header">
		                    <h3>Premium</h3>
		                    <h5>Great to take the first step</h5>
		                </div>
		                <h4 class="price"><span>$</span>29</h4>
		                <ul class="unstyled">
		                    <li>Mathematics for teaching </li>
		                    <li>Strategic Management </li>
		                    <li>Journalism </li>
		                    <li>Financial Markets</li>
		                    <li>Biotechnology</li>
		                    <li class="last"><a href="" class="btn btn-large"><i class="icon-right-circle"></i> Register Now</a></li>
		                </ul>
		            </div>

		        	<div class="col-md-3 col-xs-6 item">
		            	<div class="header">
		                    <h3>Proffesional</h3>
		                    <h5>Great to take the first step</h5>
		                </div>
		                <h4 class="price"><span>$</span>39</h4>
		                <ul class="unstyled">
		                    <li>Journalism </li>
		                    <li>Strategic Management</li>
		                    <li>Biotechnology </li>
		                    <li>Mathematics for teaching </li>
		                    <li>Basic Grammar </li>
		                    <li class="last"><a href="" class="btn btn-large"><i class="icon-right-circle"></i> Register Now</a></li>
		                </ul>
		            </div>

		        	<div class="col-md-3 col-xs-6 item">
		            	<div class="header">
		                    <h3>Elite</h3>
		                    <h5>Great to take the first step</h5>
		                </div>
		                <h4 class="price"><span>$</span>59</h4>
		                <ul class="unstyled">
		                    <li>Journalism </li>
		                    <li>Critical Reading </li>
		                    <li>Biotechnology </li>
		                    <li>Strategic Management </li>
		                    <li>Biotechnology</li>
		                    <li class="last"><a href="" class="btn btn-large"><i class="icon-right-circle"></i> Register Now</a></li>
		                </ul>
		            </div>
		        </div>
		    </div>
		    <!-- end tables -->
		    
		</div>
	</section>
	<!-- end pricing tables -->  

	<!-- map -->
	<section class="mapi generic-section">
		<div class="container" id="menu-map">
			<!--title of the section-->
			<div class="row title">
				<h1>Loved By Over 25 000 Customer</h1>
				<h3>What they say about us</h3>
			</div>
			<!--end title of the section-->

			<div class="row">
				<div class="col-md-12">
				<img src="<c:url value="/image/home/img/map-infographic.png"/>" alt="image"> 
				</div>
			</div>
		</div>
	</section>
	<!-- end map -->     

	<!-- teachers -->
	
	<!-- end teachers -->

	<!-- information -->
	<section class="information generic-section">
		<div class="container">
		<div class="row">
			<div class="col-md-7">
		    	<img src="<c:url value="/image/home/img/info-image.png"/>" alt="image">
		    </div>
		    <div class="col-md-5">
		    	<h1>Designed To Convert Better</h1>
		        <div class="accordion" id="accordion2">
		            <div class="accordion-group">
		                <div class="accordion-heading">
		                    <a class="accordion-toggle open" data-toggle="collapse" data-parent="#accordion2" href="#collapse1">
		                        Biotechnology <i class="icon-minus"></i>
		                    </a>
		                </div>
		                <div id="collapse1" class="accordion-body collapse in">
		                    <div class="accordion-inner">
		                        <p>
		                            Lorem ipsum dolor sit ametiral bro constur adipisicing elit, sedAmalesuada at aliquet a, Cras tincidunt ultricies nunc et egestas. Nam in felis eu turpis lobo rtis placerat in id neque. In vel massa nec risus commodo porttitor sed eget urna. Maecenas in nisl ante.
		                            Sed quis leo diam.
		                         </p>
		                    </div>
		                </div>
		            </div>
		            <div class="accordion-group">
		                <div class="accordion-heading">
		                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse2">
		                        Information technology <i class="icon-plus"></i>
		                    </a>
		                </div>
		                <div id="collapse2" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <p>
		                            Duis aute irure dolor in reprehenderit in voluptate velit esse cilum dolore eu fugiat. Lorem ipsum dolor sit amet, consectetur. adipisicing elit, sed do eiusmod
		                        </p>
		                    </div>
		                </div>
		            </div>
		            <div class="accordion-group">
		                <div class="accordion-heading">
		                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse3">
		                        Mathematics for teaching <i class="icon-plus"></i>
		                    </a>
		                </div>
		                <div id="collapse3" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <p>
		                            Duis aute irure dolor in reprehenderit in voluptate velit esse cilum dolore eu fugiat. Lorem ipsum dolor sit amet, consectetur. adipisicing elit, sed do eiusmod
		                        </p>
		                    </div>
		                </div>
		            </div>
		            <div class="accordion-group">
		                <div class="accordion-heading">
		                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse4">
		                        Journalism <i class="icon-plus"></i>
		                    </a>
		                </div>
		                <div id="collapse4" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <p>
		                            Duis aute irure dolor in reprehenderit in voluptate velit esse cilum dolore eu fugiat. Lorem ipsum dolor sit amet, consectetur. adipisicing elit, sed do eiusmod
		                        </p>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		</div>
	</section>
	<!-- end information -->  
    
	<!-- courses -->
	<section class="courses generic-section">
		<div class="container" id="menu-courses">

		<!--title of the section-->
		<div class="row title">
		    <h1>See all the Programs</h1>
		    <h3>Some screenshots to catch the eye of your customers</h3>
		</div>
		<!--end title of the section-->

		<div class="row">
		    <ul class="grid cs-style-5">
		        <li class="col-md-4">
		            <figure>
		                <img src="<c:url value="/image/home/img/courses/01.jpg"/>" alt="image">
		                <figcaption>
		                    <div class="info_context">
		                        <div class="col-md-6 title_context">
		                            <h3>Public Administration</h3>
		                            <span>Master Degree</span>
		                        </div>
		                        <a class="btn" href="#">Read more</a>
		                    </div>
		                </figcaption>
		            </figure>
		        </li>
		        <li class="col-md-4">
		            <figure>
		                <img src="<c:url value="/image/home/img/courses/02.jpg"/>" alt="image">
		                <figcaption>
		                    <div class="info_context">
		                        <div class="col-md-6 title_context">
		                            <h3>Public Administration</h3>
		                            <span>Master Degree</span>
		                        </div>
		                        <a class="btn" href="#">Read more</a>
		                    </div>
		                </figcaption>
		            </figure>
		        </li>
		        <li class="col-md-4">
		            <figure>
		                <img src="<c:url value="/image/home/img/courses/03.jpg"/>" alt="image">
		                <figcaption>
		                    <div class="info_context">
		                        <div class="col-md-6 title_context">
		                            <h3>Public Administration</h3>
		                            <span>Master Degree</span>
		                        </div>
		                        <a class="btn" href="#">Read more</a>
		                    </div>
		                </figcaption>
		            </figure>
		        </li>
		    </ul>
		</div>

		<div class="row">
		    <ul class="grid cs-style-5">
		        <li class="col-md-4">
		            <figure>
		                <img src="<c:url value="/image/home/img/courses/04.jpg"/>" alt="img01">
		                <figcaption>
		                    <div class="info_context">
		                        <div class="col-md-6 title_context">
		                            <h3>Public Administration</h3>
		                            <span>Master Degree</span>
		                        </div>
		                        <a class="btn" href="#">Read more</a>
		                    </div>
		                </figcaption>
		            </figure>
		        </li>
		        <li class="col-md-4">
		            <figure>
		                <img src="<c:url value="/image/home/img/courses/05.jpg"/>" alt="img01">
		                <figcaption>
		                    <div class="info_context">
		                        <div class="col-md-6 title_context">
		                            <h3>Public Administration</h3>
		                            <span>Master Degree</span>
		                        </div>
		                        <a class="btn" href="#">Read more</a>
		                    </div>
		                </figcaption>
		            </figure>
		        </li>
		        <li class="col-md-4">
		            <figure>
		                <img src="<c:url value="/image/home/img/courses/06.jpg"/>" alt="img01">
		                <figcaption>
		                    <div class="info_context">
		                        <div class="col-md-6 title_context">
		                            <h3>Public Administration</h3>
		                            <span>Jacob Cummings</span>
		                        </div>
		                        <a class="btn" href="#">Read more</a>
		                    </div>
		                </figcaption>
		            </figure>
		        </li>
		    </ul>
		</div>
		</div>
	</section>
	<!-- end courses --> 
      
	<!-- contact -->
	<section class="contact generic-section">
		<div class="content_map">
		    <div id="map"></div>
		</div>

		<div class="container" id="menu-contact">
		    <div class="row">
		        <div class="col-md-4 course-form-box">
		            <h3>Subscribe to Get information</h3>
		            <p>The Best way to help you reach your goalsDonec id elit non mi porta gravida at eget metus. </p><br>
		            <p>
		                Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuad.
		            </p>
		            <form id="contact-form" class="nm" action="index_submit" method="post">

		                <div class="content_form">

		                    <input class="input-large" type="text" required placeholder="Name" name="firstname" />


		                    <input class="input-large" type="email" required placeholder="*Email" name="firstname" />


		                    <textarea class="text-large"  required placeholder="Telephone" name="tex_msg"></textarea>


		                    <button class="btn btn-large btn-primary" type="submit"><i class="icon-edit"></i>send e-mail</button>

		                </div>
		            </form>
		        </div>
		    </div>

		</div>
	</section>
	<!-- end contact -->        
    
	<!-- footer -->
	<footer>
	    <div class="container">
	    	<div class="row">
	        
	        	<div class="col-md-3">
	            	<h4 class="footer-title"><i class="icon-calendar"></i>  calendar</h4>
	                <ul class="unstyled">
	                	<li><a href="#">&raquo; Computer Science <span>15/05/2013</span></a></li>
	                    <li><a href="#">&raquo; Mathematics <span>15/05/2013</span></a></li>
	                    <li><a href="#">&raquo; Agriculture and Forestry  <span>15/05/2013</span></a></li>
	                    <li><a href="#">&raquo; Biotechnology     <span>15/05/2013</span></a></li>
	                    <li><a href="#">&raquo; Physician Assistant <span>15/05/2013</span></a></li>
	                </ul>
	            </div>
	            
	        	<div class="col-md-3">
	            	<h4 class="footer-title"><i class="icon-mail"></i> CONTACT US</h4>
	                <p>Id pretium sapien pellentesque est pretium neque lobortis laoreet id sed.</p>
	                <ul class="unstyled contact-info">
	                	<li><i class="icon-home-outline"></i> Address: Steet example 5545</li>
	                    <li><i class="icon-desktop-1"></i> <a href="">www.company.com</a> </li>
	                    <li><i class="icon-phone-1"></i> phone: 5454-6226-26</li>
	                    <li><i class="icon-mobile"></i> Mobile: 5454-6226-26</li>
	                </ul>
	            </div>
	            
	        	<div class="col-md-3">
	            	<h4 class="footer-title"><i class="icon-comment-1"></i>  important questions</h4>
	                <ul class="unstyled">
	                	<li><a href="#">&raquo; When to choose a major? </a></li>
	                    <li><a href="#">&raquo; How to choose a major? </a></li>
	                    <li><a href="#">&raquo; What are your interests? </a></li>
	                    <li><a href="#">&raquo; What are your academic strengths? </a></li>
	                    <li><a href="#">&raquo; What are your career goals? </a></li>
	                </ul>
	            </div>
	            
	        	<div class="col-md-3">
	            	<h4 class="footer-title"><i class="icon-article-alt"></i> NEWSLETTER</h4>
	                <p>Make sure you dont miss interesting happenings by joining our newsletter program.</p>
	                <div class="suscribe course-form-box">
	                    <form id="search-form" class="nm" action="index_submit" method="post">
	                        <div class="row content_form">


	                            <input class="input-large" type="email" required placeholder="*Email" name="firstname" />


	                            <button class="btn btn-large btn-primary" type="submit"><i class="icon-edit"></i>suscribe</button>

	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="copyright">
	    	<ul class="unstyled">
	        	<li class="tooltip_hover" title="facebook" data-placement="top"  data-toggle="tooltip"><a  href="#" ><i class="fa fa-facebook-square"></i></a></li>
	            <li class="tooltip_hover"  title="twitter" data-placement="top"  data-toggle="tooltip"><a href="#"><i class="fa fa-twitter"></i></a></li>
	            <li class="tooltip_hover" title="skype" data-placement="top"  data-toggle="tooltip"><a href="#"><i class="fa fa-skype"></i></a></li>
	        </ul>
	        <h6>� 2013. University Landing Page. All rights reserved. Coralix Themes</h6>
	    </div>
	</footer>
	<!-- end footer -->    

    
	<a href="#" class="scrollup"><i style="color:gray; font-size:45px" class="fa fa-chevron-circle-up fa-2x"></i></a>      

<!-- ======================= JQuery libs =========================== -->
    
    <!-- jQuery -->
    <script src="<c:url value="/js/home/jquery-1.7.1.js"/>"></script>

    <!-- Bootstrap-->
    <script src="<c:url value="/js/home/bootstrap/bootstrap.js"/>"></script>

    <!-- Nivo slider -->
    <script type="text/javascript" src="<c:url value="/js/home/nivo-slider/jquery.nivo.slider.js"/>"></script>

    <!--Scroll To-->         
    <script src="<c:url value="/js/home/nav/jquery.scrollTo.js"/>"></script> 
    <script src="<c:url value="/js/home/nav/jquery.nav.js"/>"></script> 
    
	<!--Lightbox-->
	<script src="<c:url value="/js/home/lightbox.js"/>"></script> 
	

    <!--scroll-->
    <script src="<c:url value="/js/home/select/chosen.jquery.js"/>" type="text/javascript"></script>

    <!--bxslider-->
    <script src="<c:url value="/js/home/bxslider/jquery.bxslider.js"/>" type="text/javascript"></script>

    <!-- Video Responsive-->
    <script src="<c:url value="/js/home/jquery.fitvids.min.js"/>" type="text/javascript"></script>

    <!--effect hover-->
    <script src="<c:url value="/js/home/effect_hover/modernizr.custom.js"/>"></script>
    <script src="<c:url value="/js/home/effect_hover/toucheffects.js"/>"></script>

    <!-- maps google-->
    
    <script src="//maps.googleapis.com/maps/api/js?key=AIzaSyAYQSyRfktgEnrf" async="" defer="defer" type="text/javascript"></script>
    
    <script type="text/javascript" src="<c:url value="/js/home/gmaps/gmaps.js"/>"></script>
    <!-- end maps google-->

    <!--Custom Template Javascript-->
    <script type="text/javascript" src="<c:url value="/js/home/script.js"/>"></script>
</body>
</html>