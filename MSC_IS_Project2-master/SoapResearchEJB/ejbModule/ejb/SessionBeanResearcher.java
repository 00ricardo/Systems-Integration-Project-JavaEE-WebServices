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
import common.Skill;

/**
 * Session Bean implementation class SessionBeanResearcher
 */
@Stateless
@LocalBean
public class SessionBeanResearcher implements SessionBeanResearcherRemote, SessionBeanResearcherLocal {

    /**
     * Default constructor. 
     */
    public SessionBeanResearcher() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(name = "PersistenceProject")
    private EntityManager em;
    
    @Override
    public List<Researcher> getResearcherByName(String firstName, String lastName) {
		String jpql = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.institutions WHERE s.firstName='" + firstName+ "'AND s.lastName='" + lastName + "'";
		String jpql2 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.skills WHERE s.firstName='" + firstName + "'AND s.lastName='" + lastName + "'";
		String jpql3 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.publications WHERE s.firstName='" + firstName + "'AND s.lastName='" + lastName + "'";
		TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Researcher> researchersList = typedQuery.getResultList();
		researchersList = em.createQuery(jpql2, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
		researchersList = em.createQuery(jpql3, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
		return researchersList;
	}

    @Override
	public List<Researcher> getAllResearchrsInformation() {
		String jpql = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.institutions";
		String jpql2 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.skills";
		String jpql3 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.publications";
		TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Researcher> researchersList = typedQuery.getResultList();
		researchersList = em.createQuery(jpql2, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
		researchersList = em.createQuery(jpql3, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
		return researchersList;
	}
	
	@Override
	public List<Researcher> getResearchrsBySkill(String skill) {
		String jpql = "SELECT distinct s FROM Researcher s JOIN s.skills a WHERE a.skill='" + skill +"'";
		TypedQuery<Researcher> typedQuery = em.createQuery(jpql, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Researcher> researchersList = typedQuery.getResultList();
		List<Researcher> rListBySkill = new ArrayList<Researcher>();
		for (Researcher r : researchersList) {
			String jpql1 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.institutions WHERE s.firstName='" + r.getFirstName() + "'AND s.lastName='" + r.getLastName() + "'";
			String jpql2 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.skills WHERE s.firstName='" + r.getFirstName() + "'AND s.lastName='" + r.getLastName() + "'";
			String jpql3 = "SELECT distinct s FROM Researcher s LEFT JOIN FETCH s.publications WHERE s.firstName='" + r.getFirstName() + "'AND s.lastName='" + r.getLastName() + "'";
			List<Researcher> rAux =  em.createQuery(jpql1, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
			rAux = em.createQuery(jpql2, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
			rAux = em.createQuery(jpql3, Researcher.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false).getResultList();
			rListBySkill.addAll(rAux);
		}
		return rListBySkill;
	}

}
