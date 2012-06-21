<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Placements" />
	<div class="row-fluid" id="zyb-careers">
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

			<article id="zyb-placement-openings" class="zyb-placement-openings">
				<header><h4>Current Openings</h4></header>
				<article class="zyb-opening">
					<header class="text-right">Date: </header>
					<section class="zyb-section brief">
						<div class="row-fluid">
							<div class="span3">Company</div>
							<div class="span9"></div>
						</div>
						<div class="row-fluid">
							<div class="span3">Position</div>
							<div class="span9"></div>
						</div>
						<div class="row-fluid">
							<div class="span3">Location</div>
							<div class="span9"></div>
						</div>
						<div class="row-fluid">
							<div class="span3">Contact Person</div>
							<div class="span9"></div>
						</div>
						<div class="row-fluid">
							<div class="span3">e-mail</div>
							<div class="span9"></div>
						</div>
						<div class="row-fluid">
							<div class="span3">Contact Number</div>
							<div class="span9"></div>
						</div>
					</section>
					
					<section class="zyb-section job">
						<header><h5>Job Description</h5></header>
					</section>

					<section class="zyb-section candidate">
						<header><h5>Desired Candidate Profile</h5></header>
					</section>
				</article><!-- zyb-opening -->
				<footer>
					<div class="pull-left zyb-link prev"><< Prev</div>
					<div class="pull-right zyb-link next">Next >></div>
				</footer>
			</article><!-- zyb-placement-openings -->
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
		</div>
	</div><!-- row -->
<@macro.footer />