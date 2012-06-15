<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<div id="nav-bar" class="navbar navbar-fixed-top no-print" data-spy="scroll" data-target=".navbar-inner">

	<div class="zyb-header container">
		<div class="zyb-logo"></div>
		<div class="zyb-contact pull-right text-right">
			<div>
				<div class="phone">
					<h4>Call Us</h4> <h5>080-2524900</h5>
				</div>
				<h5 class="email">info@zybotechsolutions.in</h5>
			</div>
			<div class="social-connect">
				<div class="connect-facebook"></div>
				<div class="connect-twitter"></div>
			</div>
		</div>
	</div>
	
	<div class="navbar-inner container">
		<@macro.navigation ulclass="nav" />
	</div><!-- navbar-inner -->
</div><!-- navbar -->
