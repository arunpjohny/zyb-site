package in.co.zybotech.web.controller.misc;

import in.co.zybotech.core.exception.client.ResourceNotFoundException;
import in.co.zybotech.web.utils.RequestUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
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
			throws IOException, ArchiveException {
		File broucher = null;

		if (id == 0) {
			broucher = getAllBrouchers();
		} else {
			broucher = getBroucher(id);
		}

		if (broucher == null) {
			throw new ResourceNotFoundException(
					"Unable to find the selected resource.");
		}
		RequestUtils.openFile(response, broucher, id == 0 ? "Brouchers.zip"
				: getBroucherName(broucher));
	}

	private File getAllBrouchers() throws IOException, ArchiveException {
		File[] brouchers = getBroucherFiles();
		File file = requestUtils.getTempFile("ebroucher");
		zip(file, brouchers);
		return file;
	}

	public void zip(File zip, File[] files) throws FileNotFoundException,
			ArchiveException, IOException {
		OutputStream out = null;
		out = new FileOutputStream(zip);
		ArchiveOutputStream aout = null;
		try {
			aout = new ArchiveStreamFactory().createArchiveOutputStream("zip",
					out);
			for (File broucher : files) {
				aout.putArchiveEntry(new ZipArchiveEntry(
						getBroucherName(broucher)));
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(broucher);
					IOUtils.copy(fis, aout);
				} finally {
					fis.close();
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
		List<Broucher> brouchers = new ArrayList<Broucher>();

		File[] files = getBroucherFiles();
		if (files != null) {
			for (File file : files) {
				brouchers
						.add(new Broucher(NumberUtils.toInt(StringUtils
								.substringBefore(StringUtils.substring(
										file.getName(), 3), "-")),
								getBroucherCaption(file)));
			}
		}
		return brouchers;
	}

	private String getBroucherCaption(File file) {
		return StringUtils.substringBeforeLast(getBroucherName(file), ".");
	}

	private String getBroucherName(File file) {
		return StringUtils.substringAfter(
				StringUtils.substring(file.getName(), 3), "-");
	}

	private File[] getBroucherFiles() throws IOException {
		File dir = location.getFile();
		File[] files = null;
		if (dir.exists()) {
			files = dir.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.isFile()
							&& StringUtils.startsWith(file.getName(), "eb-");
				}
			});
		}
		return files;
	}
}
