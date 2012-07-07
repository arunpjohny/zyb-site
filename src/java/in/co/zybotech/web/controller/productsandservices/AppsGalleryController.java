package in.co.zybotech.web.controller.productsandservices;

import static in.co.zybotech.web.utils.RequestUtils.getPagerResult;
import in.co.zybotech.core.dao.criteria.SearchCriteriaResult;
import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.core.web.model.ajax.Redirect;
import in.co.zybotech.dao.criteria.productsandservices.ApplicationGalleryCriteria;
import in.co.zybotech.model.productsandservices.Application;
import in.co.zybotech.service.ProductAndServicesManager;
import in.co.zybotech.web.controller.productsandservices.form.ApplicationForm;
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

@Controller("appsGalleryController")
public class AppsGalleryController {
	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private ProductAndServicesManager manager;

	@RequestMapping("/productsandservices/app-gallery")
	public ModelAndView gallery(SecurityContextHolderAwareRequestWrapper request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("editable", isEditable(request));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/productsandservices/app-gallery");
	}

	@RequestMapping("/productsandservices/app-gallery/{id}")
	public @ResponseBody
	Application students(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		Application application = manager.getObject(Application.class, id);
		if (application == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}
		return application;
	}

	private boolean isEditable(SecurityContextHolderAwareRequestWrapper request) {
		return requestUtils.isEditable(request, "application_gallery_admin");
	}

	@RequestMapping(value = "/productsandservices/app-gallery/page/{page}")
	public @ResponseBody
	SearchCriteriaResult<Application> page(
			SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int page) {
		ApplicationGalleryCriteria criteria = new ApplicationGalleryCriteria();
		criteria.setShowHidden(isEditable(request));
		return getPagerResult(request, page, criteria, Application.class,
				manager);
	}

	@RequestMapping(value = "/productsandservices/app-gallery/image1/{id}", method = RequestMethod.GET)
	public void image1(SecurityContextHolderAwareRequestWrapper request,
			HttpServletResponse response, @PathVariable int id)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException, IOException {
		Application application = manager.getObject(Application.class, id);
		if (application == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}

		byte[] bytes = manager.getBytes(Application.class, id, "image1");
		if (bytes != null) {
			RequestUtils.sendStream(response, application.getImage1Name(),
					new ByteArrayInputStream(bytes), bytes.length);
		}
	}

	@RequestMapping(value = "/productsandservices/app-gallery/image2/{id}", method = RequestMethod.GET)
	public void image2(SecurityContextHolderAwareRequestWrapper request,
			HttpServletResponse response, @PathVariable int id)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException, IOException {
		Application application = manager.getObject(Application.class, id);
		if (application == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}

		byte[] bytes = manager.getBytes(Application.class, id, "image2");
		if (bytes != null) {
			RequestUtils.sendStream(response, application.getImage2Name(),
					new ByteArrayInputStream(bytes), bytes.length);
		}
	}

	@RequestMapping(value = "/productsandservices/app-gallery/application/{id}", method = RequestMethod.GET)
	public void application(SecurityContextHolderAwareRequestWrapper request,
			HttpServletResponse response, @PathVariable int id)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException, IOException {
		Application application = manager.getObject(Application.class, id);
		if (application == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected student.");
		}

		byte[] bytes = manager.getBytes(Application.class, id, "application");
		if (bytes != null) {
			RequestUtils.sendStream(response, application.getFileName(),
					new ByteArrayInputStream(bytes), bytes.length);
		}
		application.setDownloads(application.getDownloads() + 1);
		manager.saveObject(application, Application.class);
	}

	@RequestMapping(value = "/admin/productsandservices/app-gallery/edit/{id}", method = RequestMethod.GET)
	@Secured("ROLE_APPLICATION_GALLERY_ADMIN")
	public ModelAndView editview(
			SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("application", manager.getObject(Application.class, id));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/productsandservices/app-gallery-edit");
	}

	@RequestMapping(value = "/admin/productsandservices/app-gallery/edit/{id}", method = RequestMethod.POST)
	@Secured("ROLE_APPLICATION_GALLERY_ADMIN")
	public @ResponseBody
	Redirect editpost(SecurityContextHolderAwareRequestWrapper request,
			@Valid @ModelAttribute ApplicationForm form, @PathVariable int id)
			throws IOException {
		Application application = manager.getObject(Application.class, id);
		if (application == null) {
			application = new Application();
			application.setCreatedDate(new Date());
		}
		application.setModifiedDate(new Date());
		form.set(application);
		manager.saveObject(application, Application.class);
		return new Redirect("/productsandservices/app-gallery");
	}

	@RequestMapping(value = "/admin/productsandservices/app-gallery/delete/{id}", method = RequestMethod.GET)
	@Secured("ROLE_APPLICATION_GALLERY_ADMIN")
	public @ResponseBody
	Application delete(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		Application student = manager.remove(Application.class, id);
		return student;
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}
}
