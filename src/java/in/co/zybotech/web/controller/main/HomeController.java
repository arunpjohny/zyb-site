package in.co.zybotech.web.controller.main;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.model.career.CareerStudent;
import in.co.zybotech.service.CareerManager;
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
	private CareerManager careerManager;

	@Autowired
	private MailManager mailManager;

	@RequestMapping("/")
	public ModelAndView defaultpath(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/main/base", model);
	}

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/main/home", model);
	}

	@RequestMapping("/aboutus")
	public ModelAndView aboutus(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/main/aboutus", model);
	}

	@RequestMapping("/aboutus/{page}")
	public ModelAndView aboutuspage(HttpServletRequest request,
			@PathVariable String page) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/aboutus/" + page, model);
	}

	@RequestMapping("/productsandservices")
	public ModelAndView productsandservices(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/main/productsandservices",
				model);
	}

	@RequestMapping("/productsandservices/{page}")
	public ModelAndView productsandservicespage(HttpServletRequest request,
			@PathVariable String page) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView(
				"WEB-INF/templates/productsandservices/" + page, model);
	}

	@RequestMapping("/students")
	public ModelAndView students(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		model.put("students", careerManager.getStudentsForCareer());
		return new ModelAndView("WEB-INF/templates/main/students", model);
	}

	@RequestMapping("/student/{id}")
	public @ResponseBody
	Object student(HttpServletRequest request, @PathVariable int id) {
		CareerStudent student = careerManager
				.getObject(CareerStudent.class, id);
		if (student == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}
		return student;
	}

	@RequestMapping("/placements")
	public ModelAndView placements(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/main/placements", model);
	}

	@RequestMapping("/contactus")
	public ModelAndView contactus(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		return new ModelAndView("WEB-INF/templates/main/contactus", model);
	}

	@RequestMapping(value = "/contactus/mail", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> contactusmail(HttpServletRequest request,
			@ModelAttribute @Valid ContactUsMailForm form) {

		mailManager.sendMail(form.getFrom(), form.getSubject(), form.getBody());

		Map<String, Object> model = new HashMap<String, Object>();

		model.put(RequestUtils.AJAX_PAGE_MESSAGE, "Mail send successfully");
		return model;
	}

}
