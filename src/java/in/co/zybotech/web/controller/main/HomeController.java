package in.co.zybotech.web.controller.main;

import static in.co.zybotech.web.utils.RequestUtils.AJAX_PAGE_MESSAGE;
import in.co.zybotech.service.MailManager;
import in.co.zybotech.web.controller.main.form.ContactUsMailForm;
import in.co.zybotech.web.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private MailManager mailManager;

	@RequestMapping("/")
	public ModelAndView defaultpath(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/base");
	}

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/home");
	}

	@RequestMapping("/productsandservices")
	public ModelAndView productsandservices(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/productsandservices");
	}

	@RequestMapping("/productsandservices/{page}")
	public ModelAndView productsandservicespage(HttpServletRequest request,
			@PathVariable String page) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/productsandservices/" + page);
	}

	@RequestMapping("/placements")
	public ModelAndView placements(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/placements");
	}

	@RequestMapping("/contactus")
	public ModelAndView contactus(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/contactus");
	}

	@RequestMapping(value = "/contactus/mail", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> contactusmail(HttpServletRequest request,
			@ModelAttribute @Valid ContactUsMailForm form) {

		mailManager.sendMail(form.getFrom(), form.getSubject(), form.getBody());

		Map<String, Object> model = new HashMap<String, Object>();

		model.put(AJAX_PAGE_MESSAGE, "Mail send successfully");
		return model;
	}

	@RequestMapping("/blog")
	public ModelAndView blog(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/blog");
	}

}
