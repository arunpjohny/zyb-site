package in.co.zybotech.model.placement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "placement_openings")
public class PlacementOpening {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "placement_openings_cid_gen")
	@SequenceGenerator(name = "placement_openings_cid_gen", sequenceName = "placement_openings_cid_seq")
	@Column(name = "cid")
	private int id;

	private Date createdDate;

	private String company;

	private String position;

	private String location;

	private String contactPerson;

	private String contactEmail;

	private String contactNumber;

	private String jobDescription;

	private String desiredProfile;

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

}
