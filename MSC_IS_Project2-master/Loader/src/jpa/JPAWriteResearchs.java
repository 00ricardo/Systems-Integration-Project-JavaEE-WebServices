package jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import common.Institution;
import common.Publication;
import common.Researcher;
import common.Skill;

public class JPAWriteResearchs {
	private ArrayList<Researcher> researchers = new ArrayList<>();			//Researchers
	private ArrayList<Skill> skills = new ArrayList<>();					//Researchers Skills
	private ArrayList<Publication> publications = new ArrayList<>();		//Researchers Publications
	private ArrayList<Institution> institutions = new ArrayList<>();		//Institutions

	public static void main(String[] args) {
		JPAWriteResearchs jpaWriteResearchs = new JPAWriteResearchs();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// Generate Data
		jpaWriteResearchs.generateData();
		// Transaction started
		tx.begin();
		// Persist Researchers
		for (Researcher r : jpaWriteResearchs.getResearchers())
			em.persist(r);
		// Persist Skills
		for (Skill s : jpaWriteResearchs.getSkills())
			em.persist(s);
		// Persist Publication
		for (Publication p : jpaWriteResearchs.getPublications())
			em.persist(p);
		// Persist Institutions
		for (Institution i : jpaWriteResearchs.getInstitutions())
			em.persist(i);
		// Transaction ended
		tx.commit();
		// after commit
		System.out.println("########### After commit ############");
		// Close an application-managed entity manager.
		em.close();
		// Close the factory,
		emf.close();
	}

	public ArrayList<Researcher> getResearchers() {
		return researchers;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public ArrayList<Publication> getPublications() {
		return publications;
	}

	public ArrayList<Institution> getInstitutions() {
		return institutions;
	}

	/**
	 * Generate all the initial data that will be inserted in the database
	 */
	public void generateData() {
				
		//==============================================
		//================ Researchers =================
		//==============================================
		
		// Researcher Pedro Furtado
		// Institutions: University of Coimbra | CISUC
		Researcher researcherPedroFurtado = new Researcher("Pedro", "Furtado",
				"Pedro Furtado is Professor at University of Coimbra UC, Portugal, where he teaches courses in both Computer and Biomedical Engineering.");
		researchers.add(researcherPedroFurtado);
		
		// Researcher Henrique Madeira
		// Institutions: University of Coimbra | CISUC
		Researcher researcherHenriqueMadeira = new Researcher("Henrique", "Madeira",
				"Research topics: experimental evaluation of dependable computing systems, including security evaluation and benchmarking, fault injection techniques, error detection mechanisms, and transactional systems dependability.");
		researchers.add(researcherHenriqueMadeira);
		
		//Researcher Pedro Costa 
		//Institutions: CISUC
		Researcher researcherPedroCosta = new Researcher("Pedro", "Costa",
				"Professor at ISCAC - Polytechnic Institute of Coimbra, Portugal.");
		researchers.add(researcherPedroCosta);
		
		//Researcher Marco Vieira
		//Institutions: University of Coimbra | CISUC
		Researcher researcherMarcoVieira = new Researcher("Marco", "Vieira",
				"Professor at DEI-FCTUC.");
		researchers.add(researcherMarcoVieira);
		
		//Researcher João Gabriel Silva
		//Institutions: University of Coimbra | CISUC
		Researcher researcherJoaoGabriel = new Researcher("João Gabriel", "Silva",
				"Professor at DEI-FCTUC.");
		researchers.add(researcherJoaoGabriel);
		
		//Researcher João Durães
		//Institutions: ISEC - DEIS | CISUC
		Researcher researcherJoaoDuraes = new Researcher("João", "Durães",
				"Professor at DEIS-ISEC and researcher at CISUC.");
		researchers.add(researcherJoaoDuraes);
		
		//Researcher Naaliel Mendes
		//Institutions: University of Coimbra | CISUC
		Researcher researcherNaalielMendes = new Researcher("Naaliel", "Mendes",
				"PhD student at DEI-FCTUC and researcher at CISUC.");
		researchers.add(researcherNaalielMendes);
		
		//Researcher Tihomir Orehovacki
		//Institutions: Juraj Dobrila University of Pula
		Researcher researcherTihomirOrehovacki = new Researcher("Tihomir", "Orehovacki",
				"Associate Professor in Programming, Data Structures and Algorithms, Human Computer Interaction, Design and Programming of Computer Games, and Advanced Algorithms and Data Structures.");
		researchers.add(researcherTihomirOrehovacki);
		
		//Researcher Andrina Granic
		//Institutions: University of Split
		Researcher researcherAndrinaGranic = new Researcher("Andrina", "Granic",
				"Full Professor of Computer Science at University of Split.");
		researchers.add(researcherAndrinaGranic);
		
		//Researcher Dragutin Kermek
		//Institutions: University of Zagreb
		Researcher researcherDragutinKermek = new Researcher("Dragutin", "Kermek",
				"Professor of Computer Science at University of Zagreb.");
		researchers.add(researcherDragutinKermek);
		
		
		
		//==============================================
		//=============== Institutions =================
		//==============================================
		
		ArrayList<Researcher> matchInstitutionToResearcherUC = new ArrayList<>();
		//Institution: University of Coimbra - DEI
		matchInstitutionToResearcherUC.add(researcherPedroFurtado);
		matchInstitutionToResearcherUC.add(researcherHenriqueMadeira);
		matchInstitutionToResearcherUC.add(researcherMarcoVieira);
		matchInstitutionToResearcherUC.add(researcherJoaoGabriel);
		matchInstitutionToResearcherUC.add(researcherNaalielMendes);
		Institution institutionUniversityOfCoimbra = new Institution("University of Coimbra", "Coimbra, Portugal", "Department of Informatics Engineering",
				matchInstitutionToResearcherUC);
		institutions.add(institutionUniversityOfCoimbra);
		
		//Institution: CISUC
		ArrayList<Researcher> matchInstitutionToResearcherCISUC = new ArrayList<>();
		matchInstitutionToResearcherCISUC.clear();
		matchInstitutionToResearcherCISUC.add(researcherPedroFurtado);
		matchInstitutionToResearcherCISUC.add(researcherHenriqueMadeira);
		matchInstitutionToResearcherCISUC.add(researcherPedroCosta);
		matchInstitutionToResearcherCISUC.add(researcherMarcoVieira);
		matchInstitutionToResearcherCISUC.add(researcherJoaoGabriel);
		matchInstitutionToResearcherCISUC.add(researcherJoaoDuraes);
		matchInstitutionToResearcherCISUC.add(researcherNaalielMendes);
		Institution institutionCISUC = new Institution("CISUC", "Coimbra, Portugal","Software and Systems Engineering", matchInstitutionToResearcherCISUC);
		institutions.add(institutionCISUC);
		
		//Institution: ISEC
		ArrayList<Researcher> matchInstitutionToResearcherISEC = new ArrayList<>();
		matchInstitutionToResearcherISEC.clear();
		matchInstitutionToResearcherISEC.add(researcherJoaoDuraes);
		Institution institutionISEC = new Institution("Coimbra Institute of Engineering (ISEC)", "Coimbra, Portugal","Department of Computer Science and Systems (DEIS)", matchInstitutionToResearcherISEC);
		institutions.add(institutionISEC);
		
		//Institution: Juraj Dobrila University of Pula
		ArrayList<Researcher> matchInstitutionToResearcherPula = new ArrayList<>();
		matchInstitutionToResearcherPula.clear();
		matchInstitutionToResearcherPula.add(researcherTihomirOrehovacki);
		Institution institutionUniversityOfPula = new Institution("Juraj Dobrila University of Pula", "Pula, Croatia","Faculty of Informatics", matchInstitutionToResearcherPula);
		institutions.add(institutionUniversityOfPula);
		
		//Institution: University of Split
		ArrayList<Researcher> matchInstitutionToResearcherSplit = new ArrayList<>();
		matchInstitutionToResearcherSplit.clear();
		matchInstitutionToResearcherSplit.add(researcherAndrinaGranic);
		Institution institutionUniversityOfSplit = new Institution("University of Split", "Split, Croatia","Department of Informatics", matchInstitutionToResearcherSplit);
		institutions.add(institutionUniversityOfSplit);
		
		//Institution: University of Zagreb
		ArrayList<Researcher> matchInstitutionToResearcherZagreb = new ArrayList<>();
		matchInstitutionToResearcherZagreb.clear();
		matchInstitutionToResearcherZagreb.add(researcherDragutinKermek);
		Institution institutionUniversityOfZagreb = new Institution("University of Zagreb", "Zagreb, Croatia","Department of Theoretical and Applied Foundations of Information Sciences", matchInstitutionToResearcherZagreb);
		institutions.add(institutionUniversityOfZagreb);
		
		//==============================================
		//================== Skills ====================
		//==============================================
		
		ArrayList<Researcher> matchSkillToResearcher1 = new ArrayList<>();
		//Skill Object Recognition
		matchSkillToResearcher1.add(researcherPedroFurtado);
		skills.add(new Skill("Object Recognition", matchSkillToResearcher1));
		
		//Skill Statistics
		ArrayList<Researcher> matchSkillToResearcher2 = new ArrayList<>();
		matchSkillToResearcher2.clear();
		matchSkillToResearcher2.add(researcherPedroFurtado);
		skills.add(new Skill("Statistics", matchSkillToResearcher2));
		
		//Skill Medical Imaging
		ArrayList<Researcher> matchSkillToResearcher3 = new ArrayList<>();
		matchSkillToResearcher3.clear();
		matchSkillToResearcher3.add(researcherPedroFurtado);
		skills.add(new Skill("Medical Imaging", matchSkillToResearcher3));
		
		//Skill Data Mining
		ArrayList<Researcher> matchSkillToResearcher4 = new ArrayList<>();
		matchSkillToResearcher4.clear();
		matchSkillToResearcher4.add(researcherPedroFurtado);
		skills.add(new Skill("Data Mining", matchSkillToResearcher4));
		
		//Skill Business Intelligence
		ArrayList<Researcher> matchSkillToResearcher5 = new ArrayList<>();
		matchSkillToResearcher5.clear();
		matchSkillToResearcher5.add(researcherPedroFurtado);
		skills.add(new Skill("Business Intelligence", matchSkillToResearcher5));
		
		//Skill Deep Learning
		ArrayList<Researcher> matchSkillToResearcher6 = new ArrayList<>();
		matchSkillToResearcher6.clear();
		matchSkillToResearcher6.add(researcherPedroFurtado);
		skills.add(new Skill("Deep Learning", matchSkillToResearcher6));
		
		//Skill Databases
		ArrayList<Researcher> matchSkillToResearcher7 = new ArrayList<>();
		matchSkillToResearcher7.clear();
		matchSkillToResearcher7.add(researcherPedroFurtado);
		skills.add(new Skill("Databases", matchSkillToResearcher7));
		
		//Skill Data Warehousing
		ArrayList<Researcher> matchSkillToResearcher8 = new ArrayList<>();
		matchSkillToResearcher8.clear();
		matchSkillToResearcher8.add(researcherPedroFurtado);
		matchSkillToResearcher8.add(researcherHenriqueMadeira);
		skills.add(new Skill("Data Warehousing", matchSkillToResearcher8));
		
		//Skill Decision Support
		ArrayList<Researcher> matchSkillToResearcher9 = new ArrayList<>();
		matchSkillToResearcher9.clear();
		matchSkillToResearcher9.add(researcherPedroFurtado);
		skills.add(new Skill("Decision Support", matchSkillToResearcher9));
		
		//Skill NoSQL
		ArrayList<Researcher> matchSkillToResearcher10 = new ArrayList<>();
		matchSkillToResearcher10.clear();
		matchSkillToResearcher10.add(researcherPedroFurtado);
		skills.add(new Skill("NoSQL", matchSkillToResearcher10));
		
		//Skill Relational Databases
		ArrayList<Researcher> matchSkillToResearcher11 = new ArrayList<>();
		matchSkillToResearcher11.clear();
		matchSkillToResearcher11.add(researcherHenriqueMadeira);
		skills.add(new Skill("Relational Databases", matchSkillToResearcher11));
		
		//Skill IT Security
		ArrayList<Researcher> matchSkillToResearcher12 = new ArrayList<>();
		matchSkillToResearcher12.clear();
		matchSkillToResearcher12.add(researcherHenriqueMadeira);
		matchSkillToResearcher12.add(researcherPedroCosta);
		matchSkillToResearcher12.add(researcherNaalielMendes);
		skills.add(new Skill("IT Security", matchSkillToResearcher12));
		
		//Skill Database Management
		ArrayList<Researcher> matchSkillToResearcher13 = new ArrayList<>();
		matchSkillToResearcher13.clear();
		matchSkillToResearcher13.add(researcherHenriqueMadeira);
		skills.add(new Skill("Database Management", matchSkillToResearcher13));
		
		//Skill Data Modeling
		ArrayList<Researcher> matchSkillToResearcher14 = new ArrayList<>();
		matchSkillToResearcher14.clear();
		matchSkillToResearcher14.add(researcherHenriqueMadeira);
		skills.add(new Skill("Data Modeling", matchSkillToResearcher14));
		
		//Skill ETL
		ArrayList<Researcher> matchSkillToResearcher15 = new ArrayList<>();
		matchSkillToResearcher15.clear();
		matchSkillToResearcher15.add(researcherHenriqueMadeira);
		skills.add(new Skill("ETL", matchSkillToResearcher15));
		
		//Skill Dependability
		ArrayList<Researcher> matchSkillToResearcher16 = new ArrayList<>();
		matchSkillToResearcher16.clear();
		matchSkillToResearcher16.add(researcherHenriqueMadeira);
		matchSkillToResearcher16.add(researcherPedroCosta);
		matchSkillToResearcher16.add(researcherMarcoVieira);
		skills.add(new Skill("Dependability", matchSkillToResearcher16));
		
		//Skill Dependability Benchmarking
		ArrayList<Researcher> matchSkillToResearcher17 = new ArrayList<>();
		matchSkillToResearcher17.clear();
		matchSkillToResearcher17.add(researcherPedroCosta);
		skills.add(new Skill("Dependability Benchmarking", matchSkillToResearcher17));
		
		//Skill Software Quality
		ArrayList<Researcher> matchSkillToResearcher18 = new ArrayList<>();
		matchSkillToResearcher18.clear();
		matchSkillToResearcher18.add(researcherPedroCosta);
		skills.add(new Skill("Software Quality", matchSkillToResearcher18));
		
		//Skill Software Validation
		ArrayList<Researcher> matchSkillToResearcher19 = new ArrayList<>();
		matchSkillToResearcher19.clear();
		matchSkillToResearcher19.add(researcherPedroCosta);
		skills.add(new Skill("Software Validation", matchSkillToResearcher19));
		
		//Skill Software Metrics
		ArrayList<Researcher> matchSkillToResearcher20 = new ArrayList<>();
		matchSkillToResearcher20.clear();
		matchSkillToResearcher20.add(researcherPedroCosta);
		skills.add(new Skill("Software Metrics", matchSkillToResearcher20));
		
		//Skill Software Reliability
		ArrayList<Researcher> matchSkillToResearcher21 = new ArrayList<>();
		matchSkillToResearcher21.clear();
		matchSkillToResearcher21.add(researcherPedroCosta);
		skills.add(new Skill("Software Reliability", matchSkillToResearcher21));
		
		//Skill Software Fault Injection
		ArrayList<Researcher> matchSkillToResearcher22 = new ArrayList<>();
		matchSkillToResearcher22.clear();
		matchSkillToResearcher22.add(researcherPedroCosta);
		skills.add(new Skill("Software Fault Injection", matchSkillToResearcher22));
		
		//Skill Software Engineering
		ArrayList<Researcher> matchSkillToResearcher23 = new ArrayList<>();
		matchSkillToResearcher23.clear();
		matchSkillToResearcher23.add(researcherJoaoGabriel);
		matchSkillToResearcher23.add(researcherDragutinKermek);
		skills.add(new Skill("Software Engineering", matchSkillToResearcher23));
		
		//Skill High Performance Computing
		ArrayList<Researcher> matchSkillToResearcher24 = new ArrayList<>();
		matchSkillToResearcher24.clear();
		matchSkillToResearcher24.add(researcherJoaoGabriel);
		skills.add(new Skill("High Performance Computing", matchSkillToResearcher24));
		
		//Skill High Parallel Programming
		ArrayList<Researcher> matchSkillToResearcher25 = new ArrayList<>();
		matchSkillToResearcher25.clear();
		matchSkillToResearcher25.add(researcherJoaoGabriel);
		skills.add(new Skill("Parallel Programming", matchSkillToResearcher25));
		
		//Skill MPI
		ArrayList<Researcher> matchSkillToResearcher26 = new ArrayList<>();
		matchSkillToResearcher26.clear();
		matchSkillToResearcher26.add(researcherJoaoGabriel);
		skills.add(new Skill("MPI", matchSkillToResearcher26));
		
		//Skill Distributed Systems
		ArrayList<Researcher> matchSkillToResearcher27 = new ArrayList<>();
		matchSkillToResearcher27.clear();
		matchSkillToResearcher27.add(researcherJoaoGabriel);
		skills.add(new Skill("Distributed Systems", matchSkillToResearcher27));
		
		//Skill Fault Tolerance
		ArrayList<Researcher> matchSkillToResearcher28 = new ArrayList<>();
		matchSkillToResearcher28.clear();
		matchSkillToResearcher28.add(researcherJoaoGabriel);
		skills.add(new Skill("Fault Tolerance", matchSkillToResearcher28));
		
		//Skill Teaching
		ArrayList<Researcher> matchSkillToResearcher29 = new ArrayList<>();
		matchSkillToResearcher29.clear();
		matchSkillToResearcher29.add(researcherTihomirOrehovacki);
		matchSkillToResearcher29.add(researcherAndrinaGranic);
		skills.add(new Skill("Teaching", matchSkillToResearcher29));
		
		//Skill Human-Computer Interaction
		ArrayList<Researcher> matchSkillToResearcher30 = new ArrayList<>();
		matchSkillToResearcher30.clear();
		matchSkillToResearcher30.add(researcherAndrinaGranic);
		skills.add(new Skill("Human-Computer Interaction", matchSkillToResearcher30));
		
		//Skill Usability
		ArrayList<Researcher> matchSkillToResearcher31 = new ArrayList<>();
		matchSkillToResearcher31.clear();
		matchSkillToResearcher31.add(researcherAndrinaGranic);
		skills.add(new Skill("Usability", matchSkillToResearcher31));
		
		
		//==============================================
		//=============== Publications =================
		//==============================================
		
		ArrayList<Researcher> matchPublicationWithResearchers1 = new ArrayList<>();
		matchPublicationWithResearchers1.add(researcherPedroFurtado);
		// Publication "A Survey of Parallel and Distributed Data Warehouses"
		// Authors: Pedro Furtado
		publications.add(new Publication("10.4018/jdwm.2009040103", "April 2009",
				"A Survey of Parallel and Distributed Data Warehouses", 17, 0, 299, matchPublicationWithResearchers1));
		
		// Publication "Segmentation of Diabetic Retinopathy Lesions by Deep Learning: Achievements and Limitations"
		// Authors: Pedro Furtado
		publications.add(new Publication("10.5220/0008881100950101", "January 2020",
				"Segmentation of Diabetic Retinopathy Lesions by Deep Learning: Achievements and Limitations", 0, 0, 7, matchPublicationWithResearchers1));
		
		// Publication "Food Recognition: Can Deep Learning or Bag-of-Words Match Humans?"
		// Authors: Pedro Furtado
		publications.add(new Publication("10.5220/0008893301020108", "January 2020",
				"Food Recognition: Can Deep Learning or Bag-of-Words Match Humans?", 0, 0, 2, matchPublicationWithResearchers1));
		
		// Publication "Scalability and Realtime on Big Data, MapReduce, NoSQL and Spark"
		// Authors: Pedro Furtado
		publications.add(new Publication("10.1007/978-3-319-61164-8_4", "July 2017",
				"Scalability and Realtime on Big Data, MapReduce, NoSQL and Spark", 0, 0, 86, matchPublicationWithResearchers1));
		
		// Publication "Op-time guaranteed integration of WSNs in networked control systems"
		// Authors: Pedro Furtado
		publications.add(new Publication("10.1109/INES.2013.6632794", "June 2013",
				"Op-time guaranteed integration of WSNs in networked control systems", 0, 0, 9, matchPublicationWithResearchers1));
		
		//Publication "Plug and Play Fault Injector for Dependability Benchmarking"
		//Authors: Henrique Madeira, Pedro Costa, Marco Vieira, João Gabriel Silva
		ArrayList<Researcher> matchPublicationWithResearchers2 = new ArrayList<>();
		matchPublicationWithResearchers2.clear();
		matchPublicationWithResearchers2.add(researcherHenriqueMadeira);
		matchPublicationWithResearchers2.add(researcherPedroCosta);
		matchPublicationWithResearchers2.add(researcherMarcoVieira);
		matchPublicationWithResearchers2.add(researcherJoaoGabriel);
		publications.add(new Publication("10.1007/978-3-540-45214-0_4", "October 2003",
			"Plug and Play Fault Injector for Dependability Benchmarking", 6, 0, 25, matchPublicationWithResearchers2));
		
		//Publication "Benchmarking the Security of Web Serving Systems Based on Known Vulnerabilities"
		//Authors: Henrique Madeira, João Duraes, Naaliel Mendes
		ArrayList<Researcher> matchPublicationWithResearchers3 = new ArrayList<>();
		matchPublicationWithResearchers3.clear();
		matchPublicationWithResearchers3.add(researcherHenriqueMadeira);
		matchPublicationWithResearchers3.add(researcherJoaoDuraes);
		matchPublicationWithResearchers3.add(researcherNaalielMendes);
		publications.add(new Publication("10.1109/LADC.2011.14", "April 2011",
			"Benchmarking the Security of Web Serving Systems Based on Known Vulnerabilities", 4, 0, 73, matchPublicationWithResearchers3));
		
		//Publication "Security Benchmarks for Web Serving Systems"
		//Authors: Henrique Madeira, João Duraes, Naaliel Mendes
		ArrayList<Researcher> matchPublicationWithResearchers4 = new ArrayList<>();
		matchPublicationWithResearchers4.clear();
		matchPublicationWithResearchers4.add(researcherHenriqueMadeira);
		matchPublicationWithResearchers4.add(researcherJoaoDuraes);
		matchPublicationWithResearchers4.add(researcherNaalielMendes);
		publications.add(new Publication("10.1109/ISSRE.2014.38", "December 2014",
			"Security Benchmarks for Web Serving Systems", 6, 0, 88, matchPublicationWithResearchers4));
		
		//Publication "Evaluating and Comparing the Impact of Software Faults on Web Serverss"
		//Authors: Henrique Madeira, João Duraes, Naaliel Mendes
		ArrayList<Researcher> matchPublicationWithResearchers5 = new ArrayList<>();
		matchPublicationWithResearchers5.clear();
		matchPublicationWithResearchers5.add(researcherHenriqueMadeira);
		matchPublicationWithResearchers5.add(researcherJoaoDuraes);
		matchPublicationWithResearchers5.add(researcherNaalielMendes);
		publications.add(new Publication("10.1109/EDCC.2010.14", "May 2010",
			"Evaluating and Comparing the Impact of Software Faults on Web Servers", 3, 0, 49, matchPublicationWithResearchers5));
		
		//Publication "Evaluating the Perceived and Estimated Quality in Use of Web 2.0 Applications"
		//Authors: Tihomir Orehovacki, Andrina Granic, Dragutin Kermek
		ArrayList<Researcher> matchPublicationWithResearchers6 = new ArrayList<>();
		matchPublicationWithResearchers6.clear();
		matchPublicationWithResearchers6.add(researcherTihomirOrehovacki);
		matchPublicationWithResearchers6.add(researcherAndrinaGranic);
		matchPublicationWithResearchers6.add(researcherDragutinKermek);
		publications.add(new Publication("10.1016/j.jss.2013.05.071", "May 2013",
			"Evaluating the Perceived and Estimated Quality in Use of Web 2.0 Applications", 57, 1, 306, matchPublicationWithResearchers6));
		
	}

}
