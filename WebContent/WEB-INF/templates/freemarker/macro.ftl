<#macro header>
<#if _isAjaxRequest = false>
	<html>
		<head>
			<meta charset="utf-8">
		
			<!-- Use the .htaccess and remove these lines to avoid edge case issues.
				More info: h5bp.com/b/378 -->
			<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		
			<title>Zybotech</title>
			<meta name="description" content="">
			<meta name="author" content="">
		
			<!-- Mobile viewport optimized: j.mp/bplateviewport -->
			<meta name="viewport" content="width=device-width,initial-scale=1">
	
			<#include "header-resources.ftl" />
		</head>
		<body>
	
			<#include "menu.ftl" />
			
			<div class="zyb-header container">
				<div class="zyb-logo pull-left">
					<img src="${rc.getContextPath()}/resources/images/logo.gif" height="70px"></img>
				</div>
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
			<div class="container">
				<div class="zyb-content">
					<div>
						<#include "header.ftl" />
					</div>
					<div id="page-container">
</#if>
</#macro>

<#macro footer>
<#if _isAjaxRequest = false>
					</div><!-- #page-container -->
					<div>
						<#include "footer.ftl" />
					</div>
				</div><!-- zyb-content -->
			</div><!-- container -->
	
			<#include "footer-resources.ftl" />
			
			<#nested>
		</body>
	</html>
<#else>
	<#nested>
</#if>
</#macro>

<#macro title title>
	<div class="page-title">
		<h3 class="bordered-light-b title">${title}</h3>
	</div>
</#macro>

<#macro ctrlfile name label class="" size="" errorplacement="inline">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="file" name="${name}" class="${size}" error-placement="${errorplacement}" all-true="true"/>
		</div>
	</div>
</#macro>
<#macro ctrltextarea name label value="" class="" size="" errorplacement="inline">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<textarea name="${name}" class="${size}" error-placement="${errorplacement}" all-true="true">${value}</textarea>
		</div>
	</div>
</#macro>
<#macro ctrltext name label class="" size="" errorplacement="inline">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="text" name="${name}" class="${class} ${size}" error-placement="${errorplacement}"/>
		</div>
	</div>
</#macro>
<#macro ctrlreadonly name label class="" size="" errorplacement="inline">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="text" name="${name}" class="uneditable-input ${class} ${size}" error-placement="${errorplacement}" readonly="readonly"/>
		</div>
	</div>
</#macro>


<#macro navigation ulclass="">
		<ul class="zyb-navigation nav">
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/home">Home</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/aboutus">About Us</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/productsandservices">Products & Services</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/students">Students</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/placements">Placements</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/contactus">Contact Us</a>
			</li>
		</ul>
</#macro>

<#macro contactsidebar>
			<div class="contact-sidebar">
				<@morelinkspanle>
					<#nested>
				</@morelinkspanle>				
				<@getintouchpanel />
			</div><!-- contact-sidebar -->
</#macro>

<#macro morelinkspanle>
				<#assign links><#nested></#assign>
				<#if links?has_content>
					<section class="section more-links">
						<header class="type2"><h4>More Links</h4></header>
						<article>
							<#nested>
						</article>
					</section>
				</#if>
</#macro>
<#macro getintouchpanel>
				<section class="section get-in-touch">
					<header class="type2"><h4>Get In Touch</h4></header>
					<article>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
					</article>
				</section>
</#macro>

<#macro productsandservicessidebar>
			<div class="contact-sidebar">
				<@morelinkspanle>
					<div><a href="#/productsandservices/whyandroid">Why Android Training at Zybotech</a></div>
					<div><a href="#/productsandservices/scope-mobile-dev">Scope of Mobile Application Development</a></div>
					<div><a href="#/productsandservices/app-gallery">Apps Gallery</a></div>
					<div><a href="#/productsandservices/testimonials">Testimonies</a></div>
				</@morelinkspanle>				
				<@getintouchpanel />
			</div><!-- contact-sidebar -->
</#macro>

<#macro aboutussidebar>
			<div class="contact-sidebar">
				<@morelinkspanle>
					<div><a href="#/aboutus/advisoryboard">Advisory Board</a></div>
					<div><a href="#/aboutus/managementteam">Management Team</a></div>
					<div><a href="#/aboutus/trainers">Trainers</a></div>
				</@morelinkspanle>				
				<@getintouchpanel />
			</div><!-- contact-sidebar -->
</#macro>
