package entities;

import java.io.Serializable;
import java.util.List;

import entitiesEJB.Institution;


public class InstitutionRest implements Serializable {
	private static final long serialVersionUID = 4L;
	private Long id_institution;
	private String institution_name;
	private String location;
	private String department;

	private List<ResearcherRest> researchers;

	public InstitutionRest() {

	}

	public InstitutionRest(String institution_name, String location, String department,
			List<ResearcherRest> researchers) {
		this.institution_name = institution_name;
		this.location = location;
		this.department = department;
		this.researchers = researchers;
	}

	public InstitutionRest(String institution_name, String location, List<ResearcherRest> researchers) {
		this.institution_name = institution_name;
		this.location = location;
		this.researchers = researchers;
	}

	public Long getId_institution() {
		return id_institution;
	}

	public void setId_institution(Long id_institution) {
		this.id_institution = id_institution;
	}

	public String getInstitution_name() {
		return institution_name;
	}

	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<ResearcherRest> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<ResearcherRest> researchers) {
		this.researchers = researchers;
	}

	public InstitutionRest(Institution ins) {
		this.department = ins.getDepartment();
		this.id_institution = ins.getId_institution();
		this.institution_name = ins.getInstitution_name();
		this.location = ins.getLocation();
	}

}
