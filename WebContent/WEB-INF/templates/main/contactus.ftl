<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div class="row-fluid" id="zyb-contactus">
		<div class="span9">
			<form action="" method="POST" class="form-horizontal well">
				<fieldset>
					<@macro.ctrltext name="name" label="Name" class="" size="span6"/>
					<@macro.ctrltext name="mobile" label="Mobile" class="" size="span6"/>
					<@macro.ctrltext name="from" label="Email" class="" size="span6"/>
					<@macro.ctrltext name="subject" label="Subject" class="" size="span6"/>
					<@macro.ctrltextarea name="body" label="Body" class="" size="span6"/>
				</fieldset>
				
				<div class="form-actions">
					<span class="send-mail btn btn-primary">Send Mail</span>
					<span class="cancel-mail btn">Cancel</span>
				</div>
			</form>
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
			<address>
				<header><h4>Address</h4></header>
				<div>Zybotech solutions</div>
				<div>A7, Stephanos Tower</div>
				<div>Eachamukku(Near TV Centre)</div>
				<div>Kakkanadu, Kochi</div>
				<div>Pin-682037</div>
			</address>
		</div>
	</div><!-- row -->
<@macro.footer>
	<script language="" src="${rc.getContextPath()}/resources/js/main/contactus.js"></script>
	<script>
		$(function(){
			new zyb.main.contactus.Main("#zyb-contactus");
		});
	</script>
</@macro.footer>