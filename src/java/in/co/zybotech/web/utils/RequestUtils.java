package in.co.zybotech.web.utils;

import in.co.zybotech.core.spring.context.utils.ApplicationContextLocator;

import java.util.Collection;
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

	public static final String CONFIRM_MESSAGE = "confirm_message";

	public static final String ERROR_MESSAGE = "error_message";

	private static MessageSourceAccessor messageResolver;

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

	public static void addAjaxMessage(Map<String, Object> model,
			MessageType type, String message) {
		model.put(AJAX_PAGE_MESSAGE, message);
		model.put(AJAX_PAGE_MESSAGE_TYPE, type.getType());
	}

	public static void addAjaxMessage(Map<String, Object> model,
			MessageType type, Collection<String> message) {
		model.put(AJAX_PAGE_MESSAGE, message);
		model.put(AJAX_PAGE_MESSAGE_TYPE, type.getType());
	}

	public static String getApplicationMessage(String code) {
		return getMessageSourceAccessor().getMessage(code);
	}

	public static String getApplicationMessage(String code, Object[] args) {
		return getMessageSourceAccessor().getMessage(code, args);
	}

	public static MessageSourceAccessor getMessageSourceAccessor() {
		if (messageResolver == null) {
			messageResolver = new MessageSourceAccessor(
					ApplicationContextLocator.getApplicationContext().getBean(
							"messageSource", MessageSource.class));
		}

		return messageResolver;
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

	public enum MessageType {
		SUCCESS("success"), WARNING("warning"), ERROR("error");

		private String type;

		MessageType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
}
