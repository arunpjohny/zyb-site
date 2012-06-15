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
				<a class="nav-ajax" href="${rc.getContextPath()}/">Home</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/aboutus">About Us</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/productsandservices">Products & Services</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/careers">Careers</a>
			</li>
			<li>
				<a class="nav-ajax" href="${rc.getContextPath()}/contactus">Contact Us</a>
			</li>
		</ul>
</#macro>

<#macro contactsidebar>
			<div class="contact-sidebar">
				<section class="section more-links">
					<header class="type2"><h4>More Links</h4></header>
					<article>
						<div><a href="#link">Some Link 1</a></div>
						<div><a href="#link">Some Link 2</a></div>
						<div><a href="#link">Some Link 3</a></div>
					</article>
				</section>
				<section class="section get-in-touch">
					<header class="type2"><h4>Get In Touch</h4></header>
					<article>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
						<div><i class="icon-small-mail"></i><span>Some Link 1</span></div>
					</article>
				</section>
			</div><!-- contact-sidebar -->
</#macro>
