package in.co.zybotech.model.placement;

import in.co.zybotech.core.jackson.serializer.DateTimeSerializer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "placement_openings")
public class PlacementOpening {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "placement_openings_cid_gen")
	@SequenceGenerator(name = "placement_openings_cid_gen", sequenceName = "placement_openings_cid_seq")
	@Column(name = "cid")
	private int id;

	@JsonSerialize(using = DateTimeSerializer.class)
	private Date createdDate;

	@NotBlank
	private String company;

	@NotBlank
	private String position;

	private int noOfOpenings;

	private String location;

	private String contactPerson;

	private String contactEmail;

	private String contactNumber;

	@NotBlank
	private String jobDescription;

	@NotBlank
	private String desiredProfile;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNoOfOpenings() {
		return noOfOpenings;
	}

	public void setNoOfOpenings(int noOfOpenings) {
		this.noOfOpenings = noOfOpenings;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getDesiredProfile() {
		return desiredProfile;
	}

	public void setDesiredProfile(String desiredProfile) {
		this.desiredProfile = desiredProfile;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
