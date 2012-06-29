<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Student" />
	<div class="row-fluid" id="zyb-students">
		<div class="span9">
			<form action="" method="POST" enctype="multipart/form-data" class="form-horizontal well">
				<fieldset class="row-fluid">
					<div class="span8">
						<@macro.ctrltext name="name" label="Name" class="" size="span12" value="${(student.name)!''}"/>
						<@macro.ctrltextarea name="description" label="Body" class="" size="span12" value="${(student.description)!''}"/>
						<@macro.ctrlfile name="image" label="Image" class="" size="span12"/>
					</div>
					<div class="span4">
						<#if student?exists>
							<div style="padding: 5px 0;">
								<img src="${rc.getContextPath()}/student/photo/${student.id}"></img>
							</div>
						</#if>
					</div>
					<input type="hidden" name="id" value="${(student.id)!"0"}" />
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
	<script language="" src="${rc.getContextPath()}/resources/js/students/edit.js"></script>
	<script>
		$(function(){
			new zyb.students.edit.Main("#zyb-students", {
				student: ${(student.id)!"0"}
			});
		});
	</script>
</@macro.footer >