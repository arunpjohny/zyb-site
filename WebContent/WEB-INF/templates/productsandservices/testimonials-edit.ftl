<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Testimonials" />
	<div class="row-fluid" id="pas-testimonials-edit">
		<div class="span9">
				<form class="testimonial-edit form-horizontal" method="POST" action="${rc.getContextPath()}/admin/productsandservices/testimonial/edit/${(testimonial.id)!"0"}">
					<@macro.ctrlcheckbox name="hideTestimonial" label="Hidden" class="" value=(testimonial.hidden)!false/>
					<@macro.ctrltext name="order" label="Order" class="" size="span12" value=(testimonial.order)!"0"/>
					<@macro.ctrltext name="name" label="Name" class="" size="span12" value=(testimonial.name)!""/>
					<@macro.ctrltext name="designation" label="Designation" class="" size="span12" value=(testimonial.designation)!""/>
					<@macro.ctrltext name="company" label="Company" class="" size="span12" value=(testimonial.company)!""/>
					<@macro.ctrlfile name="image" label="Image (126x126 px)" class="" size="span12"/>
					<@macro.ctrltextarea name="testimonial" label="Description" class="height-medium" size="span12" value=(testimonial.testimonial)!""/>

					<input type="hidden" name="id" value="${(testimonial.id)!"0"}"></input>
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
	<script language="javascript" src="${rc.getContextPath()}/resources/js/productsandservices/testimonials-edit.js"></script>
	<script>
		$(function(){
			new zyb.main.productsandservices.testimonials.edit.Main("#pas-testimonials-edit", {
				testimonial: ${(testimonial.id)!"0"}
			});
		});
	</script>
</@macro.footer>