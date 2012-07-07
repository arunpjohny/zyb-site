package in.co.zybotech.model.productsandservices;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pas_testimonial")
public class Testimonial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pas_testimonial_cid_gen")
	@SequenceGenerator(name = "pas_testimonial_cid_gen", sequenceName = "pas_testimonial_cid_seq")
	@Column(name = "cid")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Column(name = "item_order")
	private int order;

	@NotBlank
	private String name;

	@NotBlank
	private String company;

	@NotBlank
	private String designation;

	@JsonIgnore
	@NotNull
	private byte[] image;

	@NotBlank
	private String imageName;

	private String testimonial;

	private boolean hidden;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	public String getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(String testimonial) {
		this.testimonial = testimonial;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
