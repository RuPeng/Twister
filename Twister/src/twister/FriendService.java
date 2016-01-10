/**
 * FriendService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public interface FriendService extends javax.xml.rpc.Service {
    public java.lang.String getFriendAddress();

    public twister.Friend getFriend() throws javax.xml.rpc.ServiceException;

    public twister.Friend getFriend(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
