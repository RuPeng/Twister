package twister;

public class FollowProxy implements twister.Follow {
  private String _endpoint = null;
  private twister.Follow follow = null;
  
  public FollowProxy() {
    _initFollowProxy();
  }
  
  public FollowProxy(String endpoint) {
    _endpoint = endpoint;
    _initFollowProxy();
  }
  
  private void _initFollowProxy() {
    try {
      follow = (new twister.FollowServiceLocator()).getFollow();
      if (follow != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)follow)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)follow)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (follow != null)
      ((javax.xml.rpc.Stub)follow)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public twister.Follow getFollow() {
    if (follow == null)
      _initFollowProxy();
    return follow;
  }
  
  public java.lang.String getFollower(java.lang.String username) throws java.rmi.RemoteException{
    if (follow == null)
      _initFollowProxy();
    return follow.getFollower(username);
  }
  
  public java.lang.String getFollowing(java.lang.String username) throws java.rmi.RemoteException{
    if (follow == null)
      _initFollowProxy();
    return follow.getFollowing(username);
  }
  
  public void deleteFollow(java.lang.String follow0, java.lang.String usernmae) throws java.rmi.RemoteException{
    if (follow == null)
      _initFollowProxy();
    follow.deleteFollow(follow0, usernmae);
  }
  
  
}