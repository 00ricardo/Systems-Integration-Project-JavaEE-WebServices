package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entitiesEJB.Institution;
import entitiesEJB.Publication;
import entitiesEJB.Researcher;
import entitiesEJB.Skill;


public class ResearcherRest implements Serializable{
	private static final long serialVersionUID = 1L;
		private Long id_researcher;
		private String firstName;
		private String lastName;
		private String description;
		private List<SkillRest> skills;
		private List<PublicationRest> publications;
		private List<InstitutionRest> institutions;
		
		
		public ResearcherRest() {
		}
						
		public ResearcherRest(String firstName, String lastName, String description) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.description = description;
		}

		public Long getId() {
			return id_researcher;
		}

		public void setId(Long id) {
			this.id_researcher = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<SkillRest> getSkills() {
			return skills;
		}

		public void setSkills(List<SkillRest> skills) {
			this.skills = skills;
		}

		public List<PublicationRest> getPublications() {
			return publications;
		}

		public void setPublications(List<PublicationRest> publications) {
			this.publications = publications;
		}

		public List<InstitutionRest> getInstitutions() {
			return institutions;
		}

		public void setInstitutions(List<InstitutionRest> institutions) {
			this.institutions = institutions;
		}

		public Long getId_researcher() {
			return id_researcher;
		}

		public void setId_researcher(Long id_researcher) {
			this.id_researcher = id_researcher;
		}
		
		public ResearcherRest(Researcher res) {
			this.description = res.getDescription();
			this.firstName = res.getFirstName();
			//this.id_researcher = res.getId();
			this.lastName = res.getLastName();
			this.institutions = new ArrayList<>();
			/*
			 * for(Institution i : res.getInstitutions()) { this.institutions.add(new
			 * InstitutionRest(i)); }
			 */
			/*
			 * this.publications = new ArrayList<>(); for(Publication p :
			 * res.getPublications()) this.publications.add(new PublicationRest(p));
			 * this.skills = new ArrayList<>(); for(Skill s : res.getSkills())
			 * this.skills.add(new SkillRest(s));
			 */
		}
				
}
