			<script language="javascript" src="${rc.getContextPath()}/resources/jquery/jquery-1.7.2.js"></script>
			<script language="javascript" src="${rc.getContextPath()}/resources/jquery/jquery.custom.js"></script>
			<script language="javascript" src="${rc.getContextPath()}/resources/bootstrap/bootstrap.js"></script>
			<script language="javascript" src="${rc.getContextPath()}/resources/utils.js"></script>

			<script language="javascript">
				var _contextPath = "${_contextPath}";
				var _pageId = "${_pageId}";
				var _disable_ajax_loading = ${(_disable_ajax_loading!"false")?string};

				var _error_message = "${error_message!""}";
			</script>

			<script type="text/javascript">
				 var _gaq = _gaq || [];
				_gaq.push(['_setAccount', 'UA-24997620-1']);
				_gaq.push(['_trackPageview']);

				(function() {
					var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
					ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
					var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
				})();
			</script>