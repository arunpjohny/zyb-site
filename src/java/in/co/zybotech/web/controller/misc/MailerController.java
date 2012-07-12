package in.co.zybotech.web.controller.misc;

import static in.co.zybotech.web.utils.RequestUtils.AJAX_PAGE_MESSAGE;
import in.co.zybotech.mailer.BulkMailer;
import in.co.zybotech.mailer.MailerType;
import in.co.zybotech.web.controller.misc.form.MailerForm;
import in.co.zybotech.web.utils.ApplicationUtils;
import in.co.zybotech.web.utils.RequestUtils;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailerController {
	private static Logger mailerlogger = LoggerFactory
			.getLogger(BulkMailer.class);

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ApplicationUtils applicationUtils;

	@Value("${bulkmailer.mail.from}")
	private String from;

	@RequestMapping(value = "/mailer", method = RequestMethod.GET)
	@Secured("ROLE_BULK_MAILER")
	public ModelAndView mailer(SecurityContextHolderAwareRequestWrapper request)
			throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/misc/mailer");
	}

	@RequestMapping(value = "/mailer", method = RequestMethod.POST)
	@Secured("ROLE_BULK_MAILER")
	public @ResponseBody
	Map<String, Object> mail(HttpServletRequest request,
			@ModelAttribute @Valid MailerForm form)
			throws InstantiationException, IllegalAccessException, IOException {
		Map<String, Object> model = new HashMap<String, Object>();

		BulkMailer mailer = form.getType().getClazz().newInstance();
		mailer.setLogger(mailerlogger);
		mailer.setSender(mailSender);
		mailer.setFields(getFields(form.getFields()));
		mailer.setFrom(from);
		mailer.setSubject(form.getSubject());
		mailer.html(form.getHtml());
		mailer.plain(form.getPlain());
		mailer.setAttachments(getAttachments(form.getAttachments()));
		File tempFile = applicationUtils.getTempFile("bulk-mailer");
		FileUtils.writeByteArrayToFile(tempFile, form.getSource().getBytes());
		mailer.send(tempFile);
		model.put(AJAX_PAGE_MESSAGE, "Mail send successfully");
		return model;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(MailerType.class, new MailerTypeEditor());
	}

	private Map<String, byte[]> getAttachments(MultipartFile[] attachment)
			throws IOException {
		Map<String, byte[]> attachments = new HashMap<String, byte[]>();
		if (attachment != null) {
			for (MultipartFile file : attachment) {
				if (!file.isEmpty()) {
					attachments
							.put(file.getOriginalFilename(), file.getBytes());
				}
			}
		}
		return attachments;
	}

	private static List<String> getFields(String fields) {
		String[] stringList = fields.split(",");
		List<String> list = new ArrayList<String>();
		for (String string : stringList) {
			list.add(StringUtils.trimToEmpty(string));
		}
		return list;
	}

	private class MailerTypeEditor extends PropertyEditorSupport {

		@Override
		public String getAsText() {
			return super.getAsText();
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(MailerType.valueOf(StringUtils.upperCase(text)));
		}

	}
}
