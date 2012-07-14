<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div id="zyb-home">
		<div class="row-fluid" id="zyb-home">
			<div class="span12">
				<div style1="position; relative;">
			        <div class="slider-wrapper theme-default home-slider">
			            <div class="nivoSlider">
			                <img src="${rc.getContextPath()}/resources/images/home/1.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/2.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/3.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/4.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/5.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/6.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/7.jpg"/>
			                <img src="${rc.getContextPath()}/resources/images/home/8.01.jpg"/>
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
						Zybotech Solutions is one of the leading company offering professional Mobile Application Training and development in Kerala. We deliver professional and competitively priced development and training solutions in mobile application development. We build experts in android development with our interactive training sessions and industry oriented curriculum and a handful of experience in working with live and multimedia projects helps developers to build confidence to handle any complex projects with a high professional quality.
						<a class="more" href="#id=/aboutus">Read More...</a>
					</section>
				</article>
				
				<div class="row-fluid">
					<div class="span6">
						<article class="article" style="height: 153px;">
							<header>Android Application Development Training</header>
							<section>
								Zybotech solutions one of the leading android application development and training company in Cochin provides, carrier oriented & Job assured courses in the latest Mobile technologies and the training is imparted by experienced faculties with real time development experience. We build technical experts rather than professionals.
								<a class="more" href="#id=/productsandservices&el=.android-app-dev-training">Read More...</a>
							</section>
						</article>
					</div>
					<div class="span6">
						<article class="article" style="height: 153px;">
							<header>Android Application Development</header>
							<section>
								We deliver end to end Application development solutions in Android OS. Our expertise talent pool works 24*7 on projects. Zybotech has built its value proposition as a client partner rather than a service provider with the ability to provide customized delivery solutions based on the client's requirements and enabling process improvements using industry benchmarks and standard quality processes.
								<a class="more" href="#id=/productsandservices&el=.android-app-dev-center">Read More...</a>
							</section>
						</article>
					</div>
				</div>
			</div> <!-- span9 -->
			<div class="span3">
				<article class="article">
					<header class="type2"><h5>Quick Links</h5></header>
					
					<div class="topic">
						<strong><a href="#id=/productsandservices/app-gallery">Apps gallary</a></strong>
					</div>
					<div class="topic">
						<strong><a href="#id=/productsandservices/whyzybotech">Why zybotech</a></strong>
					</div>
					<div class="topic">
						<strong><a href="#id=/ebroucher">E-Broucher</a></strong>
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