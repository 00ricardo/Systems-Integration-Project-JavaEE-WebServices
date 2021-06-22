/**
 * PublicationsSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serv;

public class PublicationsSoapServiceLocator extends org.apache.axis.client.Service implements serv.PublicationsSoapService {

    public PublicationsSoapServiceLocator() {
    }


    public PublicationsSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PublicationsSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PublicationsSoap
    private java.lang.String PublicationsSoap_address = "http://localhost:8080/SoapPublicationsWEB/services/PublicationsSoap";

    public java.lang.String getPublicationsSoapAddress() {
        return PublicationsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PublicationsSoapWSDDServiceName = "PublicationsSoap";

    public java.lang.String getPublicationsSoapWSDDServiceName() {
        return PublicationsSoapWSDDServiceName;
    }

    public void setPublicationsSoapWSDDServiceName(java.lang.String name) {
        PublicationsSoapWSDDServiceName = name;
    }

    public serv.PublicationsSoap getPublicationsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PublicationsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPublicationsSoap(endpoint);
    }

    public serv.PublicationsSoap getPublicationsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            serv.PublicationsSoapSoapBindingStub _stub = new serv.PublicationsSoapSoapBindingStub(portAddress, this);
            _stub.setPortName(getPublicationsSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPublicationsSoapEndpointAddress(java.lang.String address) {
        PublicationsSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serv.PublicationsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                serv.PublicationsSoapSoapBindingStub _stub = new serv.PublicationsSoapSoapBindingStub(new java.net.URL(PublicationsSoap_address), this);
                _stub.setPortName(getPublicationsSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PublicationsSoap".equals(inputPortName)) {
            return getPublicationsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://serv", "PublicationsSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://serv", "PublicationsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PublicationsSoap".equals(portName)) {
            setPublicationsSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
