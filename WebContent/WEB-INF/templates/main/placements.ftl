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
							<img src="${rc.getContextPath()}/resources/images/careers/placement-process.gif"></img>
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
				<div class="opening-container">
				</div>
				<footer>
					<div class="pull-left zyb-link prev dir-loader hide"><< Prev</div>
					<div class="pull-right zyb-link next dir-loader hide">Next >></div>
				</footer>
			</article><!-- zyb-placement-openings -->
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
		</div>
		
		<script type="text/x-jsrenderer" class="hide placement-opening-tmpl">
			<article class="zyb-opening">
				<header class="text-right">Date: {{:createdDate}}</header>
				<section class="zyb-section brief">
					<div class="row-fluid">
						<div class="span2">Company</div>
						<div class="span10">{{:company}}</div>
					</div>
					<div class="row-fluid">
						<div class="span2">Position</div>
						<div class="span10">{{:position}}</div>
					</div>
					<div class="row-fluid">
						<div class="span2">Location</div>
						<div class="span10">{{:location}}</div>
					</div>
					<div class="row-fluid">
						<div class="span2">Contact Person</div>
						<div class="span10">{{:contactPerson}}</div>
					</div>
					<div class="row-fluid">
						<div class="span2">e-mail</div>
						<div class="span10">{{:contactEmail}}</div>
					</div>
					<div class="row-fluid">
						<div class="span2">Contact Number</div>
						<div class="span10">{{:contactNumber}}</div>
					</div>
				</section>
				
				<section class="zyb-section job">
					<header><h5>Job Description</h5></header>
					<div>
						{{:jobDescription}}
					</div>
				</section>

				<section class="zyb-section candidate">
					<header><h5>Desired Candidate Profile</h5></header>
					<div>
						{{:desiredProfile}}
					</div>
				</section>
			</article><!-- zyb-opening -->
		</script>
	</div><!-- row -->
<@macro.footer>
	<script language="" src="${rc.getContextPath()}/resources/js/main/placements.js"></script>
	<script>
		$(function(){
			new zyb.main.placements.Main("#zyb-placements");
		});
	</script>
</@macro.footer>