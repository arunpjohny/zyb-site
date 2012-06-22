package in.co.zybotech.web.controller.placement;

import java.util.HashMap;
import java.util.Map;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.model.placement.PlacementOpening;
import in.co.zybotech.service.PlacementManager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/placements")
public class PlacementOpeningController {

	@Autowired
	private PlacementManager placementManager;

	@RequestMapping(value = "/opening/{id}")
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

	@RequestMapping(value = "/opening/pview/{id}")
	public @ResponseBody
	Map<String, Object> openingpview(HttpServletRequest request,
			@PathVariable int id) {
		PlacementOpening object;
		if (id == 0) {
			object = placementManager.getLatestOpening();
		} else {
			object = placementManager.getObject(PlacementOpening.class, id);
			if (object == null) {
				object = placementManager.getLatestOpening();
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("opening", object);
		if (object != null) {
			map.put("next", placementManager.getNextOpeningId(object.getId()));
			map.put("prev",
					placementManager.getPreviousOpeningId(object.getId()));
		}
		return map;
	}

}
