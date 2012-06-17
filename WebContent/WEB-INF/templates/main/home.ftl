<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div id="zyb-home">
		<div class="row-fluid" id="zyb-home">
			<div class="span12">
				<div style1="position; relative;">
			        <div class="slider-wrapper theme-default home-slider">
			            <div class="nivoSlider">
			                <img src="${rc.getContextPath()}/resources/images/home/android-work-shops.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/imagine-tomorrow.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/learn-while-u-do.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/looking-for-a-smart.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/mob-apps-development.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/talents.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/training.jpg"/>
			            </div>
			        </div>
				</div>
			</div> <!-- span12 -->
		</div><!-- row -->
		
		<div class="row-fluid">
			<div class="span9">
				<article class="welcome">
					<header><h3>Welcome to zybotech Solutions</h3></header>
					<section>
						Zybotech Solutions is one of the leading companies offering professional Mobile Application Training and development in Kerala. We deliver professional and competitively priced development and training solutions in mobile application development. We build experts in android development with our interactive training sessions and industry oriented curriculum and a handful of experience in working with live and multimedia projects helps developers to build confidence to handle any complex projects with a high professional quality.
						<a class="more" href="#id=/aboutus">Read More...</a>
					</section>
				</article>
				
				<div class="row-fluid">
					<div class="span6">
						<article class="article">
							<header>Android Application Development Training</header>
							<section>
								In Spring 2.0, all advice parameters are statically typed, so that you work with advice parameters of the appropriate type (the type of the return value from a method execution for example) rather than Object arrays.
								<a class="more" href="#id=/productsandservices&el=.android-app-dev-training">Read More...</a>
							</section>
						</article>
					</div>
					<div class="span6">
						<article class="article">
							<header>Android Application Development</header>
							<section>
								In Spring 2.0, all advice parameters are statically typed, so that you work with advice parameters of the appropriate type (the type of the return value from a method execution for example) rather than Object arrays.
								<a class="more" href="#id=/productsandservices&el=.android-app-dev-center">Read More...</a>
							</section>
						</article>
					</div>
				</div>
			</div> <!-- span9 -->
			<div class="span3">
				<article class="article">
					<header class="type2"><h5>Quick Links<h5></header>
					
					<div class="topic">
						<strong><a href="#id=/productsandservices/app-gallery">Apps gallary</a></strong>
					</div>
					<div class="topic">
						<strong><a href="#id=/productsandservices/whyandroid">Why zybotech</a></strong>
					</div>
					<div class="topic">
						<strong><a href="#id=/productsandservices/scope-mobile-dev">Scope of mobile apps development</a></strong>
					</div>
				</article>
			</div> <!-- span3 -->
		</div> <!-- row -->
		
	</div> <!-- zyb-home -->
<@macro.footer>
	<script language="" src="${rc.getContextPath()}/resources/js/main/home.js"></script>
	<script>
		$(function(){
			new zyb.main.home.Main("#zyb-home");
		});
	</script>
</@macro.footer>