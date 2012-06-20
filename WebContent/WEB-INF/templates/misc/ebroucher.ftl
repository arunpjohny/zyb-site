<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "E-Broucher" />
	<div class="row-fluid">
		<div class="span9">
			<#if brouchers?exists && brouchers?size &gt; 0>
				<#list brouchers as broucher>
					<div class="zyb-broucher">
						<a href="${rc.getContextPath()}//ebroucher/download/${broucher.id}" target="_blank">${broucher.caption}</a>
					</div>
				</#list>
			</#if>
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.productsandservicessidebar />
		</div>
	</div><!-- row -->
<@macro.footer />