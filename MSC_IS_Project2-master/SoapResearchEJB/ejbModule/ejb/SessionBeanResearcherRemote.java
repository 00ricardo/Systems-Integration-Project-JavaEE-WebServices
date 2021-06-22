package ejb;

import java.util.List;

import javax.ejb.Remote;

import common.Researcher;

@Remote
public interface SessionBeanResearcherRemote {
	public List<Researcher> getResearcherByName(String firstName, String lastName);
	public List<Researcher> getAllResearchrsInformation();
	public List<Researcher> getResearchrsBySkill(String skill);
}
