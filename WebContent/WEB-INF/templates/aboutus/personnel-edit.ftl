<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Student" />
	<div class="row-fluid" id="zyb-aboutus-personnel-edit">
		<div class="span9">
			<form action="" method="POST" enctype="multipart/form-data" class="form-horizontal well">
				<fieldset class="row-fluid">
					<div class="span8">
						<@macro.ctrltext name="name" label="Name" class="" size="span12" value="${(person.name)!''}"/>
						<@macro.ctrltext name="designation" label="Designation" class="" size="span12" value="${(person.designation)!''}"/>
						<@macro.ctrltext name="company" label="Company" class="" size="span12" value="${(person.company)!''}"/>
						<@macro.ctrltext name="order" label="Order" class="" size="span12" value="${(person.order)!''}"/>
						<@macro.ctrlfile name="image" label="Image" class="" size="span12"/>
						<@macro.ctrltextarea name="summary" label="Summry" class="height-medium" size="span12" value="${(person.summary)!''}"/>
					</div>
					<div class="span4">
						<#if person?exists>
							<div style="padding: 5px 0;">
								<img src="${rc.getContextPath()}/aboutus/personnel/${person.type.name}/photo/${person.id}"></img>
							</div>
						</#if>
					</div>
					<input type="hidden" name="id" value="${(person.id)!"0"}" />
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
	<script language="" src="${rc.getContextPath()}/resources/js/aboutus/personnel-edit.js"></script>
	<script>
		$(function(){
			new zyb.aboutus.personnel.edit.Main("#zyb-aboutus-personnel-edit", {
				person: ${(person.id)!"0"},
				type: '${type}'
			});
		});
	</script>
</@macro.footer >