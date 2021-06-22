package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.jpa.QueryHints;

import common.Publication;
import common.Researcher;

/**
 * Session Bean implementation class SessionBeanPublications
 */
@Stateless
@LocalBean
public class SessionBeanPublications implements SessionBeanPublicationsRemote, SessionBeanPublicationsLocal {

    /**
     * Default constructor. 
     */
    public SessionBeanPublications() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(name = "PersistencePublications")
    private EntityManager em;
    
    @Override
    public List<Publication> getAllPublications(){
    	String jpql = "SELECT distinct p FROM Publication p JOIN FETCH p.researchers r";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Publication> publicationsList = typedQuery.getResultList();
		return publicationsList;
    }
    
    @Override
    public List<Publication> getPublicationsByTitle(String title){
    	String jpql = "SELECT distinct p FROM Publication p JOIN FETCH p.researchers r WHERE p.publication_title='" + title +"'";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Publication> publicationsList = typedQuery.getResultList();
		return publicationsList;
    }

    
    @Override
    public List<Publication> getPublicationsByResearcher(String firstName, String lastName){
    	String jpql = "SELECT distinct p FROM Publication p JOIN p.researchers r WHERE r.firstName='" + firstName + "' AND r.lastName='" + lastName+"'";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Publication> publicationsList = typedQuery.getResultList();
		List<Publication> pubFinal = new ArrayList<>();
		for (Publication p : publicationsList) {
			String jpqlR = "SELECT distinct p FROM Publication p JOIN FETCH p.researchers r WHERE p.publication_title='" + p.getPublication_title() +"'";
			List<Publication> pubAux = em.createQuery(jpqlR, Publication.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
			pubFinal.addAll(pubAux);
		}
		return pubFinal;
    }
    
}
