<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "Why Zybotech" />
	<div class="row-fluid">
		<div class="span9">
			<p class="text-center">
				<img src="${rc.getContextPath()}/resources/images/why_zybotech.png"></img>
			</p>
			<p>
				Zybotech solutions identifies young talents train them in the most professional way. Helps them to generate new idea, provide opportunity to implement and execute these ideas. Zybotech is successful in building friendly organization culture and a result oriented working environment. Our systematic process in the development and design phase and effective client management helps delivering high level of satisfaction for every client.
			</p>
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.productsandservicessidebar />
		</div>
	</div><!-- row -->
<@macro.footer />