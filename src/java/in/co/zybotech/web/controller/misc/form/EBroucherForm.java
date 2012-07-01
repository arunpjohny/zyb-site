package in.co.zybotech.web.controller.misc.form;

import in.co.zybotech.model.misc.EBroucher;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class EBroucherForm {

	private int id;

	@NotBlank
	private String broucher;

	private MultipartFile file;

	private int order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBroucher() {
		return broucher;
	}

	public void setBroucher(String broucher) {
		this.broucher = broucher;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void set(EBroucher broucher) throws IOException {
		broucher.setCaption(this.broucher);
		broucher.setModifiedDate(new Date());
		broucher.setOrder(order);

		if (file != null && !file.isEmpty()) {
			broucher.setBroucher(file.getBytes());
			broucher.setName(this.broucher
					+ "."
					+ StringUtils.substringAfterLast(
							file.getOriginalFilename(), "."));
		}
	}
}
