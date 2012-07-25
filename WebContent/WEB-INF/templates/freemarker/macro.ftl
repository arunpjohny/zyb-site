<#macro header title="" metadescription="" metakeywords="">
<#if _isAjaxRequest = false>
	<html>
		<head>
			<meta charset="utf-8">
		
			<title><#if title?has_content>${title}<#else>Android training in cochin, android training in Kerala, best android training in Kochi, certified android training courses in Cochin</#if></title>

			<meta name="domain" content="www.zybotech.in">
			<meta name="author" content="Arun P Johny">
			<meta name="copyright" content="July 2012">
			<meta name="contact" content="info.zybotech@gmail.com">

			<meta name="keywords" content="<#if metakeywords?has_content>${metakeywords}<#else>Android training in cochin, android training in Kerala, best android training in kochi, certified android training courses in Cochin , Android application development training in cochin, kochi, Ernakulum,  Kerala, mobile application jobs, mobile application development training,  android jobs in cochin, college projects in android, mobile application programmer, android development training, certified courses on mobile application,  android application development, corporate job oriented android training, placement oriented android training, zybotech android training courses, job oriented android training program</#if>">
			<meta name="tags" content="<#if metakeywords?has_content>${metakeywords}<#else>Android training in cochin, android training in Kerala, best android training in kochi, certified android training courses in Cochin , Android application development training in cochin, kochi, Ernakulum,  Kerala, mobile application jobs, mobile application development training,  android jobs in cochin, college projects in android, mobile application programmer, android development training, certified courses on mobile application,  android application development, corporate job oriented android training, placement oriented android training, zybotech android training courses, job oriented android training program</#if>">
			<meta name="description" content="<#if metadescription?has_content>${metadescription}<#else>Zybotech solutions offers 100% job oriented courses on mobile application development for freshers and professionals with advanced curriculam, interactive training sessions, live projects and placement assistance. Zybotech solutions one of the leading mobile application development and training company in Cochin offers Btech/BCA/MCA/BSc/Msc students 100% job assured mobile application development course</#if>">
			<meta name="header" content="Android training in cochin, android training in Kerala, best android training in kochi, certified android training courses in Cochin">

			<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
			<!-- Mobile viewport optimized: j.mp/bplateviewport -->
			<meta name="viewport" content="width=device-width,initial-scale=1">
	
			<#include "header-resources.ftl" />
		</head>
		<body>
	
			<#include "menu.ftl" />
			
			<div class="zyb-header container">
				<div class="zyb-logo pull-left">
					<img src="${rc.getContextPath()}/resources/images/logo.gif" height="65px"></img>
				</div>
				<div class="zyb-contact pull-right text-right">
					<div>
						<div class="phone">
							<h4>Call us: 0484-6009444</h4>
						</div>
						<h5 class="email"><a href="#mailto:info.zybotech@gmail.com">info.zybotech@gmail.com</a></h5>
					</div>
					<div class="social-connect">
						<a href="http://www.facebook.com/Zybotech" target="_blank"><div class="connect-facebook"></div></a>
						<a href="https://twitter.com/#!/zybotech" target="_blank"><div class="connect-twitter"></div></a>
						<a href="https://plus.google.com/102678237917946943186" rel="publisher" target="_blank"><div class="connect-googleplus"></div></a>
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

<#macro ctrlfile name label class="" size="" errorplacement="inline" value="">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="file" name="${name}" class="${size} ${class}" error-placement="${errorplacement}" all-true="true" value="${value!""}"/>
		</div>
	</div>
</#macro>
<#macro ctrltextarea name label value="" class="" size="" errorplacement="inline">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<textarea name="${name}" class="${size} ${class}" error-placement="${errorplacement}" all-true="true">${value}</textarea>
		</div>
	</div>
</#macro>
<#macro ctrltext name label class="" size="" errorplacement="inline" value="" placeholder="" hidden=false>
	<div class="control-group <#if hidden==true>hide</#if>">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="text" name="${name}" class="${class} ${size}" error-placement="${errorplacement}" value="${value!""}" placeholder="${placeholder}"/>
		</div>
	</div>
</#macro>
<#macro ctrlreadonly name label class="" size="" errorplacement="inline" value="">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="text" name="${name}" class="uneditable-input ${class} ${size}" error-placement="${errorplacement}" readonly="readonly" value="${value!""}"/>
		</div>
	</div>
</#macro>
<#macro ctrlcheckbox name label value=false class="" errorplacement="inline">
	<div class="control-group zyb-ctrl-chkbx">
		<div class="controls">
			<input type="checkbox" name="${name}" class="pull-left ${class}" error-placement="${errorplacement}" <#if value == true>checked="checked"</#if>/>
			<label class="pull-left">
				${messageResolver.getMessage( label )}
			</label>
		</div>
	</div>
</#macro>
<#macro ctrlpassword name label class="" size="" errorplacement="inline" value="" placeholder="">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<input type="password" name="${name}" class="${class} ${size}" error-placement="${errorplacement}" value="${value!""}" placeholder="${placeholder}"/>
		</div>
	</div>
</#macro>
<#macro ctrlcombo label class="" size="" errorplacement="inline" placeholder="">
	<div class="control-group">
		<label class="control-label">${messageResolver.getMessage( label )}</label>
		<div class="controls">
			<div class="${class}" data-combosize="${size}" error-placement="${errorplacement}" placeholder="${placeholder}"></div>
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
				<a class="nav-ajax" href="${rc.getContextPath()}/productsandservices">Services</a>
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
			<li>
				<a href="http://zybotech.wordpress.com/" target="_blank">Blog</a>
			</li>
		</ul>
</#macro>

<#macro sidebar>
			<div class="contact-sidebar">
					<#nested>
			</div><!-- contact-sidebar -->
</#macro>

<#macro contactsidebar>
			<div class="contact-sidebar">
				<@morelinkspanle>
					<#nested>
				</@morelinkspanle>				
				<@getintouchpanel />
			</div><!-- contact-sidebar -->
</#macro>

<#macro morelinkspanle title="More Links">
				<#assign links><#nested></#assign>
				<#if links?has_content>
					<section class="section more-links">
						<header class="type2"><h4>${title}</h4></header>
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
						<div><i class="icon-small-mail"></i><span>Email: info.zybotech@gmail.com</span></div>
						<div><i class="icon-small-mail"></i><span>Phone: 0484-6009444</span></div>
						<div><i class="icon-small-mail"></i><span>Mobile: 9746600813</span></div>
					</article>
				</section>
</#macro>

<#macro aboutussidebar>
			<@macro.sidebar>
				<@macro.morelinkspanle title="About">
					<div><a href="#id=/aboutus/personnel/advisoryboard">Advisory Board</a></div>
					<div><a href="#id=/aboutus/personnel/managementteam">Management Team</a></div>
					<div><a href="#id=/aboutus/personnel/trainers">Trainers</a></div>
				</@macro.morelinkspanle>
				<@macro.morelinkspanle title="Quick Links">
					<div><a href="#id=/productsandservices/whyzybotech">Why Zybotech</a></div>
					<div><a href="#id=/productsandservices">Products and Services</a></div>
					<div><a href="#id=/productsandservices/app-gallery">Apps Gallary</a></div>
					<div><a href="#id=/contactus">Contact us</a></div>
				</@macro.morelinkspanle>
			</@macro.sidebar>
</#macro>

<#macro productsandservicessidebar>
			<@macro.sidebar>
				<@macro.morelinkspanle title="Quick Links">
					<div><a href="#id=/aboutus">About Us</a></div>
					<div><a href="#id=/contactus">Contact us</a></div>
				</@macro.morelinkspanle>
				<@macro.morelinkspanle title="More Links">
					<div><a href="#id=/productsandservices/whyzybotech">Why Zybotech</a></div>
					<div><a href="#id=/productsandservices/scope-mobile-dev">Scope of Mobile Application Development</a></div>
					<div><a href="#id=/productsandservices/app-gallery">Apps Gallery</a></div>
					<div><a href="#id=/productsandservices/testimonials">Testimonials</a></div>
				</@macro.morelinkspanle>
			</@macro.sidebar>
</#macro>
