package serv;

public class ServiceResearchSoapProxy implements serv.ServiceResearchSoap {
  private String _endpoint = null;
  private serv.ServiceResearchSoap serviceResearchSoap = null;
  
  public ServiceResearchSoapProxy() {
    _initServiceResearchSoapProxy();
  }
  
  public ServiceResearchSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceResearchSoapProxy();
  }
  
  private void _initServiceResearchSoapProxy() {
    try {
      serviceResearchSoap = (new serv.ServiceResearchSoapServiceLocator()).getServiceResearchSoap();
      if (serviceResearchSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceResearchSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceResearchSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceResearchSoap != null)
      ((javax.xml.rpc.Stub)serviceResearchSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serv.ServiceResearchSoap getServiceResearchSoap() {
    if (serviceResearchSoap == null)
      _initServiceResearchSoapProxy();
    return serviceResearchSoap;
  }
  
  public byte[] getResearchrsBySkill(java.lang.String skill) throws java.rmi.RemoteException{
    if (serviceResearchSoap == null)
      _initServiceResearchSoapProxy();
    return serviceResearchSoap.getResearchrsBySkill(skill);
  }
  
  public byte[] getResearcherByName(java.lang.String firstName, java.lang.String lastName) throws java.rmi.RemoteException{
    if (serviceResearchSoap == null)
      _initServiceResearchSoapProxy();
    return serviceResearchSoap.getResearcherByName(firstName, lastName);
  }
  
  public byte[] getAllResearchrsInformation() throws java.rmi.RemoteException{
    if (serviceResearchSoap == null)
      _initServiceResearchSoapProxy();
    return serviceResearchSoap.getAllResearchrsInformation();
  }
  
  
}