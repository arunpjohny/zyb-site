package in.co.zybotech.web.controller.placement;

import static in.co.zybotech.web.utils.RequestUtils.getPagerResult;
import in.co.zybotech.core.dao.criteria.SearchCriteriaResult;
import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.dao.criteria.placement.OpeningListCriteria;
import in.co.zybotech.model.placement.PlacementOpening;
import in.co.zybotech.service.PlacementManager;
import in.co.zybotech.web.utils.RequestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlacementOpeningController {

	@Autowired
	private PlacementManager placementManager;

	@Autowired
	private RequestUtils requestUtils;

	@RequestMapping("/placements")
	public ModelAndView placements(
			SecurityContextHolderAwareRequestWrapper request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editable",
				requestUtils.isEditable(request, "placement_admin"));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/placements");
	}

	@RequestMapping(value = "/placements/opening/page/{page}")
	public @ResponseBody
	SearchCriteriaResult<PlacementOpening> page(HttpServletRequest request,
			@PathVariable int page) {
		OpeningListCriteria criteria = new OpeningListCriteria();
		return getPagerResult(request, page, criteria, PlacementOpening.class,
				placementManager);
	}

	@RequestMapping(value = "/placements/opening/{id}")
	public @ResponseBody
	PlacementOpening opening(HttpServletRequest request, @PathVariable int id) {
		PlacementOpening object = placementManager.getObject(
				PlacementOpening.class, id);
		if (object == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected opening.");
		}
		return object;
	}

	@RequestMapping(value = "/admin/placements/opening/edit/{id}", method = RequestMethod.POST)
	public @ResponseBody
	PlacementOpening save(HttpServletRequest request,
			@ModelAttribute @Valid PlacementOpening opening) {
		if (opening.getId() == 0) {
			opening.setCreatedDate(new Date());
		}
		opening = placementManager.saveObject(opening, PlacementOpening.class);
		return opening;
	}

	@RequestMapping(value = "/admin/placements/opening/delete/{id}")
	public @ResponseBody
	PlacementOpening delete(HttpServletRequest request, @PathVariable int id) {
		return placementManager.remove(PlacementOpening.class, id);
	}

}
