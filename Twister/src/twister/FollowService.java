/**
 * FollowService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public interface FollowService extends javax.xml.rpc.Service {
    public java.lang.String getFollowAddress();

    public twister.Follow getFollow() throws javax.xml.rpc.ServiceException;

    public twister.Follow getFollow(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
