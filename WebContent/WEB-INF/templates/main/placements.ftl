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
						<div class="row-fluid">
							<div class="span2">Company</div>
							<div class="span4">{{:company}}</div>
							<div class="span2">Position</div>
							<div class="span4">{{:position}}</div>
						</div>
						<div class="row-fluid">
							<div class="span2">Location</div>
							<div class="span4">{{:location}}</div>
						</div>
						<div class="row-fluid">
							<div class="span2">Contact Person</div>
							<div class="span4">{{:contactPerson}}</div>
						</div>
						<div class="row-fluid">
							<div class="span2">e-mail</div>
							<div class="span4">{{:contactEmail}}</div>
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