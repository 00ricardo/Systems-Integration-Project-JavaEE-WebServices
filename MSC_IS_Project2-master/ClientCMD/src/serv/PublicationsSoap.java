/**
 * PublicationsSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serv;

public interface PublicationsSoap extends java.rmi.Remote {
    public byte[] getPublicationByTitle(java.lang.String title) throws java.rmi.RemoteException;
    public byte[] getPublicationByResearcher(java.lang.String firstName, java.lang.String lastName) throws java.rmi.RemoteException;
    public byte[] getAllPublications() throws java.rmi.RemoteException;
}
