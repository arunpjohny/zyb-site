<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<div id="nav-bar" class="navbar navbar-fixed-top no-print" data-spy="scroll" data-target=".navbar-inner">
	<div class="navbar-inner container">
		<@macro.navigation ulclass="nav" />

		<#if _user?exists>
			<ul class="pull-right nav">
				<li><a href="#">${_user.username}</a></li>
				<li><a href="${rc.getContextPath()}/j_spring_security_logout">Sign Out</a></li>
			</ul>
		</#if>
	</div><!-- navbar-inner -->
</div><!-- navbar -->
