package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entitiesEJB.Researcher;
import entitiesEJB.Skill;


public class SkillRest implements Serializable {
	private static final long serialVersionUID = 2L;
	private Long id_skill;
	private String skill;
	private List<ResearcherRest> researchers;
	
	public SkillRest() {
		
	}
	
	public SkillRest(String skill, List<ResearcherRest> researchers) {
		this.skill = skill;
		this.researchers = researchers;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


	public List<ResearcherRest> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<ResearcherRest> researchers) {
		this.researchers = researchers;
	}
	
	public Long getId_skill() {
		return id_skill;
	}

	public void setId_skill(Long id_skill) {
		this.id_skill = id_skill;
	}

	public SkillRest(Skill s) {
		//this.id_skill = s.getId_skill();
		this.skill = s.getSkill();
		this.researchers = new ArrayList<>();
		for (Researcher r : s.getResearchers()) 
			this.researchers.add(new ResearcherRest(r));	
	}
	
}
