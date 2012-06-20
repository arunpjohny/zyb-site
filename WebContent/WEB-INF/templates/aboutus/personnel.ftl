<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title (type.caption)!"" />
	<div class="row-fluid">
		<div class="span9">
			
			<#if type?exists && type.personnel?exists && type.personnel?size &gt; 0>
				<#list type.personnel as person>
					<div class="zyb-personnel">
						<div class="row-fluid">
							<div class="span9">
								<div class="brief">
									<img src="${person.image?replace("{contextPath}", rc.getContextPath())}" class="pull-left"></img>
									<div class="pull-left details">
										<div class="name"><h3>${person.name}</h3></div>
										<#if person.designation?has_content>
											<div class="designation"><h5>${person.designation}</h5></div>
										</#if>
										<#if person.company?has_content>
											<div class="company"><h5>${person.company}</h5></div>
										</#if>
									</div><!-- details -->
								</div><!-- breig -->
							</div><!-- span12 -->
						</div><!-- row -->
					
						<#if person.summary?has_content>
							<article class="summary">
								${person.summary}
							</article>
						</#if>
					</div><!-- zyb-personnel -->
				</#list>
			</#if>
		
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.aboutussidebar />
		</div>
	</div><!-- row -->
<@macro.footer />