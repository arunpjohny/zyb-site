<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Placements" />
	<div class="row-fluid" id="zyb-placements">
		<div class="span9">
			<div class="row-fluid">
				<div class="span12">
					<article class="article">
						<header class="type2"><h4>Development and Training process</h4></header>
						<section style="text-align: center;">
							<img src="${rc.getContextPath()}/resources/images/careers/placement-process.png"></img>
						</section>
					</article>

					<article class="article">
						<header class="type2"><h4>What we do</h4></header>
						<section>
							<p>
								Zybotech solutions offer 100% placement assistance for the students and till date most of the trained students were placed in android application development in various companies in and around the state.
							</p>
							<p>
								Our systematic training and placement process helps identifying candidates real potential and we nurture those talents to meet up with the industry requirements.
							</p>
						</section>
					</article>
				</div><!--span12-->
			</div><!--row-fluid-->

			<article class="zyb-placement-openings">
				<header><h4>Current Openings</h4></header>
				<#if editable == true>
					<div class="zyb-btn-wrapper">
						<span class="opening-add pull-right btn btn-primary">Add Openings</span>
					</div>
					<div class="add-form-container">
					</div>
				</#if>
				<div class="list-view">
				    <div class="list-view-content accordion">
				    </div>
				    <div class="list-view-footer"></div>
				</div>
			</article><!-- zyb-placement-openings -->
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
		</div>

		<script type="text/x-jsrenderer" class="hide placement-opening-view-tmpl">
				<#if editable == true>
					<i class="icon-remove pull-right zyb-link" style="margin-left: 5px;"></i>
					<i class="icon-edit pull-right zyb-link"></i>
                </#if>
				<div class="row-fluid">
					<div class="span2">Company2</div>
					<div class="span4">{{:company}}</div>
					<div class="span2">Location</div>
					<div class="<#if editable == true>span3<#else>span4</#if>">{{:location}}</div>
				</div>
				<div class="row-fluid">
					<div class="span2">Position</div>
					<div class="span4">{{:position}}</div>
					{{if noOfOpenings > 0 }}
						<div class="span2">No. of Openings</div>
						<div class="span4">{{:noOfOpenings}}</div>
					{{/if}}
				</div>
				<div class="row-fluid">
					<div class="span2">Contact Person</div>
					<div class="span4">{{:contactPerson}}</div>
				</div>
				<div class="row-fluid">
					<div class="span2">Contact EMail</div>
					<div class="span4"><a href="mailto:{{:contactEmail}}?subject=Apply: Company:{{:company}} - Position:{{:position}}">{{:contactEmail}}</a></div>
					<div class="span2">Contact Number</div>
					<div class="span4">{{:contactNumber}}</div>
				</div>
				<section>
					<header><h5>Job Description</h5></header>
					<div>
						{{:jobDescription}}
					</div>
				</section>

				<section>
					<header><h5>Desired Candidate Profile</h5></header>
					<div>
						{{:desiredProfile}}
					</div>
				</section>
		</script>

		<#if editable == true>
			<script type="text/x-jsrenderer" class="hide placement-opening-edit-tmpl">
				<form class="form-horizontal" method="POST">
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrltext name="company" label="Company" class="" size="span12" value="{{:company}}"/>
						</div>
						<div class="span6">
							<@macro.ctrltext name="location" label="Location" class="" size="span12" value="{{:location}}"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrltext name="position" label="Position" class="" size="span12" value="{{:position}}"/>
						</div>
						<div class="span6">
							<@macro.ctrltext name="noOfOpenings" label="No. of Openings" class="" size="span12" value="{{:noOfOpenings}}"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrltext name="contactPerson" label="Contact Person" class="" size="span12" value="{{:contactPerson}}"/>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<@macro.ctrltext name="contactEmail" label="Contact Email" class="" size="span12" value="{{:contactEmail}}"/>
						</div>
						<div class="span6">
							<@macro.ctrltext name="contactNumber" label="Contact Number" class="" size="span12" value="{{:contactNumber}}"/>
						</div>
					</div>
					<@macro.ctrltextarea name="jobDescription" label="Job Description" class="height-medium" size="span12" value="{{:jobDescription}}"/>
					<@macro.ctrltextarea name="desiredProfile" label="Desired Profile" class="height-medium" size="span12" value="{{:desiredProfile}}"/>

					<div class="form-actions">
						<input type="submit" class="btn btn-primary save" value="Save"></input>
						<input type="submit" class="btn cancel" value="Cancel"></input>
						<input type="hidden" name="id" value="{{:id}}"></input>
					</div>
				</form>
			</script>
		</#if>

		<script type="text/x-jsrenderer" class="hide placement-opening-tmpl">
	        <section class="list-view-item accordion-group" data-opening="{{:id}}">
	            <header>
	            	<div class="row-fluid">
		            	<div class="span5">
		            		<h4>{{:company}}</h4>
		            		<h6>{{:createdDate}}<h6>
		            	</div>
		            	<div class="span7">
		            		<h5>{{:position}}</h5>
		            	</div>
		            <div>
	            </header>
	
	            <div class="list-view-item-body hide">
                    <div class="list-view-item-content">
						<div class="placement-opening-view">
							{{if id > 0 tmpl=~viwPlacementOpening}}
							{{/if}}
						</div>
						<#if editable == true>
							<div class="placement-opening-edit hide">
								{{if id > 0 tmpl=~edtPlacementOpening}}
								{{/if}}
							</div>
						</#if>
                    </div><!-- list-view-item-content -->
                    <footer class="list-view-item-footer">
                    </footer><!-- list-view-item-footer -->
	            </div><!-- list-view-item-body -->
	        </section>
		</script>
	</div><!-- row -->
<@macro.footer>
	<script language="javascript" src="${rc.getContextPath()}/resources/js/main/placements.js"></script>
	<script>
		$(function(){
			new zyb.main.placements.Main("#zyb-placements");
		});
	</script>
</@macro.footer>