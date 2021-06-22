package ejb.beans;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.jpa.QueryHints;

import entities.InstitutionRest;
import entities.ResearcherRest;
import entitiesEJB.Institution;
import entitiesEJB.Researcher;



/**
 * Session Bean implementation class RestBean
 */
@Stateless
@LocalBean
public class RestBean {


	@PersistenceContext(name = "PersistenceRest")
    private EntityManager em;
    
    
    public List<InstitutionRest> getInstitutionByName(String name) {
		String jpql = "SELECT distinct s FROM Institution s JOIN FETCH s.researchers r WHERE s.institution_name='" + name + "'";
		TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);;
		List<Institution> institutionList = typedQuery.getResultList();
		List<InstitutionRest> ins = new ArrayList<>();
		for ( Institution i : institutionList) {
			InstitutionRest newIns = new InstitutionRest(i);
			List<ResearcherRest> rRest = new ArrayList<>();
			for (Researcher r : i.getResearchers()) {
				rRest.add(new ResearcherRest(r));
			}
			newIns.setResearchers(rRest);
			ins.add(newIns);
		}
		return ins;
	}

    
    public List<InstitutionRest> getAllInsitutions() {
		String jpql = "SELECT distinct s FROM Institution s JOIN FETCH s.researchers r";
		TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Institution> institutionList = typedQuery.getResultList();
		List<InstitutionRest> ins = new ArrayList<>();
		for ( Institution i : institutionList) {
			InstitutionRest newIns = new InstitutionRest(i);
			List<ResearcherRest> rRest = new ArrayList<>();
			for (Researcher r : i.getResearchers()) {
				rRest.add(new ResearcherRest(r));
			}
			newIns.setResearchers(rRest);
			ins.add(newIns);
		}
		return ins;
	}
    
   
    public List<InstitutionRest> getInstitutionByResearchName(String firstname, String lastName){
    	String jpql = "SELECT distinct s FROM Institution s JOIN FETCH s.researchers r";
		TypedQuery<Institution> typedQuery = em.createQuery(jpql, Institution.class).setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);
		List<Institution> institutionList = typedQuery.getResultList();
		List<Institution> insaux = new ArrayList<Institution>();
		List<InstitutionRest> ins = new ArrayList<>();
		
		for (Institution i : institutionList) {
			for (Researcher r : i.getResearchers()) {
				if(r.getFirstName().equals(firstname) && r.getLastName().equals(lastName))
					insaux.add(i);
			}
		}
		
		for ( Institution i : insaux) {
			InstitutionRest newIns = new InstitutionRest(i);
			List<ResearcherRest> rRest = new ArrayList<>();
			for (Researcher r : i.getResearchers()) {
				rRest.add(new ResearcherRest(r));
			}
			newIns.setResearchers(rRest);
			ins.add(newIns);
		}
		return ins;
    }

}
