/**
 * Friend.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public interface Friend extends java.rmi.Remote {
    public java.lang.String follow(java.lang.String user, java.lang.String current) throws java.rmi.RemoteException;
    public java.lang.String searchFriend(java.lang.String search) throws java.rmi.RemoteException;
}
