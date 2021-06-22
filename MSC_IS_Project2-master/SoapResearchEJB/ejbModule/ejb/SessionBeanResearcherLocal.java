package ejb;

import java.util.List;

import javax.ejb.Local;

import common.Researcher;

@Local
public interface SessionBeanResearcherLocal {
	public List<Researcher> getResearcherByName(String firstName, String lastName);
	public List<Researcher> getAllResearchrsInformation();
	public List<Researcher> getResearchrsBySkill(String skill);
}
