package in.co.zybotech.web.controller.main;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.model.career.CareerStudent;
import in.co.zybotech.service.CareerManager;
import in.co.zybotech.web.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private CareerManager careerManager;

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

	@RequestMapping("/students")
	public ModelAndView students(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		requestUtils.putContents(request, model);
		model.put("students", careerManager.getStudentsForCareer());
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/students");
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
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/placements");
	}

	@RequestMapping("/blog")
	public ModelAndView blog(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/blog");
	}

}
