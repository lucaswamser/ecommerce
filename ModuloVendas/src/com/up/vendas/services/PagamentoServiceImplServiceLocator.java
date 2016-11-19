/**
 * PagamentoServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.up.vendas.services;

public class PagamentoServiceImplServiceLocator extends org.apache.axis.client.Service implements com.up.vendas.services.PagamentoServiceImplService {

    public PagamentoServiceImplServiceLocator() {
    }


    public PagamentoServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PagamentoServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PagamentoServiceImplPort
    private java.lang.String PagamentoServiceImplPort_address = "http://localhost:8080/ModuloPagamento2/services/pagamento";

    public java.lang.String getPagamentoServiceImplPortAddress() {
        return PagamentoServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PagamentoServiceImplPortWSDDServiceName = "PagamentoEndPointImplPort";

    public java.lang.String getPagamentoServiceImplPortWSDDServiceName() {
        return PagamentoServiceImplPortWSDDServiceName;
    }

    public void setPagamentoServiceImplPortWSDDServiceName(java.lang.String name) {
        PagamentoServiceImplPortWSDDServiceName = name;
    }

    public com.up.vendas.interfaces.services.PagamentoService getPagamentoServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PagamentoServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPagamentoServiceImplPort(endpoint);
    }

    public com.up.vendas.interfaces.services.PagamentoService getPagamentoServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.up.vendas.services.PagamentoServiceImplPortBindingStub _stub = new com.up.vendas.services.PagamentoServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getPagamentoServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPagamentoServiceImplPortEndpointAddress(java.lang.String address) {
        PagamentoServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.up.vendas.interfaces.services.PagamentoService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.up.vendas.services.PagamentoServiceImplPortBindingStub _stub = new com.up.vendas.services.PagamentoServiceImplPortBindingStub(new java.net.URL(PagamentoServiceImplPort_address), this);
                _stub.setPortName(getPagamentoServiceImplPortWSDDServiceName());
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
        if ("PagamentoEndPointImplPort".equals(inputPortName)) {
            return getPagamentoServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://endpoint.pagamento.up.com/", "PagamentoEndPointImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://endpoint.pagamento.up.com/", "PagamentoEndPointImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PagamentoServiceImplPort".equals(portName)) {
            setPagamentoServiceImplPortEndpointAddress(address);
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
