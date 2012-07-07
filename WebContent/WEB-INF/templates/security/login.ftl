<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div id="zyb-login" class="row-fluid">
		<div class="span12">
			<form action="${rc.getContextPath()}/j_spring_security_check" method="POST" class="form-horizobtal well">
				<@macro.ctrltext name="j_username" label="User Name" class="" size="span3" value=(application.caption)!"" placeholder="User Name" value=""/>
				<@macro.ctrlpassword name="j_password" label="Password" class="" size="span3" value=(application.caption)!"" placeholder="Password" value=""/>
				<div class="form-actions">
					<input type="submit" value="Login" class="btn btn-primary login"/>
				</div>
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