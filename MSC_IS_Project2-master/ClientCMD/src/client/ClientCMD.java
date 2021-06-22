package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.Institution;
import common.Publication;
import common.Researcher;
import common.Skill;
import entities.InstitutionRest;
import entities.ResearcherRest;
import serv.PublicationsSoap;
import serv.PublicationsSoapProxy;
import serv.ServiceResearchSoap;
import serv.ServiceResearchSoapProxy;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ClientCMD {

	public final static String MENU = 
			  "1 - Get all the Researchers Information \n"
			+ "2 - Get all the Publications Information \n" 
			+ "3 - Get all the Institutions Information \n"
			+ "4 - Search Research by Name \n" 
			+ "5 - Search Research by Skill \n"
			+ "6 - Search Publication by Title \n" 
			+ "7 - Search Publication by Researcher Name \n"
			+ "8 - Search Institution by Name \n" 
			+ "9 - Search Institution by Researcher Name \n" 
			+ "0 - Exit \n";
	public final static int MIN_MENU_OPTION = 0;
	public final static int MAX_MENU_OPTION = 9;

	public static void main(String[] args) {
		boolean exitFlag = false;
		// Service Researchers
		ServiceResearchSoapProxy proxy = new ServiceResearchSoapProxy();
		ServiceResearchSoap service = proxy.getServiceResearchSoap();
		// Service Publications
		PublicationsSoapProxy proxyPublication = new PublicationsSoapProxy();
		PublicationsSoap servicePublication = proxyPublication.getPublicationsSoap();
		// Rest Web Service
		Client client = ClientBuilder.newClient();
		WebTarget target;
		Response response;
		GenericType genericType = new GenericType<ArrayList<InstitutionRest>>(){};

		while (!exitFlag) {
			printMenu();
			int option = readOption(MIN_MENU_OPTION, MAX_MENU_OPTION);
			List<Researcher> researchers;
			List<Publication> publications;
			ArrayList<InstitutionRest> institutions;
			switch (option) {
			case 0:
				exitFlag = true;
				break;
			case 1: // Get all the Researchers Information
				researchers = getListOfResearchers(service, option, "", "", "");
				printResearchersInformation(researchers);
				break;
			case 2: // Get all the Publications Information
				publications = getListOfPublication(servicePublication, option, "", "", "");
				printPublicationsInformation(publications);
				break;
			case 3: // Get all the Institutions Information
				target = client.target("http://localhost:8080/Projeto-WebProject-REST/request/path/getallinstitution");
				response = target.request().get();
				institutions =  (ArrayList<InstitutionRest>) response.readEntity(genericType);
				response.close();
				printIntitutionsInformation(institutions);
				break;
			case 4: // Search Research by Name
				System.out.print("Insert the Research First Name: ");
				String firstName = readString();
				System.out.print("Insert the Research Last Name: ");
				String lastName = readString();
				researchers = getListOfResearchers(service, option, firstName, lastName, "");
				printResearchersInformation(researchers);
				break;
			case 5: // Search Research by Skill
				System.out.print("Insert the Skill: ");
				String skill = readString();
				researchers = getListOfResearchers(service, option, "", "", skill);
				printResearchersInformation(researchers);
				break;
			case 6: // Search Publication by Title
				System.out.print("Insert the Publication Title: ");
				String publicationTitle = readString();
				publications = getListOfPublication(servicePublication, option, publicationTitle, "", "");
				printPublicationsInformation(publications);
				break;
			case 7: // Search Publication by Researcher Name
				System.out.print("Insert the Research First Name: ");
				String firstNameP = readString();
				System.out.print("Insert the Research Last Name: ");
				String lastNameP = readString();
				publications = getListOfPublication(servicePublication, option, "", firstNameP, lastNameP);
				printPublicationsInformation(publications);
				break;
			case 8: // Search Institution by Name
				System.out.print("Insert the Institution Name: ");
				String instituionName = readString();
				target = client.target("http://localhost:8080/Projeto-WebProject-REST/request/path/getinstitutionbyname");
				target = target.queryParam("name", instituionName);
				response = target.request().get();
				institutions =  (ArrayList<InstitutionRest>) response.readEntity(genericType);
				response.close();
				printIntitutionsInformation(institutions);
				break;
			case 9: // Search Institution by Researcher Name
				System.out.print("Insert the Research First Name: ");
				String firstNameI = readString();
				System.out.print("Insert the Research Last Name: ");
				String lastNameI = readString();
				target = client.target("http://localhost:8080/Projeto-WebProject-REST/request/path/getinstitutionbyresearchername");
				target = target.queryParam("firstName", firstNameI).queryParam("lastName", lastNameI);
				response = target.request().get();
				institutions =  (ArrayList<InstitutionRest>) response.readEntity(genericType);
				response.close();
				printIntitutionsInformation(institutions);
				break;
			default:
				break;
			}

		}
	}
	
	public static void printIntitutionsInformation(ArrayList<InstitutionRest> list) {
		if (list.isEmpty())
			System.out.println("There are no institutions that matchs the research option choosed!");
		else
			System.out.println(
					"================================================ \n Institutions Informations: \n================================================");
		for (InstitutionRest institution : list) {
			System.out.println("\n-> Institution : " + institution.getInstitution_name());
			System.out.println("  Department : " + institution.getDepartment());
			System.out.println("  Location : " + institution.getLocation());
			if (!institution.getResearchers().isEmpty())
				System.out.println("  Researchers: ");
			for (ResearcherRest researcher : institution.getResearchers())
				System.out.println("    - " + researcher.getFirstName() + " " + researcher.getLastName());

		}
		System.out.println("=========================================================================================");
	}

	/**
	 * 
	 * @param service
	 * @param option
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static List<Publication> getListOfPublication(PublicationsSoap service, int option, String title,
			String firstName, String lastName) {
		byte[] arrPublications = null;
		try {
			switch (option) {
			case 2:
				arrPublications = service.getAllPublications();
				break;
			case 6:
				arrPublications = service.getPublicationByTitle(title);
				break;
			case 7:
				arrPublications = service.getPublicationByResearcher(firstName, lastName);
				break;
			default:
				break;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("rebentou !!!!!!");
		}

		List<Publication> publications = new ArrayList<>();
		// Deserialize the List of Publications
		if (arrPublications != null) {
			ByteArrayInputStream in = new ByteArrayInputStream(arrPublications);
			ObjectInputStream is;
			try {
				is = new ObjectInputStream(in);
				try {
					publications = (List<Publication>) is.readObject();
				} catch (ClassNotFoundException e) {
					// e.printStackTrace();
					System.out.println("Error in the Desearialize of the publication list - Class Not Found Exeception");
				}
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("Error in the Desearialize of the publication list - IO Exception");
			}
		}
		return publications;
	}

	/**
	 * Return a List of Research that comes from a SOAP Web Service
	 * 
	 * @param service
	 * @param option
	 * @param firstName
	 * @param lastName
	 * @param skill
	 * @return
	 */
	public static List<Researcher> getListOfResearchers(ServiceResearchSoap service, int option, String firstName,
			String lastName, String skill) {
		byte arr[] = null;
		try {
			switch (option) {
			case 1:
				arr = service.getAllResearchrsInformation();
				break;
			case 5:
				arr = service.getResearchrsBySkill(skill);
				break;
			case 4:
				arr = service.getResearcherByName(firstName, lastName);
				break;
			default:
				break;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Researcher> researchers = new ArrayList<>();
		if (arr != null) {
			// Deserialize the List of Researchers
			ByteArrayInputStream in = new ByteArrayInputStream(arr);
			ObjectInputStream is;
			try {
				is = new ObjectInputStream(in);
				try {
					researchers = (List<Researcher>) is.readObject();
				} catch (ClassNotFoundException e) {
					// e.printStackTrace();
					System.out
							.println("Error in the Desearialize of the researchers list - Class Not Found Exeception");
				}
			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("Error in the Desearialize of the researchers list - IO Exception");
			}
		}

		return researchers;
	}

	/**
	 * Write to the stdout all the information about a list of Publications
	 * 
	 * @param list
	 */
	public static void printPublicationsInformation(List<Publication> list) {
		if (list.isEmpty())
			System.out.println("There are no publications that matchs the research option choosed!");
		else
			System.out.println(
					"================================================ \n Publications Informations: \n================================================");
		for (Publication publication : list) {
			System.out.println("\n-> Publication Title: " + publication.getPublication_title());
			if (!publication.getResearchers().isEmpty())
				System.out.println("  Authors/Researchers: ");
			for (Researcher researcher : publication.getResearchers())
				System.out.println("    - " + researcher.getFirstName() + " " + researcher.getLastName());
			System.out.println("  Date: " + publication.getPublication_Date());
			System.out.println("  DOI: " + publication.getId_publication());
			System.out.println("  Reads: " + publication.getReads());
			System.out.println("  Citations: " + publication.getCitations());
			System.out.println("  Recommendations: " + publication.getRecommendations());
		}
		System.out.println("=========================================================================================");
	}

	/**
	 * Write to the stdout all the information about a list of Researchers
	 * 
	 * @param list of Researchers
	 */
	public static void printResearchersInformation(List<Researcher> list) {
		if (list.isEmpty())
			System.out.println("There are no reserchers that matchs the research option choosed!");
		else
			System.out.println(
					"================================================ \n Researchers Informations: \n================================================");
		for (Researcher researcher : list) {
			System.out.println("\n- Researcher Name: " + researcher.getFirstName() + " " + researcher.getLastName());
			System.out.println("- Description: " + researcher.getDescription());
			if (!researcher.getInstitutions().isEmpty()) {
				System.out.println("- Researcher Institution:");
				for (Institution i : researcher.getInstitutions())
					System.out.println("   - " + i.getInstitution_name());
			}
			if (!researcher.getSkills().isEmpty()) {
				System.out.println("- Researcher Skills: ");
				for (Skill s : researcher.getSkills())
					System.out.println("   - " + s.getSkill());
			}
			if (!researcher.getPublications().isEmpty()) {
				System.out.println("- Researcher Publications: ");
				for (Publication p : researcher.getPublications())
					System.out.println("   - " + p.getPublication_title());
			}
		}
		System.out.println("=========================================================================================");
	}

	/**
	 * Print the Menu int he stdout
	 */
	public static void printMenu() {
		System.out.println(MENU);
	}

	/**
	 * Read an int (option menu) from stdin
	 * 
	 * @param minimumOption  allowed
	 * @param maximumOptiona allowed
	 * @return an validate int
	 */
	private static int readOption(int minimumOption, int maximumOption) {
		int opt = 0;
		System.out.print("Insert your option: ");
		Scanner scan = new Scanner(System.in);
		boolean aux = true;
		while (aux) {
			if (scan.hasNextInt()) {
				opt = scan.nextInt();
				if (opt >= minimumOption && opt <= maximumOption)
					aux = false;
				else
					System.out.print("Invalid option. Try again: ");
			} else {
				System.out.print("Invalid option. Try again: ");
				scan.next();
			}
		}
		return opt;
	}

	/**
	 * Read a String from stdin
	 * 
	 * @return a string
	 */
	private static String readString() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}
}
