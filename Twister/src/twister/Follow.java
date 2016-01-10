/**
 * Follow.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public interface Follow extends java.rmi.Remote {
    public java.lang.String getFollower(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String getFollowing(java.lang.String username) throws java.rmi.RemoteException;
    public void deleteFollow(java.lang.String follow, java.lang.String usernmae) throws java.rmi.RemoteException;
}
