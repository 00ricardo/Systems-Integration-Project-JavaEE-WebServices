package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ejb.beans.RestBean;
import entities.InstitutionRest;


@Path("/path")
@RequestScoped
public class HTTPRequestCalls {

	
	@EJB
	RestBean rb;
	
	@GET
	@Path("/getallinstitution")   // http://localhost:8080/Projeto-WebProject-REST/request/path/getallinstitution
	@Produces(MediaType.APPLICATION_JSON )
	public List<InstitutionRest> getAllInstitutions() {
		List<InstitutionRest> json;
		json = rb.getAllInsitutions();
		System.out.println("Requesting all institutions information from Bean...");
		return json;
	}
	
	@GET
	@Path("/getinstitutionbyname")   // http://localhost:8080/Projeto-WebProject-REST/request/path/getinstitutionbyname
	@Produces(MediaType.APPLICATION_JSON )
	public List<InstitutionRest> getInstitutionByName(@QueryParam("name") String value) {
		List<InstitutionRest> json;
		json = rb.getInstitutionByName(value);
		System.out.println("Requesting intitution by name to the bean from Bean...");
		return json;
	}
	
	@GET
	@Path("/getinstitutionbyresearchername")   // http://localhost:8080/Projeto-WebProject-REST/request/path/getinstitutionbyresearchername
	@Produces(MediaType.APPLICATION_JSON )
	public List<InstitutionRest> getInstitutionByResearcherName(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
		List<InstitutionRest> json;
		json = rb.getInstitutionByResearchName(firstName, lastName);
		System.out.println("Requesting intitutions by researcher name to the bean from Bean...");
		return json;
	}
	
}
