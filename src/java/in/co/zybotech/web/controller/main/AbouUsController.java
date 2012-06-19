package in.co.zybotech.web.controller.main;

import in.co.zybotech.service.PersonnelManager;
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
@RequestMapping("/aboutus")
public class AbouUsController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private PersonnelManager personnelManager;

	@RequestMapping("")
	public ModelAndView aboutus(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/aboutus");
	}

	@RequestMapping("/personnel/{type}")
	public ModelAndView advisoryboard(HttpServletRequest request,
			@PathVariable String type) {
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("type", personnelManager.getPersonnelType(type));

		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/aboutus/personnel");
	}

	@RequestMapping("/{page}")
	public ModelAndView aboutuspage(HttpServletRequest request,
			@PathVariable String page) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/aboutus/" + page);
	}

}
