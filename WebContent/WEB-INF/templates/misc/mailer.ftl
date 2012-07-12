<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div class="row-fluid" id="zyb-misc-mailer">
		<div class="span9">
			<form action="" method="POST" class="form-horizontal well" enctype="multipart/form-data">
				<fieldset>
					<@macro.ctrlcombo label="Type" class="mailer-type" size="span11" errorplacement="help-block"/>
					<@macro.ctrltext name="fields" label="Source Fields" class="" size="span12" errorplacement="help-block" hidden=true/>
					<@macro.ctrlfile name="source" label="Source" class="" size="span12" errorplacement="help-block"/>
					<@macro.ctrltext name="subject" label="Subject" class="" size="span12" errorplacement="help-block"/>
					<@macro.ctrltextarea name="html" label="HTML" class="" size="span12" errorplacement="help-block"/>
					<@macro.ctrltextarea name="plain" label="Plain" class="" size="span12" errorplacement="help-block"/>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrlfile name="attachments" label="Attachment 1" class="" size="span12" errorplacement="help-block"/>
						</div>
						<div class="span6">
							<@macro.ctrlfile name="attachments" label="Attachment 2" class="" size="span12" errorplacement="help-block"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrlfile name="attachments" label="Attachment 3" class="" size="span12" errorplacement="help-block"/>
						</div>
						<div class="span6">
							<@macro.ctrlfile name="attachments" label="Attachment 4" class="" size="span12" errorplacement="help-block"/>
						</div>
					</div>
				</fieldset>
				
				<div class="form-actions">
					<span class="send-mail btn btn-primary">Send Mail</span>
				</div>
			</form>
		</div> <!-- span9 -->
	</div><!-- row -->
<@macro.footer>
	<script language="" src="${rc.getContextPath()}/resources/js/misc/mailer.js"></script>
	<script>
		$(function(){
			new zyb.misc.mailer.Main("#zyb-misc-mailer");
		});
	</script>
</@macro.footer>