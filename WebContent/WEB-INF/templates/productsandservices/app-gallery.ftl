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

			<div class="gallery-view">
			    <div class="gallery-content">
			    </div>
			    <div class="gallery-footer"></div>
			</div>
		</div> <!-- span9 -->

		<script type="text/x-jsrenderer" class="hide list-tmpl">
			<div class="span6">
				<article class="article application-view" style="height: 155px;" data-application="{{:id}}">
					<#if editable == true>
						<i class="icon-remove pull-right zyb-link" style="margin-left: 5px;"></i>
						<i class="icon-edit pull-right zyb-link"></i>
		            </#if>
					<header class="type2"><h4>{{:caption}}</h4></header>
					<section class="row-fluid">
						<img src="${rc.getContextPath()}/productsandservices/app-gallery/image1/{{:id}}" class="pull-left" style="width: 126px; height: 126px;"></img>
						<div class="zyb-btn-wrapper text-center" style="margin-top: 50px;">
							<span class="btn btn-primary download">Download</span>
						</div>
					</section>
				</article>
			</div>
		</script>
		<script type="text/x-jsrenderer" class="hide view-tmpl">
			<div class="modal hide modal-application-view" data-application="{{:id}}">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><i class="icon-remove"></i></button>
					<h3>{{:caption}}</h3>
				</div>
				<div class="modal-body">
					<div style="height: 255px; padding: 5px;">
						<img style="width: 250px; height: 250px;" class="pull-left" src="${rc.getContextPath()}/productsandservices/app-gallery/image2/{{:id}}">
						<div style="margin-top: 105px;" class="zyb-btn-wrapper text-center">
							<span class="btn btn-primary download">Download</span>
						</div>
					</div>
					<article class="article">
						{{:description}}
					</article>
				</div>
			</div>
		</script>

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