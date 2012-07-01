package in.co.zybotech.web.controller.main.form;

import java.io.IOException;

import in.co.zybotech.model.zyb.Personnel;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class PersonnelForm {

	private int id;
	
	@NotBlank
	private String name;

	@NotBlank
	private String designation;

	private String company;

	private MultipartFile image;

	private int order;

	@NotBlank
	private String summary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void set(Personnel person) throws IOException {
		person.setCompany(company);
		person.setDesignation(designation);
		if (image != null && !image.isEmpty()) {
			person.setImage(image.getBytes());
			person.setImageName(image.getOriginalFilename());
		}
		person.setName(name);
		person.setOrder(order);
		person.setSummary(summary);
	}
}
