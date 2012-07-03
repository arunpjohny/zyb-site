package in.co.zybotech.web.controller.main;

import in.co.zybotech.web.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private RequestUtils requestUtils;

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

	@RequestMapping("/blog")
	public ModelAndView blog(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/blog");
	}

}
