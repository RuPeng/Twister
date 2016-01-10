/**
 * FollowServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public class FollowServiceLocator extends org.apache.axis.client.Service implements twister.FollowService {

    public FollowServiceLocator() {
    }


    public FollowServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FollowServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Follow
    private java.lang.String Follow_address = "http://localhost:8080/TwisterServer/services/Follow";

    public java.lang.String getFollowAddress() {
        return Follow_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FollowWSDDServiceName = "Follow";

    public java.lang.String getFollowWSDDServiceName() {
        return FollowWSDDServiceName;
    }

    public void setFollowWSDDServiceName(java.lang.String name) {
        FollowWSDDServiceName = name;
    }

    public twister.Follow getFollow() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Follow_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFollow(endpoint);
    }

    public twister.Follow getFollow(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            twister.FollowSoapBindingStub _stub = new twister.FollowSoapBindingStub(portAddress, this);
            _stub.setPortName(getFollowWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFollowEndpointAddress(java.lang.String address) {
        Follow_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (twister.Follow.class.isAssignableFrom(serviceEndpointInterface)) {
                twister.FollowSoapBindingStub _stub = new twister.FollowSoapBindingStub(new java.net.URL(Follow_address), this);
                _stub.setPortName(getFollowWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Follow".equals(inputPortName)) {
            return getFollow();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://twister", "FollowService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://twister", "Follow"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Follow".equals(portName)) {
            setFollowEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
