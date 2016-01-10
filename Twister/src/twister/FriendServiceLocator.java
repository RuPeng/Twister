/**
 * FriendServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public class FriendServiceLocator extends org.apache.axis.client.Service implements twister.FriendService {

    public FriendServiceLocator() {
    }


    public FriendServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FriendServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Friend
    private java.lang.String Friend_address = "http://localhost:8080/TwisterServer/services/Friend";

    public java.lang.String getFriendAddress() {
        return Friend_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FriendWSDDServiceName = "Friend";

    public java.lang.String getFriendWSDDServiceName() {
        return FriendWSDDServiceName;
    }

    public void setFriendWSDDServiceName(java.lang.String name) {
        FriendWSDDServiceName = name;
    }

    public twister.Friend getFriend() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Friend_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFriend(endpoint);
    }

    public twister.Friend getFriend(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            twister.FriendSoapBindingStub _stub = new twister.FriendSoapBindingStub(portAddress, this);
            _stub.setPortName(getFriendWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFriendEndpointAddress(java.lang.String address) {
        Friend_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (twister.Friend.class.isAssignableFrom(serviceEndpointInterface)) {
                twister.FriendSoapBindingStub _stub = new twister.FriendSoapBindingStub(new java.net.URL(Friend_address), this);
                _stub.setPortName(getFriendWSDDServiceName());
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
        if ("Friend".equals(inputPortName)) {
            return getFriend();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://twister", "FriendService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://twister", "Friend"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Friend".equals(portName)) {
            setFriendEndpointAddress(address);
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
