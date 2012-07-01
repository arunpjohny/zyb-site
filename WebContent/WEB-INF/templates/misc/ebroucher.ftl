<#import "/WEB-INF/templates/freemarker/macro.ftl" as macro/>

<@macro.header />
	<@macro.title "E-Broucher" />
	<div class="row-fluid" id="zyb-misc-broucher">
		<div class="span9">
			<div class="alert alert-info">
				<h4>Click on the brouchers to download them.</h4>
			</div>
			<#if editable == true>
				<div class="zyb-btn-wrapper">
					<span class="ebroucher-add pull-right btn btn-primary">Add</span>
				</div>
			</#if>

			<#if brouchers?exists && brouchers?size &gt; 0>
				<#list brouchers as broucher>
					<div class="zyb-broucher" data-broucher="${broucher.id}">
						<h4>
							<span class="brocher-dl">
								<#if editable == true>
									<span class="pull-right">
										<i class="icon-edit zyb-link"></i>
										<i class="icon-remove zyb-link"></i>
									</span>
								</#if>
								<a href="${rc.getContextPath()}/ebroucher/download/${broucher.id}" target="_blank">
									${broucher.caption}
								</a>
							</span>
						</h4>
					</div>
				</#list>
				<div class="zyb-broucher">
					<h4>
						<span class="brocher-dl">
							<a href="${rc.getContextPath()}//ebroucher/download/0" target="_blank">Download All</a>
						</span>
					</h4>
				</div>
			</#if>
		</div> <!-- span9 -->
		<div class="span3">
			<@macro.productsandservicessidebar />
		</div>
	</div><!-- row -->
<@macro.footer >
	<script language="" src="${rc.getContextPath()}/resources/js/misc/ebroucher.js"></script>
	<script>
		$(function(){
			new zyb.misc.broucher.Main("#zyb-misc-broucher");
		});
	</script>
</@macro.footer >