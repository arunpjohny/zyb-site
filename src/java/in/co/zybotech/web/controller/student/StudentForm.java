package in.co.zybotech.web.controller.student;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import in.co.zybotech.model.career.Student;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
	
	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NotNull
	private MultipartFile image;

	private int weight;

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
		student.setImage(image.getBytes());
		student.setImageName(image.getOriginalFilename());
		student.setName(name);
		student.setWeight(student.getWeight());
	}
}
