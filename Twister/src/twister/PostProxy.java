package twister;

public class PostProxy implements twister.Post {
  private String _endpoint = null;
  private twister.Post post = null;
  
  public PostProxy() {
    _initPostProxy();
  }
  
  public PostProxy(String endpoint) {
    _endpoint = endpoint;
    _initPostProxy();
  }
  
  private void _initPostProxy() {
    try {
      post = (new twister.PostServiceLocator()).getPost();
      if (post != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)post)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)post)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (post != null)
      ((javax.xml.rpc.Stub)post)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public twister.Post getPost() {
    if (post == null)
      _initPostProxy();
    return post;
  }
  
  public java.lang.String getPost(java.lang.String username) throws java.rmi.RemoteException{
    if (post == null)
      _initPostProxy();
    return post.getPost(username);
  }
  
  public java.lang.String doPost(java.lang.String postData) throws java.rmi.RemoteException{
    if (post == null)
      _initPostProxy();
    return post.doPost(postData);
  }
  
  public void deletePost(java.lang.String postData) throws java.rmi.RemoteException{
    if (post == null)
      _initPostProxy();
    post.deletePost(postData);
  }
  
  
}