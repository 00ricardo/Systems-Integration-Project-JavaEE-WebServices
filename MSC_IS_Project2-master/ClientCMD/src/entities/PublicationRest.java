package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import common.Publication;
import common.Researcher;





public class PublicationRest implements Serializable{
	private static final long serialVersionUID = 3L;
	private String id_publication;
	private String publication_Date;
	private String publication_title;
	private int citations;
	private int recommendations;
	private int reads;
	private List<ResearcherRest> researchers;
	
	public PublicationRest() {
		
	}
	
	public PublicationRest(String id_publication, String publication_Date, String publication_title, int citations,
			int recommendations, int reads, List<ResearcherRest> researchers) {
		this.id_publication = id_publication;
		this.publication_Date = publication_Date;
		this.publication_title = publication_title;
		this.citations = citations;
		this.recommendations = recommendations;
		this.reads = reads;
		this.researchers = researchers;
	}

	public String getId_publication() {
		return id_publication;
	}
	
	public void setId_publication(String id_publication) {
		this.id_publication = id_publication;
	}
	
	public String getPublication_Date() {
		return publication_Date;
	}
	
	public void setPublication_Date(String publication_Date) {
		this.publication_Date = publication_Date;
	}
	
	public String getPublication_title() {
		return publication_title;
	}

	public void setPublication_title(String publication_title) {
		this.publication_title = publication_title;
	}

	public int getCitations() {
		return citations;
	}
	
	public void setCitations(int citations) {
		this.citations = citations;
	}
	
	public int getRecommendations() {
		return recommendations;
	}
	
	public void setRecommendations(int recommendations) {
		this.recommendations = recommendations;
	}
	
	public int getReads() {
		return reads;
	}
	
	public void setReads(int reads) {
		this.reads = reads;
	}
	public List<ResearcherRest> getResearchers() {
		return researchers;
	}
	
	public void List(List<ResearcherRest> researchers) {
		this.researchers = researchers;
	}

	public void setResearchers(List<ResearcherRest> researchers) {
		this.researchers = researchers;
	}
	
	public PublicationRest(Publication p) {
		this.citations = p.getCitations();
		this.id_publication = p.getId_publication();
		this.publication_Date = p.getPublication_Date();
		this.publication_title = p.getPublication_title();
		this.reads = p.getReads();
		this.recommendations = p.getRecommendations();
		this.researchers = new ArrayList<>();
		for (Researcher r : p.getResearchers()) 
			this.researchers.add(new ResearcherRest(r));
	}
	
	
}
