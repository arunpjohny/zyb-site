package in.co.zybotech.model.zyb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.core.Ordered;

@Entity
@Table(name = "zyb_personnel")
public class Personnel implements Ordered {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "zyb_personnel_cid_gen")
	@SequenceGenerator(name = "zyb_personnel_cid_gen", sequenceName = "zyb_personnel_cid_seq")
	@Column(name = "cid")
	private int id;

	@ManyToOne(targetEntity = PersonnelType.class)
	@JoinColumn(name = "p_type")
	private PersonnelType type;

	private String name;

	private String designation;

	private String company;

	@JsonIgnore
	private byte[] image;

	private String imageName;

	private String summary;

	@Column(name = "item_order")
	private int order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonnelType getType() {
		return type;
	}

	public void setType(PersonnelType type) {
		this.type = type;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
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

}
