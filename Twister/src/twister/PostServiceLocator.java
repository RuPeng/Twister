/**
 * PostServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public class PostServiceLocator extends org.apache.axis.client.Service implements twister.PostService {

    public PostServiceLocator() {
    }


    public PostServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PostServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Post
    private java.lang.String Post_address = "http://localhost:8080/TwisterServer/services/Post";

    public java.lang.String getPostAddress() {
        return Post_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PostWSDDServiceName = "Post";

    public java.lang.String getPostWSDDServiceName() {
        return PostWSDDServiceName;
    }

    public void setPostWSDDServiceName(java.lang.String name) {
        PostWSDDServiceName = name;
    }

    public twister.Post getPost() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Post_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPost(endpoint);
    }

    public twister.Post getPost(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            twister.PostSoapBindingStub _stub = new twister.PostSoapBindingStub(portAddress, this);
            _stub.setPortName(getPostWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPostEndpointAddress(java.lang.String address) {
        Post_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (twister.Post.class.isAssignableFrom(serviceEndpointInterface)) {
                twister.PostSoapBindingStub _stub = new twister.PostSoapBindingStub(new java.net.URL(Post_address), this);
                _stub.setPortName(getPostWSDDServiceName());
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
        if ("Post".equals(inputPortName)) {
            return getPost();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://twister", "PostService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://twister", "Post"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Post".equals(portName)) {
            setPostEndpointAddress(address);
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
