package twister;

public class LoginProxy implements twister.Login {
  private String _endpoint = null;
  private twister.Login login = null;
  
  public LoginProxy() {
    _initLoginProxy();
  }
  
  public LoginProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginProxy();
  }
  
  private void _initLoginProxy() {
    try {
      login = (new twister.LoginServiceLocator()).getLogin();
      if (login != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)login)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)login)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (login != null)
      ((javax.xml.rpc.Stub)login)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public twister.Login getLogin() {
    if (login == null)
      _initLoginProxy();
    return login;
  }
  
  public java.lang.String getAllPosts(java.lang.String username) throws java.rmi.RemoteException{
    if (login == null)
      _initLoginProxy();
    return login.getAllPosts(username);
  }
  
  public java.lang.String verifyUser(java.lang.String userInfo) throws java.rmi.RemoteException{
    if (login == null)
      _initLoginProxy();
    return login.verifyUser(userInfo);
  }
  
  
}