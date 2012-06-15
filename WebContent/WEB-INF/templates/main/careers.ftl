<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<div class="row-fluid" id="zyb-careers">
		<div class="span9">
			<h3 class="bordered-light-b title">Careers</h3>

			<div class="row-fluid">
				<div class="span12">
					<div class="scrollable-wrapper career-student">
						<a class="prev browse left"></a>
						<div class="scrollable">
							<div class="items">
								<#list students as student>
									<#if student_index % 5 == 0><div></#if>
									<img src="${student.image?replace("{contextPath}", rc.getContextPath())}" data-studentid="${student.id}"></img>
									<#if student_index % 5 == 4 || student_index = students?size - 1></div></#if>
								</#list>
							</div><!--items-->
						</div><!--scrollable-->
						<a class="next browse right"></a>
					</div><!--scrollable-wrapper-->
				</div><!--span12-->
			</div><!--row-fluid-->

			<div class="row-fluid">
				<div class="span12">
					<div class="student-info-ct" style="margin-top: 5px;">
					</div>
				</div><!--span12-->
			</div><!--row-fluid-->
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
		</div>

		<script type="text/x-jsrender" class="career-student-tmpl">
			<section class="student section">
				<header class="type2"><h4>{{:name}}</h4></header>
				<article>
					{{:description}}
				</article>
			</section>
		</script>
	</div><!-- row -->
<@macro.footer >
	<script language="" src="${rc.getContextPath()}/resources/js/main/careers.js"></script>
	<script>
		$(function(){
			new zyb.main.careers.Main("#zyb-careers");
		});
	</script>
</@macro.footer >