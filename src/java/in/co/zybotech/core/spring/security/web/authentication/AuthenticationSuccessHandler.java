package in.co.zybotech.core.spring.security.web.authentication;

import static in.co.zybotech.web.utils.RequestUtils.isAjaxRequest;
import static org.springframework.http.HttpStatus.OK;
import in.co.zybotech.core.jackson.JacksonUtils;
import in.co.zybotech.core.web.model.ajax.Redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class AuthenticationSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();

	private JacksonUtils jacksonUtils;

	@Override
	public void setRequestCache(RequestCache requestCache) {
		super.setRequestCache(requestCache);
		this.requestCache = requestCache;
	}

	public void setJacksonUtils(JacksonUtils jacksonUtils) {
		this.jacksonUtils = jacksonUtils;
	}

	protected String determineAjaxTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		String targetUrl = null;
		if (savedRequest != null) {
			targetUrl = savedRequest.getRedirectUrl();
		}

		String targetUrlParameter = getTargetUrlParameter();
		if (isAlwaysUseDefaultTargetUrl()
				|| (targetUrlParameter != null && StringUtils.isBlank(request
						.getParameter(targetUrlParameter)))) {
			targetUrl = request.getContextPath()
					+ super.determineTargetUrl(request, response);
		}

		return StringUtils.isBlank(targetUrl) ? request.getContextPath()
				+ super.determineTargetUrl(request, response) : targetUrl;
	}

	protected void setAjaxResponse(HttpServletRequest request,
			HttpServletResponse response, String targetUrl)
			throws JsonGenerationException, JsonMappingException, IOException {
		clearAuthenticationAttributes(request);
		response.setStatus(OK.value());

		Redirect redirect = new Redirect(targetUrl);
		jacksonUtils.writeValue(redirect, response.getWriter());
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		if (isAjaxRequest(request)) {
			String targetUrl = determineAjaxTargetUrl(request, response);
			setAjaxResponse(request, response, targetUrl);
			return;
		}

		super.onAuthenticationSuccess(request, response, authentication);
	}

	protected void setResponse(HttpServletRequest request,
			HttpServletResponse response, String targetUrl) throws IOException {
		logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}
}
