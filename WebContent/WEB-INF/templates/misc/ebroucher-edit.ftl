<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Student" />
	<div class="row-fluid" id="zyb-misc-ebroucher-edit">
		<div class="span9">
			<form action="" method="POST" enctype="multipart/form-data" class="form-horizontal well">
				<fieldset class="row-fluid">
					<div class="span12">
						<@macro.ctrltext name="broucher" label="Caption" class="" size="span12" value="${(broucher.caption)!''}"/>
						<@macro.ctrltext name="order" label="Order" class="" size="span12" value="${(broucher.order)!''}"/>
						<@macro.ctrlfile name="file" label="File" class="" size="span12"/>
					</div>
					<input type="hidden" name="id" value="${(broucher.id)!"0"}" />
				</fieldset>
				
				<div class="form-actions">
					<input type="submit" class="save btn btn-primary" value="Save"></input>
					<span class="cancel btn">Cancel</span>
				</div>
			</form>
		</div> <!-- span9 -->
		<div class="span3">
		</div>
	</div><!-- row -->
<@macro.footer >
	<script language="" src="${rc.getContextPath()}/resources/js/misc/ebroucher-edit.js"></script>
	<script>
		$(function(){
			new zyb.misc.broucher.edit.Main("#zyb-misc-ebroucher-edit", {
				broucher: ${(broucher.id)!"0"}
			});
		});
	</script>
</@macro.footer >