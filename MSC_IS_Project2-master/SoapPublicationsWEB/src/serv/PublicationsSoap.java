package serv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.SessionBeanPublicationsRemote;


public class PublicationsSoap {

	
	
	public byte[] getAllPublications() throws NamingException, IOException {
		Context context;
		Properties jndiProperties = new Properties();
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		context = new InitialContext(jndiProperties);
		SessionBeanPublicationsRemote ej = (SessionBeanPublicationsRemote) context.lookup("SoapPublicationsEAR/SoapPublicationsEJB/SessionBeanPublications!ejb.SessionBeanPublicationsRemote");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(ej.getAllPublications());		
		return  out.toByteArray();
	}
	
	public byte[] getPublicationByTitle(String title) throws NamingException, IOException {
		Context context;
		Properties jndiProperties = new Properties();
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		context = new InitialContext(jndiProperties);
		SessionBeanPublicationsRemote ej = (SessionBeanPublicationsRemote) context.lookup("SoapPublicationsEAR/SoapPublicationsEJB/SessionBeanPublications!ejb.SessionBeanPublicationsRemote");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(ej.getPublicationsByTitle(title));		
		return  out.toByteArray();
	}
	
	public byte[] getPublicationByResearcher(String firstName, String lastName) throws NamingException, IOException {
		Context context;
		Properties jndiProperties = new Properties();
		jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		context = new InitialContext(jndiProperties);
		SessionBeanPublicationsRemote ej = (SessionBeanPublicationsRemote) context.lookup("SoapPublicationsEAR/SoapPublicationsEJB/SessionBeanPublications!ejb.SessionBeanPublicationsRemote");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(ej.getPublicationsByResearcher(firstName, lastName));		
		return  out.toByteArray();
	}
	
	
}
