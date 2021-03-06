<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Students" />
	<div class="row-fluid" id="zyb-students">
		<div class="span9">
			<div class="row-fluid">
				<div class="span12">
					<div class="scrollable-wrapper student">
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
					<div class="info-ct" style="margin-top: 5px;">
					</div>
				</div><!--span12-->
			</div><!--row-fluid-->
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.contactsidebar />
		</div>

		<script type="text/x-jsrender" class="student-tmpl">
			<article class="student article">
				<header class="type2"><h4>{{:name}}</h4></header>
				<section>
					{{:description}}
				</section>
			</article>
		</script>
	</div><!-- row -->
<@macro.footer >
	<script language="" src="${rc.getContextPath()}/resources/js/main/students.js"></script>
	<script>
		$(function(){
			new zyb.main.students.Main("#zyb-students");
		});
	</script>
</@macro.footer >