<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Application Gallery" />
	<div class="row-fluid" id="application-gallery-edit">
		<div class="span9">
				<form class="application-edit form-horizontal" method="POST" action="${rc.getContextPath()}/admin/productsandservices/app-gallery/edit/${(application.id)!"0"}">
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrlcheckbox name="hideApplication" label="Hidden" class="" value=(application.hidden)!false/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrltext name="caption" label="Caption" class="" size="span12" value=(application.caption)!""/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrltext name="order" label="Order" class="" size="span12" value=(application.order)!"0"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrltext name="author" label="Author" class="" size="span12" value=(application.author)!""/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrlfile name="application" label="Application" class="" size="span12"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrlfile name="image" label="Image" class="" size="span12"/>
						</div>
					</div>
					<@macro.ctrltextarea name="breif" label="Brief" class="height-small" size="span12" value=(application.brief)!""/>
					<@macro.ctrltextarea name="description" label="Description" class="height-small" size="span12" value=(application.description)!""/>

					<input type="hidden" name="id" value="${(application.id)!"0"}"></input>
					<div class="form-actions">
						<span class="btn btn-primary save">Save</span>
						<span class="btn cancel">Cancel</span>
					</div>
				</form>

		</div> <!-- span9 -->
		<div class="span3">
			<@macro.productsandservicessidebar />
		</div>
	</div><!-- row -->
<@macro.footer>
	<script language="javascript" src="${rc.getContextPath()}/resources/js/productsandservices/app-gallery-edit.js"></script>
	<script>
		$(function(){
			new zyb.main.productsandservices.appsgallery.edit.Main("#application-gallery-edit", {
				application: ${(application.id)!"0"}
			});
		});
	</script>
</@macro.footer>