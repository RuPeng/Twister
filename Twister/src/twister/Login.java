/**
 * Login.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public interface Login extends java.rmi.Remote {
    public java.lang.String getAllPosts(java.lang.String username) throws java.rmi.RemoteException;
    public java.lang.String verifyUser(java.lang.String userInfo) throws java.rmi.RemoteException;
}
