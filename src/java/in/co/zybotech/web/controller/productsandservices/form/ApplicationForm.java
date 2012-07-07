package in.co.zybotech.web.controller.productsandservices.form;

import in.co.zybotech.model.productsandservices.Application;

import java.io.IOException;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class ApplicationForm {

	private int id;

	private int order;

	@NotBlank
	private String caption;

	private MultipartFile application;

	private MultipartFile image1;

	private MultipartFile image2;

	@NotBlank
	private String breif;

	@NotBlank
	private String description;

	private String author;

	private boolean hideApplication;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public MultipartFile getApplication() {
		return application;
	}

	public void setApplication(MultipartFile application) {
		this.application = application;
	}

	public MultipartFile getImage1() {
		return image1;
	}

	public void setImage1(MultipartFile image1) {
		this.image1 = image1;
	}

	public MultipartFile getImage2() {
		return image2;
	}

	public void setImage2(MultipartFile image2) {
		this.image2 = image2;
	}

	public String getBreif() {
		return breif;
	}

	public void setBreif(String breif) {
		this.breif = breif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isHideApplication() {
		return hideApplication;
	}

	public void setHideApplication(boolean hideApplication) {
		this.hideApplication = hideApplication;
	}

	public void set(Application item) throws IOException {
		if (application != null && !application.isEmpty()) {
			item.setApplication(application.getBytes());
			item.setFileName(application.getOriginalFilename());
		}
		item.setAuthor(author);
		item.setBreif(breif);
		item.setDescription(description);
		item.setHidden(hideApplication);
		if (image1 != null && !image1.isEmpty()) {
			item.setImage1(image1.getBytes());
			item.setImage1Name(image1.getOriginalFilename());
		}
		if (image2 != null && !image2.isEmpty()) {
			item.setImage2(image2.getBytes());
			item.setImage2Name(image2.getOriginalFilename());
		}
		item.setCaption(caption);
		item.setOrder(order);
	}
}
