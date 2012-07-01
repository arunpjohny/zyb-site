package in.co.zybotech.web.controller.misc;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.core.web.model.ajax.Redirect;
import in.co.zybotech.model.misc.EBroucher;
import in.co.zybotech.service.MiscManager;
import in.co.zybotech.web.controller.misc.form.EBroucherForm;
import in.co.zybotech.web.utils.RequestUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
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
public class BroucherController {

	@Autowired
	private RequestUtils requestUtils;

	@Autowired
	private MiscManager miscManager;

	@RequestMapping("/ebroucher")
	public ModelAndView ebroucher(
			SecurityContextHolderAwareRequestWrapper request)
			throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<EBroucher> brouchers = miscManager.getBrouchers();
		model.put("brouchers", brouchers);
		model.put("editable",
				requestUtils.isEditable(request, "broucher_admin"));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/misc/ebroucher");
	}

	@RequestMapping("/ebroucher/download/0")
	public void downloadAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ArchiveException,
			SecurityException, IllegalArgumentException, NoSuchFieldException,
			IllegalAccessException {
		List<EBroucher> brouchers = miscManager.getBrouchers();
		File file = requestUtils.getTempFile("ebroucher");
		zip(file, brouchers);
		RequestUtils.openFile(response, file, "Brouchers.zip");
		FileUtils.deleteQuietly(file);
	}

	@RequestMapping("/ebroucher/download/{id}")
	public void download(HttpServletRequest request,
			HttpServletResponse response, @PathVariable int id)
			throws IOException, ArchiveException, SecurityException,
			IllegalArgumentException, NoSuchFieldException,
			IllegalAccessException {
		EBroucher broucher = miscManager.getObject(EBroucher.class, id);

		if (broucher == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected Broucher.");
		}

		byte[] bytes = miscManager.getBytes(EBroucher.class, id, "broucher");
		RequestUtils.sendStream(response, broucher.getName(),
				new ByteArrayInputStream(bytes), bytes.length);
	}

	@RequestMapping(value = "/admin/ebroucher/edit/{id}", method = RequestMethod.GET)
	@Secured("ROLE_STUDENT_ADMIN")
	public ModelAndView edit(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("broucher", miscManager.getObject(EBroucher.class, id));
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/misc/ebroucher-edit");
	}

	@RequestMapping(value = "/admin/ebroucher/edit/{id}", method = RequestMethod.POST)
	@Secured("ROLE_STUDENT_ADMIN")
	public @ResponseBody
	Redirect editpost(SecurityContextHolderAwareRequestWrapper request,
			@Valid @ModelAttribute EBroucherForm form, @PathVariable int id)
			throws IOException {
		EBroucher broucher = miscManager.getObject(EBroucher.class, id);
		if (broucher == null) {
			broucher = new EBroucher();
			broucher.setCreatedDate(new Date());
		}
		form.set(broucher);
		miscManager.saveObject(broucher, EBroucher.class);
		return new Redirect("/ebroucher");
	}

	@RequestMapping(value = "/admin/ebroucher/delete/{id}", method = RequestMethod.GET)
	@Secured("ROLE_STUDENT_ADMIN")
	public @ResponseBody
	EBroucher delete(SecurityContextHolderAwareRequestWrapper request,
			@PathVariable int id) {
		EBroucher broucher = miscManager.remove(EBroucher.class, id);
		return broucher;
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
	}

	private void zip(File zip, List<EBroucher> brouchers)
			throws FileNotFoundException, ArchiveException, IOException,
			SecurityException, IllegalArgumentException, NoSuchFieldException,
			IllegalAccessException {
		OutputStream out = null;
		out = new FileOutputStream(zip);
		ArchiveOutputStream aout = null;
		try {
			aout = new ArchiveStreamFactory().createArchiveOutputStream("zip",
					out);
			for (EBroucher broucher : brouchers) {
				aout.putArchiveEntry(new ZipArchiveEntry(broucher.getName()));
				InputStream is = null;
				try {
					is = new ByteArrayInputStream(miscManager.getBytes(
							EBroucher.class, broucher.getId(), "broucher"));
					IOUtils.copy(is, aout);
				} finally {
					is.close();
				}
				aout.closeArchiveEntry();
			}
		} finally {
			if (aout != null) {
				aout.flush();
				aout.close();
			}
			if (out != null) {
				out.close();

			}
		}
	}

}
