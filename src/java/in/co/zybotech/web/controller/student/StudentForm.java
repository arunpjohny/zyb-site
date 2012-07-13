package in.co.zybotech.web.controller.student;

import in.co.zybotech.model.career.Student;

import java.io.IOException;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class StudentForm {

	private int id;

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	private MultipartFile image;

	private int weight;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void set(Student student) throws IOException {
		student.setDescription(description);
		if (image != null && !image.isEmpty()) {
			student.setImage(image.getBytes());
			student.setImageName(image.getOriginalFilename());
		}
		student.setName(name);
		student.setWeight(weight);
	}
}
