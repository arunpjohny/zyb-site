<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div class="row" id="zyb-contactus">
		<div class="span9">
			<form action="" method="POST" class="form-horizontal well">
				<fieldset>
					<@macro.ctrltext name="from" label="From" class="" size="span6"/>
					<@macro.ctrltext name="subject" label="Subject" class="" size="span6"/>
					<@macro.ctrltextarea name="body" label="Body" class="" size="span6"/>
				</fieldset>
				
				<div class="form-actions">
					<span class="send-mail btn btn-primary">Send Mail</span>
					<span class="cancel-mail btn btn-primary">Cancel</span>
				</div>
			</form>
		</div> <!-- span12 -->
	</div><!-- row -->
<@macro.footer>
	<script language="" src="${rc.getContextPath()}/resources/js/main/contactus.js"></script>
	<script>
		$(function(){
			new zyb.main.contactus.Main("#zyb-contactus");
		});
	</script>
</@macro.footer>