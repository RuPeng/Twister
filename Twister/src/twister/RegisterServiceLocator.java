/**
 * RegisterServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package twister;

public class RegisterServiceLocator extends org.apache.axis.client.Service implements twister.RegisterService {

    public RegisterServiceLocator() {
    }


    public RegisterServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RegisterServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Register
    private java.lang.String Register_address = "http://localhost:8080/TwisterServer/services/Register";

    public java.lang.String getRegisterAddress() {
        return Register_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RegisterWSDDServiceName = "Register";

    public java.lang.String getRegisterWSDDServiceName() {
        return RegisterWSDDServiceName;
    }

    public void setRegisterWSDDServiceName(java.lang.String name) {
        RegisterWSDDServiceName = name;
    }

    public twister.Register getRegister() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Register_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRegister(endpoint);
    }

    public twister.Register getRegister(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            twister.RegisterSoapBindingStub _stub = new twister.RegisterSoapBindingStub(portAddress, this);
            _stub.setPortName(getRegisterWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRegisterEndpointAddress(java.lang.String address) {
        Register_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (twister.Register.class.isAssignableFrom(serviceEndpointInterface)) {
                twister.RegisterSoapBindingStub _stub = new twister.RegisterSoapBindingStub(new java.net.URL(Register_address), this);
                _stub.setPortName(getRegisterWSDDServiceName());
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
        if ("Register".equals(inputPortName)) {
            return getRegister();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://twister", "RegisterService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://twister", "Register"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Register".equals(portName)) {
            setRegisterEndpointAddress(address);
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
