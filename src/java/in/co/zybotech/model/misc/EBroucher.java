package in.co.zybotech.model.misc;

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
@Table(name = "ebrouchers")
public class EBroucher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ebrouchers_cid_gen")
	@SequenceGenerator(name = "ebrouchers_cid_gen", sequenceName = "ebrouchers_cid_seq")
	@Column(name = "cid")
	private int id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name = "item_order")
	private int order;

	@NotNull
	@NotBlank
	private String caption;

	@NotNull
	@NotBlank
	private String name;

	@JsonIgnore
	private byte[] broucher;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getBroucher() {
		return broucher;
	}

	public void setBroucher(byte[] broucher) {
		this.broucher = broucher;
	}

}
