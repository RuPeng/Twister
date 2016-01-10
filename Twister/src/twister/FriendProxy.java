package twister;

public class FriendProxy implements twister.Friend {
  private String _endpoint = null;
  private twister.Friend friend = null;
  
  public FriendProxy() {
    _initFriendProxy();
  }
  
  public FriendProxy(String endpoint) {
    _endpoint = endpoint;
    _initFriendProxy();
  }
  
  private void _initFriendProxy() {
    try {
      friend = (new twister.FriendServiceLocator()).getFriend();
      if (friend != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)friend)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)friend)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (friend != null)
      ((javax.xml.rpc.Stub)friend)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public twister.Friend getFriend() {
    if (friend == null)
      _initFriendProxy();
    return friend;
  }
  
  public java.lang.String follow(java.lang.String user, java.lang.String current) throws java.rmi.RemoteException{
    if (friend == null)
      _initFriendProxy();
    return friend.follow(user, current);
  }
  
  public java.lang.String searchFriend(java.lang.String search) throws java.rmi.RemoteException{
    if (friend == null)
      _initFriendProxy();
    return friend.searchFriend(search);
  }
  
  
}