<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Apps Gallery" />
	<div class="row-fluid" id="application-gallery">
		<div class="span9">
			<#if editable == true>
				<div class="zyb-btn-wrapper">
					<span class="application-add pull-right btn btn-primary">Add Application</span>
				</div>
			</#if>


			<#if editable == true>
				<script type="text/x-jsrenderer" class="hide application-edit-tmpl">
					<div class="row-fluid">
						<div class="span6">
							{{if hidden == true}}
								<@macro.ctrlcheckbox name="hideApplication" label="Hidden" class="" value=true/>
							{{else}}
								<@macro.ctrlcheckbox name="hideApplication" label="Hidden" class="" value=false/>
							{{/if}}
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrltext name="caption" label="Caption" class="" size="span12" value="{{:caption}}"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrltext name="order" label="Order" class="" size="span12" value="{{:order}}"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<@macro.ctrltext name="author" label="Author" class="" size="span12" value="{{:author}}"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrlfile name="application" label="Application" class="" size="span12"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrlfile name="image" label="Image" class="" size="span12"/>
						</div>
					</div>
					<@macro.ctrltextarea name="breif" label="Brief" class="height-small" size="span12" value="{{:breif}}"/>
					<@macro.ctrltextarea name="description" label="Description" class="height-small" size="span12" value="{{:description}}"/>

					<input type="hidden" name="id" value="{{:id}}"></input>
				</script>

				<form class="modal hide modal-application-edit form-horizontal" method="POST">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><i class="icon-remove"></i></button>
						<h3>Application</h3>
					</div>
					<div class="hide ajax-message alert">
						<div class="message-content"></div>
					</div>
					<fieldset class="modal-body">
					</fieldset>
					<div class="modal-footer">
						<span class="btn" data-dismiss="modal">Close</span>
						<span class="btn btn-primary save">Save</span>
					</div>
				</form>
			</#if>

		</div> <!-- span9 -->
		<div class="span3">
			<@macro.productsandservicessidebar />
		</div>
	</div><!-- row -->
<@macro.footer>
	<script language="javascript" src="${rc.getContextPath()}/resources/js/productsandservices/app-gallery.js"></script>
	<script>
		$(function(){
			new zyb.main.productsandservices.appsgallery.Main("#application-gallery");
		});
	</script>
</@macro.footer>