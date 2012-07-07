<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Testimonials" />
	<div class="row-fluid" id="pas-testimonials">
		<div class="span9">
			<#if editable == true>
				<div class="zyb-btn-wrapper">
					<span class="testimonial-add pull-right btn btn-primary">Add Testimonial</span>
				</div>
			</#if>

			<div class="list-view">
			    <div class="list-view-content accordion">
			    </div>
			    <div class="list-view-footer"></div>
			</div>

			<script type="text/x-jsrenderer" class="hide list-tmpl">
				<article class="article testimonial-view" style="height: 175px;" data-testimonial="{{:id}}">
					<#if editable == true>
						<i class="icon-remove pull-right zyb-link" style="margin-left: 5px;"></i>
						<i class="icon-edit pull-right zyb-link"></i>
		            </#if>
					<header class="type2">
						<h4>{{:name}}</h4>
						<h6>{{:designation}}, {{:company}}</h6>
					</header>
					<section>
						<img src="${rc.getContextPath()}/productsandservices/testimonial/image/{{:id}}" class="pull-left" style="width: 126px; height: 126px; margin: 0 5px 5px 0;"></img>
						<div>
							{{:testimonial}}
						</div>
					</section>
				</article>
			</script>
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.productsandservicessidebar />
		</div>
	</div><!-- row -->
<@macro.footer>
	<script language="javascript" src="${rc.getContextPath()}/resources/js/productsandservices/testimonials.js"></script>
	<script>
		$(function(){
			new zyb.main.productsandservices.testimonials.Main("#pas-testimonials");
		});
	</script>
</@macro.footer>