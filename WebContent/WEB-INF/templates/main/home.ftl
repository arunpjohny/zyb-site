<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div id="zyb-home">
		<div class="row-fluid" id="zyb-home">
			<div class="span12">
		        <div class="slider-wrapper theme-default">
		            <div class="nivoSlider">
		                <img src="resources/images/toystory.jpg" data-thumb="resources/images/toystory.jpg" alt="" />
		                <a href="http://dev7studios.com"><img src="resources/images/up.jpg" data-thumb="resources/images/up.jpg" alt="" title="This is an example of a caption" /></a>
		                <img src="resources/images/walle.jpg" data-thumb="resources/images/walle.jpg" alt="" data-transition="slideInLeft" />
		                <img src="resources/images/nemo.jpg" data-thumb="resources/images/nemo.jpg" alt="" title="#htmlcaption" />
		            </div>
		            <div id="htmlcaption" class="nivo-html-caption">
		                <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>. 
		            </div>
		        </div>
			</div> <!-- span12 -->
		</div><!-- row -->
		
		<div class="row-fluid">
			<div class="span9">
				<section class="welcome">
					<header><h3>Welcome to zybotech Solutions</h3></header>
					<article>
						Around advice is the most general kind of advice. Since Spring AOP, like AspectJ, provides a full range of advice types, we recommend that you use the least powerful advice type that can implement the required behavior. For example, if you need only to update a cache with the return value of a method, you are better off implementing an after returning advice than an around advice, although an around advice can accomplish the same thing. Using the most specific advice type provides a simpler programming model with less potential for errors. For example, you do not need to invoke the proceed() method on the JoinPoint used for around advice, and hence cannot fail to invoke it.
					</article>
					<p class="more">Read More</p>
				</section>
				
				<div class="row-fluid">
					<div class="span6">
						<section class="section">
							<header>ANDROID APPLICATION DEVELOPMENT</header>
							<article>
								In Spring 2.0, all advice parameters are statically typed, so that you work with advice parameters of the appropriate type (the type of the return value from a method execution for example) rather than Object arrays.
							</article>
						</section>
					</div>
					<div class="span6">
						<section class="section">
							<header>ANDROID APPLICATION DEVELOPMENT</header>
							<article></article>
						</section>
					</div>
				</div>
			</div> <!-- span9 -->
			<div class="span3">
				<section class="section">
					Some contents goes here
					
					<div class="topic">
						<strong>Some topic goes here</strong>
					</div>
				</section>
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