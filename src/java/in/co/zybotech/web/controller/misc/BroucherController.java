package in.co.zybotech.web.controller.misc;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.web.utils.RequestUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BroucherController {

	@Autowired
	private RequestUtils requestUtils;

	@Value("classpath:../ebroucher")
	private Resource location;

	@RequestMapping("/ebroucher")
	public ModelAndView ebroucher(HttpServletRequest request)
			throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Broucher> brouchers = getBrouchers();
		model.put("brouchers", brouchers);
		return requestUtils.getModelAndView(request, model,
				"WEB-INF/templates/misc/ebroucher");
	}

	@RequestMapping("/ebroucher/download/{id}")
	public void download(HttpServletRequest request,
			HttpServletResponse response, @PathVariable int id)
			throws IOException {
		File broucher = getBroucher(id);
		if (broucher == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected resource.");
		}
		RequestUtils.openFile(
				response,
				broucher,
				StringUtils.substringAfter(
						StringUtils.substring(broucher.getName(), 3), "-"));
	}

	private File getBroucher(final int id) throws IOException {
		File dir = location.getFile();
		if (dir.exists()) {
			File[] files = dir.listFiles(new FileFilter() {

				@Override
				public boolean accept(File file) {
					return file.isFile()
							&& StringUtils.startsWith(file.getName(), "eb-"
									+ id + "-");
				}
			});

			return files != null && files.length == 1 ? files[0] : null;
		}
		return null;
	}

	private List<Broucher> getBrouchers() throws IOException {
		File dir = location.getFile();
		List<Broucher> brouchers = new ArrayList<Broucher>();

		if (dir.exists()) {
			File[] files = dir.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.isFile()
							&& StringUtils.startsWith(file.getName(), "eb-");
				}
			});
			for (File file : files) {
				brouchers
						.add(new Broucher(
								NumberUtils.toInt(StringUtils.substringBefore(
										StringUtils
												.substring(file.getName(), 3),
										"-")),
								StringUtils.substringBeforeLast(
										StringUtils
												.substringAfter(StringUtils
														.substring(
																file.getName(),
																3), "-"),
										".")));
			}
		}

		return brouchers;
	}
}
