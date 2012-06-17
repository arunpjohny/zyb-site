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
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
		</div>
	</div><!-- row -->
<@macro.footer />