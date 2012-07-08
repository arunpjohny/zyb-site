package in.co.zybotech.web.controller.placement;

import static in.co.zybotech.web.utils.RequestUtils.getPagerResult;
import in.co.zybotech.core.dao.criteria.SearchCriteriaResult;
import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.dao.criteria.placement.OpeningListCriteria;
import in.co.zybotech.model.placement.PlacementOpening;
import in.co.zybotech.service.MailManager;
import in.co.zybotech.service.MiscManager;
import in.co.zybotech.web.controller.placement.form.OpeningApplyForm;
import in.co.zybotech.web.utils.RequestUtils;
import in.co.zybotech.web.utils.RequestUtils.MessageType;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${apply.opening.mail.to}")
	private String applyTo;

	@Autowired
	private MiscManager miscManager;

	@Autowired
	private MailManager mailManager;

	@Autowired
	private RequestUtils requestUtils;

	@RequestMapping("/placements")
	public ModelAndView placements(
			SecurityContextHolderAwareRequestWrapper request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editable", isEditable(request));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/placements");
	}

	private boolean isEditable(SecurityContextHolderAwareRequestWrapper request) {
		return requestUtils.isEditable(request, "placement_admin");
	}

	@RequestMapping(value = "/placements/opening/page/{page}")
	public @ResponseBody
	SearchCriteriaResult<PlacementOpening> page(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int page) {
		OpeningListCriteria criteria = new OpeningListCriteria();
		criteria.setShowHidden(isEditable(request));
		return getPagerResult(request, page, criteria, PlacementOpening.class,
				miscManager);
	}

	@RequestMapping(value = "/placements/opening/{id}")
	public @ResponseBody
	PlacementOpening opening(HttpServletRequest request, @PathVariable int id) {
		PlacementOpening object = miscManager.getObject(
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
		opening = miscManager.saveObject(opening, PlacementOpening.class);
		return opening;
	}

	@RequestMapping(value = "/admin/placements/opening/delete/{id}")
	public @ResponseBody
	PlacementOpening delete(HttpServletRequest request, @PathVariable int id) {
		return miscManager.remove(PlacementOpening.class, id);
	}

	@RequestMapping(value = "/placements/opening/apply/{id}", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> apply(HttpServletRequest request, @PathVariable int id,
			@ModelAttribute @Valid OpeningApplyForm form) throws IOException {
		PlacementOpening opening = miscManager.getObject(
				PlacementOpening.class, id);
		if (opening == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected opening.");
		}

		StringBuffer body = new StringBuffer();
		body.append("Name: " + StringUtils.trimToEmpty(form.getName()) + "\n");
		body.append("Email: " + StringUtils.trimToEmpty(form.getEmail()) + "\n");
		body.append("Mobile: " + StringUtils.trimToEmpty(form.getMobile())
				+ "\n");
		body.append("\nMessage:\n");
		body.append(form.getBody());

		Map<String, byte[]> attachments = new HashMap<String, byte[]>();
		if (form.getFile() != null && !form.getFile().isEmpty()) {
			attachments.put(form.getFile().getOriginalFilename(), form
					.getFile().getBytes());
		}
		mailManager
				.sendMail(
						form.getEmail(),
						applyTo,
						WordUtils.capitalize(form.getName())
								+ " applied for position "
								+ opening.getPosition() + " in "
								+ opening.getCompany(), body.toString(),
						attachments);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("opening", opening);
		RequestUtils.addAjaxMessage(model, MessageType.SUCCESS,
				"Your application submitted successfully.");
		return model;
	}

}
