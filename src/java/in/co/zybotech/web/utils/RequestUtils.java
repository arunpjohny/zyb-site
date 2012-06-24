package in.co.zybotech.web.utils;

import in.co.zybotech.core.spring.context.utils.ApplicationContextLocator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestUtils {
	private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);

	public static final String AJAX_FIELD_ERRORS = "_field-errors";
	public static final String AJAX_PAGE_MESSAGE = "_page-message";
	public static final String AJAX_PAGE_MESSAGE_TYPE = "_page-message-type";

	public static final String CONFIRM_MESSAGE = "confirm_message";
	public static final String ERROR_MESSAGE = "error_message";

	public static final String DISABLE_AJAX_LOADING = "_disable_ajax_loading";

	private static MessageSourceAccessor messageResolver;

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;

	@Value("classpath:../temp")
	private Resource tempLocation;

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

	public static void openFile(HttpServletResponse res, File file,
			String fileName) throws FileNotFoundException, IOException {
		if (file.exists()) {
			int length = (int) file.length();
			FileInputStream fis = new FileInputStream(file);

			sendStream(res, fileName, fis, length);
		} else {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.write("<font size='5' color='red'>File not found: " + fileName
					+ "</font>");
			logger.error("File not found:" + file);
		}
	}

	public static void sendStream(HttpServletResponse response,
			String fileName, InputStream fis, int length) throws IOException {
		writeFileUploadHeaders(response, fileName, length);
		ServletOutputStream ouputStream = response.getOutputStream();
		try {
			int b;
			while ((b = fis.read()) != -1) {
				ouputStream.write(b);
			}
		} finally {
			ouputStream.flush();
			ouputStream.close();
			fis.close();
		}
	}

	public static String getContentType(String fileName) {
		String contentType = "application/";
		String fileExtension = fileName
				.substring(fileName.lastIndexOf('.') + 1).toUpperCase();
		if ("XLS".equals(fileExtension) || "XLSX".equals(fileExtension)) {
			contentType = contentType + "vnd.ms-excel";
		} else if ("DOC".equals(fileExtension) || "DOCX".equals(fileExtension)) {
			contentType = contentType + "msword";
		} else if ("PDF".equals(fileExtension)) {
			contentType = contentType + "pdf";
		} else if ("RTF".equals(fileExtension)) {
			contentType = contentType + "msword";
		} else if ("PPS".equals(fileExtension)) {
			contentType = contentType + "vnd.ms-powerpoint";
		} else if ("PPT".equals(fileExtension) || "PPTX".equals(fileExtension)) {
			contentType = contentType + "vnd.ms-powerpoint";
		} else if ("JPG".equals(fileExtension)) {
			contentType = "image/jpeg";
		} else if ("GIF".equals(fileExtension) || "BMP".equals(fileExtension)) {
			contentType = "image/" + fileExtension;
		} else if ("ZIP".equals(fileExtension)) {
			contentType += "zip";
		} else {
			contentType = "text/HTML";
		}
		return contentType;
	}

	public static void writeFileUploadHeaders(HttpServletResponse response,
			String fileName, int length) {
		String contentType = getContentType(fileName);
		String disHeader = "Attachment;Filename=\"" + fileName + "\"";
		response.setContentType(contentType);
		response.setHeader("Content-Disposition", disHeader);
		response.setHeader("Cache-Control", "private, max-age=5");

		response.setHeader("Pragma", "");
		if (length != -1) {
			response.setContentLength(length);
		}
	}

	public static User getUser() {
		User user = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			Authentication authentication = context.getAuthentication();
			if (authentication != null) {
				user = (User) authentication.getPrincipal();
			}
		}
		return user;
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
		User user = getUser();
		if (user != null) {
			model.put("_user", user);
		}
	}

	public ModelAndView getModelAndView(HttpServletRequest request,
			Map<String, Object> model, String viewName) {
		Map<String, Object> map = new HashMap<String, Object>();
		putContents(request, map);
		map.putAll(model);
		return new ModelAndView(viewName, map);
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

	public File getTempDir(String type) throws IOException {
		File temp = tempLocation.getFile();
		File dir = new File(temp, type);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

	public File getTempFile(String type) throws IOException {
		File dir = getTempDir(type);
		String name;
		synchronized (getClass()) {
			name = UUID.randomUUID().toString();
		}
		return new File(dir, name);
	}
}
