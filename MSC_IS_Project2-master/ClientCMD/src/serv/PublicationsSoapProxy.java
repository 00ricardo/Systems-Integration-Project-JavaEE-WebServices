package serv;

public class PublicationsSoapProxy implements serv.PublicationsSoap {
  private String _endpoint = null;
  private serv.PublicationsSoap publicationsSoap = null;
  
  public PublicationsSoapProxy() {
    _initPublicationsSoapProxy();
  }
  
  public PublicationsSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initPublicationsSoapProxy();
  }
  
  private void _initPublicationsSoapProxy() {
    try {
      publicationsSoap = (new serv.PublicationsSoapServiceLocator()).getPublicationsSoap();
      if (publicationsSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)publicationsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)publicationsSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (publicationsSoap != null)
      ((javax.xml.rpc.Stub)publicationsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public serv.PublicationsSoap getPublicationsSoap() {
    if (publicationsSoap == null)
      _initPublicationsSoapProxy();
    return publicationsSoap;
  }
  
  public byte[] getPublicationByTitle(java.lang.String title) throws java.rmi.RemoteException{
    if (publicationsSoap == null)
      _initPublicationsSoapProxy();
    return publicationsSoap.getPublicationByTitle(title);
  }
  
  public byte[] getPublicationByResearcher(java.lang.String firstName, java.lang.String lastName) throws java.rmi.RemoteException{
    if (publicationsSoap == null)
      _initPublicationsSoapProxy();
    return publicationsSoap.getPublicationByResearcher(firstName, lastName);
  }
  
  public byte[] getAllPublications() throws java.rmi.RemoteException{
    if (publicationsSoap == null)
      _initPublicationsSoapProxy();
    return publicationsSoap.getAllPublications();
  }
  
  
}