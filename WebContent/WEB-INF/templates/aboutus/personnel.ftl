<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title (type.caption)!"" />
	<div class="row-fluid" id="zyb-aboutus-personnel">
		<div class="span9">

			<#if editable == true>
				<div class="zyb-btn-wrapper">
					<span class="personnel-add pull-right btn btn-primary">Add</span>
				</div>
			</#if>

			<#if type?exists && type.personnel?exists && type.personnel?size &gt; 0>
				<#list type.personnel as person>
					<div class="zyb-personnel" data-personnel="${person.id}">
					<#if editable == true>
						<i class="icon-remove pull-right zyb-link" style="margin-left: 5px;"></i>
						<i class="icon-edit pull-right zyb-link"></i>
					</#if>
						<div class="row-fluid">
							<div class="span9">
								<div class="brief">
									<img src="${rc.getContextPath()}/aboutus/personnel/${person.type.name}/photo/${person.id}<#if editable == true>?_dc=${dc}</#if>" class="pull-left"></img>
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
<@macro.footer >
	<script language="" src="${rc.getContextPath()}/resources/js/aboutus/personnel.js"></script>
	<script>
		$(function(){
			new zyb.aboutus.personnel.Main("#zyb-aboutus-personnel", {
				type: '${type.name}'
			});
		});
	</script>
</@macro.footer >