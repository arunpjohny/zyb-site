package in.co.zybotech.web.controller.tag;

import static in.co.zybotech.web.utils.RequestUtils.DISABLE_AJAX_LOADING;
import in.co.zybotech.web.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TagsController {

	@Autowired
	private RequestUtils requestUtils;

	@RequestMapping("/tags/mobile-application-development-training-kochi_cochin_Ernakulam_kerala")
	public ModelAndView mobappdevtraining(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(DISABLE_AJAX_LOADING, true);
		return requestUtils
				.getModelAndView(request, model,
						"WEB-INF/templates/tags/mobile-application-development-training");
	}

	@RequestMapping("/tags/android-training-kochi_cochin_Ernakulam_kerala")
	public ModelAndView androidtraining(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(DISABLE_AJAX_LOADING, true);
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/tags/android-training");
	}

	@RequestMapping("/tags/learning-android-development-kochi_cochin_Ernakulam_kerala")
	public ModelAndView leanandroiddev(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(DISABLE_AJAX_LOADING, true);
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/tags/learning-android-development");
	}

	@RequestMapping("/tags/android-app-training-kochi_cochin_Ernakulam_kerala")
	public ModelAndView androidapptraining(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(DISABLE_AJAX_LOADING, true);
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/tags/android-app-training");
	}
}
