/**
 * ServiceResearchSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serv;

public interface ServiceResearchSoap extends java.rmi.Remote {
    public byte[] getResearchrsBySkill(java.lang.String skill) throws java.rmi.RemoteException;
    public byte[] getResearcherByName(java.lang.String firstName, java.lang.String lastName) throws java.rmi.RemoteException;
    public byte[] getAllResearchrsInformation() throws java.rmi.RemoteException;
}
