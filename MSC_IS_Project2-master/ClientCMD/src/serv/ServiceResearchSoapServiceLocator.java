/**
 * ServiceResearchSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package serv;

public class ServiceResearchSoapServiceLocator extends org.apache.axis.client.Service implements serv.ServiceResearchSoapService {

    public ServiceResearchSoapServiceLocator() {
    }


    public ServiceResearchSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceResearchSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceResearchSoap
    private java.lang.String ServiceResearchSoap_address = "http://localhost:8080/SoapResearchWeb/services/ServiceResearchSoap";

    public java.lang.String getServiceResearchSoapAddress() {
        return ServiceResearchSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceResearchSoapWSDDServiceName = "ServiceResearchSoap";

    public java.lang.String getServiceResearchSoapWSDDServiceName() {
        return ServiceResearchSoapWSDDServiceName;
    }

    public void setServiceResearchSoapWSDDServiceName(java.lang.String name) {
        ServiceResearchSoapWSDDServiceName = name;
    }

    public serv.ServiceResearchSoap getServiceResearchSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceResearchSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceResearchSoap(endpoint);
    }

    public serv.ServiceResearchSoap getServiceResearchSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            serv.ServiceResearchSoapSoapBindingStub _stub = new serv.ServiceResearchSoapSoapBindingStub(portAddress, this);
            _stub.setPortName(getServiceResearchSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceResearchSoapEndpointAddress(java.lang.String address) {
        ServiceResearchSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (serv.ServiceResearchSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                serv.ServiceResearchSoapSoapBindingStub _stub = new serv.ServiceResearchSoapSoapBindingStub(new java.net.URL(ServiceResearchSoap_address), this);
                _stub.setPortName(getServiceResearchSoapWSDDServiceName());
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
        if ("ServiceResearchSoap".equals(inputPortName)) {
            return getServiceResearchSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://serv", "ServiceResearchSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://serv", "ServiceResearchSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceResearchSoap".equals(portName)) {
            setServiceResearchSoapEndpointAddress(address);
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
