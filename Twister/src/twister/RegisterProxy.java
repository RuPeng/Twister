package twister;

public class RegisterProxy implements twister.Register {
  private String _endpoint = null;
  private twister.Register register = null;
  
  public RegisterProxy() {
    _initRegisterProxy();
  }
  
  public RegisterProxy(String endpoint) {
    _endpoint = endpoint;
    _initRegisterProxy();
  }
  
  private void _initRegisterProxy() {
    try {
      register = (new twister.RegisterServiceLocator()).getRegister();
      if (register != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)register)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)register)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (register != null)
      ((javax.xml.rpc.Stub)register)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public twister.Register getRegister() {
    if (register == null)
      _initRegisterProxy();
    return register;
  }
  
  public java.lang.String createUser(java.lang.String newUser) throws java.rmi.RemoteException{
    if (register == null)
      _initRegisterProxy();
    return register.createUser(newUser);
  }
  
  public void cleanServer() throws java.rmi.RemoteException{
    if (register == null)
      _initRegisterProxy();
    register.cleanServer();
  }
  
  
}