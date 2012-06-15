package in.co.zybotech.web.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class RequestUtils {
	public static final String AJAX_FIELD_ERRORS = "_field-errors";
	public static final String AJAX_PAGE_MESSAGE = "_page-message";
	public static final String AJAX_PAGE_MESSAGE_TYPE = "_page-message-type";

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;

	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request
				.getHeader(HttpHeader.X_REQUESTED_WITH.getName());
		return StringUtils.endsWithIgnoreCase(header, "XMLHttpRequest");
	}

	public static String getResourceId(HttpServletRequest request) {
		return request.getRequestURI().substring(
				request.getContextPath().length());
	}

	public void putContents(HttpServletRequest request,
			Map<String, Object> model) {
		boolean ajaxRequest = isAjaxRequest(request);
		model.put("_isAjaxRequest", ajaxRequest);

		MessageSourceAccessor accessor = new MessageSourceAccessor(
				messageSource);
		model.put("messageResolver", accessor);

		if (!ajaxRequest) {
			model.put("_contextPath", request.getContextPath());
			model.put("_pageId", getResourceId(request));
		}
	}

}
