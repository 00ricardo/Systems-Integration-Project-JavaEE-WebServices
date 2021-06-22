package ejb;

import java.util.List;

import javax.ejb.Local;

import common.Publication;

@Local
public interface SessionBeanPublicationsLocal {
	public List<Publication> getAllPublications();
	public List<Publication> getPublicationsByTitle(String title);
	public List<Publication> getPublicationsByResearcher(String firstName, String lastName);
}
