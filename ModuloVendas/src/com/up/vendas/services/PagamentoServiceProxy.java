package com.up.vendas.services;

import org.springframework.stereotype.Service;

import com.up.vendas.exceptions.PagNaoAprovadoException;

@Service
public class PagamentoServiceProxy implements com.up.vendas.interfaces.services.PagamentoService {
  private String _endpoint = null;
  private com.up.vendas.interfaces.services.PagamentoService pagamentoService = null;
  
  public PagamentoServiceProxy() {
    _initPagamentoServiceProxy();
  }
  
  public PagamentoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPagamentoServiceProxy();
  }
  
  private void _initPagamentoServiceProxy() {
    try {
      pagamentoService = (new com.up.vendas.services.PagamentoServiceImplServiceLocator()).getPagamentoServiceImplPort();
      if (pagamentoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pagamentoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pagamentoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pagamentoService != null)
      ((javax.xml.rpc.Stub)pagamentoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.up.vendas.interfaces.services.PagamentoService getPagamentoService() {
    if (pagamentoService == null)
      _initPagamentoServiceProxy();
    return pagamentoService;
  }
  
  public boolean pagar(com.up.vendas.domain.Pagamento arg0) throws java.rmi.RemoteException, PagNaoAprovadoException{
    if (pagamentoService == null)
      _initPagamentoServiceProxy();
    Boolean pagamento = pagamentoService.pagar(arg0);
    if(!pagamento)
    	throw new PagNaoAprovadoException();
    return pagamento;
  }
  
  
}