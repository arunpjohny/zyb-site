<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div id="zyb-login" class="row-fluid">
		<div class="span12">
			<form action="${rc.getContextPath()}/j_spring_security_check" method="POST">
				<input name="j_username" placeholder="User Name"/>
				<input name="j_password" placeholder="Password"/>
				<input type="submit" value="Login" class="btn btn-primary"/>
			</form>
		</div>
	</div> <!-- zyb-home -->
<@macro.footer>
	<script language="" src="${rc.getContextPath()}/resources/js/security/login.js"></script>
	<script>
		$(function(){
			new zyb.security.login.Main("#zyb-login");
		});
	</script>
</@macro.footer>