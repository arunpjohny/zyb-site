package in.co.zybotech.web.controller.main;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.core.web.model.ajax.Redirect;
import in.co.zybotech.model.zyb.Personnel;
import in.co.zybotech.model.zyb.PersonnelType;
import in.co.zybotech.service.PersonnelManager;
import in.co.zybotech.web.controller.main.form.PersonnelForm;
import in.co.zybotech.web.utils.RequestUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AbouUsController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private PersonnelManager personnelManager;

	@RequestMapping("/aboutus")
	public ModelAndView aboutus(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/main/aboutus");
	}

	@RequestMapping("/aboutus/personnel/{type}")
	public ModelAndView advisoryboard(
			SecurityContextHolderAwareRequestWrapper request,
			@PathVariable String type) {
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("type", personnelManager.getPersonnelType(type));
		model.put("dc", new Date().getTime());
		model.put("editable", requestUtils.isEditable(request, "ABOUTUS_ADMIN"));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/aboutus/personnel");
	}

	@RequestMapping("/aboutus/{page}")
	public ModelAndView aboutuspage(HttpServletRequest request,
			@PathVariable String page) {
		Map<String, Object> model = new HashMap<String, Object>();
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/aboutus/" + page);
	}

	@RequestMapping(value = "/aboutus/personnel/{type}/photo/{id}", method = RequestMethod.GET)
	public void photo(SecurityContextHolderAwareRequestWrapper request,
			HttpServletResponse response, @PathVariable int id)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException, IOException {
		Personnel student = personnelManager.getObject(Personnel.class, id);
		if (student == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}

		byte[] bytes = personnelManager.getBytes(Personnel.class, id, "image");
		if (bytes != null) {
			RequestUtils.sendStream(response, student.getImageName(),
					new ByteArrayInputStream(bytes), bytes.length);
		}

	}

	@RequestMapping(value = "/admin/aboutus/personnel/{type}/edit/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ABOUTUS_ADMIN")
	public ModelAndView edit(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable String type, @PathVariable int id) {
		Map<String, Object> model = new HashMap<String, Object>();
		Personnel person = personnelManager.getObject(Personnel.class, id);
		if (person != null
				&& !StringUtils.equals(type, person.getType().getName())) {
			throw new ResourceNotFoundException(
					"Unable to find the selected person.");
		}
		model.put("person", person);
		model.put("type", type);
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/aboutus/personnel-edit");
	}

	@RequestMapping(value = "/admin/aboutus/personnel/{type}/edit/{id}", method = RequestMethod.POST)
	@Secured("ROLE_ABOUTUS_ADMIN")
	public @ResponseBody
	Redirect editpost(SecurityContextHolderAwareRequestWrapper request,
			@Valid @ModelAttribute PersonnelForm form,
			@PathVariable String type, @PathVariable int id) throws IOException {
		Personnel person = personnelManager.getObject(Personnel.class, id);
		if (person == null) {
			person = new Personnel();
			PersonnelType personnelType = personnelManager
					.getPersonnelType(type);
			if (personnelType == null) {
				throw new ResourceNotFoundException(
						"Unable to find the selected type.");
			}
			person.setType(personnelType);
		}
		form.set(person);
		personnelManager.saveObject(person, Personnel.class);
		return new Redirect("/aboutus/personnel/" + type);
	}

	@RequestMapping(value = "/admin/aboutus/personnel/{type}/delete/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ABOUTUS_ADMIN")
	public @ResponseBody
	Personnel delete(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable String type, @PathVariable int id) {
		Personnel person = personnelManager.getPersonnel(id);
		if (!StringUtils.equals(type, person.getType().getName())) {
			throw new ResourceNotFoundException(
					"Unable to find the selected person.");
		}
		personnelManager.remove(Personnel.class, id);
		return person;
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}
}
