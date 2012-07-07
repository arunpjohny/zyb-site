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
@Table(name = "pas_application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pas_application_cid_gen")
	@SequenceGenerator(name = "pas_application_cid_gen", sequenceName = "pas_application_cid_seq")
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
	private String caption;

	@JsonIgnore
	@NotNull
	private byte[] application;

	@NotBlank
	private String fileName;

	@JsonIgnore
	@NotNull
	private byte[] image;

	@NotBlank
	private String imageName;

	@NotBlank
	private String breif;

	@NotBlank
	private String description;

	private String author;

	private int downloads;

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

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public byte[] getApplication() {
		return application;
	}

	public void setApplication(byte[] application) {
		this.application = application;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public int getDownloads() {
		return downloads;
	}

	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
