/**
 * Register.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public interface Register extends java.rmi.Remote {
    public java.lang.String createUser(java.lang.String newUser) throws java.rmi.RemoteException;
    public void cleanServer() throws java.rmi.RemoteException;
}
