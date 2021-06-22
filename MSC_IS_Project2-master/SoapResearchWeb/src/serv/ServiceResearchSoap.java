package serv;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.Researcher;
import ejb.SessionBeanResearcherRemote;

public class ServiceResearchSoap {
	
	
	
	public byte[] getResearcherByName(String firstName, String lastName) throws IOException, NamingException {
		Context context;
		Properties jndiProperties = new Properties();
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		context = new InitialContext(jndiProperties);
		SessionBeanResearcherRemote ej = (SessionBeanResearcherRemote) context.lookup("SoapEAR/SoapResearchEJB/SessionBeanResearcher!ejb.SessionBeanResearcherRemote");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(ej.getResearcherByName(firstName, lastName));		
		return  out.toByteArray();
	}

	public byte[] getAllResearchrsInformation() throws IOException, NamingException {
		Context context;
		Properties jndiProperties = new Properties();
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		context = new InitialContext(jndiProperties);
		SessionBeanResearcherRemote ej = (SessionBeanResearcherRemote) context.lookup("SoapEAR/SoapResearchEJB/SessionBeanResearcher!ejb.SessionBeanResearcherRemote");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(ej.getAllResearchrsInformation());		
		return  out.toByteArray();
	}
	
	public byte[] getResearchrsBySkill(String skill) throws IOException, NamingException {
		Context context;
		Properties jndiProperties = new Properties();
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		context = new InitialContext(jndiProperties);
		SessionBeanResearcherRemote ej = (SessionBeanResearcherRemote) context.lookup("SoapEAR/SoapResearchEJB/SessionBeanResearcher!ejb.SessionBeanResearcherRemote");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(ej.getResearchrsBySkill(skill));		
		return  out.toByteArray();
	}
}
