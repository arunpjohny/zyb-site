package in.co.zybotech.web.controller.productsandservices.form;

import in.co.zybotech.model.productsandservices.Testimonial;

import java.io.IOException;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class TestimonialForm {
	private int id;

	private int order;

	@NotBlank
	private String name;

	@NotBlank
	private String company;

	@NotBlank
	private String designation;

	private MultipartFile image;

	private String testimonial;

	private boolean hideTestimonial;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(String testimonial) {
		this.testimonial = testimonial;
	}

	public boolean isHideTestimonial() {
		return hideTestimonial;
	}

	public void setHideTestimonial(boolean hideTestimonial) {
		this.hideTestimonial = hideTestimonial;
	}

	public void set(Testimonial item) throws IOException {
		if (image != null && !image.isEmpty()) {
			item.setImage(image.getBytes());
			item.setImageName(image.getOriginalFilename());
		}
		item.setCompany(company);
		item.setDesignation(designation);
		item.setHidden(hideTestimonial);
		item.setName(name);
		item.setOrder(order);
		item.setTestimonial(testimonial);
	}
}
