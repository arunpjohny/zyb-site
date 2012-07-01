package in.co.zybotech.model.zyb;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "zyb_personnel_type")
public class PersonnelType {

	@Id
	@Column(name = "name")
	private String name;

	private String caption;

	private String description;

	@JsonIgnore
	@OneToMany(targetEntity = Personnel.class, mappedBy = "type")
	private Set<Personnel> personnel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Personnel> getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Set<Personnel> personnel) {
		this.personnel = personnel;
	}

}
