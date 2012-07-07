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
	private byte[] image1;

	@NotBlank
	private String image1Name;

	@JsonIgnore
	@NotNull
	private byte[] image2;

	@NotBlank
	private String image2Name;

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

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public String getImage1Name() {
		return image1Name;
	}

	public void setImage1Name(String image1Name) {
		this.image1Name = image1Name;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public String getImage2Name() {
		return image2Name;
	}

	public void setImage2Name(String image2Name) {
		this.image2Name = image2Name;
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
