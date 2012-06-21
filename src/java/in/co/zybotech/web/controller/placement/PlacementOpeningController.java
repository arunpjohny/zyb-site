package in.co.zybotech.web.controller.placement;

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
	PlacementOpening contactusmail(HttpServletRequest request,
			@PathVariable int id) {
		PlacementOpening object = placementManager.getObject(
				PlacementOpening.class, id);
		if (object == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected opening.");
		}
		return object;
	}

}
