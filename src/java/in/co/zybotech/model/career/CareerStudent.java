package in.co.zybotech.model.career;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "career_students")
public class CareerStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "career_students_cid_gen")
	@SequenceGenerator(name = "career_students_cid_gen", sequenceName = "career_students_cid_seq")
	@Column(name = "cid")
	private int id;

	private String name;

	private String description;

	private String image;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
