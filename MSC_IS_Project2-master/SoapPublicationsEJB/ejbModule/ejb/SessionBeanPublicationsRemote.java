package ejb;

import java.util.List;

import javax.ejb.Remote;

import common.Publication;

@Remote
public interface SessionBeanPublicationsRemote {
	public List<Publication> getAllPublications();
	public List<Publication> getPublicationsByTitle(String title);
	public List<Publication> getPublicationsByResearcher(String firstName, String lastName);
}
