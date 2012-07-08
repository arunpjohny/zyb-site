package in.co.zybotech.web.controller.productsandservices;

import static in.co.zybotech.web.utils.RequestUtils.getPagerResult;
import in.co.zybotech.core.dao.criteria.SearchCriteriaResult;
import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.core.web.model.ajax.Redirect;
import in.co.zybotech.dao.criteria.productsandservices.TestimonialListCriteria;
import in.co.zybotech.model.productsandservices.Testimonial;
import in.co.zybotech.service.MiscManager;
import in.co.zybotech.web.controller.productsandservices.form.TestimonialForm;
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
public class TestimonialController {
	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private MiscManager manager;

	@RequestMapping("/productsandservices/testimonials")
	public ModelAndView gallery(SecurityContextHolderAwareRequestWrapper request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editable", isEditable(request));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/productsandservices/testimonials");
	}

	private boolean isEditable(SecurityContextHolderAwareRequestWrapper request) {
		return requestUtils.isEditable(request, "TESTIMONIAL_ADMIN");
	}

	@RequestMapping(value = "/productsandservices/testimonial/page/{page}")
	public @ResponseBody
	SearchCriteriaResult<Testimonial> page(
			SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int page) {
		TestimonialListCriteria criteria = new TestimonialListCriteria();
		criteria.setShowHidden(isEditable(request));
		return getPagerResult(request, page, criteria, Testimonial.class,
				manager);
	}

	@RequestMapping(value = "/productsandservices/testimonial/image/{id}", method = RequestMethod.GET)
	public void image(SecurityContextHolderAwareRequestWrapper request,
			HttpServletResponse response, @PathVariable int id)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException, IOException {
		Testimonial testimonial = manager.getObject(Testimonial.class, id);
		if (testimonial == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected testimonial.");
		}

		byte[] bytes = manager.getBytes(Testimonial.class, id, "image");
		if (bytes != null) {
			RequestUtils.sendStream(response, testimonial.getImageName(),
					new ByteArrayInputStream(bytes), bytes.length);
		}
	}

	@RequestMapping(value = "/admin/productsandservices/testimonial/edit/{id}", method = RequestMethod.GET)
	@Secured("ROLE_TESTIMONIAL_ADMIN")
	public ModelAndView editview(
			SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("testimonial", manager.getObject(Testimonial.class, id));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/productsandservices/testimonials-edit");
	}

	@RequestMapping(value = "/admin/productsandservices/testimonial/edit/{id}", method = RequestMethod.POST)
	@Secured("ROLE_TESTIMONIAL_ADMIN")
	public @ResponseBody
	Redirect editpost(SecurityContextHolderAwareRequestWrapper request,
			@Valid @ModelAttribute TestimonialForm form, @PathVariable int id)
			throws IOException {
		Testimonial testimonial = manager.getObject(Testimonial.class, id);
		if (testimonial == null) {
			testimonial = new Testimonial();
			testimonial.setCreatedDate(new Date());
		}
		testimonial.setModifiedDate(new Date());
		form.set(testimonial);
		manager.saveObject(testimonial, Testimonial.class);
		return new Redirect("/productsandservices/testimonials");
	}

	@RequestMapping(value = "/admin/productsandservices/testimonial/delete/{id}", method = RequestMethod.GET)
	@Secured("ROLE_TESTIMONIAL_ADMIN")
	public @ResponseBody
	Testimonial delete(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		return manager.remove(Testimonial.class, id);
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}
}
